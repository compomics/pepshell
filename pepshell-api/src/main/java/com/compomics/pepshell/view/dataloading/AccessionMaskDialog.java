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

import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.controllers.AccessionMaskReader;
import com.compomics.pepshell.controllers.properties.ProgramProperties;
import com.compomics.pepshell.model.protein.proteinimplementations.PepshellProtein;
import com.compomics.pepshell.model.enums.ExportPropertyEnum;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.compomics.pepshell.view.components.JFileChooserWithMemory;

/**
 *
 * @author Davy Maddelein
 */
public class AccessionMaskDialog extends javax.swing.JDialog {

    private static Map<PepshellProtein, String> maskMap = new HashMap<>();
    private boolean accept = false;

    /**
     * Creates new form AccessionMaskDialog
     */
    public AccessionMaskDialog(java.awt.Frame parent, boolean modal, List<? extends PepshellProtein> proteinsToDisplay) {
        super(parent, modal);

        initComponents();

        this.getContentPane().setBackground(Color.WHITE);
        proteinList.setListData(proteinsToDisplay.toArray(new PepshellProtein[proteinsToDisplay.size()]));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        originalAccessionLabel = new javax.swing.JLabel();
        acceptAccessionMaskButton = new javax.swing.JButton();
        originalAccessionTextField = new javax.swing.JTextField();
        maskingAccessionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        proteinList = new javax.swing.JList();
        accessionMaskTextField = new javax.swing.JTextField();
        bottomPanel = new javax.swing.JPanel();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        maskDialogMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        exportFileMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("add a masking for accessions");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        topPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        topPanel.setOpaque(false);

        originalAccessionLabel.setText("original accession");

        acceptAccessionMaskButton.setText("add/remove");
        acceptAccessionMaskButton.setToolTipText("add or remove the current masking");
        acceptAccessionMaskButton.setMaximumSize(new java.awt.Dimension(100, 25));
        acceptAccessionMaskButton.setMinimumSize(new java.awt.Dimension(100, 25));
        acceptAccessionMaskButton.setPreferredSize(new java.awt.Dimension(100, 25));
        acceptAccessionMaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptAccessionMaskButtonActionPerformed(evt);
            }
        });

        originalAccessionTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        maskingAccessionLabel.setText("masking accession");

        proteinList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proteinListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(proteinList);

        accessionMaskTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accessionMaskTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(originalAccessionTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                        .addGap(0, 136, Short.MAX_VALUE)
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maskingAccessionLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(originalAccessionLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(acceptAccessionMaskButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(originalAccessionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(originalAccessionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(maskingAccessionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accessionMaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(acceptAccessionMaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        bottomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bottomPanel.setOpaque(false);

        acceptButton.setText("accept");
        acceptButton.setMaximumSize(new java.awt.Dimension(80, 25));
        acceptButton.setMinimumSize(new java.awt.Dimension(80, 25));
        acceptButton.setPreferredSize(new java.awt.Dimension(80, 25));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("cancel");
        cancelButton.setMaximumSize(new java.awt.Dimension(80, 25));
        cancelButton.setMinimumSize(new java.awt.Dimension(80, 25));
        cancelButton.setPreferredSize(new java.awt.Dimension(80, 25));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        fileMenu.setText("File");

        loadFileMenuItem.setText("export current masking...");
        loadFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadFileMenuItem);

        exportFileMenuItem.setText("load masking...");
        exportFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exportFileMenuItem);

        maskDialogMenu.add(fileMenu);

        setJMenuBar(maskDialogMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptAccessionMaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptAccessionMaskButtonActionPerformed
        // TODO add your handling code here:
        if (!accessionMaskTextField.getText().isEmpty()) {
            maskMap.put(((PepshellProtein) proteinList.getSelectedValue()), accessionMaskTextField.getText());
            ((PepshellProtein) proteinList.getSelectedValue()).setVisibleAccession(accessionMaskTextField.getText());
        } else {
            maskMap.remove(proteinList.getSelectedValue());
            ((PepshellProtein) proteinList.getSelectedValue()).setVisibleAccession(originalAccessionTextField.getText());
        }
        proteinList.repaint();
    }//GEN-LAST:event_acceptAccessionMaskButtonActionPerformed

    private void proteinListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proteinListMouseClicked
        // TODO add your handling code here:
        PepshellProtein selectedPepshellProtein = ((PepshellProtein) proteinList.getSelectedValue());
        originalAccessionTextField.setText(selectedPepshellProtein.getOriginalAccession());
        if (!selectedPepshellProtein.getOriginalAccession().equals(selectedPepshellProtein.getVisibleAccession())) {
            accessionMaskTextField.setText(selectedPepshellProtein.getVisibleAccession());
        } else {
            accessionMaskTextField.setText("");
        }
    }//GEN-LAST:event_proteinListMouseClicked

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        accept = true;
        this.dispose();
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (!accept) {
            for (int i = 0; i < proteinList.getModel().getSize(); i++) {
                if (maskMap.containsKey(proteinList.getModel().getElementAt(i))) {
                    ((PepshellProtein) proteinList.getModel().getElementAt(i)).setVisibleAccession(((PepshellProtein) proteinList.getModel().getElementAt(i)).getOriginalAccession());
                }
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void loadFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileMenuItemActionPerformed
        FileWriter saveWriter = null;
        try {
            // TODO add your handling code here:
            JFileChooserWithMemory accessionMaskSaver = new JFileChooserWithMemory(ProgramProperties.getInstance().getProperty(ExportPropertyEnum.LASTACCESSIONMASKEXPORTFOLDER.getKey()));
            accessionMaskSaver.setDialogType(JFileChooserWithMemory.SAVE_DIALOG);
            accessionMaskSaver.setMultiSelectionEnabled(false);
            accessionMaskSaver.showOpenDialog(this);
            File saveFile = accessionMaskSaver.getSelectedFile();
            //this could be moved out of this dialog to the controller
            saveWriter = new FileWriter(saveFile);
            for (Entry<PepshellProtein, String> anAccessionMaskingEntry : maskMap.entrySet()) {
                saveWriter.append(anAccessionMaskingEntry.getKey().getOriginalAccession()).append("=").append(anAccessionMaskingEntry.getValue()).append("\n");
            }
        } catch (IOException ex) {
            FaultBarrier.getInstance().handleException(ex);
        } finally {
            try {
                if (saveWriter != null) {
                    saveWriter.flush();
                    saveWriter.close();
                }
            } catch (IOException ex) {
                FaultBarrier.getInstance().handleException(ex);
            }
        }
    }//GEN-LAST:event_loadFileMenuItemActionPerformed

    private void exportFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileMenuItemActionPerformed
        JFileChooserWithMemory accessionMaskingChooser = new JFileChooserWithMemory(ProgramProperties.getInstance().getProperty(ExportPropertyEnum.LASTACCESSIONMASKEXPORTFOLDER.getKey()));
        accessionMaskingChooser.setFileSelectionMode(JFileChooserWithMemory.FILES_ONLY);
        accessionMaskingChooser.showOpenDialog(this);
        File selectedFile = accessionMaskingChooser.getSelectedFile();
        try {
            maskMap = AccessionMaskReader.parseAccessionFile(selectedFile);
            for (int i = 0; i < proteinList.getModel().getSize(); i++) {
                if (maskMap.containsKey(proteinList.getModel().getElementAt(i))) {
                    ((PepshellProtein) proteinList.getModel().getElementAt(i)).setVisibleAccession(maskMap.get(proteinList.getModel().getElementAt(i)));
                    proteinList.repaint();
                }
            }
        } catch (IOException ex) {
            FaultBarrier.getInstance().handleException(ex);
        }
    }//GEN-LAST:event_exportFileMenuItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptAccessionMaskButton;
    private javax.swing.JButton acceptButton;
    private javax.swing.JTextField accessionMaskTextField;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenuItem exportFileMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JMenuBar maskDialogMenu;
    private javax.swing.JLabel maskingAccessionLabel;
    private javax.swing.JLabel originalAccessionLabel;
    private javax.swing.JTextField originalAccessionTextField;
    private javax.swing.JList proteinList;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
