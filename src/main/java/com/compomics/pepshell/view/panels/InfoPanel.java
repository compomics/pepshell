package com.compomics.pepshell.view.panels;

import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.model.AnalysisGroup;
import com.compomics.pepshell.model.Experiment;
import com.compomics.pepshell.model.PeptideGroup;
import com.compomics.pepshell.model.Protein;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davy
 */
public class InfoPanel extends javax.swing.JPanel {

    private Experiment referenceExperiment;

    public InfoPanel() {
        initComponents();
    }

    public InfoPanel(Experiment referenceExperiment, AnalysisGroup aGroup) {
        this();
        this.referenceExperiment = referenceExperiment;
        setExperimentsToDisplay(aGroup);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sequenceCoveragePanel = new com.compomics.pepshell.view.panels.SequenceCoveragePanel();
        peptidesProteinsOverlapPanel1 = new com.compomics.pepshell.view.panels.PeptidesProteinsOverlapPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sequenceCoveragePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peptidesProteinsOverlapPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(peptidesProteinsOverlapPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sequenceCoveragePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void updateProteinGraphics(Protein proteinOfInterest) throws SQLException {
        sequenceCoveragePanel.showProteinCoverage(proteinOfInterest.getProteinSequence(), proteinOfInterest.getPeptideGroupsForProtein().iterator(), true);
        double test = (double) (peptidesProteinsOverlapPanel1.getWidth() - 100);
        ProgramVariables.SCALE = (double) proteinOfInterest.getProteinSequence().length() / (double) (peptidesProteinsOverlapPanel1.getWidth() - 100);
        peptidesProteinsOverlapPanel1.setProtein(proteinOfInterest);
        peptidesProteinsOverlapPanel1.revalidate();
        peptidesProteinsOverlapPanel1.repaint();
        updatePeptideGraphics(proteinOfInterest);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.compomics.pepshell.view.panels.PeptidesProteinsOverlapPanel peptidesProteinsOverlapPanel1;
    private com.compomics.pepshell.view.panels.SequenceCoveragePanel sequenceCoveragePanel;
    // End of variables declaration//GEN-END:variables

    /**
     * sets the project do display the peptides from in relation to the
     * reference experiment
     *
     * @param toCompareProjects the projects to compare
     * @param condense should the experiments be treated as a group or not
     */
    public void setExperimentsToDisplay(List<Experiment> experiments, boolean condense) {
        jPanel1.setLayout(new GridBagLayout());
        for (int i = 0; i < experiments.size(); i++) {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.fill = GridBagConstraints.BOTH;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            gridBagConstraints.gridy = i;
            gridBagConstraints.anchor = GridBagConstraints.CENTER;
            PeptidesOnlyPanel panel = new PeptidesOnlyPanel(experiments.get(i));
            panel.setExperiment(experiments.get(i));
            panel.setYOffset(panel.getSize().getHeight() * i);
            //change with smarter clustering jpanel
            jPanel1.add(panel, gridBagConstraints);
        }
        jPanel1.revalidate();
        jPanel1.repaint();

    }

    public Experiment getReferenceExperiment() {
        return referenceExperiment;
    }

    public void setReferenceExperiment(Experiment aReferenceExperiment) {
        this.referenceExperiment = aReferenceExperiment;
    }

    public final void setExperimentsToDisplay(List<Experiment> experiments) {
        setExperimentsToDisplay(experiments, true);
    }

    private void updatePeptideGraphics(Protein aProtein) {
        for (int i = 0; i < jPanel1.getComponents().length; i++) {
            ((PeptidesOnlyPanel) jPanel1.getComponent(i)).setProtein(aProtein);
        }
    }

    protected void setSequenceCoverage(String proteinSequence, PeptideGroup aPeptideGroup) {
        // this is a very quick fix to get updating sequence coverage but has to be refined
        List<PeptideGroup> tempList = new ArrayList<PeptideGroup>();
        tempList.add(aPeptideGroup);
        sequenceCoveragePanel.showProteinCoverage(proteinSequence, tempList.iterator(), false);
    }

    protected void setSequenceCoverageToOriginal() {
        if (!sequenceCoveragePanel.isOriginalCoverage()) {
            sequenceCoveragePanel.setOriginalCoverage();
        }
    }
}