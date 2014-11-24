package com.compomics.pepshell.view.panels;

import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.controllers.comparators.ComparePdbInfoByResolution;
import com.compomics.pepshell.model.Experiment;
import com.compomics.pepshell.model.PdbInfo;
import com.compomics.pepshell.model.ProteinInterface;
import com.compomics.pepshell.view.DrawModes.DrawProteinPeptidesInterface;
import com.compomics.pepshell.view.DrawModes.Peptides.QuantedPeptideDrawMode;
import com.compomics.pepshell.view.DrawModes.Proteins.FreeEnergyProteinDrawMode;
import com.compomics.pepshell.view.DrawModes.Proteins.HydrophobicityProteinDrawMode;
import com.compomics.pepshell.view.DrawModes.Proteins.SecondaryStructureProteinDrawMode;
import com.compomics.pepshell.view.DrawModes.Proteins.SolventAccessibleProteinDrawMode;
import com.compomics.pepshell.view.DrawModes.AbstractPeptideProteinDrawMode;
import com.compomics.pepshell.view.DrawModes.DrawModeUtilities;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;

import javax.swing.JOptionPane;

/**
 *
 * @author Davy Maddelein
 */
class ReferenceExperimentPanel extends javax.swing.JPanel {

    public static final String NO_PDB_FILES_FOUND = "no PDBs found";

    private Experiment referenceExperiment;

    private Integer startingZoomCoordinate = 0;
    private Integer endingZoomCoordinate = 0;
    
    /**
     * Creates new form ReferenceExperimentPanel
     */
    public ReferenceExperimentPanel() {
        initComponents();

        referenceProteinScrollPane.getViewport().setOpaque(false);
        referenceProteinScrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
        pdbSelectionComboBox.setEnabled(false);
    }

    public ReferenceExperimentPanel(Experiment project) {
        this();
        projectNameLabel.setText(project.getExperimentName());
    }

    public void updateProtein(ProteinInterface protein) {
        pdbSelectionComboBox.removeAllItems();

        if (protein.getPdbFilesInfo().isEmpty()) {
            //retrieve the PDB info objects and add them to the protein
            protein.addPdbFileInfo(ProgramVariables.STRUCTUREDATASOURCE.getPdbInforForProtein(protein, new ComparePdbInfoByResolution()));
        }
        //check after retrieval if any PDB info is available
        if (protein.getPdbFilesInfo().isEmpty()) {
            //add a default item
            PdbInfo defaultPdbInfo = new PdbInfo();
            defaultPdbInfo.setPdbAccession("no pdb files found");
            pdbSelectionComboBox.addItem(defaultPdbInfo);
        } else {
            for (PdbInfo pdbInfo : protein.getPdbFilesInfo()) {
                pdbSelectionComboBox.addItem(pdbInfo);
            }
        }

        //set selected item
        pdbSelectionComboBox.setSelectedIndex(0);

        //update the draw panel
        referenceProteinDrawPanel.updateProtein(protein);
    }

    public void setReferenceExperiment(Experiment reference) {
        this.referenceExperiment = reference;
        projectNameLabel.setText(referenceExperiment.getExperimentName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        experimentPopupMenu = new javax.swing.JPopupMenu();
        changeNameOption = new javax.swing.JMenuItem();
        exportImageToPDFOption = new javax.swing.JMenuItem();
        optionsPanel = new javax.swing.JPanel();
        quantCheckBox = new javax.swing.JCheckBox();
        drawModeChooser = new javax.swing.JComboBox();
        pdbSelectionComboBox = new javax.swing.JComboBox<PdbInfo>();
        projectNameLabel = new javax.swing.JLabel();
        referenceProteinScrollPane = new javax.swing.JScrollPane();

        changeNameOption.setText("change name of the selected experiment");
        changeNameOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameOptionActionPerformed(evt);
            }
        });
        experimentPopupMenu.add(changeNameOption);

        exportImageToPDFOption.setText("export this image to PDF");
        experimentPopupMenu.add(exportImageToPDFOption);

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 180));

        optionsPanel.setOpaque(false);

        quantCheckBox.setText("show quantitfied range");
        quantCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantCheckBoxActionPerformed(evt);
            }
        });

        drawModeChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "hydrophobicity", "secondary structure", "free energy", "solvent accessibility" }));
        drawModeChooser.setPreferredSize(new java.awt.Dimension(122, 25));
        drawModeChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawModeChooserActionPerformed(evt);
            }
        });

        pdbSelectionComboBox.setMinimumSize(new java.awt.Dimension(122, 25));
        pdbSelectionComboBox.setPreferredSize(new java.awt.Dimension(122, 25));
        pdbSelectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdbSelectionComboBoxActionPerformed(evt);
            }
        });

        projectNameLabel.setMaximumSize(new java.awt.Dimension(1600, 300));
        projectNameLabel.setMinimumSize(new java.awt.Dimension(50, 30));
        projectNameLabel.setPreferredSize(new java.awt.Dimension(50, 30));

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(drawModeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pdbSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quantCheckBox)
                        .addGap(0, 515, Short.MAX_VALUE))
                    .addComponent(projectNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(drawModeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantCheckBox)
                    .addComponent(pdbSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE))
        );

        referenceProteinScrollPane.setBorder(null);
        referenceProteinScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(referenceProteinScrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referenceProteinScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void drawModeChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawModeChooserActionPerformed
        if (referenceProteinDrawPanel.getProtein() != null) {
            DrawProteinPeptidesInterface secondaryDrawMode;
            PdbInfo pdbAccession = null;

            //disable PDB selection combobox
            pdbSelectionComboBox.setEnabled(false);

            switch (drawModeChooser.getSelectedIndex()) {
                case 0:
                    secondaryDrawMode = new HydrophobicityProteinDrawMode();
                    break;
                case 1:
                    secondaryDrawMode = new SecondaryStructureProteinDrawMode();
                    if (ProgramVariables.STRUCTUREDATASOURCE != null) {
                        pdbSelectionComboBox.setEnabled(true);
                        pdbAccession = (PdbInfo) pdbSelectionComboBox.getSelectedItem();
                    }
                    break;
                case 2:
                    secondaryDrawMode = new FreeEnergyProteinDrawMode();
                    pdbSelectionComboBox.setEnabled(true);
                    pdbAccession = (PdbInfo) pdbSelectionComboBox.getSelectedItem();
                    break;
                case 3:
                    secondaryDrawMode = new SolventAccessibleProteinDrawMode();
                    pdbSelectionComboBox.setEnabled(true);
                    pdbAccession = (PdbInfo) pdbSelectionComboBox.getSelectedItem();
                    break;
                default:
                    secondaryDrawMode = new HydrophobicityProteinDrawMode();
                    break;
            }
            referenceProteinDrawPanel.updateSecondaryDrawMode(secondaryDrawMode, pdbAccession);
        } else {
            JOptionPane.showMessageDialog(this.getParent(), "Please select a protein from the list.", "Draw mode selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_drawModeChooserActionPerformed

    private void quantCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantCheckBoxActionPerformed
        DrawProteinPeptidesInterface proteinDrawMode;
        if (quantCheckBox.isSelected()) {
            proteinDrawMode = new QuantedPeptideDrawMode<>();
        } else {
            proteinDrawMode = new AbstractPeptideProteinDrawMode();
        }
          referenceProteinDrawPanel.updateMainProteinDrawMode(proteinDrawMode);
    }//GEN-LAST:event_quantCheckBoxActionPerformed

    private void changeNameOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameOptionActionPerformed
        // TODO add your handling code here:
        projectNameLabel.setText(JOptionPane.showInputDialog("change name of " + projectNameLabel.getText()));

    }//GEN-LAST:event_changeNameOptionActionPerformed

    private void pdbSelectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdbSelectionComboBoxActionPerformed
        if (pdbSelectionComboBox.getSelectedItem() != null) {
            PdbInfo pdbAccession = (PdbInfo) pdbSelectionComboBox.getSelectedItem();
            referenceProteinDrawPanel.updatePdbInfo(pdbAccession);
        }
    }//GEN-LAST:event_pdbSelectionComboBoxActionPerformed

    private void referenceProteinDrawPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceProteinDrawPanelMouseDragged
        // TODO add your handling code here:
        endingZoomCoordinate = evt.getX();

    }//GEN-LAST:event_referenceProteinDrawPanelMouseDragged

    private void referenceProteinDrawPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceProteinDrawPanelMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_referenceProteinDrawPanelMousePressed

    private void referenceProteinDrawPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceProteinDrawPanelMouseClicked
        // TODO add your handling code here:
        if (evt.isShiftDown()) {
            DrawModeUtilities.getInstance().getCurrentScalingStrategy().getCurrentStrategy().setScale(1.0);
            this.repaint();
        }
    }//GEN-LAST:event_referenceProteinDrawPanelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changeNameOption;
    private javax.swing.JComboBox drawModeChooser;
    private javax.swing.JPopupMenu experimentPopupMenu;
    private javax.swing.JMenuItem exportImageToPDFOption;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JComboBox<PdbInfo> pdbSelectionComboBox;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JCheckBox quantCheckBox;
    private javax.swing.JScrollPane referenceProteinScrollPane;
    // End of variables declaration//GEN-END:variables

    BoundedRangeModel getHorizontalScrollBarModel() {
        return referenceProteinScrollPane.getHorizontalScrollBar().getModel();
    }

}
