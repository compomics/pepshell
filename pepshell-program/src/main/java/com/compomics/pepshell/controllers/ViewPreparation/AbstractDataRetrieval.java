/*
 * Copyright 2014 Davy Maddelein.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.compomics.pepshell.controllers.ViewPreparation;

import com.compomics.pepshell.controllers.InfoFinders.DataRetrievalStep;
import com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps.AccessionConverting;
import com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps.AddDomains;
import com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps.AddPdbInfo;
import com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps.CPDTAnalysis;
import com.compomics.pepshell.model.Experiment;
import com.compomics.pepshell.model.protein.proteinimplementations.PepshellProtein;
import com.compomics.pepshell.model.UpdateMessage;
import com.google.common.collect.Lists;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;

/**
 * prepares the data for the viewing part of pepshell
 * @author Davy Maddelein
 * @param <T> the type of experiment to prepare for
 */
public abstract class AbstractDataRetrieval<T extends Experiment> extends Observable implements Observer {

    private LinkedList<DataRetrievalStep> linkedSteps = new LinkedList<DataRetrievalStep>() {
        {
            //default list
            this.add(new AccessionConverting());
            this.add(new AddDomains());
            this.add(new AddPdbInfo());
            this.add(new CPDTAnalysis());
        }
    };

    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ProgressMonitor progressMonitor;
    private boolean skipStep = false;

    
    /**
     * retrieve the protein data and all secondary data annotations for a given experiment
     * @param referenceExperiment the experiment to add data to
     * @return the experiment that was passed along
     */
    public T retrieveData(T referenceExperiment) {
        JPanel progressMonitorPanel = new JPanel();
        progressMonitorPanel.setBackground(Color.white);
        progressMonitorPanel.setOpaque(true);
        JButton skipButton = new JButton();
        skipButton.setText("skip current retrieval step");
        skipButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                skipStep = true;
            }
        });
        progressMonitor = new ProgressMonitor(progressMonitorPanel, skipButton, "retrieving data", 0, 101);
        return retrievePrimaryData(referenceExperiment);
    }

    /**
     * adds the protein and peptide information to the experiment
     * @param referenceExperiment the experiment to add the information to
     * @return the experiment passed to the method
     */
    protected abstract T retrievePrimaryData(T referenceExperiment);

    /**
     * retrieve any secondary data steps set for retrieval
     * @param experiment the experiment to retrieve the secondary data for
     */
    protected abstract void retrieveSecondaryData(T experiment);

    protected abstract boolean checkAndAddQuantToProteinsInExperiment(T anExperiment);

    public void setDataRetievalSteps(LinkedList<DataRetrievalStep> linkedSteps) {
        this.linkedSteps.clear();
        this.linkedSteps.addAll(linkedSteps);
    }
    
    public Collection<DataRetrievalStep> getDataRetrievalSteps(){
        return Collections.unmodifiableCollection(linkedSteps);
    }

    //can be moved to separate class
    class runRetrievalSteps extends SwingWorker<Boolean, Void> {
 
        private Observer observer;
        private Experiment experiment;
        private Collection<DataRetrievalStep> stepsToExecute;

        /**
         * creates an instance of a swingworker that will run the passed along retrieval steps on the experiment
         * @param anExperiment the experiment to run over
         * @param anObserver optional observer to report progress to
         * @param retrievalSteps the steps to execute
         */
        public runRetrievalSteps(Experiment anExperiment, Collection<DataRetrievalStep> retrievalSteps, Observer anObserver) {
            observer = anObserver;
            experiment = anExperiment;
            stepsToExecute = retrievalSteps;
        }

        @Override
        protected Boolean doInBackground() throws Exception {
            //TODO add preliminary checks to see if the server is accessible, if not, skip and warn user       
            /**
             * the logic for splitting up the tasks and then splitting up the
             * list of proteins, is that this way skipping unwanted steps
             * becomes granular and we can still multi thread each step instead
             * of front loading the list and then terminating whatever steps are
             * left or filtering the step that has to be skipped out of the
             * executor queue
             *
             */

            List<List<PepshellProtein>> partitionedProteinList = Lists.partition((List<PepshellProtein>) experiment.getProteins(), (int) Math.ceil(experiment.getProteins().size() / Runtime.getRuntime().availableProcessors()));

            int totalTasks = (partitionedProteinList.size() * stepsToExecute.size());

            progressMonitor.setMaximum(totalTasks + 2);

            for (DataRetrievalStep aStep : stepsToExecute) {
                List<Future<List<PepshellProtein>>> taskList = new ArrayList<>();
                partitionedProteinList.stream().map(aStep::getInstance).map((toExecute) -> {
                    toExecute.addObserver(observer);
                    return toExecute;
                }).forEach((toExecute) -> taskList.add(executor.submit(toExecute)));
                //+2 because the partition returns the rest in an extra list, for example 4 can give 4 or 5 lists

                while (!taskList.isEmpty()) {
                    if (skipStep) {
                        taskList.stream().forEach((aFuture) -> aFuture.cancel(true));
                        skipStep = false;
                    } else {
                        Iterator<Future<List<PepshellProtein>>> futureIter = taskList.listIterator();
                        while (futureIter.hasNext()) {
                            Future<List<PepshellProtein>> aFuture = futureIter.next();
                            if (aFuture.isDone() || aFuture.isCancelled()) {
                                futureIter.remove();
                                totalTasks--;
                                progressMonitor.setProgress(progressMonitor.getMaximum() - totalTasks);
                            }
                        }
                        if (progressMonitor.isCanceled()) {
                            taskList.stream().forEach((aFuture) -> aFuture.cancel(true));
                        }
                        if (progressMonitor.isCanceled()) {
                            break;
                        }
                        sleep(250);
                    }
                }
            }
            progressMonitor.setNote("cleaning up");
            executor.shutdown();
            progressMonitor.setProgress(progressMonitor.getMaximum());
            return true;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            if (arg instanceof UpdateMessage) {
                //comes from lower, throw higher in the chain, update notification to user
                this.setChanged();
                progressMonitor.setNote(((UpdateMessage) arg).getMessage());
                this.notifyObservers(arg);
            }
        }
    }

}
