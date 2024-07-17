/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package store;

import javax.swing.JButton;

/**
 *
 * @author ASUS
 */
public class storefront extends javax.swing.JFrame {

    /**
     * Creates new form storefront
     */
    public storefront() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncheckitem = new javax.swing.JButton();
        btnadditem = new javax.swing.JButton();
        lblitem = new javax.swing.JLabel();
        lbladditem = new javax.swing.JLabel();
        btnclose1 = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        lbladditem1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(450, 250));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncheckitem.setBackground(new java.awt.Color(204, 204, 255));
        btncheckitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-list-96.png"))); // NOI18N
        getContentPane().add(btncheckitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 202, 86, 93));

        btnadditem.setBackground(new java.awt.Color(204, 204, 255));
        btnadditem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-list-96.png"))); // NOI18N
        btnadditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadditemActionPerformed(evt);
            }
        });
        getContentPane().add(btnadditem, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 202, 95, 93));

        lblitem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblitem.setText("Check Items");
        getContentPane().add(lblitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 308, -1, 35));

        lbladditem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbladditem.setText("Add Item");
        getContentPane().add(lbladditem, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 308, 95, 35));

        btnclose1.setBackground(java.awt.Color.red);
        btnclose1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btnclose1.setForeground(new java.awt.Color(255, 255, 255));
        btnclose1.setText("X");
        getContentPane().add(btnclose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 0, -1, -1));

        btnupdate.setBackground(new java.awt.Color(153, 153, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-to-do-96.png"))); // NOI18N
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 202, 92, 93));

        lbladditem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbladditem1.setText("Item Details Update");
        getContentPane().add(lbladditem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 308, 145, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnadditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadditemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnadditemActionPerformed

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
            java.util.logging.Logger.getLogger(storefront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(storefront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(storefront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(storefront.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new storefront().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadditem;
    private javax.swing.JButton btncheckitem;
    private javax.swing.JButton btnclose1;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbladditem;
    private javax.swing.JLabel lbladditem1;
    private javax.swing.JLabel lblitem;
    // End of variables declaration//GEN-END:variables

    public JButton getbtnadd() {
        return btnadditem;
    }
public JButton getbtncheck() {
        return btncheckitem;
    }

    public JButton getbtnclose() {
        return btnclose1;
    }
    
    public JButton getitmupdte() {
        return btnupdate;
    }

}