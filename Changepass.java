package Bank;

import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Changepass extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String dburl = "jdbc:derby://localhost:1527/Bank";
    static String pass = "password";
    static String user = "username";
    static Connection conn = null;
    static Statement stmt = null;
    String acc_no, s, query;
    int i = 1;
    JFrame jf = new JFrame();

    private void clean() {
        jPasswordField1.setText(null);
        jPasswordField2.setText(null);
        jPasswordField3.setText(null);
    }

    private void clean(String str) {
        clean();
        JOptionPane.showMessageDialog(jf, str, "ERROR", JOptionPane.ERROR_MESSAGE);
        Changepass.this.setVisible(true);
    }

    private void chance(int sta, String s) {
        String dis;
        if (sta > 0) {
            dis = s + "\n" + sta + " chance available";
            s = null;
        } else {
            dis = "Sorry account blocked \nplese login after 24 hours\n";
            s = acc_no;
        }
        JOptionPane.showMessageDialog(jf, dis, "ERROR", JOptionPane.ERROR_MESSAGE);
        clean();
        Changepass.this.setVisible(false);
        new Startpage(s).setVisible(true);
    }

    public Changepass(String acc_no) {
        this.acc_no = acc_no;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Refactor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PASSWORD Refactor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Current Password");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("New Password");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("RE-Enter Password");

        jPasswordField1.setBackground(java.awt.SystemColor.controlHighlight);
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField1.setBorder(null);
        jPasswordField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jPasswordField2.setBackground(java.awt.SystemColor.controlHighlight);
        jPasswordField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField2.setBorder(null);
        jPasswordField2.setCaretColor(new java.awt.Color(255, 255, 255));

        jPasswordField3.setBackground(java.awt.SystemColor.controlHighlight);
        jPasswordField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField3.setBorder(null);
        jPasswordField3.setCaretColor(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jPasswordField2)
                            .addComponent(jPasswordField3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String cpass1 = jPasswordField1.getText();
        String npass1 = jPasswordField2.getText();
        String rpass1 = jPasswordField3.getText();
        if (cpass1.length() > 15) {
            clean("invalid Password size \nSize is should not to more than 15");
        } else if (npass1.length() > 15) {
            clean("invalid Password size \nSize is should not to more than 15");
        } else if (rpass1.length() > 15) {
            clean("invalid Password size \nSize is should not to more than 15");
        } else {
            try {
                conn = DriverManager.getConnection(dburl, "bank", "bank");
                stmt = conn.createStatement();
                String q1 = "Select password,pin,status from Bank.B1 where Accountnumber='" + acc_no + "'";
                ResultSet res = stmt.executeQuery(q1);
                res.next();
                String cpass2 = res.getString("password");
                int pin = res.getInt("pin");
                int st = res.getInt("status");
                if (st > 0) {
                    if (cpass1.equals(cpass2)) {
                        if (npass1.equals(rpass1)) {
                            if (npass1.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*\\(\\)_+\\{\\}\\[\\]\\?<>|_]).{4,15})")) {
                                Changepass.this.setVisible(false);
                                String p1 = JOptionPane.showInputDialog(jf, "enter the pin", "pin", JOptionPane.OK_CANCEL_OPTION);
                                try {
                                    int pin1 = Integer.parseInt(p1);
                                    if (pin == pin1) {
                                        String q2 = "update Bank.b1 set password='" + rpass1 + "' where accountnumber='" + acc_no + "'";
                                        stmt.executeUpdate(q2);
                                        JOptionPane.showMessageDialog(jf, "Password changed sucessfully", "sucessfull", JOptionPane.PLAIN_MESSAGE);
                                        new Bankservice(acc_no).setVisible(true);
                                    } else {
                                        query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no + "'";
                                        stmt.executeUpdate(query);
                                        chance(st, "Authentication Failed \nInvalid Pin\n");
                                    }
                                } catch (NumberFormatException ex) {
                                    query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no + "'";
                                    stmt.executeUpdate(query);
                                    chance(st, "Authentication Failed \nInvalid Pin\n");
                                }
                            } else {
                                s = "password should contain atleast \n1 special character\n1 numeric\n1 uppercase letter\n1 lowercase latter";
                                clean(s);
                            }
                        } else {
                            clean("password Mismatch");
                        }
                    } else {
                        query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no + "'";
                        stmt.executeUpdate(query);
                        chance(st, "Authentication Failed \nInvalid current Password\n");
                    }
                } else {
                    chance(st, null);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Changepin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Changepass.this.setVisible(false);
        new Startpage(null).setVisible(true);
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
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables

}
