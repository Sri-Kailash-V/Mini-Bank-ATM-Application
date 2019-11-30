package Bank;

import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Withdraw extends javax.swing.JFrame {

    static String dburl = "jdbc:derby://localhost:1527/Bank";
    static String pass = "password";
    static String user = "username";
    String acc_no, s;
    JFrame jf = new JFrame();

    private void chance(int sta) {
        String dis;
        if (sta == -1) {
            dis = "Insufficent balance";
            s = null;
        } else if (sta > 0) {
            dis = "Invalid PIN\n" + sta + " chance available";
            s = null;
        } else {
            dis = "Sorry account blocked \nplese login after 24 hours\n";
            s = acc_no;
        }
        JOptionPane.showMessageDialog(jf, dis, "ERROR", JOptionPane.ERROR_MESSAGE);
        jTextField1.setText(null);
        Withdraw.this.setVisible(false);
        new Startpage(s).setVisible(true);
    }

    public Withdraw(String acc_no) {
        this.acc_no = acc_no;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("withdraw");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Withdraw ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter the amount to withdraw");

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText(" ");
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Proceed");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(87, 87, 87)
                                .addComponent(jButton1))
                            .addComponent(jLabel2))))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Startpage(null).setVisible(true);
        Withdraw.this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s1 = jTextField1.getText();
        long wamt = 0, i = 0;
        try {
            wamt = Integer.parseInt(s1.trim());
            i = 1;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(jf, "Please enter valid amount", "ERROR", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText(null);
            Withdraw.this.setVisible(true);
        }
        if (i == 1) {
            if (wamt <= 40000) {
                try {
                    Connection conn = DriverManager.getConnection(dburl, "bank", "bank");
                    Statement stmt = conn.createStatement();
                    String query = "Select balance,pin,status from Bank.B1 where Accountnumber='" + acc_no + "'";
                    ResultSet res = stmt.executeQuery(query);
                    res.next();
                    long bal = res.getLong("BALANCE");
                    int pin = res.getInt("pin");
                    int st = res.getInt("status");
                    if (st > 0) {
                        String p1 = JOptionPane.showInputDialog(jf, "enter the pin", "pin", JOptionPane.OK_CANCEL_OPTION);
                        Withdraw.this.setVisible(false);
                        try {
                            int pin1 = Integer.parseInt(p1);
                            if (pin == pin1) {
                                if (bal >= wamt) {
                                    bal -= wamt;
                                    query = "update Bank.b1 set balance=" + bal + "where accountnumber='" + acc_no + "'";
                                    stmt.executeUpdate(query);
                                    try {
                                        TimeUnit.SECONDS.sleep(1);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    JOptionPane.showMessageDialog(jf, "Collect the amount " + wamt, "Delivered", JOptionPane.PLAIN_MESSAGE);
                                    new Bankservice(acc_no).setVisible(true);
                                } else {
                                    chance(-1);
                                }
                            } else {
                                query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no + "'";
                                stmt.executeUpdate(query);
                                chance(st);
                            }
                        } catch (NumberFormatException ex) {
                            query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no + "'";
                            stmt.executeUpdate(query);
                            chance(st);
                        }
                    } else {
                        chance(st);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(jf, "withdraw amount exceeded", "ERROR", JOptionPane.ERROR_MESSAGE);
                new Withdraw(acc_no).setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
