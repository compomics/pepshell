package com.compomics.pepshell.view.frames;

import com.compomics.pepshell.controllers.DataModes.FastaDataMode;
import com.compomics.pepshell.model.Experiment;
import java.io.File;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Davy
 */
public class OfflineFileSelectionFrame extends javax.swing.JFrame {

    private File fastaFile;

    /**
     * Creates new form OfflineFileSelectionFrame
     */
    public OfflineFileSelectionFrame() {
        initComponents();
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

        digestPanel = new javax.swing.JPanel();
        simpleDigestRadioButton = new javax.swing.JRadioButton();
        CPDTRadioButton = new javax.swing.JRadioButton();
        proteaseBox = new javax.swing.JComboBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        peptideFileTreePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fastaFileLocationTextField = new javax.swing.JTextField();
        launchMainWindowButton = new javax.swing.JButton();
        fastaSelectionButton = new javax.swing.JButton();
        selfDigestCheckBox = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        simpleDigestRadioButton.setText("simple digest");
        simpleDigestRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleDigestRadioButtonActionPerformed(evt);
            }
        });

        CPDTRadioButton.setText("use CP-DT");
        CPDTRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPDTRadioButtonActionPerformed(evt);
            }
        });

        proteaseBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout digestPanelLayout = new javax.swing.GroupLayout(digestPanel);
        digestPanel.setLayout(digestPanelLayout);
        digestPanelLayout.setHorizontalGroup(
            digestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(digestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digestPanelLayout.createSequentialGroup()
                        .addComponent(simpleDigestRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(proteaseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CPDTRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        digestPanelLayout.setVerticalGroup(
            digestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digestPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(digestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpleDigestRadioButton)
                    .addComponent(proteaseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CPDTRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("add analysis group");

        jButton2.setText("add peptide file");

        javax.swing.GroupLayout peptideFileTreePanelLayout = new javax.swing.GroupLayout(peptideFileTreePanel);
        peptideFileTreePanel.setLayout(peptideFileTreePanelLayout);
        peptideFileTreePanelLayout.setHorizontalGroup(
            peptideFileTreePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peptideFileTreePanelLayout.createSequentialGroup()
                .addGap(javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                .addGroup(peptideFileTreePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        peptideFileTreePanelLayout.setVerticalGroup(
            peptideFileTreePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peptideFileTreePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fastaFileLocationTextField.setEditable(false);
        fastaFileLocationTextField.setText("fasta file");

        launchMainWindowButton.setText("go");
        launchMainWindowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchMainWindowButtonActionPerformed(evt);
            }
        });

        fastaSelectionButton.setText("select a fasta db");
        fastaSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastaSelectionButtonActionPerformed(evt);
            }
        });

        selfDigestCheckBox.setText("digest fasta file");
        selfDigestCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selfDigestCheckBoxActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(launchMainWindowButton)
                .addGap(195, 195, 195))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selfDigestCheckBox)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fastaFileLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(fastaSelectionButton)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fastaFileLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fastaSelectionButton))
                .addGap(18, 18, 18)
                .addComponent(selfDigestCheckBox)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(launchMainWindowButton)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fastaSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastaSelectionButtonActionPerformed
        JFileChooser fastaChooser = new JFileChooser();
        //fastaChooser.setFileFilter(); fastafilefilter
        fastaChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fastaChooser.setMultiSelectionEnabled(false);
        this.fastaFile = fastaChooser.getSelectedFile();
        if (fastaFile != null) {
            fastaFileLocationTextField.setText(fastaFile.getName());
        }
    }//GEN-LAST:event_fastaSelectionButtonActionPerformed

    private void launchMainWindowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchMainWindowButtonActionPerformed
        boolean goAhead = false;
        if (fastaFile == null) {
            JOptionPane.showMessageDialog(this, "please provide a fasta file");
        } else {
            new FastaDataMode(fastaFile);
            goAhead = true;
        }
        if (goAhead){
         if (selfDigestCheckBox.isSelected()){
             
         } else {
             if(jTextArea1.getText().isEmpty()){
              goAhead = false;
              JOptionPane.showMessageDialog(this, "digested peptides are needed to continue if you do not want to self digest");
             }
         }
        }
    }//GEN-LAST:event_launchMainWindowButtonActionPerformed

    private void selfDigestCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfDigestCheckBoxActionPerformed
        // TODO add your handling code here:

        if (selfDigestCheckBox.isSelected()) {
            jTextArea1.setEnabled(false);
        } else {
            jTextArea1.setEnabled(true);
        }

    }//GEN-LAST:event_selfDigestCheckBoxActionPerformed

    private void simpleDigestRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleDigestRadioButtonActionPerformed
        // TODO add your handling code here:
        if (simpleDigestRadioButton.isSelected()) {
            proteaseBox.setEnabled(true);
        }

    }//GEN-LAST:event_simpleDigestRadioButtonActionPerformed

    private void CPDTRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPDTRadioButtonActionPerformed
        // TODO add your handling code here:
        if (CPDTRadioButton.isSelected()) {
            proteaseBox.setEnabled(false);
        }
    }//GEN-LAST:event_CPDTRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CPDTRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel digestPanel;
    private javax.swing.JTextField fastaFileLocationTextField;
    private javax.swing.JButton fastaSelectionButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton launchMainWindowButton;
    private javax.swing.JPanel peptideFileTreePanel;
    private javax.swing.JComboBox proteaseBox;
    private javax.swing.JCheckBox selfDigestCheckBox;
    private javax.swing.JRadioButton simpleDigestRadioButton;
    // End of variables declaration//GEN-END:variables

    public Experiment getReferenceProject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<Experiment> getProjectsToCompare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
