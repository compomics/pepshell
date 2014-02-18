package com.compomics.pepshell.view.frames;

import com.compomics.pepshell.view.panels.LinkDbLoginDialog;
import com.compomics.pepshell.DataModeController;
import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.controllers.DAO.DbDAO;
import com.compomics.pepshell.controllers.DataModes.FastaDataMode;
import com.compomics.pepshell.controllers.DataSources.StructureDataSources.InternetStructureDataSource;
import com.compomics.pepshell.controllers.properties.DatabaseProperties;
import com.compomics.pepshell.controllers.properties.ViewProperties;
import com.compomics.pepshell.model.AnalysisGroup;
import com.compomics.pepshell.model.Experiment;
import com.compomics.pepshell.model.Property;
import com.compomics.pepshell.model.enums.DataBasePropertyEnum;
import com.compomics.pepshell.model.enums.ViewPropertyEnum;
import com.compomics.pepshell.view.panels.LoginDialog;
import java.awt.Point;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Davy
 */
public class ExperimentSelectionFrame extends javax.swing.JFrame implements Observer {

    private List<Experiment> selectedProjectsList = new ArrayList<Experiment>();
    private FaultBarrier faultBarrier = FaultBarrier.getInstance();
    private Experiment referenceProject;
    private File fastaFile;

    /**
     * Creates new form ProjectSelectionTreeFrame all this is pretty much unsafe
     * when doing reflection
     */
    public ExperimentSelectionFrame() {
        this(null);
    }

    public ExperimentSelectionFrame(Point aPoint) {
        initComponents();
        preloadProteinFilterPanel1.setVisible(false);
        preloadProteinMaskPanel1.setVisible(false);
        //went faster than setting bounds
        int x = aPoint.x - (this.getWidth() / 2);
        int y = aPoint.y - (this.getHeight() / 2);
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        this.setLocation(x, y);
        this.pack();
        this.setVisible(true);
        new LoginDialog(this, true, DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBUSERNAME.getKey()),
                DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBURL.getKey()),
                DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBNAME.getKey())).setLocationRelativeTo(this);
        try {
            fillProjectList();
        } catch (Exception ex) {
            faultBarrier.handleException(ex);
            JOptionPane.showMessageDialog(this, "something went wrong while retrieving the list of projects:\n" + ex.getMessage());
        }
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
        analyseButton = new javax.swing.JButton();
        addFastaButton = new javax.swing.JButton();
        fastaLocationTextField = new javax.swing.JTextField();
        maskProteinsCheckBox = new javax.swing.JCheckBox();
        filterSubsetCheckBox = new javax.swing.JCheckBox();
        ownFastaCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectList = new javax.swing.JList();
        removeProjectButton = new javax.swing.JButton();
        removeAnalysisGroupButton = new javax.swing.JButton();
        toProjectTreeButton = new javax.swing.JButton();
        addAnalysisGroupButton = new javax.swing.JButton();
        removeReferenceProjectButton = new javax.swing.JButton();
        addReferenceProjectButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        referenceProjectTextBox = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        projectTree = new com.compomics.pepshell.view.components.DragAndDropTree();
        preloadProteinFilterPanel1 = new com.compomics.pepshell.view.panels.PreloadProteinFilterPanel();
        preloadProteinMaskPanel1 = new com.compomics.pepshell.view.panels.PreloadProteinMaskPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        useLinkDbCheckBox = new javax.swing.JCheckBoxMenuItem();
        useInternetCheckBox = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        uniprotTranslateRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        swissprotTranslationRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        genbankTranslationRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        fetchDomainDataCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        fetchPdbDataCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("project selection");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(708, 807));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        experimentSelectionPanel.setBackground(new java.awt.Color(255, 255, 255));
        experimentSelectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        analyseButton.setText("proceed...");
        analyseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyseButtonActionPerformed(evt);
            }
        });

        addFastaButton.setText("add fasta");
        addFastaButton.setEnabled(false);
        addFastaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFastaButtonActionPerformed(evt);
            }
        });

        fastaLocationTextField.setEditable(false);

        maskProteinsCheckBox.setText("mask proteins");
        maskProteinsCheckBox.setMargin(new java.awt.Insets(2, 0, 2, 2));
        maskProteinsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maskProteinsCheckBoxActionPerformed(evt);
            }
        });

        filterSubsetCheckBox.setText("filter proteins");
        filterSubsetCheckBox.setMargin(new java.awt.Insets(2, 0, 2, 2));
        filterSubsetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterSubsetCheckBoxActionPerformed(evt);
            }
        });

        ownFastaCheckBox.setText("use own fasta file");
        ownFastaCheckBox.setMargin(new java.awt.Insets(2, 0, 2, 2));
        ownFastaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownFastaCheckBoxActionPerformed(evt);
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(199, 354));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(199, 354));

        projectList.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        projectList.setMinimumSize(new java.awt.Dimension(199, 354));
        projectList.setPreferredSize(new java.awt.Dimension(199, 354));
        jScrollPane1.setViewportView(projectList);

        removeProjectButton.setText("remove project");
        removeProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProjectButtonActionPerformed(evt);
            }
        });

        removeAnalysisGroupButton.setText("remove selected projectgroup");
        removeAnalysisGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnalysisGroupButtonActionPerformed(evt);
            }
        });

        toProjectTreeButton.setText("add project");
        toProjectTreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toProjectTreeButtonActionPerformed(evt);
            }
        });

        addAnalysisGroupButton.setText("add a projectgroup");
        addAnalysisGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnalysisGroupButtonActionPerformed(evt);
            }
        });

        removeReferenceProjectButton.setText("remove reference project");
        removeReferenceProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeReferenceProjectButtonActionPerformed(evt);
            }
        });

        addReferenceProjectButton.setText("add reference project");
        addReferenceProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReferenceProjectButtonActionPerformed(evt);
            }
        });

        referenceProjectTextBox.setColumns(20);
        referenceProjectTextBox.setRows(5);
        referenceProjectTextBox.setEnabled(false);
        referenceProjectTextBox.setMinimumSize(new java.awt.Dimension(232, 92));
        jScrollPane2.setViewportView(referenceProjectTextBox);

        projectTree.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        projectTree.setMinimumSize(new java.awt.Dimension(113, 19));
        jScrollPane3.setViewportView(projectTree);

        javax.swing.GroupLayout experimentSelectionPanelLayout = new javax.swing.GroupLayout(experimentSelectionPanel);
        experimentSelectionPanel.setLayout(experimentSelectionPanelLayout);
        experimentSelectionPanelLayout.setHorizontalGroup(
            experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(removeAnalysisGroupButton)
                            .addComponent(removeProjectButton)
                            .addComponent(toProjectTreeButton)
                            .addComponent(addAnalysisGroupButton)
                            .addComponent(removeReferenceProjectButton)
                            .addComponent(addReferenceProjectButton)))
                    .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                        .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maskProteinsCheckBox)
                            .addComponent(ownFastaCheckBox))
                        .addGap(0, 0, 0)
                        .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterSubsetCheckBox)
                            .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(fastaLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addFastaButton)))))
                .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, experimentSelectionPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(analyseButton))
                    .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        experimentSelectionPanelLayout.setVerticalGroup(
            experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(experimentSelectionPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(addReferenceProjectButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeReferenceProjectButton)
                        .addGap(57, 57, 57)
                        .addComponent(addAnalysisGroupButton)
                        .addGap(18, 18, 18)
                        .addComponent(toProjectTreeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeProjectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeAnalysisGroupButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, experimentSelectionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, experimentSelectionPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ownFastaCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fastaLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFastaButton))
                .addGap(5, 5, 5)
                .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(analyseButton)
                    .addGroup(experimentSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maskProteinsCheckBox)
                        .addComponent(filterSubsetCheckBox)))
                .addContainerGap())
        );

        preloadProteinFilterPanel1.setBackground(new java.awt.Color(255, 255, 255));
        preloadProteinFilterPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        preloadProteinMaskPanel1.setBackground(new java.awt.Color(255, 255, 255));
        preloadProteinMaskPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(experimentSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preloadProteinFilterPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preloadProteinMaskPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(experimentSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preloadProteinFilterPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preloadProteinMaskPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
        );

        jMenu1.setText("data sources");

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

        jMenuItem1.setText("connect to data db");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("retrieval steps");

        jMenu3.setText("translate accessions to");

        uniprotTranslateRadioButtonMenuItem.setText("uniprot");
        jMenu3.add(uniprotTranslateRadioButtonMenuItem);

        swissprotTranslationRadioButtonMenuItem.setText("swissprot");
        jMenu3.add(swissprotTranslationRadioButtonMenuItem);

        genbankTranslationRadioButtonMenuItem.setText("genbank");
        jMenu3.add(genbankTranslationRadioButtonMenuItem);

        jMenu2.add(jMenu3);

        fetchDomainDataCheckBoxMenuItem.setSelected(true);
        fetchDomainDataCheckBoxMenuItem.setText("fetch domain-related data");
        jMenu2.add(fetchDomainDataCheckBoxMenuItem);

        fetchPdbDataCheckBoxMenuItem.setSelected(true);
        fetchPdbDataCheckBoxMenuItem.setText("fetch pdb data for proteins");
        jMenu2.add(fetchPdbDataCheckBoxMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void analyseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseButtonActionPerformed
        // TODO add your handling code here:

        boolean goAhead = false;
        //can we actually continue?
        List<AnalysisGroup> analysisList = new ArrayList<AnalysisGroup>();
        if (!selectedProjectsList.isEmpty() && referenceProject != null) {
            AnalysisGroup rogueProjects = new AnalysisGroup("Analysis");
            Enumeration tree = ((TreeNode) projectTree.getModel().getRoot()).children();
            while (tree.hasMoreElements()) {
                Object anObject = tree.nextElement();
                if (((DefaultMutableTreeNode) anObject).getUserObject() instanceof Experiment) {
                    rogueProjects.addExperiment((Experiment) ((DefaultMutableTreeNode) anObject).getUserObject());
                } else if (((DefaultMutableTreeNode) anObject).getUserObject() instanceof AnalysisGroup) {
                    analysisList.add((AnalysisGroup) ((DefaultMutableTreeNode) anObject).getUserObject());
                }
                DataModeController.setDataSource(DataModeController.DataSource.DATABASE);
            }

            if (!rogueProjects.getExperiments().isEmpty()) {
                analysisList.add(rogueProjects);
            }
            goAhead = true;
            if (ownFastaCheckBox.isSelected() && fastaFile != null && goAhead) {
                //this sure as hell can be better
                DataModeController.setDb(DataModeController.Db.FASTA);
                ((FastaDataMode) DataModeController.getDb().getDataMode()).setFastaFile(fastaFile);
            } else if (ownFastaCheckBox.isSelected() && fastaFile == null) {
                goAhead = false;
            }
        }
        if (filterSubsetCheckBox.isSelected()) {
            if (!preloadProteinFilterPanel1.getProteinsToFilterWith().isEmpty()) {
                DataModeController.getDb().getDataMode().getViewPreparationForMode().hasToFilter(true);
                DataModeController.getDb().getDataMode().getViewPreparationForMode().setProteinsToFilter(preloadProteinFilterPanel1.getProteinsToFilterWith());
            } else {
                JOptionPane.showMessageDialog(this, "empty filter set, was ignored");
            }
        }
        if (maskProteinsCheckBox.isSelected()) {
            if (!preloadProteinMaskPanel1.getProteinsToMaskWith().isEmpty()) {
                DataModeController.getDb().getDataMode().getViewPreparationForMode().hasToMask(true);
                DataModeController.getDb().getDataMode().getViewPreparationForMode().setProteinMasks(preloadProteinMaskPanel1.getProteinsToMaskWith());
            } else {
                JOptionPane.showMessageDialog(this, "empty masking set, was ignored");
            }
        }

        if (fetchDomainDataCheckBoxMenuItem.isSelected()) {
            DataModeController.getDb().getDataMode().getViewPreparationForMode().hasToFetchDomainData(true);
        }

        if (fetchPdbDataCheckBoxMenuItem.isSelected()) {
            DataModeController.getDb().getDataMode().getViewPreparationForMode().hasToRetrievePDBData(true);
        }

        if (uniprotTranslateRadioButtonMenuItem.isSelected() || swissprotTranslationRadioButtonMenuItem.isSelected() || genbankTranslationRadioButtonMenuItem.isSelected()) {
            //TODO actually set what to translate to
            DataModeController.getDb().getDataMode().getViewPreparationForMode().hasToTranslateAccessions(false);
        }

        if (goAhead) {
            MainWindow window = new MainWindow();
            faultBarrier.addObserver(window);
            window.setVisible(true);
            this.dispose();
            window.collectData(referenceProject, analysisList);
        } else {
            JOptionPane.showMessageDialog(this, "please make sure you have a reference project, one or more projects to compare to and if requested, have supplied a fasta");
        }
    }//GEN-LAST:event_analyseButtonActionPerformed

    private void addReferenceProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReferenceProjectButtonActionPerformed

        if (projectList.getSelectedValue() != null) {
            referenceProject = (Experiment) projectList.getSelectedValue();
            referenceProjectTextBox.setText(referenceProject.getExperimentName());
        }
// TODO add your handling code here:
    }//GEN-LAST:event_addReferenceProjectButtonActionPerformed

    private void removeReferenceProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeReferenceProjectButtonActionPerformed
        if (!referenceProjectTextBox.getText().isEmpty()) {
            referenceProject = null;
            referenceProjectTextBox.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_removeReferenceProjectButtonActionPerformed

    private void addAnalysisGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnalysisGroupButtonActionPerformed
        // TODO add your handling code here:
        String temp = JOptionPane.showInputDialog(this);
        if (temp != null) {
            if (!temp.isEmpty()) {
                projectTree.addObject(new AnalysisGroup(temp));
            }
        }
    }//GEN-LAST:event_addAnalysisGroupButtonActionPerformed

    private void toProjectTreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toProjectTreeButtonActionPerformed
        if (!selectedProjectsList.contains((Experiment) projectList.getSelectedValue())) {
            DefaultMutableTreeNode projectNode = projectTree.addObject(projectList.getSelectedValue());
            projectNode.setAllowsChildren(false);
            selectedProjectsList.add((Experiment) projectList.getSelectedValue());
        }
    }//GEN-LAST:event_toProjectTreeButtonActionPerformed

    private void removeProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProjectButtonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (projectTree.getSelectionPath() != null) {
            if (projectTree.getSelectionPath().getLastPathComponent() instanceof Experiment) {
                selectedProjectsList.remove((Experiment) projectTree.getSelectionPath().getLastPathComponent());
                projectTree.removeCurrentNode();
            }
        }
    }//GEN-LAST:event_removeProjectButtonActionPerformed

    private void removeAnalysisGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAnalysisGroupButtonActionPerformed

        if (projectTree.getSelectionPath() != null) {
            if (projectTree.getSelectionPath().getLastPathComponent() instanceof AnalysisGroup) {
                projectTree.removeCurrentNode();
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_removeAnalysisGroupButtonActionPerformed

    private void addFastaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFastaButtonActionPerformed
        JFileChooser fastaChooser = new JFileChooser();
        fastaChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fastaChooser.setMultiSelectionEnabled(false);
        fastaChooser.showOpenDialog(this);
        this.fastaFile = fastaChooser.getSelectedFile();
        if (fastaFile != null) {
            fastaLocationTextField.setText(fastaFile.getName());
            ViewProperties.getInstance().setProperty(new Property(ViewPropertyEnum.PROTEINFASTALOCATION, fastaFile.getAbsolutePath()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addFastaButtonActionPerformed

    private void ownFastaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownFastaCheckBoxActionPerformed
        // TODO add your handling code here:
        if (ownFastaCheckBox.isSelected()) {
            addFastaButton.setEnabled(true);
            fastaFile = new File(ViewProperties.getInstance().getProperty(ViewPropertyEnum.PROTEINFASTALOCATION.getKey()));
            fastaLocationTextField.setText(fastaFile.getName());
        } else {
            addFastaButton.setEnabled(false);
        }
    }//GEN-LAST:event_ownFastaCheckBoxActionPerformed

    private void filterSubsetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterSubsetCheckBoxActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
        if (maskProteinsCheckBox.isSelected()) {
            preloadProteinMaskPanel1.setVisible(true);
            this.pack();
            this.repaint();
        } else {
            preloadProteinMaskPanel1.setVisible(false);
            this.pack();
            this.repaint();
        }
    }//GEN-LAST:event_maskProteinsCheckBoxActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        LoginDialog dialog = new LoginDialog(this, true, DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBUSERNAME.getKey()),
                DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBURL.getKey()),
                DatabaseProperties.getInstance().getProperties().getProperty(DataBasePropertyEnum.DBNAME.getKey()));
        dialog.setLocationRelativeTo(this);
        try {
            fillProjectList();
            projectTree.removeAll();
        } catch (Exception ex) {
            faultBarrier.handleException(ex);
            JOptionPane.showMessageDialog(this, "something went wrong while retrieving the list of projects:\n" + ex.getMessage());
        }
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAnalysisGroupButton;
    private javax.swing.JButton addFastaButton;
    private javax.swing.JButton addReferenceProjectButton;
    private javax.swing.JButton analyseButton;
    private javax.swing.JPanel experimentSelectionPanel;
    private javax.swing.JTextField fastaLocationTextField;
    private javax.swing.JCheckBoxMenuItem fetchDomainDataCheckBoxMenuItem;
    private javax.swing.JCheckBoxMenuItem fetchPdbDataCheckBoxMenuItem;
    private javax.swing.JCheckBox filterSubsetCheckBox;
    private javax.swing.JRadioButtonMenuItem genbankTranslationRadioButtonMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox maskProteinsCheckBox;
    private javax.swing.JCheckBox ownFastaCheckBox;
    private com.compomics.pepshell.view.panels.PreloadProteinFilterPanel preloadProteinFilterPanel1;
    private com.compomics.pepshell.view.panels.PreloadProteinMaskPanel preloadProteinMaskPanel1;
    private javax.swing.JList projectList;
    private com.compomics.pepshell.view.components.DragAndDropTree projectTree;
    private javax.swing.JTextArea referenceProjectTextBox;
    private javax.swing.JButton removeAnalysisGroupButton;
    private javax.swing.JButton removeProjectButton;
    private javax.swing.JButton removeReferenceProjectButton;
    private javax.swing.JRadioButtonMenuItem swissprotTranslationRadioButtonMenuItem;
    private javax.swing.JButton toProjectTreeButton;
    private javax.swing.JRadioButtonMenuItem uniprotTranslateRadioButtonMenuItem;
    private javax.swing.JCheckBoxMenuItem useInternetCheckBox;
    private javax.swing.JCheckBoxMenuItem useLinkDbCheckBox;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object o1) {
        if (o1 != null) {
            if (o1 instanceof Exception) {
                faultBarrier.handleException((Exception) o1);
            }
        }
    }

    private void fillProjectList() throws SQLException {
        projectList.setListData(DbDAO.getProjects().toArray());
    }
}
