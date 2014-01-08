package com.compomics.peppi.view.frames;

import com.compomics.peppi.DataModeController;
import com.compomics.peppi.FaultBarrier;
import com.compomics.peppi.controllers.DAO.WebDAO;
import com.compomics.peppi.model.AnalysisGroup;
import com.compomics.peppi.model.Project;
import com.compomics.peppi.model.Protein;
import com.compomics.peppi.model.exceptions.ConversionException;
import com.compomics.peppi.view.panels.InfoPanel;
import com.compomics.peppi.view.panels.StatisticsPanel;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davy
 */
public class MainWindow extends javax.swing.JFrame implements Observer {

    private static FaultBarrier faultBarrier;
    private Set<Protein> proteinsToDisplay = new HashSet<Protein>();

    public MainWindow() {
        faultBarrier = FaultBarrier.getInstance();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public MainWindow(final Project toCompareWithProject, final AnalysisGroup dataList) {
        this();
        infoPanelTabbedPane.add(new InfoPanel());
        new Runnable() {
            @Override
            public void run() {
                collectData(toCompareWithProject, dataList);
            }
        }.run();
    }

    public MainWindow(final Project toCompareWithProject, final List<AnalysisGroup> dataList) {
        this();
        new Runnable() {
            @Override
            public void run() {
                for (AnalysisGroup aGroup : dataList) {
                    collectData(toCompareWithProject, aGroup);
                    infoPanelTabbedPane.add(aGroup.getName(), new InfoPanel(aGroup));
                    statisticsTabbedPane.add(aGroup.getName(), new StatisticsPanel(aGroup));
                }
            }
        }.run();
        //proteinsToDisplay.addAll(((InfoPanel) infoPanelTabbedPane.getComponent(0)).getCondensedProject().getProteins());
        proteinsToDisplay = toCompareWithProject.getProteins();
        //this totally does not have to happen with anonymous stuff
        proteinList.setListData(proteinsToDisplay.toArray());
        jScrollPane1.setViewportView(proteinList);
        pdbProteinList.setListData(proteinsToDisplay.toArray());
        jScrollPane2.setViewportView(pdbProteinList);

        infoPanelTabbedPane.setSelectedIndex(infoPanelTabbedPane.getComponentCount() - 1);
    }

    private void collectData(Project toCompareWithProject, List<Project> toCompareProjects) {
        DataModeController.getDb().getDataMode().getViewPreparationForMode().PrepareProteinsForJList(toCompareWithProject, toCompareProjects, false);
    }

    //
    private void collectAndShowData(Project toCompareWithProject, List<Project> toCompareProjects, InfoPanel anInfoPanel) {
        DataModeController.getDb().getDataMode().getViewPreparationForMode().PrepareProteinsForJList(toCompareWithProject, toCompareProjects, false);
        anInfoPanel.setProjectsToDisplay(toCompareProjects);

    }

    public void update(Observable o, Object o1) {
        if (o1 != null && o1 instanceof Exception) {
            tabsPane.setFont(new Font(null, Font.BOLD, 12));
            tabsPane.setIconAt(tabsPane.getTabCount() - 1, UIManager.getIcon("OptionPane.warningIcon"));
            //TODO show in error pane
            ((Exception) o1).printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsPane = new javax.swing.JTabbedPane();
        mainViewPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        proteinList = new javax.swing.JList();
        accessionLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        infoPanelTabbedPane = new javax.swing.JTabbedPane();
        exportPanel = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        exportButton = new javax.swing.JButton();
        jCheckBox7 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jmolPanel1 = new com.compomics.peppi.view.panels.JmolPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pdbProteinList = new javax.swing.JList();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        statisticsTabbedPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        preferencesMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comparison window");
        setPreferredSize(new java.awt.Dimension(800, 600));

        tabsPane.setMinimumSize(new java.awt.Dimension(1573, 571));
        tabsPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsPaneStateChanged(evt);
            }
        });

        mainViewPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        proteinList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        proteinList.setMaximumSize(new java.awt.Dimension(99, 90));
        proteinList.setMinimumSize(new java.awt.Dimension(99, 90));
        proteinList.setPreferredSize(null);
        proteinList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proteinListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                proteinListMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(proteinList);

        accessionLabel.setText("found reference proteins");

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setMinimumSize(new java.awt.Dimension(50, 3));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 3));

        infoPanelTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                infoPanelTabbedPaneStateChanged(evt);
            }
        });

        javax.swing.GroupLayout mainViewPanelLayout = new javax.swing.GroupLayout(mainViewPanel);
        mainViewPanel.setLayout(mainViewPanelLayout);
        mainViewPanelLayout.setHorizontalGroup(
            mainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainViewPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(accessionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoPanelTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainViewPanelLayout.setVerticalGroup(
            mainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainViewPanelLayout.createSequentialGroup()
                        .addComponent(infoPanelTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 752, Short.MAX_VALUE))
                    .addGroup(mainViewPanelLayout.createSequentialGroup()
                        .addComponent(accessionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabsPane.addTab("Protein Comparison", mainViewPanel);

        jCheckBox1.setText("export all projects");

        jCheckBox2.setText("export selection of projects");

        jCheckBox3.setText("export selection of proteins");

        jCheckBox4.setText("export selection of peptides");

        jLabel1.setText("select export options (temp)");

        jCheckBox5.setText("Export as tab seperated file");

        jCheckBox6.setText("Export as excel file");

        exportButton.setText("Export!");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        jCheckBox7.setText("change savefile name, this will change the name for all exported files");

        jTextField1.setText("autogeneratedName");

        javax.swing.GroupLayout exportPanelLayout = new javax.swing.GroupLayout(exportPanel);
        exportPanel.setLayout(exportPanelLayout);
        exportPanelLayout.setHorizontalGroup(
            exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(exportPanelLayout.createSequentialGroup()
                        .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportPanelLayout.createSequentialGroup()
                                    .addComponent(jCheckBox1)
                                    .addGap(301, 301, 301))
                                .addGroup(exportPanelLayout.createSequentialGroup()
                                    .addComponent(jCheckBox2)
                                    .addGap(257, 257, 257)))
                            .addGroup(exportPanelLayout.createSequentialGroup()
                                .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox4))
                                .addGap(255, 255, 255)))
                        .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox5)))
                    .addGroup(exportPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exportButton))))
                .addContainerGap(538, Short.MAX_VALUE))
        );
        exportPanelLayout.setVerticalGroup(
            exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox6))
                .addGap(18, 18, 18)
                .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox7))
                .addGroup(exportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(exportPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox4))
                    .addGroup(exportPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(exportButton)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(502, Short.MAX_VALUE))
        );

        tabsPane.addTab("exportPanel", exportPanel);

        pdbProteinList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        pdbProteinList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdbProteinListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pdbProteinList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jmolPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jmolPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );

        tabsPane.addTab("pdb view panel", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(statisticsTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1392, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statisticsTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        tabsPane.addTab("statistics", jPanel2);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("options");

        jMenu3.setText("accession");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("uniprot");
        jMenu3.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");
        jMenu3.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("jRadioButtonMenuItem3");
        jMenu3.add(jRadioButtonMenuItem3);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        preferencesMenu.setText("preferences...");
        preferencesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferencesMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(preferencesMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1398, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabsPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabsPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsPaneStateChanged
        if (tabsPane.getSelectedIndex() == 2) {
            tabsPane.setFont(new Font(null, Font.PLAIN, 12));
            tabsPane.setIconAt(tabsPane.getTabCount() - 1, null);
        }
    }//GEN-LAST:event_tabsPaneStateChanged

    private void pdbProteinListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdbProteinListMouseClicked

        new Runnable() {
            @Override
            public void run() {
                try {
                    jmolPanel1.setPDBProtein((Protein) pdbProteinList.getSelectedValue());
                } catch (MalformedURLException ex) {
                    faultBarrier.handleException(ex);
                } catch (IOException ex) {
                    faultBarrier.handleException(ex);
                } catch (ConversionException ex) {
                    faultBarrier.handleException(ex);
                } catch (SQLException ex) {
                    faultBarrier.handleException(ex);
                }
            }
        }.run();

    }//GEN-LAST:event_pdbProteinListMouseClicked

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        //TODO extract export pane
        /**
         * File saveLocation = new
         * File(PropertiesManager.getPreferredSaveLocation()); JFileChooser
         * saveLocationChooser = new JFileChooser(saveLocation,new
         * DirectoryFilter()); --> set only directory mode
         * saveLocationChooser.setVisible(true); --> this is different
         * saveLocation = saveLocationChooser.getSelectedFile();
         * export(saveLocation,ExcelFileExportCheckbox.get)
         */
    }//GEN-LAST:event_exportButtonActionPerformed

    private void proteinListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proteinListMouseReleased

        //TODO add double click get protein information listener
        try {
            Protein proteinOfInterest = (Protein) proteinList.getSelectedValue();
            if (proteinOfInterest.getProteinSequence().isEmpty()) {
                proteinOfInterest.setSequence(WebDAO.fetchSequence(proteinOfInterest.getProteinAccession()));
            }
            ((InfoPanel) infoPanelTabbedPane.getSelectedComponent()).updateProteinGraphics(proteinOfInterest);
            //very dirty
            pdbProteinListMouseClicked(evt);
        } catch (MalformedURLException ex) {
            faultBarrier.handleException(ex);
        } catch (IOException ex) {
            faultBarrier.handleException(ex);
        } catch (SQLException ex) {
            faultBarrier.handleException(ex);
            JOptionPane.showMessageDialog(null, "there has been a connection error while retrieving the protein sequence:\n" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        } catch (ConversionException ex) {
            faultBarrier.handleException(ex);
        } catch (NullPointerException ex) {
            faultBarrier.handleException(ex);
        }
    }//GEN-LAST:event_proteinListMouseReleased

    private void proteinListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proteinListMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                Desktop.getDesktop().browse(new URI(((Protein)proteinList.getSelectedValue()).getProteinAccession()));
                /**
                 * ProteinInfoFrame protInfo = new ProteinInfoFrame((Protein)
                 * proteinList.getSelectedValue());
                protInfo.setVisible(true);
                 */
            } catch (URISyntaxException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_proteinListMouseClicked

    private void infoPanelTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_infoPanelTabbedPaneStateChanged
        // TODO add your handling code here:
        proteinsToDisplay.clear();
        proteinsToDisplay.addAll(((InfoPanel) infoPanelTabbedPane.getSelectedComponent()).getCondensedProject().getProteins());
    }//GEN-LAST:event_infoPanelTabbedPaneStateChanged

    private void preferencesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferencesMenuActionPerformed
        // TODO add your handling code here:
        new PreferenceFrame();
        
    }//GEN-LAST:event_preferencesMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessionLabel;
    private javax.swing.JButton exportButton;
    private javax.swing.JPanel exportPanel;
    private javax.swing.JTabbedPane infoPanelTabbedPane;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private com.compomics.peppi.view.panels.JmolPanel jmolPanel1;
    private javax.swing.JPanel mainViewPanel;
    private javax.swing.JList pdbProteinList;
    private javax.swing.JMenu preferencesMenu;
    private javax.swing.JList proteinList;
    private javax.swing.JTabbedPane statisticsTabbedPane;
    private javax.swing.JTabbedPane tabsPane;
    // End of variables declaration//GEN-END:variables
}