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

package com.compomics.pepshell.view.dataloading;

import com.compomics.pepshell.DataModeController;
import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.controllers.InfoFinders.DataRetrievalStep;
import com.compomics.pepshell.controllers.properties.ProgramProperties;
import com.compomics.pepshell.view.componentmodels.DataRetrievalStepsDialogListCellRenderer;
import com.google.common.collect.Lists;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;

/**
 *
 * @author Davy Maddelein
 */
public class DataRetrievalStepsDialog extends javax.swing.JDialog {

    private static LinkedList<DataRetrievalStep> retrievalSteps = new LinkedList<>();
    private final DefaultListModel<DataRetrievalStep> enabledListModel = new DefaultListModel<>();
    private final DefaultListModel<DataRetrievalStep> disabledListModel = new DefaultListModel<>();
    private final DataRetrievalStepComparator dataRetrievalStepComparator = new DataRetrievalStepComparator();

    /**
     * Creates new form DataRetrievalStepsDialog
     */
    public DataRetrievalStepsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.white);
        fillRetrievalStepsList();
    }

    public DataRetrievalStepsDialog() {

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
        acceptStepsButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        disabledStepsList = new javax.swing.JList<>();
        enableStepsButton = new javax.swing.JButton();
        disableStepsButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        enabledStepsList = new javax.swing.JList<>();
        disabledLabel = new javax.swing.JLabel();
        enabledLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("data retrieval order");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        acceptStepsButton.setText("accept");
        acceptStepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptStepsButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(acceptStepsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(acceptStepsButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("drag and drop order"));
        jPanel2.setOpaque(false);

        disabledStepsList.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        disabledStepsList.setCellRenderer(new DataRetrievalStepsDialogListCellRenderer());
        disabledStepsList.setDragEnabled(true);
        disabledStepsList.setDropMode(javax.swing.DropMode.ON_OR_INSERT);
        disabledStepsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disabledStepsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(disabledStepsList);

        enableStepsButton.setText("=>");
        enableStepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableStepsButtonActionPerformed(evt);
            }
        });

        disableStepsButton.setText("<=");
        disableStepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableStepsButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(enabledStepsList);

        disabledLabel.setText("disabled");

        enabledLabel.setText("enabled");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enableStepsButton)
                            .addComponent(disableStepsButton)))
                    .addComponent(disabledLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enabledLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(enableStepsButton)
                .addGap(18, 18, 18)
                .addComponent(disableStepsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(disabledLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(enabledLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enableStepsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableStepsButtonActionPerformed
        enabledListModel.clear();
        disabledStepsList.getSelectedValuesList().stream().map((aStep) -> {
            aStep.setExecute(true);
            return aStep;
        }).map((aStep) -> {
            retrievalSteps.add(aStep);
            return aStep;
        }).forEach((aStep) -> {
            disabledListModel.removeElement(aStep);
        });
        Collections.sort(retrievalSteps, dataRetrievalStepComparator);

        retrievalSteps.stream().forEach((aStep) -> {
            enabledListModel.addElement(aStep);
        });
        disabledStepsList.repaint();
        enabledStepsList.repaint();
    }//GEN-LAST:event_enableStepsButtonActionPerformed

    private void disableStepsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableStepsButtonActionPerformed
        // TODO add your handling code here:
        retrievalSteps.clear();
        enabledStepsList.getSelectedValuesList().stream().map((disabledStep) -> {
            disabledStep.setExecute(false);
            return disabledStep;
        }).map((disabledStep) -> {
            disabledListModel.addElement(disabledStep);
            return disabledStep;
        }).forEach((disabledStep) -> {
            enabledListModel.removeElement(disabledStep);
        });

        Enumeration<DataRetrievalStep> enabledSteps = enabledListModel.elements();
        while (enabledSteps.hasMoreElements()) {
            retrievalSteps.add(enabledSteps.nextElement());
        }

        enabledStepsList.repaint();
        disabledStepsList.repaint();
    }//GEN-LAST:event_disableStepsButtonActionPerformed

    private void disabledStepsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disabledStepsListMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            //retrievalStepsList.gets
        }
    }//GEN-LAST:event_disabledStepsListMouseClicked

    private void acceptStepsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptStepsButtonActionPerformed
        // TODO add your handling code here:
        DataModeController.getInstance().getDb().getDataMode().getViewPreparationForMode().setDataRetievalSteps(retrievalSteps);
        this.setVisible(false);
    }//GEN-LAST:event_acceptStepsButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        retrievalSteps = new LinkedList<>();
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptStepsButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton disableStepsButton;
    private javax.swing.JLabel disabledLabel;
    private javax.swing.JList<DataRetrievalStep> disabledStepsList;
    private javax.swing.JButton enableStepsButton;
    private javax.swing.JLabel enabledLabel;
    private javax.swing.JList<DataRetrievalStep> enabledStepsList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void fillRetrievalStepsList() {
        List<DataRetrievalStep> loadedEnabledList = new ArrayList<>();
        List<DataRetrievalStep> loadedDisabledList = new ArrayList<>();
        ProgramProperties.getInstance().getProperties().entrySet().stream().forEach((aClassReference) -> {
            try {
                if (aClassReference.getValue() instanceof String) {
                    DataRetrievalStep step = (DataRetrievalStep) ClassLoader.getSystemClassLoader().loadClass((String) aClassReference.getValue()).newInstance();
                    if (DataModeController.getInstance().getDb().getDataMode().getViewPreparationForMode().getDataRetrievalSteps().contains(step)) {
                        loadedEnabledList.add(step);
                    } else {
                        loadedDisabledList.add(step);
                    }
                } else {
                    throw new ClassCastException("can only load string references to classes and retrieval steps");
                }
            } catch (ClassCastException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                FaultBarrier.getInstance().handleException(ex);
            }
        });
        Collections.sort(loadedEnabledList, dataRetrievalStepComparator);
        loadedEnabledList.stream().forEach((aStep) -> {
            enabledListModel.addElement(aStep);
        });

        Collections.sort(loadedDisabledList, dataRetrievalStepComparator);
        loadedDisabledList.stream().forEach((aStep) -> {
            disabledListModel.addElement(aStep);
        });
        enabledStepsList.setModel(enabledListModel);
        disabledStepsList.setModel(disabledListModel);
    }

    public LinkedList<DataRetrievalStep> getRetrievalSteps() {
        return new LinkedList<>(retrievalSteps);
    }

    private class DataRetrievalStepComparator implements Comparator<DataRetrievalStep> {

        @Override
        public int compare(DataRetrievalStep o1, DataRetrievalStep o2) {
            return o1.getRetrievalStepDescription().compareTo(o2.getRetrievalStepDescription());
        }
    }
}
