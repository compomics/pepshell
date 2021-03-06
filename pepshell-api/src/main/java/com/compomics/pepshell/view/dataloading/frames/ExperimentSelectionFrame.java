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

package com.compomics.pepshell.view.dataloading.frames;

import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.controllers.DataSources.StructureDataSources.InternetStructureDataSource;
import com.compomics.pepshell.controllers.ViewPreparation.DataRetrievalForFasta;
import com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps.AccessionMasking;
import com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps.ProteinFiltering;
import com.compomics.pepshell.controllers.dataimport.DbConnectionController;
import com.compomics.pepshell.controllers.properties.DatabaseProperties;
import com.compomics.pepshell.controllers.properties.ViewProperties;
import com.compomics.pepshell.model.*;
import com.compomics.pepshell.model.DataModes.DataRetrievalInterface;
import com.compomics.pepshell.model.databases.DbDAOInterface;
import com.compomics.pepshell.model.enums.DataBasePropertyEnum;
import com.compomics.pepshell.model.enums.ViewPropertyEnum;
import com.compomics.pepshell.view.dataviewing.frames.MainWindow;
import com.compomics.pepshell.view.dataloading.DataRetrievalStepsDialog;
import com.compomics.pepshell.view.dataloading.LinkDbLoginDialog;
import com.compomics.pepshell.view.dataloading.DbLoginDialog;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * @author Davy Maddelein
 */
public class ExperimentSelectionFrame extends javax.swing.JFrame {

    private List<Experiment> selectedProjectsList = new ArrayList<>();
    private Experiment referenceProject;
    private File fastaFile;
    private DataRetrievalStepsDialog dialog = new DataRetrievalStepsDialog(this, true);
    private DataRetrievalInterface<Experiment> dataRetriever;
    private DbDAOInterface database;

    /**
     * Creates new form ProjectSelectionTreeFrame all this is pretty much unsafe
     * when doing reflection
     */
    public ExperimentSelectionFrame(DbDAOInterface databaseToUse) {
        initComponents();
        this.database = databaseToUse;
        projectListScrollPane.getViewport().setOpaque(false);
        referenceProjectTextBoxScrollPane.getViewport().setOpaque(false);
        projectTreeScrollPane.getViewport().setOpaque(false);

        preloadProteinFilterPanel1.setVisible(false);
        preloadProteinMaskPanel1.setVisible(false);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        try {
            fillProjectList();
        } catch (SQLException ex) {
            FaultBarrier.getInstance().handleException(ex);
            JOptionPane.showMessageDialog(null, "something went wrong while retrieving the list of projects:\n" + ex.getMessage());
        }
    }

    public ExperimentSelectionFrame(AnnotatedFile referenceExperiment, List<AnnotatedFile> comparisonExperiments) {
        initComponents();
        projectListScrollPane.getViewport().setOpaque(false);
        referenceProjectTextBoxScrollPane.getViewport().setOpaque(false);
        projectTreeScrollPane.getViewport().setOpaque(false);

        preloadProteinFilterPanel1.setVisible(false);
        preloadProteinMaskPanel1.setVisible(false);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        FileBasedExperiment experiment = new FileBasedExperiment(referenceExperiment.getName());
        experiment.setFile(referenceExperiment);
        referenceProject = experiment;
        referenceProjectTextBox.setText(referenceProject.getExperimentName());
        FileBasedExperiment[] experimentArray = new FileBasedExperiment[comparisonExperiments.size()];
        for (int i = 0; i < comparisonExperiments.size(); i++) {
            FileBasedExperiment experiment1 = new FileBasedExperiment(comparisonExperiments.get(i).getName());
            experiment1.setFile(comparisonExperiments.get(i));
            experimentArray[i] = experiment1;
        }
        projectList.setListData(experimentArray);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        experimentSelectionPanel = new javax.swing.JPanel();
        maskProteinsCheckBox = new javax.swing.JCheckBox();
        filterSubsetCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        removeProjectGroupButton = new javax.swing.JButton();
        addAnalysisGroupButton = new javax.swing.JButton();
        removeProjectButton = new javax.swing.JButton();
        toProjectTreeButton = new javax.swing.JButton();
        addReferenceProjectButton = new javax.swing.JButton();
        removeReferenceProjectButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        referenceProjectTextBoxScrollPane = new javax.swing.JScrollPane();
        referenceProjectTextBox = new javax.swing.JTextArea();
        projectTreeScrollPane = new javax.swing.JScrollPane();
        projectTree = new com.compomics.pepshell.view.components.DragAndDropTree();
        projectListScrollPane = new javax.swing.JScrollPane();
        projectList = new javax.swing.JList();
        ownFastaCheckBox = new javax.swing.JCheckBox();
        fastaLocationTextField = new javax.swing.JTextField();
        addFastaButton = new javax.swing.JButton();
        onlyFoundProteinsCheckBox = new javax.swing.JCheckBox();
        preloadProteinFilterPanel1 = new com.compomics.pepshell.view.dataloading.PreloadProteinFilterPanel();
        preloadProteinMaskPanel1 = new com.compomics.pepshell.view.dataloading.PreloadProteinMaskPanel();
        analyseButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        useLinkDbCheckBox = new javax.swing.JCheckBoxMenuItem();
        useInternetCheckBox = new javax.swing.JCheckBoxMenuItem();
        dbConnectMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        uniprotTranslateRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        swissprotTranslationRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        genbankTranslationRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        editRetrievalStepsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("project selection");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(840, 565));
        setPreferredSize(new java.awt.Dimension(640, 565));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(831, 554));
        jPanel1.setPreferredSize(new java.awt.Dimension(831, 554));

        experimentSelectionPanel.setBackground(new java.awt.Color(255, 255, 255));
        experimentSelectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        experimentSelectionPanel.setMinimumSize(new java.awt.Dimension(631, 554));
        experimentSelectionPanel.setPreferredSize(new java.awt.Dimension(631, 554));

        maskProteinsCheckBox.setText("mask proteins");
        maskProteinsCheckBox.setMargin(new java.awt.Insets(2, 0, 2, 2));
        maskProteinsCheckBox.setOpaque(false);
        maskProteinsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maskProteinsCheckBoxActionPerformed(evt);
            }
        });

        filterSubsetCheckBox.setText("filter proteins");
        filterSubsetCheckBox.setMargin(new java.awt.Insets(2, 0, 2, 2));
        filterSubsetCheckBox.setOpaque(false);
        filterSubsetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterSubsetCheckBoxActionPerformed(evt);
            }
        });

        jPanel3.setOpaque(false);

        buttonPanel.setOpaque(false);

        removeProjectGroupButton.setText("remove projectgroup");
        removeProjectGroupButton.setMaximumSize(new java.awt.Dimension(177, 25));
        removeProjectGroupButton.setMinimumSize(new java.awt.Dimension(177, 25));
        removeProjectGroupButton.setPreferredSize(new java.awt.Dimension(177, 25));
        removeProjectGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProjectGroupButtonActionPerformed(evt);
            }
        });

        addAnalysisGroupButton.setText("add a projectgroup");
        addAnalysisGroupButton.setMaximumSize(new java.awt.Dimension(177, 25));
        addAnalysisGroupButton.setMinimumSize(new java.awt.Dimension(177, 25));
        addAnalysisGroupButton.setPreferredSize(new java.awt.Dimension(177, 25));
        addAnalysisGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnalysisGroupButtonActionPerformed(evt);
            }
        });

        removeProjectButton.setText("remove project");
        removeProjectButton.setMaximumSize(new java.awt.Dimension(177, 25));
        removeProjectButton.setMinimumSize(new java.awt.Dimension(177, 25));
        removeProjectButton.setPreferredSize(new java.awt.Dimension(177, 25));
        removeProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProjectButtonActionPerformed(evt);
            }
        });

        toProjectTreeButton.setText("add project");
        toProjectTreeButton.setMaximumSize(new java.awt.Dimension(177, 25));
        toProjectTreeButton.setMinimumSize(new java.awt.Dimension(177, 25));
        toProjectTreeButton.setPreferredSize(new java.awt.Dimension(177, 25));
        toProjectTreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toProjectTreeButtonActionPerformed(evt);
            }
        });

        addReferenceProjectButton.setText("add reference project");
        addReferenceProjectButton.setMaximumSize(new java.awt.Dimension(177, 25));
        addReferenceProjectButton.setMinimumSize(new java.awt.Dimension(177, 25));
        addReferenceProjectButton.setPreferredSize(new java.awt.Dimension(177, 25));
        addReferenceProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReferenceProjectButtonActionPerformed(evt);
            }
        });

        removeReferenceProjectButton.setText("remove reference project");
        removeReferenceProjectButton.setMaximumSize(new java.awt.Dimension(177, 25));
        removeReferenceProjectButton.setMinimumSize(new java.awt.Dimension(177, 25));
        removeReferenceProjectButton.setPreferredSize(new java.awt.Dimension(177, 25));
        removeReferenceProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeReferenceProjectButtonActionPerformed(evt);
            }
        });

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(270, 361));

        referenceProjectTextBoxScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        referenceProjectTextBoxScrollPane.setPreferredSize(new java.awt.Dimension(270, 96));

        referenceProjectTextBox.setEditable(false);
        referenceProjectTextBox.setColumns(20);
        referenceProjectTextBox.setRows(5);
        referenceProjectTextBox.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        referenceProjectTextBox.setMinimumSize(new java.awt.Dimension(232, 92));
        referenceProjectTextBoxScrollPane.setViewportView(referenceProjectTextBox);

        projectTreeScrollPane.setPreferredSize(new java.awt.Dimension(270, 322));

        projectTree.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        projectTree.setMinimumSize(new java.awt.Dimension(113, 19));
        projectTree.setPreferredSize(new java.awt.Dimension(270, 16));
        projectTreeScrollPane.setViewportView(projectTree);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(projectTreeScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(referenceProjectTextBoxScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(referenceProjectTextBoxScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(projectTreeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(removeProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeReferenceProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeProjectGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addReferenceProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addAnalysisGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(toProjectTreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(addReferenceProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeReferenceProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addAnalysisGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeProjectGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toProjectTreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        projectListScrollPane.setMinimumSize(new java.awt.Dimension(199, 354));
        projectListScrollPane.setPreferredSize(new java.awt.Dimension(270, 354));

        projectList.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        projectList.setMinimumSize(new java.awt.Dimension(199, 320));
        projectList.setPreferredSize(new java.awt.Dimension(199, 320));
        projectListScrollPane.setViewportView(projectList);

        ownFastaCheckBox.setText("use own fasta file");
        ownFastaCheckBox.setMargin(new java.awt.Insets(2, 0, 2, 2));
        ownFastaCheckBox.setOpaque(false);
        ownFastaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownFastaCheckBoxActionPerformed(evt);
            }
        });

        fastaLocationTextField.setEditable(false);

        addFastaButton.setText("add fasta");
        addFastaButton.setEnabled(false);
        addFastaButton.setMaximumSize(new java.awt.Dimension(83, 23));
        addFastaButton.setMinimumSize(new java.awt.Dimension(83, 23));
        addFastaButton.setPreferredSize(new java.awt.Dimension(83, 23));
        addFastaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFastaButtonActionPerformed(evt);
            }
        });

        onlyFoundProteinsCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        onlyFoundProteinsCheckBox.setSelected(true);
        onlyFoundProteinsCheckBox.setText("add only proteins found in experiments");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(onlyFoundProteinsCheckBox)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(projectListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ownFastaCheckBox))
                                                                .addGap(10, 10, 10)
                                                                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(fastaLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(addFastaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(440, 440, 440))))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(projectListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ownFastaCheckBox)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fastaLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addFastaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addComponent(onlyFoundProteinsCheckBox)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout experimentSelectionPanelLayout = new javax.swing.GroupLayout(experimentSelectionPanel);
        experimentSelectionPanel.setLayout(experimentSelectionPanelLayout);
        experimentSelectionPanelLayout.setHorizontalGroup(
                experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(maskProteinsCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterSubsetCheckBox)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );
        experimentSelectionPanelLayout.setVerticalGroup(
                experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(maskProteinsCheckBox)
                                        .addComponent(filterSubsetCheckBox))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        preloadProteinFilterPanel1.setBackground(new java.awt.Color(255, 255, 255));
        preloadProteinFilterPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        preloadProteinMaskPanel1.setBackground(new java.awt.Color(255, 255, 255));
        preloadProteinMaskPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        analyseButton.setText("proceed...");
        analyseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(preloadProteinFilterPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(preloadProteinMaskPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(analyseButton))
                                        .addComponent(experimentSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(experimentSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(preloadProteinFilterPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(preloadProteinMaskPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(analyseButton)
                                .addContainerGap())
        );

        jMenu1.setText("Data sources");

        useLinkDbCheckBox.setSelected(true);
        useLinkDbCheckBox.setText("use link db");
        useLinkDbCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useLinkDbCheckBoxActionPerformed(evt);
            }
        });
        jMenu1.add(useLinkDbCheckBox);

        useInternetCheckBox.setSelected(true);
        useInternetCheckBox.setText("use internet sources");
        jMenu1.add(useInternetCheckBox);

        dbConnectMenuItem.setText("connect to data db");
        dbConnectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbConnectMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(dbConnectMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Retrieval steps");

        jMenu3.setText("translate accessions to");

        uniprotTranslateRadioButtonMenuItem.setText("uniprot");
        jMenu3.add(uniprotTranslateRadioButtonMenuItem);

        swissprotTranslationRadioButtonMenuItem.setText("swissprot");
        jMenu3.add(swissprotTranslationRadioButtonMenuItem);

        genbankTranslationRadioButtonMenuItem.setText("genbank");
        jMenu3.add(genbankTranslationRadioButtonMenuItem);

        jMenu2.add(jMenu3);

        editRetrievalStepsMenuItem.setText("edit retrieval steps");
        editRetrievalStepsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRetrievalStepsMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(editRetrievalStepsMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void useLinkDbCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useLinkDbCheckBoxActionPerformed
        if (useLinkDbCheckBox.isSelected()) {
            LinkDbLoginDialog loginDialog = new LinkDbLoginDialog();
            loginDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            if (useInternetCheckBox.isSelected()) {
                ProgramVariables.STRUCTUREDATASOURCE = new InternetStructureDataSource();
            } else {
                //accept own implementation or local sources? if own, make pluggable
            }
        }

    }//GEN-LAST:event_useLinkDbCheckBoxActionPerformed

    private void dbConnectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        DbLoginDialog dbLogindialog = new DbLoginDialog(this, true, DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBUSERNAME.getKey()),
                DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBURL.getKey()),
                DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBNAME.getKey()));
        dbLogindialog.setLocationRelativeTo(this);
        try {
            fillProjectList();
            projectTree.removeAll();
        } catch (Exception ex) {
            FaultBarrier.getInstance().handleException(ex);
            JOptionPane.showMessageDialog(this, "something went wrong while retrieving the list of projects:\n" + ex.getMessage());
        }
        this.revalidate();
        this.repaint();
    }

    private void editRetrievalStepsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRetrievalStepsMenuItemActionPerformed
        // TODO add your handling code here:
        dialog.setVisible(true);
    }//GEN-LAST:event_editRetrievalStepsMenuItemActionPerformed

    private void addFastaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFastaButtonActionPerformed
        JFileChooser fastaChooser = new JFileChooser();
        fastaChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fastaChooser.setMultiSelectionEnabled(false);
        int option = fastaChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            this.fastaFile = fastaChooser.getSelectedFile();
            if (fastaFile != null && fastaFile.exists()) {
                fastaLocationTextField.setText(fastaFile.getName());
                ViewProperties.getInstance().setProperty(new Property(ViewPropertyEnum.PROTEINFASTALOCATION, fastaFile.getAbsolutePath()));
            }
        }
    }//GEN-LAST:event_addFastaButtonActionPerformed

    private void ownFastaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownFastaCheckBoxActionPerformed
        // TODO add your handling code here:
        if (ownFastaCheckBox.isSelected()) {
            addFastaButton.setEnabled(true);
            onlyFoundProteinsCheckBox.setEnabled(true);
            fastaFile = new File(ViewProperties.getInstance().getProperty(ViewPropertyEnum.PROTEINFASTALOCATION.getKey()));
            if (fastaFile != null) {
                fastaLocationTextField.setText(fastaFile.getName());
            }
        } else {
            addFastaButton.setEnabled(false);
            onlyFoundProteinsCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_ownFastaCheckBoxActionPerformed

    private void removeReferenceProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeReferenceProjectButtonActionPerformed
        if (!referenceProjectTextBox.getText().isEmpty()) {
            referenceProject = null;
            referenceProjectTextBox.setText("");
        }
    }//GEN-LAST:event_removeReferenceProjectButtonActionPerformed

    private void addReferenceProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReferenceProjectButtonActionPerformed
        if (projectList.getSelectedValue() != null) {
            referenceProject = (Experiment) projectList.getSelectedValue();
            referenceProjectTextBox.setText(referenceProject.getExperimentName());
        }
    }//GEN-LAST:event_addReferenceProjectButtonActionPerformed

    private void toProjectTreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toProjectTreeButtonActionPerformed
        for (Object selectedValues : projectList.getSelectedValuesList()) {
            if (!selectedProjectsList.contains((Experiment) selectedValues)) {
                DefaultMutableTreeNode projectNode = projectTree.addObject(selectedValues);
                projectNode.setAllowsChildren(false);
                selectedProjectsList.add((Experiment) selectedValues);
            }
        }
    }//GEN-LAST:event_toProjectTreeButtonActionPerformed

    private void removeProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProjectButtonActionPerformed
        if (projectTree.getSelectionPath() != null) {
            for (TreePath aPath : projectTree.getSelectionPaths()) {
                if (((DefaultMutableTreeNode) aPath.getLastPathComponent()).getUserObject() instanceof Experiment) {
                    selectedProjectsList.remove(((DefaultMutableTreeNode) aPath.getLastPathComponent()).getUserObject());
                    projectTree.removeCurrentNode();
                }
            }
        }
    }//GEN-LAST:event_removeProjectButtonActionPerformed

    private void addAnalysisGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnalysisGroupButtonActionPerformed
        String temp = JOptionPane.showInputDialog(this);
        if (temp != null && !temp.isEmpty()) {
            projectTree.addObject(new AnalysisGroup(temp));
        }
    }//GEN-LAST:event_addAnalysisGroupButtonActionPerformed

    private void removeProjectGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProjectGroupButtonActionPerformed
        if (projectTree.getSelectionPath() != null) {
            if (projectTree.getSelectionPath().getLastPathComponent() instanceof AnalysisGroup) {
                projectTree.removeCurrentNode();
            }
        }
    }//GEN-LAST:event_removeProjectGroupButtonActionPerformed

    private void filterSubsetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterSubsetCheckBoxActionPerformed
        if (filterSubsetCheckBox.isSelected()) {
            preloadProteinFilterPanel1.setVisible(true);
            this.pack();
            this.repaint();
        } else {
            preloadProteinFilterPanel1.setVisible(false);
            this.pack();
            this.repaint();
        }
    }//GEN-LAST:event_filterSubsetCheckBoxActionPerformed

    private void maskProteinsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maskProteinsCheckBoxActionPerformed
        if (maskProteinsCheckBox.isSelected()) {
            preloadProteinMaskPanel1.setVisible(true);
            this.pack();
        } else {
            preloadProteinMaskPanel1.setVisible(false);
            this.pack();
        }
    }//GEN-LAST:event_maskProteinsCheckBoxActionPerformed

    private void analyseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseButtonActionPerformed
        boolean goAhead = false;
        //can we actually continue?
        List<AnalysisGroup> analysisList = new ArrayList<>();
        if (!selectedProjectsList.isEmpty() && referenceProject != null) {
            AnalysisGroup rogueProjects = new AnalysisGroup("Analysis");
            Enumeration tree = ((TreeNode) projectTree.getModel().getRoot()).children();
            if (tree.hasMoreElements()) {
                goAhead = true;
            }
            while (tree.hasMoreElements()) {
                Object anObject = tree.nextElement();
                if (((DefaultMutableTreeNode) anObject).getUserObject() instanceof Experiment) {
                    rogueProjects.addExperiment((Experiment) ((DefaultMutableTreeNode) anObject).getUserObject());
                } else if (((DefaultMutableTreeNode) anObject).getUserObject() instanceof AnalysisGroup) {
                    analysisList.add((AnalysisGroup) ((DefaultMutableTreeNode) anObject).getUserObject());
                }
            }

            if (!rogueProjects.getExperiments().isEmpty()) {
                analysisList.add(rogueProjects);
            }
            if (ownFastaCheckBox.isSelected() && fastaFile != null && goAhead) {
                //set the view preparation to get proteins from the fasta database and set the passed along file
                dataRetriever = new DataRetrievalForFasta<>().setFastaFile(fastaFile).addOnlyExperimentProteinsFromFasta(onlyFoundProteinsCheckBox.isSelected());
            } else if (ownFastaCheckBox.isSelected()) {
                goAhead = false;
            }
        }
        if (filterSubsetCheckBox.isSelected()) {
            if (!preloadProteinFilterPanel1.getProteinsToFilterWith().isEmpty()) {
                int index = dialog.getRetrievalSteps().indexOf(new ProteinFiltering());
                if (index == -1) {
                    ProteinFiltering addedStep = new ProteinFiltering();
                    addedStep.setFilterList(preloadProteinFilterPanel1.getProteinsToFilterWith());
                    dialog.getRetrievalSteps().addFirst(addedStep);
                    JOptionPane.showMessageDialog(this, "filtering step was not selected, added as step");
                } else {
                    ((ProteinFiltering) dialog.getRetrievalSteps().get(index)).setFilterList(preloadProteinFilterPanel1.getProteinsToFilterWith());
                }
            } else {
                JOptionPane.showMessageDialog(this, "empty filter set, was ignored");
            }
        }
        if (maskProteinsCheckBox.isSelected()) {
            if (!preloadProteinMaskPanel1.getProteinsToMaskWith().isEmpty()) {
                int index = dialog.getRetrievalSteps().indexOf(new AccessionMasking());
                if (index == -1) {
                    AccessionMasking addedStep = new AccessionMasking();
                    addedStep.setMaskingSet(preloadProteinMaskPanel1.getProteinsToMaskWith());
                    dialog.getRetrievalSteps().addFirst(addedStep);
                    JOptionPane.showMessageDialog(this, "masking step was not selected, added as very first step");
                } else {
                    ((AccessionMasking) dialog.getRetrievalSteps().get(index)).setMaskingSet(preloadProteinMaskPanel1.getProteinsToMaskWith());
                }
            } else {
                JOptionPane.showMessageDialog(this, "empty masking set, was ignored");
            }
        }

        if (dialog != null && !dialog.getRetrievalSteps().isEmpty()) {
            dataRetriever.setDataRetrievalSteps(dialog.getRetrievalSteps());
        }

        if (goAhead) {
            MainWindow window = new MainWindow();
            FaultBarrier.getInstance().addObserver(window);
            window.setVisible(true);
            this.dispose();
            new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    dataRetriever.retrieveData(referenceProject);
                    analysisList.stream().forEach(e -> e.getExperiments().stream().forEach(dataRetriever::retrieveData));
                    return null;
                }

                @Override
                protected void done() {
                }
            }.execute();
            window.setData(referenceProject, analysisList);

        } else {
            JOptionPane.showMessageDialog(this, "please make sure you have a reference project, one or more projects to compare to and if requested, have supplied a fasta");
        }
    }//GEN-LAST:event_analyseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAnalysisGroupButton;
    private javax.swing.JButton addFastaButton;
    private javax.swing.JButton addReferenceProjectButton;
    private javax.swing.JButton analyseButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JMenuItem dbConnectMenuItem;
    private javax.swing.JMenuItem editRetrievalStepsMenuItem;
    private javax.swing.JPanel experimentSelectionPanel;
    private javax.swing.JTextField fastaLocationTextField;
    private javax.swing.JCheckBox filterSubsetCheckBox;
    private javax.swing.JRadioButtonMenuItem genbankTranslationRadioButtonMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox maskProteinsCheckBox;
    private javax.swing.JCheckBox onlyFoundProteinsCheckBox;
    private javax.swing.JCheckBox ownFastaCheckBox;
    private com.compomics.pepshell.view.dataloading.PreloadProteinFilterPanel preloadProteinFilterPanel1;
    private com.compomics.pepshell.view.dataloading.PreloadProteinMaskPanel preloadProteinMaskPanel1;
    private javax.swing.JList projectList;
    private javax.swing.JScrollPane projectListScrollPane;
    private com.compomics.pepshell.view.components.DragAndDropTree projectTree;
    private javax.swing.JScrollPane projectTreeScrollPane;
    private javax.swing.JTextArea referenceProjectTextBox;
    private javax.swing.JScrollPane referenceProjectTextBoxScrollPane;
    private javax.swing.JButton removeProjectButton;
    private javax.swing.JButton removeProjectGroupButton;
    private javax.swing.JButton removeReferenceProjectButton;
    private javax.swing.JRadioButtonMenuItem swissprotTranslationRadioButtonMenuItem;
    private javax.swing.JButton toProjectTreeButton;
    private javax.swing.JRadioButtonMenuItem uniprotTranslateRadioButtonMenuItem;
    private javax.swing.JCheckBoxMenuItem useInternetCheckBox;
    private javax.swing.JCheckBoxMenuItem useLinkDbCheckBox;
    // End of variables declaration//GEN-END:variables

    private void fillProjectList() throws SQLException {
        projectList.setListData(database.getExperiments(DbConnectionController.getExperimentDbConnection()).toArray());
    }
}
