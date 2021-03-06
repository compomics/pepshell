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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compomics.pepshell.view.dataloading;

import com.compomics.pepshell.model.SeparatedValueExperimentMetadata;
import com.compomics.pepshell.model.enums.PossibleMetaDataAnnotationsEnum;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * @author Davy Maddelein
 */
public class ExtraMetaDataAnnotatorPanel extends javax.swing.JPanel {

    /**
     * Creates new form ExtraMetaDataAnnotatorPanel
     */
    public ExtraMetaDataAnnotatorPanel() {
        initComponents();
        this.addMetaDataRow();
        this.setVisible(true);
    }

    public ExtraMetaDataAnnotatorPanel(boolean addMultipleFileAnnotationRow) {
        this();
        if (addMultipleFileAnnotationRow) {
            addMetaDataRow();
        }
    }

    public SeparatedValueExperimentMetadata getAllAnnotations() {
        SeparatedValueExperimentMetadata metaData = new SeparatedValueExperimentMetadata();
        for (Component aComponent : getComponents()) {
            if (aComponent instanceof MetaDataRowPanel) {
                metaData.addMetaData((PossibleMetaDataAnnotationsEnum) ((MetaDataRowPanel) aComponent).getComboBox().getSelectedItem(), ((MetaDataRowPanel) aComponent).getText());
            }
        }
        return metaData;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        possibleMetaDataLabel = new javax.swing.JLabel();
        addRowButton = new javax.swing.JButton();
        metaDataRowPanel1 = new com.compomics.pepshell.view.dataloading.MetaDataRowPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setMaximumSize(new java.awt.Dimension(200, 80));
        setMinimumSize(new java.awt.Dimension(200, 100));
        setPreferredSize(new java.awt.Dimension(200, 100));
        setLayout(new java.awt.GridBagLayout());

        possibleMetaDataLabel.setText("possible meta data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 23);
        add(possibleMetaDataLabel, gridBagConstraints);

        addRowButton.setText("add another row");
        addRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 0, 22);
        add(addRowButton, gridBagConstraints);

        metaDataRowPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(metaDataRowPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void addRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowButtonActionPerformed
        //lower the button
        addMetaDataRow();
        repaint();
    }//GEN-LAST:event_addRowButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowButton;
    private com.compomics.pepshell.view.dataloading.MetaDataRowPanel metaDataRowPanel1;
    private javax.swing.JLabel possibleMetaDataLabel;
    // End of variables declaration//GEN-END:variables

    private MetaDataRowPanel addMetaDataRow() {

        GridBagConstraints constraints = ((GridBagLayout) this.getLayout()).getConstraints(addRowButton);
        constraints.gridy++;
        ((GridBagLayout) this.getLayout()).setConstraints(addRowButton, constraints);

        MetaDataRowPanel addedMetaDataRow = new MetaDataRowPanel();

        constraints.gridy = constraints.gridy - 1;
        constraints.gridx = 0;

        add(addedMetaDataRow, constraints);
        addedMetaDataRow.getComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addMetaDataRow();
                }
            }
        });

        addedMetaDataRow.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                repaint();
            }
        });

        DeleteButton deleteRowButton = new DeleteButton(addedMetaDataRow);
        deleteRowButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove(((DeleteButton) (evt.getSource())).getPanelToDelete());
                remove((DeleteButton) evt.getSource());
            }
        });
        constraints.gridx = constraints.gridx + 1;
        add(deleteRowButton, constraints);
        addedMetaDataRow.getComponent().requestFocus();
        int height = 0;

        //todo fix this to n metadatarow panels + label height + add row button height
        for (Component aComponent : this.getComponents()) {
            height += aComponent.getHeight();
        }
        setPreferredSize(new Dimension(this.getWidth(), height));
        repaint();
        return addedMetaDataRow;
    }

    public void clearMetaData() {
        for (Component aComponent : getComponents()) {
            if (aComponent instanceof DeleteButton || aComponent instanceof MetaDataRowPanel) {
                remove(aComponent);
            }
        }
    }

    void setAnnotation(String key, String value) {
       MetaDataRowPanel addedRow = addMetaDataRow();
        addedRow.getComboBox().setSelectedItem(PossibleMetaDataAnnotationsEnum.valueOf(key));
        if(addedRow.getComponent() instanceof JComboBox){
            ((JComboBox)addedRow.getComponent()).setSelectedItem(value);
        } else{
            ((JTextField)addedRow.getComponent()).setText(value);
        }
    }

    private class DeleteButton extends JButton {

        private final MetaDataRowPanel linkedPanel;

        DeleteButton(MetaDataRowPanel panelToDelete) {
            super("-");
            linkedPanel = panelToDelete;
        }

        MetaDataRowPanel getPanelToDelete() {
            return linkedPanel;

        }
    }
}
