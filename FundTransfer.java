package Bank;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FundTransfer extends javax.swing.JFrame {

    static String dburl = "jdbc:derby://localhost:1527/Bank";
    static String pass = "password";
    static String user = "username";
    String acc_no_s, query, s;
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
            s = acc_no_s;
        }
        JOptionPane.showMessageDialog(jf, dis, "ERROR", JOptionPane.ERROR_MESSAGE);
        jTextField1.setText(null);
        FundTransfer.this.setVisible(false);
        new Startpage(s).setVisible(true);
    }

    public FundTransfer(String acc_no) {
        this.acc_no_s = acc_no;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fund Transfer");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Fund Transfer");

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Proceed");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Enter Account Number");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Enter Account Holder Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Enter IFSI Code");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Enter the Amount");

        jTextField1.setBackground(java.awt.SystemColor.controlHighlight);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField2.setBackground(java.awt.SystemColor.controlHighlight);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(java.awt.SystemColor.controlHighlight);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField3.setBorder(null);
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 255));

        jTextField4.setBackground(java.awt.SystemColor.controlHighlight);
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField4.setBorder(null);
        jTextField4.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel2)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton1)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String acc_no_r = jTextField1.getText();
        String acc_name = jTextField2.getText();
        String ifsi = jTextField3.getText();
        String amount = jTextField4.getText();
        int amt = 0, i = 0;
        try {
            amt = Integer.parseInt(amount);
            i = 1;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(jf, "Please enter valid amount", "ERROR", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText(null);
            jTextField2.setText(null);
            jTextField3.setText(null);
            jTextField4.setText(null);
            FundTransfer.this.setVisible(true);
        }
        if (i == 1) {
            try {
                Connection conn = DriverManager.getConnection(dburl, "bank", "bank");
                Statement stmt = conn.createStatement();
                String q1 = "Select balance,pin,status from Bank.B1 where Accountnumber='" + acc_no_s + "'";
                ResultSet res = stmt.executeQuery(q1);
                res.next();
                long bal1 = res.getLong("BALANCE");
                int pin = res.getInt("pin");
                int st = res.getInt("status");
                String q2 = "Select accountnumber,ifsi,name,balance from Bank.B1 where Accountnumber='" + acc_no_r + "'";
                res = stmt.executeQuery(q2);
                FundTransfer.this.setVisible(false);
                if (res.next()) {
                    String accnoo = res.getString("accountnumber");
                    String accnam = res.getString("name");
                    String ifsin = res.getString("ifsi");
                    long bal2 = res.getLong("BALANCE");
                    if (!acc_no_r.equals(acc_no_s)) {
                        if (acc_no_r.equals(accnoo) && acc_name.equals(accnam) && ifsi.equals(ifsin)) {
                            if (st > 0) {
                                String p1 = JOptionPane.showInputDialog(jf, "enter the pin", "pin", JOptionPane.OK_CANCEL_OPTION);
                                try {
                                    int pin1 = Integer.parseInt(p1);
                                    if (pin == pin1) {
                                        if (bal1 >= amt) {
                                            bal1 -= amt;
                                            bal2 += amt;
                                            String q3 = "update Bank.b1 set balance=" + bal1 + "where accountnumber='" + acc_no_s + "'";
                                            stmt.executeUpdate(q3);
                                            String q4 = "update Bank.b1 set balance=" + bal2 + "where accountnumber='" + acc_no_r + "'";
                                            stmt.executeUpdate(q4);
                                            JOptionPane.showMessageDialog(jf, "Amount " + amt + "Transfered sucessfully", "Status", JOptionPane.PLAIN_MESSAGE);
                                            new Bankservice(acc_no_s).setVisible(true);
                                        } else {
                                            chance(-1);
                                        }
                                    } else {
                                        query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no_s + "'";
                                        stmt.executeUpdate(query);
                                        chance(st);
                                    }
                                } catch (NumberFormatException ex) {
                                    query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no_s + "'";
                                    stmt.executeUpdate(query);
                                    chance(st);
                                }
                            } else {
                                chance(st);
                            }

                        } else {
                            JOptionPane.showMessageDialog(jf, "Please enter the valid Account Details", "ERROR", JOptionPane.ERROR_MESSAGE);
                            new Startpage(null).setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(jf, "No Self transation", "ERROR", JOptionPane.ERROR_MESSAGE);
                        new Startpage(null).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(jf, "Please enter the valid Account Details", "ERROR", JOptionPane.ERROR_MESSAGE);
                    new Startpage(null).setVisible(true);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Startpage(null).setVisible(true);
        FundTransfer.this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FundTransfer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FundTransfer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FundTransfer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FundTransfer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
