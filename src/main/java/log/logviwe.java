/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package log;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class logviwe extends javax.swing.JFrame {

    /**
     * Creates new form logviwe
     */
    public logviwe() {
        initComponents();
       
        txtusername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                     txtpw.requestFocus();
                }
            }
        });
         txtpw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnlog.doClick();
                }
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

        txtusername = new javax.swing.JTextField();
        txtpw = new javax.swing.JPasswordField();
        btnlog = new javax.swing.JButton();
        lblunme = new javax.swing.JLabel();
        lblunme1 = new javax.swing.JLabel();
        btnclose = new javax.swing.JButton();
        chekpw = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setLocation(new java.awt.Point(335, 110));
        setLocationByPlatform(true);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 125, 211, -1));
        getContentPane().add(txtpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 165, 211, -1));

        btnlog.setBackground(new java.awt.Color(0, 204, 0));
        btnlog.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnlog.setText("Login");
        btnlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogActionPerformed(evt);
            }
        });
        btnlog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnlogKeyPressed(evt);
            }
        });
        getContentPane().add(btnlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 235, 73, -1));

        lblunme.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblunme.setText("User Name :");
        getContentPane().add(lblunme, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 115, 116, 40));

        lblunme1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblunme1.setText("Password :");
        getContentPane().add(lblunme1, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 155, 102, 40));

        btnclose.setBackground(java.awt.Color.red);
        btnclose.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 235, 93, -1));

        chekpw.setText("Show Password");
        chekpw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekpwActionPerformed(evt);
            }
        });
        getContentPane().add(chekpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 195, 141, -1));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 48)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnlogActionPerformed

    private void chekpwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekpwActionPerformed
        // TODO add your handling code here:
        if(chekpw.isSelected())
        {
            txtpw.setEchoChar((char)0);
        }
        else
        {
            txtpw.setEchoChar('`');
        }
    }//GEN-LAST:event_chekpwActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handli((''');ng code here:

    }//GEN-LAST:event_btncloseActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void btnlogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnlogKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogKeyPressed

    private void textFieldKeyPressed(java.awt.event.KeyEvent evt) {                                  
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            getBtnlog();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logviwe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logviwe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logviwe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logviwe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logviwe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnlog;
    private javax.swing.JCheckBox chekpw;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblunme;
    private javax.swing.JLabel lblunme1;
    private javax.swing.JPasswordField txtpw;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
public JButton getBtnlog() {
        return btnlog;
    }
public JButton getbtnclose() {
        return btnclose;
    }
    public JTextField getTxtuser() {
        return txtusername;
    }
    public JTextField getTxtpw() {
        return txtpw;
    }
    


}
