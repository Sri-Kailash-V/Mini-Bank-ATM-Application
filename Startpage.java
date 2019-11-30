package Bank;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Startpage extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String dburl = "jdbc:derby://localhost:1527/Bank";
    static String pass = "password";
    static String user = "username";
    static Connection conn = null;
    static Statement stmt = null;
    static String acc_no, passd, query;
    int st;
    static int i = 1, j = 0;
    JFrame jf = new JFrame();
    LocalDateTime now, tom, bl, op;

    private void clear() {
        jTextField1.setText(null);
        jPasswordField1.setText(null);
    }

    private void chance(int sta) {
        if (sta > 0) {
            JOptionPane.showMessageDialog(jf, "Enter the valid userid or password\n" + sta + " chance available", "ERROR", JOptionPane.ERROR_MESSAGE);
            clear();
            new Startpage(null).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(jf, "Sorry account blocked \nplese login after 24 hours\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            clear();
            new Startpage(acc_no).setVisible(false);
        }
    }

    public Startpage(String acc_no) {
        if (acc_no != null) {
            try {
                conn = DriverManager.getConnection(dburl, "bank", "bank");
                stmt = conn.createStatement();
                query = "Select block from Bank.B1 where Accountnumber='" + acc_no + "'";
                ResultSet res = stmt.executeQuery(query);
                res.next();
                now = LocalDateTime.now();
                query = "update Bank.b1 set block='" + now.plusHours(24) + "'where accountnumber='" + acc_no + "'";
                stmt.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Startpage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Start Page");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Welcome to ATM");

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(240, 240, 240));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jPasswordField1.setBackground(new java.awt.Color(240, 240, 240));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPasswordField1.setBorder(null);
        jPasswordField1.setCaretColor(new java.awt.Color(240, 240, 240));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Account number");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Startpage.this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
    }//GEN-LAST:event_jPasswordField1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        acc_no = jTextField1.getText();
        passd = jPasswordField1.getText();
        Startpage.this.setVisible(false);
        int in = JOptionPane.showConfirmDialog(jf, "continue to login as " + acc_no, "Alert", JOptionPane.OK_OPTION);
        if (in == JOptionPane.OK_OPTION) {
            try {
                conn = DriverManager.getConnection(dburl, "bank", "bank");
                stmt = conn.createStatement();
                query = "Select password,accountnumber,status,block from Bank.B1 where Accountnumber='" + acc_no + "'";
                ResultSet res = stmt.executeQuery(query);
                if (res.next()) {
                    String pass1 = res.getString("Password");
                    st = res.getInt("status");
                    bl = LocalDateTime.parse(res.getString("block"));
                    now = LocalDateTime.now();
                    if ((st <= 0)) {
                        if (now.isAfter(bl)) {
                            query = "update Bank.b1 set status=" + 3 + "where accountnumber='" + acc_no + "'";
                            stmt.executeUpdate(query);
                            query = "update Bank.b1 set block='" + now + "'where accountnumber='" + acc_no + "'";
                            stmt.executeUpdate(query);
                            j = 1;
                        } else {
                            JOptionPane.showMessageDialog(jf, "Account blocked \nlogin after some time", "ERROR", JOptionPane.ERROR_MESSAGE);
                            j = 0;
                        }
                    } else if ((st > 0)) {
                        j = 1;
                    }
                    if (j != 0) {
                        if (passd.equals(pass1)) {
                            new Bankservice(acc_no).setVisible(true);
                        } else {
                            query = "update Bank.b1 set status=" + (--st) + "where accountnumber='" + acc_no + "'";
                            stmt.executeUpdate(query);
                            chance(st);
                        }
                    } else {
                        new Startpage(null).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(jf, "Enter the valid userid or password", "ERROR", JOptionPane.ERROR_MESSAGE);
                    clear();
                    new Startpage(null).setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Startpage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            clear();
            Startpage.this.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
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
            java.util.logging.Logger.getLogger(Startpage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Startpage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Startpage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Startpage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Startpage(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
