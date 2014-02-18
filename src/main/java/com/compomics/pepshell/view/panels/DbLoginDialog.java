package com.compomics.pepshell.view.panels;

import com.compomics.pepshell.DataModeController;
import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.controllers.objectcontrollers.DbConnectionController;
import com.compomics.pepshell.controllers.properties.DatabaseProperties;
import com.compomics.pepshell.model.Property;
import com.compomics.pepshell.model.enums.DataBasePropertyEnum;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Davy
 */
public class DbLoginDialog extends javax.swing.JDialog {

    /**
     *
     * @param parent
     * @param modal
     */
    public DbLoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        this.getContentPane().setBackground(Color.WHITE);
    }

    public DbLoginDialog(java.awt.Frame parent, boolean modal, String username, String url, String dbname) {
        this(parent, modal);

        init(username, url, dbname);

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void init(String username, String url, String dbname) {
        loginPanel.getUsernameTextField().setText(username);
        loginPanel.getUrlTextField().setText(url);
        loginPanel.getDatabaseNameTextField().setText(dbname);
        loginPanel.getPasswordField().setFocusTraversalKeysEnabled(false);
        loginPanel.getUrlTextField().setFocusTraversalKeysEnabled(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);        

        loginPanel.getDatabaseNameTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    executeLogin();
                } else if (e.isShiftDown() && e.getKeyChar() == KeyEvent.VK_TAB) {
                    loginPanel.getUrlTextField().requestFocus();
                    loginPanel.getUrlTextField().selectAll();
                } else if (e.getKeyChar() == KeyEvent.VK_TAB) {
                    loginButton.requestFocus();
                } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    executeLogin();
                } else {
                    super.keyTyped(e);
                }
            }
        });

        loginButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                executeLogin();
            }
        });

        cancelButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new com.compomics.pepshell.view.panels.LoginPanel();
        bottomPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("database login");
        setModal(true);

        loginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bottomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        bottomPanel.setOpaque(false);

        loginButton.setText("Login");
        loginButton.setMaximumSize(new java.awt.Dimension(85, 23));
        loginButton.setMinimumSize(new java.awt.Dimension(85, 23));
        loginButton.setPreferredSize(new java.awt.Dimension(85, 23));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginButtonMouseReleased(evt);
            }
        });

        cancelButton.setText("Exit");
        cancelButton.setMaximumSize(new java.awt.Dimension(85, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(85, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(85, 23));
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseReleased

    private void loginButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseReleased
        if (loginPanel.getUsernameTextField().getText().equals("") || new String(loginPanel.getPasswordField().getPassword()).equals("") || loginPanel.getUrlTextField().getText().equals("") || loginPanel.getDatabaseNameTextField().getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please provide all the fields");
        } else {
            executeLogin();
            storeCredentials(loginPanel.getStoreCredentialsCheckBox().isSelected());
            this.dispose();
        }
    }//GEN-LAST:event_loginButtonMouseReleased

    public void executeLogin() {
        try {
            DbConnectionController.createConnection(loginPanel.getUsernameTextField().getText(), new String(loginPanel.getPasswordField().getPassword()), loginPanel.getUrlTextField().getText(), loginPanel.getDatabaseNameTextField().getText());
            DataModeController.checkDbScheme();
        } catch (SQLException sqle) {
            FaultBarrier.getInstance().handleException(sqle);
            JOptionPane.showMessageDialog(this, "there has been an error while trying to log in.\n" + sqle.getMessage());
        }
    }

    public void storeCredentials(boolean store) {
        if (store) {
            DatabaseProperties.getInstance().setProperties(new ArrayList<Property>() {
                {
                    this.add(new Property(DataBasePropertyEnum.DBUSERNAME, loginPanel.getUsernameTextField().getText()));
                    this.add(new Property(DataBasePropertyEnum.DBURL, loginPanel.getUrlTextField().getText()));
                    this.add(new Property(DataBasePropertyEnum.DBNAME, loginPanel.getDatabaseNameTextField().getText()));
                }
            });
        } else {
            DatabaseProperties.getInstance().setProperties(new ArrayList<Property>() {
                {
                    this.add(new Property(DataBasePropertyEnum.DBUSERNAME, DataBasePropertyEnum.DBUSERNAME.getDefaultValue()));
                    this.add(new Property(DataBasePropertyEnum.DBURL, DataBasePropertyEnum.DBURL.getDefaultValue()));
                    this.add(new Property(DataBasePropertyEnum.DBNAME, DataBasePropertyEnum.DBNAME.getDefaultValue()));
                }
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton loginButton;
    protected com.compomics.pepshell.view.panels.LoginPanel loginPanel;
    // End of variables declaration//GEN-END:variables
}
