package com.compomics.pepshell.view.panels;

import com.compomics.pepshell.controllers.AccessionMaskReader;
import com.compomics.pepshell.controllers.properties.ProgramProperties;
import com.compomics.pepshell.model.Protein;
import com.compomics.pepshell.model.enums.ProgramPropertyEnum;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Davy
 */
public class AccessionMaskDialog extends javax.swing.JDialog {

    private static Map<Protein, String> maskMap = new HashMap<Protein, String>();
    private boolean accept = false;

    /**
     * Creates new form AccessionMaskDialog
     */
    public AccessionMaskDialog(java.awt.Frame parent, boolean modal, List<Protein> proteinsToDisplay) {
        super(parent, modal);
        initComponents();
        proteinList.setListData(proteinsToDisplay.toArray(new Protein[0]));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadAccessionMaskButton = new javax.swing.JButton();
        exportAccessionMaskButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        proteinList = new javax.swing.JList();
        originalAccessionTextField = new javax.swing.JTextField();
        accessionMaskTextField = new javax.swing.JTextField();
        acceptAccessionMaskButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("add a masking for accessions");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        loadAccessionMaskButton.setText("load a accession masking file");
        loadAccessionMaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadAccessionMaskButtonActionPerformed(evt);
            }
        });

        exportAccessionMaskButton.setText("export the current accession masking");
        exportAccessionMaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAccessionMaskButtonActionPerformed(evt);
            }
        });

        proteinList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        proteinList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proteinListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(proteinList);

        originalAccessionTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        accessionMaskTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        acceptAccessionMaskButton.setText("add/remove masking");
        acceptAccessionMaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptAccessionMaskButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("original accession");

        jLabel2.setText("masking accession");

        jButton1.setText("mask and return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accessionMaskTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(originalAccessionTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 120, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(acceptAccessionMaskButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(loadAccessionMaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportAccessionMaskButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(originalAccessionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accessionMaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(acceptAccessionMaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadAccessionMaskButton)
                    .addComponent(exportAccessionMaskButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptAccessionMaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptAccessionMaskButtonActionPerformed
        // TODO add your handling code here:
        if (!accessionMaskTextField.getText().isEmpty()) {
            maskMap.put(((Protein) proteinList.getSelectedValue()), accessionMaskTextField.getText());
            ((Protein) proteinList.getSelectedValue()).setVisibleAccession(accessionMaskTextField.getText());
        } else {
            maskMap.remove((Protein) proteinList.getSelectedValue());
            ((Protein) proteinList.getSelectedValue()).setVisibleAccession(originalAccessionTextField.getText());
        }
        proteinList.repaint();
    }//GEN-LAST:event_acceptAccessionMaskButtonActionPerformed

    private void loadAccessionMaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAccessionMaskButtonActionPerformed
        JFileChooser accessionMaskingChooser = new JFileChooser(ProgramProperties.getInstance().getProperty(ProgramPropertyEnum.LASTACCESSIONMASKEXPORTFOLDER.getKey()));
        accessionMaskingChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        accessionMaskingChooser.showOpenDialog(this);
        File selectedFile = accessionMaskingChooser.getSelectedFile();
        try {
            maskMap = AccessionMaskReader.parseAccessionFile(selectedFile);
            for (int i = 0; i < proteinList.getModel().getSize(); i++) {
                if (maskMap.containsKey((Protein) proteinList.getModel().getElementAt(i))) {
                    ((Protein) proteinList.getModel().getElementAt(i)).setVisibleAccession(maskMap.get((Protein) proteinList.getModel().getElementAt(i)));
                    proteinList.repaint();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AccessionMaskDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadAccessionMaskButtonActionPerformed

    private void exportAccessionMaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAccessionMaskButtonActionPerformed
        FileWriter saveWriter = null;
        try {
            // TODO add your handling code here:
            JFileChooser accessionMaskSaver = new JFileChooser(ProgramProperties.getInstance().getProperty(ProgramPropertyEnum.LASTACCESSIONMASKEXPORTFOLDER.getKey()));
            accessionMaskSaver.setDialogType(JFileChooser.SAVE_DIALOG);
            accessionMaskSaver.setMultiSelectionEnabled(false);
            accessionMaskSaver.showOpenDialog(this);
            File saveFile = accessionMaskSaver.getSelectedFile();
            //this could be moved out of this dialog to the controller
            saveWriter = new FileWriter(saveFile);
            for (Entry<Protein, String> anAccessionMaskingEntry : maskMap.entrySet()) {
                saveWriter.append(anAccessionMaskingEntry.getKey().getOriginalAccession()).append("=").append(anAccessionMaskingEntry.getValue()).append("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(AccessionMaskDialog.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (saveWriter != null) {
                    saveWriter.flush();
                    saveWriter.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(AccessionMaskDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exportAccessionMaskButtonActionPerformed

    private void proteinListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proteinListMouseClicked
        // TODO add your handling code here:
        Protein selectedProtein = ((Protein) proteinList.getSelectedValue());
        originalAccessionTextField.setText(selectedProtein.getOriginalAccession());
        if (!selectedProtein.getOriginalAccession().equals(selectedProtein.getVisibleAccession())) {
            accessionMaskTextField.setText(selectedProtein.getVisibleAccession());
        } else {
            accessionMaskTextField.setText("");
        }
    }//GEN-LAST:event_proteinListMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        accept = true;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (!accept) {
            for (int i = 0; i < proteinList.getModel().getSize(); i++) {
                if (maskMap.containsKey((Protein) proteinList.getModel().getElementAt(i))) {
                    ((Protein) proteinList.getModel().getElementAt(i)).setVisibleAccession(((Protein) proteinList.getModel().getElementAt(i)).getOriginalAccession());
                }
            }
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptAccessionMaskButton;
    private javax.swing.JTextField accessionMaskTextField;
    private javax.swing.JButton exportAccessionMaskButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadAccessionMaskButton;
    private javax.swing.JTextField originalAccessionTextField;
    private javax.swing.JList proteinList;
    // End of variables declaration//GEN-END:variables
}
