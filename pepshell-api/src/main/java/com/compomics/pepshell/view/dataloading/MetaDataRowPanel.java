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

package com.compomics.pepshell.view.dataloading;


import com.compomics.pepshell.model.enums.PossibleMetaDataAnnotationsEnum;
import com.compomics.pepshell.view.componentmodels.ClassBasedFilter;

import java.awt.Component;
import java.awt.event.ItemEvent;

import javax.swing.*;
import javax.swing.text.*;

/**
 * @author Davy Maddelein
 */
public class MetaDataRowPanel extends javax.swing.JPanel {

    private JComboBox<String> booleanbox = new JComboBox<>(new String[]{"true", "false"});

    /**
     * Creates new form MetaDataRowPanel
     */
    public MetaDataRowPanel() {
        initComponents();
        booleanbox.setMaximumSize(new java.awt.Dimension(100, 20));
        booleanbox.setMinimumSize(new java.awt.Dimension(100, 20));
        booleanbox.setPreferredSize(new java.awt.Dimension(100, 20));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        annotationComboBox = new javax.swing.JComboBox<>(PossibleMetaDataAnnotationsEnum.values());
        annotationTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(350, 50));
        setMinimumSize(new java.awt.Dimension(350, 50));
        setPreferredSize(new java.awt.Dimension(350, 50));

        annotationComboBox.setMaximumSize(new java.awt.Dimension(3140000, 20));
        annotationComboBox.setMinimumSize(new java.awt.Dimension(100, 20));
        annotationComboBox.setPreferredSize(new java.awt.Dimension(100, 20));
        annotationComboBox.addItemListener(this::annotationComboBoxItemStateChanged);

        annotationTextField.setMaximumSize(new java.awt.Dimension(100, 20));
        annotationTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        annotationTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(annotationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(annotationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(annotationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annotationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void annotationComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_annotationComboBoxItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if ((annotationComboBox.getSelectedItem() == PossibleMetaDataAnnotationsEnum.HASHEADERS)) {
                ((GroupLayout) this.getLayout()).replace(annotationTextField, booleanbox);
            } else {
                if (booleanbox.isShowing()) {
                    ((GroupLayout) this.getLayout()).replace(booleanbox, annotationTextField);
                }

                ((PlainDocument) annotationTextField.getDocument()).setDocumentFilter(new ClassBasedFilter(((PossibleMetaDataAnnotationsEnum) annotationComboBox.getSelectedItem()).getAllowedInputClass()));
            }
        }
    }//GEN-LAST:event_annotationComboBoxItemStateChanged

    public Component getComponent() {
        if (annotationTextField.isVisible()) {
            return annotationTextField;
        } else {
            return booleanbox;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<PossibleMetaDataAnnotationsEnum> annotationComboBox;
    private javax.swing.JTextField annotationTextField;
    // End of variables declaration//GEN-END:variables

    public JComboBox<PossibleMetaDataAnnotationsEnum> getComboBox() {
        return annotationComboBox;
    }

    public String getText() {
        if (annotationTextField.isShowing()) {
            return annotationTextField.getText();
        } else {
            return (String) booleanbox.getSelectedItem();
        }
    }
}
