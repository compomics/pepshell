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

package com.compomics.pepshell.view.dataviewing;

import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.controllers.DAO.WebDAO;
import com.compomics.pepshell.model.Experiment;
import com.compomics.pepshell.model.PeptideGroup;
import com.compomics.pepshell.model.Protein;
import com.compomics.pepshell.model.ProteinInterface;
import com.compomics.pepshell.model.exceptions.ConversionException;
import com.compomics.pepshell.model.exceptions.UndrawableException;
import com.compomics.pepshell.view.DrawModes.GradientDrawModeInterface;
import com.compomics.pepshell.view.DrawModes.Peptides.IntensityPeptideDrawMode;
import com.compomics.pepshell.view.DrawModes.Peptides.QuantedPeptideDrawMode;
import com.compomics.pepshell.view.DrawModes.Proteins.DomainProteinDrawMode;
import com.compomics.pepshell.view.DrawModes.AbstractPeptideProteinDrawMode;
import com.compomics.pepshell.view.DrawModes.DrawModeUtilities;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Davy Maddelein
 */
class ExperimentPanel extends javax.swing.JPanel {

    private int horizontalOffset = this.getX() + 15;
    private int verticalOffset = 25;
    private Protein protein;
    private AbstractPeptideProteinDrawMode proteinDrawMode = new IntensityPeptideDrawMode();
    private boolean recalculate = true;
    private Experiment experiment;
    private String experimentName;
    private boolean nameChanged = false;
    private BufferedImage cachedImage;
    private int startingZoomCoordinate;
    private int endingZoomCoordinate;
    private double scale = 1.0;
    private boolean proteinChanged = true;
    private DomainProteinDrawMode domainBackgroundDrawMode = new DomainProteinDrawMode();

    /**
     * Creates new form PeptidesProteinsOverlapGUI
     */
    private ExperimentPanel() {
        initComponents();
        this.addMouseListener(new popupMenuListener());
    }

    public ExperimentPanel(Experiment experiment) {
        this();
        this.experiment = experiment;
        ((IntensityPeptideDrawMode) proteinDrawMode).setMaxIntensity(experiment.getMaxIntensity());
        experimentName = experiment.getExperimentName();
        projectNameLabel.setText(experiment.getExperimentName());
    }

    public void setProtein(ProteinInterface aProtein) {
        try {
            if (this.protein == null || !this.protein.equals(aProtein)) {
                this.protein = experiment.getProteins().get(experiment.getProteins().indexOf(aProtein));
                if (!aProtein.getDomains().isEmpty()) {
                    this.protein.addDomains(aProtein.getDomains());
                }
                proteinChanged = true;
            }
        } catch (IndexOutOfBoundsException e) {
            this.protein = null;
        }
        this.revalidate();
        this.repaint();
    }

    public void setXoffset(int anXoffset) {
        horizontalOffset = anXoffset;
    }

    public String getProjectNameForPanel() {
        return projectNameLabel.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        experimentPopupMenu = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        projectNameLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        jMenuItem1.setText("change name of selected experiment");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        experimentPopupMenu.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        experimentPopupMenu.add(jMenuItem2);

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 65));
        setMinimumSize(new java.awt.Dimension(1000, 65));
        setPreferredSize(new java.awt.Dimension(1000, 65));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        projectNameLabel.setMaximumSize(new java.awt.Dimension(1600, 300));
        projectNameLabel.setMinimumSize(new java.awt.Dimension(50, 30));
        projectNameLabel.setPreferredSize(new java.awt.Dimension(50, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "intensity", "ratio" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        //replace with a hashset and call contains
        if (protein != null) {
            for (PeptideGroup peptideGroup : protein.getPeptideGroups()) {
                if (evt.getX() >= (int) Math.ceil((double) horizontalOffset + peptideGroup.getStartingAlignmentPosition() * ProgramVariables.SCALE) && evt.getX() <= (int) Math.ceil((double) horizontalOffset + peptideGroup.getEndAlignmentPosition() * ProgramVariables.SCALE)) {
                    //dirty
                    Protein aProtein = new Protein(protein.getProteinSequence());
                    if (!protein.getDomains().isEmpty()) {
                        aProtein.addDomains(protein.getDomains());
                    }
                    aProtein.addPeptideGroup(peptideGroup);
                    ((ProteinDetailPanel) this.getParent().getParent().getParent().getParent()).setSequenceCoverage(protein.getProteinSequence(), aProtein);
                }
            }
        }
    }//GEN-LAST:event_formMouseMoved

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        projectNameLabel.setText(JOptionPane.showInputDialog("change experiment name to " + projectNameLabel.getText()));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO fix this by adding the draw modes to the combobox and invoke the selected one, then this only has to call a redraw, this can then be further optimized by keeping the previous selected index and redraw only on change
        if (jComboBox1.getSelectedIndex() == 0) {
            if (proteinDrawMode instanceof IntensityPeptideDrawMode) {
                proteinDrawMode = new IntensityPeptideDrawMode();
                ((IntensityPeptideDrawMode) proteinDrawMode).setMaxIntensity(experiment.getMaxIntensity());
                recalculate = true;
            }
        } else if (jComboBox1.getSelectedIndex() == 1) {
            if (proteinDrawMode instanceof QuantedPeptideDrawMode) {
                proteinDrawMode = new QuantedPeptideDrawMode<>();
                ((QuantedPeptideDrawMode) proteinDrawMode).setMaxRatio(experiment.getMaxRatio());
                recalculate = true;
            }
        }
        if (recalculate) {
            this.repaint();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        //when extracting this code to it's own mouse adapter flip the scale calculations so the doubles are always bigger than 1 instead of smaller
        endingZoomCoordinate = evt.getX() + 15;
        Double tempScale = (double) (endingZoomCoordinate / startingZoomCoordinate);
        if (tempScale * protein.getProteinSequence().length() < 1) {
            // zoomed in to a value greater than one amino acid
            tempScale = (double) 10 / protein.getProteinSequence().length();
        } else {
            if (tempScale < 1) {
                //dragged to the left
                scale = tempScale;
            } else {
                //dragged to the right, flip the start and end
                endingZoomCoordinate = startingZoomCoordinate;
                startingZoomCoordinate = evt.getX() + 15;
                if ((1 / tempScale) * protein.getProteinSequence().length() < 1) {
                } else {
                    scale = 1 / tempScale;
                }
            }
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        //add scrolling support if(evt.getMouseButton is scrollup) increase zoom with 10% centered on the mouse location
        // same as above but reduce by 10%
        startingZoomCoordinate = evt.getX() + 15;


    }//GEN-LAST:event_formMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu experimentPopupMenu;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel projectNameLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paintComponent(Graphics g) {
        //replace protein recalculation with a buffered image to display
        super.paintComponent(g);
        if (protein != null) {
            if (!nameChanged) {
                projectNameLabel.setText(experimentName);
            }
            if (protein.getProteinSequence().isEmpty()) {
                try {
                    protein.setSequence(WebDAO.fetchSequence(protein.getProteinAccession()));
                } catch (IOException | ConversionException e) {
                    FaultBarrier.getInstance().handleException(e);
                }
            }
            if (!protein.getProteinSequence().isEmpty()) {
                if (recalculate) {
                    Point offsetPoint = new Point(horizontalOffset, verticalOffset + 10);
                    int width = DrawModeUtilities.getInstance().scale(protein.getProteinSequence().length());
                    BufferedImage tempImage = new BufferedImage(width + 65, ProgramVariables.VERTICALSIZE + 10, BufferedImage.TYPE_INT_ARGB);
                    try {
                        //proteinDrawMode.drawProtein(protein, tempImage.getGraphics(), horizontalOffset, verticalOffset + 5, horizontalBarSize, ProgramVariables.VERTICALSIZE); //((DrawableProtein) protein).draw(horizontalOffset, verticalOffset, g);
                        proteinDrawMode.drawProteinAndPeptides(protein, g, offsetPoint, width, ProgramVariables.VERTICALSIZE); //((DrawableProtein) protein).draw(horizontalOffset, verticalOffset, g);
                    } catch (UndrawableException ex) {
                        FaultBarrier.getInstance().handleException(ex);
                    }
                    if (!protein.getDomains().isEmpty()) {
                        try {
                            domainBackgroundDrawMode.setProteinAlpha(0.18f);
                            domainBackgroundDrawMode.drawProteinAndPeptides(protein, g, offsetPoint, width, this.getHeight());
                        } catch (UndrawableException ex) {
                            FaultBarrier.getInstance().handleException(ex);
                        }
                        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
                    }
                    cachedImage = tempImage;
                    //((GradientDrawModeInterface) peptideDrawMode).drawColorLegend(horizontalOffset + horizontalBarSize + 15, 50, g);
                    ((GradientDrawModeInterface) proteinDrawMode).drawColorLegend(new Point(offsetPoint.x + width + 15, 50), tempImage.getGraphics());

                    recalculate = true;

                }
            } else {
                projectNameLabel.setText(experimentName + ": protein not found");
            }
        }
        if (cachedImage != null) {
            //this.getGraphics().drawImage(cachedImage, horizontalOffset, verticalOffset, null);
            proteinChanged = false;
        }
        //if the cached image works, the zooming logic can be extracted to its own mouse adapter class and this can turn into a static method in a zoom controller
    }

    void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    void setYOffset(double height) {
        verticalOffset = (int) (verticalOffset + height);
    }

    public void scaleToDimension(Dimension dimension) {
        //if one panel zooms in, all zoom in so we zoom to the passed dimension
    }

    private class popupMenuListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                experimentPopupMenu.show(e.getComponent(),
                        e.getX(), e.getY());
            }
        }

    }
}