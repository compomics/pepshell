package com.compomics.pepshell.view.frames;

import com.compomics.pepshell.model.Experiment;
import com.compomics.pepshell.view.panels.ExperimentFileBasedExperimentSelectionPanel;
import com.compomics.pepshell.view.panels.MetaDataProviderDialog;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Davy Maddelein
 */
public class FileBasedSelectionFrame extends javax.swing.JFrame {

    private final MetaDataProviderDialog metaDataProviderDialog = new MetaDataProviderDialog(this, true);

    /**
     * Creates new form OfflineFileSelectionFrame
     */
    public FileBasedSelectionFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.validate();
        this.repaint();
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
        addExperimentMetaDataButton = new javax.swing.JButton();
        launchMainWindowButton = new javax.swing.JButton();
        referenceExperimentCheckBox = new javax.swing.JCheckBox();
        referenceFileBasedExperimentPanel1 = new com.compomics.pepshell.view.panels.ReferenceFileBasedExperimentPanel();
        experimentFileBasedExperimentSelectionPanel1 = new com.compomics.pepshell.view.panels.ExperimentFileBasedExperimentSelectionPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("select files");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(1200, 1200));
        setMinimumSize(new java.awt.Dimension(640, 206));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(480, 319));

        addExperimentMetaDataButton.setText("add additional info ...");
        addExperimentMetaDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExperimentMetaDataButtonActionPerformed(evt);
            }
        });

        launchMainWindowButton.setText("parse selected files");
        launchMainWindowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchMainWindowButtonActionPerformed(evt);
            }
        });

        referenceExperimentCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        referenceExperimentCheckBox.setSelected(true);
        referenceExperimentCheckBox.setText("refence experiment in separate file");
        referenceExperimentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceExperimentCheckBoxActionPerformed(evt);
            }
        });

        referenceFileBasedExperimentPanel1.setPreferredSize(new java.awt.Dimension(378, 84));

        experimentFileBasedExperimentSelectionPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(referenceFileBasedExperimentPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(referenceExperimentCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(experimentFileBasedExperimentSelectionPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addExperimentMetaDataButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(launchMainWindowButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(referenceExperimentCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referenceFileBasedExperimentPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(experimentFileBasedExperimentSelectionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addExperimentMetaDataButton)
                .addGap(18, 18, 18)
                .addComponent(launchMainWindowButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void launchMainWindowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchMainWindowButtonActionPerformed

        if (referenceFileBasedExperimentPanel1.getReferenceFile() == null && referenceExperimentCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(this,"no reference experiment is present, and the reference option was selected");
        }
        if (experimentFileBasedExperimentSelectionPanel1.getExperimentFiles().isEmpty()) {
            JOptionPane.showMessageDialog(this,"no experiments were selected");
        }



    }//GEN-LAST:event_launchMainWindowButtonActionPerformed

    private void addExperimentMetaDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExperimentMetaDataButtonActionPerformed
        // TODO add your handling code here:
        List<File> files = new ArrayList<>();
        files.addAll(experimentFileBasedExperimentSelectionPanel1.getExperimentFiles());
        files.add(referenceFileBasedExperimentPanel1.getReferenceFile());
        metaDataProviderDialog.setFilesToAnnotate(files);
        metaDataProviderDialog.setVisible(true);
    }//GEN-LAST:event_addExperimentMetaDataButtonActionPerformed

    private void referenceExperimentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceExperimentCheckBoxActionPerformed
        // TODO add your handling code here:
        if (referenceExperimentCheckBox.isSelected()) {
            referenceFileBasedExperimentPanel1.setVisible(true);
            experimentFileBasedExperimentSelectionPanel1.setMode(ExperimentFileBasedExperimentSelectionPanel.ALL_EXPERIMENTS);
        } else {
            referenceFileBasedExperimentPanel1.setVisible(false);
            experimentFileBasedExperimentSelectionPanel1.setMode(ExperimentFileBasedExperimentSelectionPanel.REFERENCE_EXPERIMENT);
        }
        this.pack();
    }//GEN-LAST:event_referenceExperimentCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExperimentMetaDataButton;
    private com.compomics.pepshell.view.panels.ExperimentFileBasedExperimentSelectionPanel experimentFileBasedExperimentSelectionPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton launchMainWindowButton;
    private javax.swing.JCheckBox referenceExperimentCheckBox;
    private com.compomics.pepshell.view.panels.ReferenceFileBasedExperimentPanel referenceFileBasedExperimentPanel1;
    // End of variables declaration//GEN-END:variables

    public Experiment getReferenceProject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<Experiment> getProjectsToCompare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
