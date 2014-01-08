package com.compomics.peppi.view.frames;

import com.compomics.peppi.DataModeController;
import com.compomics.peppi.FaultBarrier;
import com.compomics.peppi.controllers.DAO.DbDAO;
import com.compomics.peppi.controllers.DataModes.FastaDataMode;
import com.compomics.peppi.controllers.properties.ViewProperties;
import com.compomics.peppi.model.AnalysisGroup;
import com.compomics.peppi.model.Project;
import com.compomics.peppi.model.Property;
import com.compomics.peppi.model.enums.ViewPropertyEnum;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Davy
 */
public class ProjectSelectionTreeFrame extends javax.swing.JFrame implements Observer {

    private Set<Project> selectedProjectsSet = new HashSet<Project>();
    private FaultBarrier faultBarrier = FaultBarrier.getInstance();
    private Project referenceProject;
    private File fastaFile;

    /**
     * Creates new form ProjectSelectionTreeFrame all this is pretty much unsafe
     * when doing reflection
     */
    public ProjectSelectionTreeFrame() {
        initComponents();
        this.setVisible(true);
        try {
            fillProjectList();
        } catch (Exception ex) {
            faultBarrier.handleException(ex);
            JOptionPane.showMessageDialog(null, "something went wrong while retrieving the list of projects:\n" + ex.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        projectList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        referenceProjectTextBox = new javax.swing.JTextArea();
        addReferenceProjectButton = new javax.swing.JButton();
        removeReferenceProjectButton = new javax.swing.JButton();
        toProjectTreeButton = new javax.swing.JButton();
        addAnalysisGroupButton = new javax.swing.JButton();
        removeAnalysisGroupButton = new javax.swing.JButton();
        removeProjectButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        projectTree = new com.compomics.peppi.view.components.DragAndDropTree();
        analyseButton = new javax.swing.JButton();
        ownFastaToggle = new javax.swing.JToggleButton();
        fastaLocationTextField = new javax.swing.JTextField();
        addFastaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("project selection");

        jScrollPane1.setViewportView(projectList);

        referenceProjectTextBox.setColumns(20);
        referenceProjectTextBox.setRows(5);
        jScrollPane2.setViewportView(referenceProjectTextBox);

        addReferenceProjectButton.setText("add reference project");
        addReferenceProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReferenceProjectButtonActionPerformed(evt);
            }
        });

        removeReferenceProjectButton.setText("remove reference project");
        removeReferenceProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeReferenceProjectButtonActionPerformed(evt);
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

        removeAnalysisGroupButton.setText("remove selected projectgroup");
        removeAnalysisGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnalysisGroupButtonActionPerformed(evt);
            }
        });

        removeProjectButton.setText("remove project");
        removeProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProjectButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(projectTree);

        analyseButton.setText("proceed...");
        analyseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyseButtonActionPerformed(evt);
            }
        });

        ownFastaToggle.setText("search against own fasta");
        ownFastaToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownFastaToggleActionPerformed(evt);
            }
        });

        fastaLocationTextField.setEditable(false);

        addFastaButton.setText("add fasta");
        addFastaButton.setEnabled(false);
        addFastaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFastaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addReferenceProjectButton)
                            .addComponent(removeReferenceProjectButton)
                            .addComponent(toProjectTreeButton)
                            .addComponent(addAnalysisGroupButton)
                            .addComponent(removeAnalysisGroupButton)
                            .addComponent(removeProjectButton))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addFastaButton)
                        .addGap(18, 18, 18)
                        .addComponent(fastaLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ownFastaToggle)
                        .addGap(18, 18, 18)
                        .addComponent(analyseButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addReferenceProjectButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeReferenceProjectButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(addAnalysisGroupButton)
                                .addGap(18, 18, 18)
                                .addComponent(toProjectTreeButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeAnalysisGroupButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeProjectButton))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyseButton)
                    .addComponent(ownFastaToggle)
                    .addComponent(fastaLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFastaButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addReferenceProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReferenceProjectButtonActionPerformed
        if (projectList.getSelectedValue() != null) {
            referenceProject = (Project) projectList.getSelectedValue();
            referenceProjectTextBox.setText(referenceProject.getProjectName());
        }
    }//GEN-LAST:event_addReferenceProjectButtonActionPerformed

    private void removeReferenceProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeReferenceProjectButtonActionPerformed
        if (!referenceProjectTextBox.getText().isEmpty()) {
            referenceProject = null;
            referenceProjectTextBox.setText("");
        }
    }//GEN-LAST:event_removeReferenceProjectButtonActionPerformed

    private void toProjectTreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toProjectTreeButtonActionPerformed
        if (!selectedProjectsSet.contains((Project) projectList.getSelectedValue())) {
            DefaultMutableTreeNode projectNode = projectTree.addObject(projectList.getSelectedValue());
            projectNode.setAllowsChildren(false);
            selectedProjectsSet.add((Project) projectList.getSelectedValue());
        }
    }//GEN-LAST:event_toProjectTreeButtonActionPerformed

    private void addAnalysisGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnalysisGroupButtonActionPerformed
        // TODO add your handling code here:
        String temp = JOptionPane.showInputDialog(null);
        if (temp != null) {
            if (!temp.isEmpty()) {
                projectTree.addObject(new AnalysisGroup(temp));
            }
        }
    }//GEN-LAST:event_addAnalysisGroupButtonActionPerformed

    private void removeAnalysisGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAnalysisGroupButtonActionPerformed
        if (projectTree.getSelectionPath() != null) {
            if (projectTree.getSelectionPath().getLastPathComponent() instanceof AnalysisGroup) {
                projectTree.removeCurrentNode();
            }
        }
    }//GEN-LAST:event_removeAnalysisGroupButtonActionPerformed

    private void removeProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProjectButtonActionPerformed
        // TODO add your handling code here:
        if (projectTree.getSelectionPath() != null) {
            if (projectTree.getSelectionPath().getLastPathComponent() instanceof Project) {
                selectedProjectsSet.remove((Project) projectTree.getSelectionPath().getLastPathComponent());
                projectTree.removeCurrentNode();
            }
        }
    }//GEN-LAST:event_removeProjectButtonActionPerformed

    private void analyseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyseButtonActionPerformed

        boolean goAhead = false;
        //can we actually continue?
        List<AnalysisGroup> analysisList = new ArrayList<AnalysisGroup>();
        if (!selectedProjectsSet.isEmpty() && referenceProject != null) {
            AnalysisGroup rogueProjects = new AnalysisGroup("Analysis");
            Enumeration tree = ((DefaultMutableTreeNode) projectTree.getModel().getRoot()).children();
            while (tree.hasMoreElements()) {
                Object anObject = tree.nextElement();
                if (((DefaultMutableTreeNode) anObject).getUserObject() instanceof Project) {
                    rogueProjects.add((Project) ((DefaultMutableTreeNode) anObject).getUserObject());
                } else if (((DefaultMutableTreeNode) anObject).getUserObject() instanceof AnalysisGroup) {
                    analysisList.add((AnalysisGroup) ((DefaultMutableTreeNode) anObject).getUserObject());
                }
                DataModeController.setDataSource(DataModeController.DataSource.DATABASE);
            } 


            if (!rogueProjects.isEmpty()) {
                analysisList.add(rogueProjects);
            }
            goAhead = true;
            if (ownFastaToggle.isSelected() && fastaFile != null && goAhead) {
                //this sure as hell can be better
                DataModeController.setDb(DataModeController.Db.FASTA);
                ((FastaDataMode) DataModeController.getDb().getDataMode()).setFastaFile(fastaFile);
            } else if (ownFastaToggle.isSelected() && fastaFile == null) {
                goAhead = false;
            }
        }
        if (goAhead) {
            MainWindow window = new MainWindow(referenceProject, analysisList);
            faultBarrier.addObserver(window);
            window.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "please make sure you have a reference project, one or more projects to compare to and if requested, have supplied a fasta");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_analyseButtonActionPerformed

    private void ownFastaToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownFastaToggleActionPerformed
        // TODO add your handling code here:
        if (ownFastaToggle.isSelected()) {
            addFastaButton.setEnabled(true);
            fastaFile = new File(ViewProperties.getInstance().getProperty(ViewPropertyEnum.PROTEINFASTALOCATION.getKey()));
            fastaLocationTextField.setText(fastaFile.getName());
        } else {
            addFastaButton.setEnabled(false);
        }
    }//GEN-LAST:event_ownFastaToggleActionPerformed

    private void addFastaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFastaButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fastaChooser = new JFileChooser();
        fastaChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fastaChooser.setMultiSelectionEnabled(false);
        fastaChooser.showOpenDialog(this);
        this.fastaFile = fastaChooser.getSelectedFile();
        if (fastaFile != null) {
            fastaLocationTextField.setText(fastaFile.getName());
            ViewProperties.getInstance().setProperty(new Property(ViewPropertyEnum.PROTEINFASTALOCATION, fastaFile.getAbsolutePath()));
        }
    }//GEN-LAST:event_addFastaButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAnalysisGroupButton;
    private javax.swing.JButton addFastaButton;
    private javax.swing.JButton addReferenceProjectButton;
    private javax.swing.JButton analyseButton;
    private javax.swing.JTextField fastaLocationTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton ownFastaToggle;
    private javax.swing.JList projectList;
    private com.compomics.peppi.view.components.DragAndDropTree projectTree;
    private javax.swing.JTextArea referenceProjectTextBox;
    private javax.swing.JButton removeAnalysisGroupButton;
    private javax.swing.JButton removeProjectButton;
    private javax.swing.JButton removeReferenceProjectButton;
    private javax.swing.JButton toProjectTreeButton;
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
