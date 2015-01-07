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
package com.compomics.pepshell.view.panels.dataloading;

import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.model.AnnotatedFile;
import com.compomics.pepshell.model.SeparatedvalueExperimentMetaData;
import com.compomics.pepshell.view.PossibleMetaDataAnnotationsEnum;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 * @author Davy Maddelein
 */
public class MetaDataProviderDialog extends javax.swing.JDialog {

    private DefaultListModel<AnnotatedFile> model = new DefaultListModel<>();
    private AnnotatedFile reference;

    /**
     * Creates new form MetaDataProviderDialog
     */
    public MetaDataProviderDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @Override
    public void setVisible(boolean visible) {
        extraMetaDataAnnotatorPanel1.clearMetaData();
        super.setVisible(visible);
    }

    public void setFilesToAnnotate(List<File> files) {
        model.clear();
        for (File aFile : files) {
            AnnotatedFile replacement = new AnnotatedFile(aFile.getAbsolutePath());
            model.addElement(replacement);
        }
        filesToAnnotateList.setModel(model);
    }

    public void setFilesToAnnotate(File referenceFile, List<File> files) {
        model.clear();
        reference = new AnnotatedFile(referenceFile.getAbsolutePath());
        model.addElement(reference);
        for (File aFile : files) {
            model.addElement(new AnnotatedFile(aFile.getAbsolutePath()));
        }
        filesToAnnotateList.setModel(model);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        filesToAnnotateList = new javax.swing.JList<AnnotatedFile>();
        multipleExperimentsCheckbox = new javax.swing.JCheckBox();
        addInfoToFilesButton = new javax.swing.JButton();
        commitDataButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        extraMetaDataAnnotatorPanel1 = new com.compomics.pepshell.view.panels.dataloading.ExtraMetaDataAnnotatorPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("provide meta data for experiment parsing");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMinimumSize(new java.awt.Dimension(645, 455));
        jPanel1.setPreferredSize(new java.awt.Dimension(645, 455));

        jScrollPane2.setViewportView(filesToAnnotateList);

        multipleExperimentsCheckbox.setText("multiple experiments per file");
        multipleExperimentsCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleExperimentsCheckboxActionPerformed(evt);
            }
        });

        addInfoToFilesButton.setText("accept info");
        addInfoToFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInfoToFilesButton1ActionPerformed(evt);
            }
        });

        commitDataButton1.setText("accept and finalize info gathering");
        commitDataButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitDataButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(525, 80));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(525, 80));

        extraMetaDataAnnotatorPanel1.setMaximumSize(new java.awt.Dimension(300, 80));
        extraMetaDataAnnotatorPanel1.setMinimumSize(new java.awt.Dimension(300, 80));
        extraMetaDataAnnotatorPanel1.setPreferredSize(new java.awt.Dimension(300, 80));
        extraMetaDataAnnotatorPanel1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                extraMetaDataAnnotatorPanel1ComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                extraMetaDataAnnotatorPanel1ComponentRemoved(evt);
            }
        });
        jScrollPane1.setViewportView(extraMetaDataAnnotatorPanel1);

        jButton1.setText("cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("clear info");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("select all experiments");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(multipleExperimentsCheckbox)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(commitDataButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addInfoToFilesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(multipleExperimentsCheckbox)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addInfoToFilesButton)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(commitDataButton1)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jMenu1.setText("Options");

        jMenuItem1.setText("save annotations");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("load annotations");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void addInfoToFilesButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInfoToFilesButton1ActionPerformed
        // TODO add your handling code here:
        for (AnnotatedFile aFile : filesToAnnotateList.getSelectedValuesList()) {
            aFile.addAnnotationsToFile(extraMetaDataAnnotatorPanel1.getAllAnnotations());
        }

    }//GEN-LAST:event_addInfoToFilesButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        extraMetaDataAnnotatorPanel1.clearMetaData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //remove file data
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void extraMetaDataAnnotatorPanel1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_extraMetaDataAnnotatorPanel1ComponentAdded
        extraMetaDataAnnotatorPanel1.repaint();
        jScrollPane1.scrollRectToVisible(evt.getComponent().getBounds());
        this.pack();
    }//GEN-LAST:event_extraMetaDataAnnotatorPanel1ComponentAdded

    private void extraMetaDataAnnotatorPanel1ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_extraMetaDataAnnotatorPanel1ComponentRemoved
        extraMetaDataAnnotatorPanel1.repaint();
        jScrollPane1.scrollRectToVisible(evt.getComponent().getBounds());
        this.pack();
    }//GEN-LAST:event_extraMetaDataAnnotatorPanel1ComponentRemoved

    private void commitDataButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitDataButton1ActionPerformed
        // TODO add your handling code here:
        //very not clean
        addInfoToFilesButton1ActionPerformed(null);
        this.setVisible(false);
    }//GEN-LAST:event_commitDataButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        SeparatedvalueExperimentMetaData data = extraMetaDataAnnotatorPanel1.getAllAnnotations();
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        int state = chooser.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            try {
                try (FileWriter writer = new FileWriter(chooser.getSelectedFile())) {
                    for (Entry<PossibleMetaDataAnnotationsEnum, String> anEntry : data.getMetaDataAsMap().entrySet()) {
                        writer.append(anEntry.getKey().name() + " = " + anEntry.getValue() + "\n");
                    }
                    writer.flush();
                }
            } catch (IOException ex) {
                FaultBarrier.getInstance().handleException(ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        int state = chooser.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            try {
                LineNumberReader reader = new LineNumberReader(new FileReader(chooser.getSelectedFile()));
                String aString = reader.readLine();
                while (aString != null) {
                    String[] annotation = aString.split(" = ");

                    extraMetaDataAnnotatorPanel1.setAnnotation(annotation[0], annotation[1]);
                    aString = reader.readLine();
                }
            } catch (IOException ioe) {
                FaultBarrier.getInstance().handleException(ioe);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_A && evt.isControlDown()) {
            filesToAnnotateList.setSelectionInterval(0, filesToAnnotateList.getModel().getSize());
        }
    }//GEN-LAST:event_formKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        filesToAnnotateList.getSelectionModel().setSelectionInterval(0, filesToAnnotateList.getModel().getSize()-1);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    public AnnotatedFile getReferenceExperimentFile() {
        return reference;

    }

    public List<AnnotatedFile> getFiles() {

        return Collections.list(model.elements());
    }

    private void multipleExperimentsCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInfoToFilesButton;
    private javax.swing.JButton commitDataButton1;
    private com.compomics.pepshell.view.panels.dataloading.ExtraMetaDataAnnotatorPanel extraMetaDataAnnotatorPanel1;
    private javax.swing.JList<AnnotatedFile> filesToAnnotateList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox multipleExperimentsCheckbox;
    // End of variables declaration//GEN-END:variables
}