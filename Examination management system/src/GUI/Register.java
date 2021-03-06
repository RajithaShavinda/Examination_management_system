/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.Student;
import Code.ConnectionDB;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rajitha Shavinda
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    String pass;
    boolean isAdmin = false;
    private String sub;

    public void setAdmin(boolean b) {
        //to identify if this is a student login or admin login 
        isAdmin = b;
    }

    public Register() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void setPasswordFields(boolean isUpdate) { //Prepare current interface for update or insert new details
        btnSubmit.setEnabled(!isUpdate);
        txtStudentID.setEnabled(!isUpdate);

        btnUpdate.setEnabled(isUpdate);

        txtPassword3.setVisible(isUpdate);
        lblOldPass.setVisible(isUpdate);

    }

    public void init(Student std, boolean admin) { // update mode || fill text boxes when interface starting
        txtStudentID.setText(std.getId());
        txtStudentName.setText(std.getName());
        txtEmail.setText(std.getEmail());
        txtContactNo.setText(std.getContact());
        txtCourseName.setText(std.getCourseName());
        txtBday.setText(std.getBday());
        pass = std.getPassword();
        sub = std.getSubjects();

        isAdmin = admin;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        txtStudentName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        txtBday = new javax.swing.JTextField();
        txtPassword1 = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();
        txtPassword3 = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblOldPass = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("Re enter Password");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 430, 110, 40);
        jPanel1.add(txtStudentID);
        txtStudentID.setBounds(200, 60, 170, 30);
        jPanel1.add(txtStudentName);
        txtStudentName.setBounds(200, 100, 170, 30);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(200, 160, 170, 30);
        jPanel1.add(txtContactNo);
        txtContactNo.setBounds(200, 200, 170, 30);

        txtCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCourseName);
        txtCourseName.setBounds(200, 250, 170, 30);

        txtBday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBdayActionPerformed(evt);
            }
        });
        jPanel1.add(txtBday);
        txtBday.setBounds(200, 300, 170, 30);

        txtPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassword1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword1);
        txtPassword1.setBounds(200, 440, 170, 30);

        txtPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassword2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword2);
        txtPassword2.setBounds(200, 400, 170, 30);

        txtPassword3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassword3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword3);
        txtPassword3.setBounds(200, 360, 170, 30);

        btnSubmit.setText("Register");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit);
        btnSubmit.setBounds(450, 60, 110, 40);

        btnCancel.setText("Continue");
        btnCancel.setToolTipText("");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);
        btnCancel.setBounds(450, 180, 110, 40);

        jLabel2.setText("Student ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 50, 110, 40);

        jLabel3.setText("name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 100, 110, 40);

        jLabel4.setText("email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 150, 110, 40);

        jLabel5.setText("Contact no");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 200, 110, 40);

        jLabel6.setText("coursename");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 240, 110, 40);

        jLabel7.setText("bday");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 290, 110, 40);

        lblOldPass.setText("Old Password");
        jPanel1.add(lblOldPass);
        lblOldPass.setBounds(70, 350, 110, 40);

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(450, 120, 110, 40);

        jLabel9.setText("New Password");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(70, 390, 110, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Register");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(160, 10, 270, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseNameActionPerformed

    private void txtBdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBdayActionPerformed

    private void txtPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassword1ActionPerformed

    private void txtPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassword2ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:

        try {
            String p1 = String.valueOf(txtPassword1.getPassword());
            String p2 = String.valueOf(txtPassword2.getPassword());

            if (p1.equals(p2)) {//password validation

                java.sql.Connection con = ConnectionDB.Connect();// call "ConnectionDB" class "Connect()" method to initialize Connection object
                
                //insert text boxes values to the table row
                String str = "INSERT INTO `student` values('" + txtStudentID.getText() + "','" + txtStudentName.getText() + "','" + txtEmail.getText() + "','"
                        + txtContactNo.getText() + "','" + txtCourseName.getText()
                        + "','" + txtBday.getText() + "','" + p1 + "','','','std');";

                Statement statement = con.createStatement(); 
                // 'Statement' object used for executing a static SQL statement and returning the results it produces.
                statement.executeUpdate(str);

                statement.close();

                JOptionPane.showMessageDialog(null, "Successfull");

            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
            }

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
            //return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return null;
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        try {
            if (isAdmin) { //if user is admin, navigate to "studentsAdmin" interface 
                new studentsAdmin().setVisible(true);
            } else {
                Login n = new Login();
                n.init(txtStudentID.getText(), String.valueOf(txtPassword1.getPassword())); //send user name and password to login interface
                n.setVisible(true);
                this.dispose();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return null;
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtPassword3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassword3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassword3ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {

            String p1 = String.valueOf(txtPassword1.getPassword());
            String p2 = String.valueOf(txtPassword2.getPassword());

            String curren_password = String.valueOf(txtPassword3.getPassword());

            if (p1.equals(p2) && curren_password.equals(pass)) { //password validation || Update mode

                java.sql.Connection con = ConnectionDB.Connect(); // call "ConnectionDB" class "Connect()" method to initialize Connection object
                
                //Update user details
                String str = "UPDATE `student` SET `Name`='" + txtStudentName.getText() + "',`email`='" + txtEmail.getText() + "',"
                        + "`contact`='" + txtContactNo.getText() + "', `Cname`='" + txtCourseName.getText()
                        + "', `bday`='" + txtBday.getText() + "', `password`='" + p1
                        + "' Where `ID`='" + txtStudentID.getText() + "';";

                Statement statement = con.createStatement();
                // 'Statement' object used for executing a static SQL statement and returning the results it produces.
                statement.executeUpdate(str);

                statement.close();

                JOptionPane.showMessageDialog(null, "Successfull");

            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
            }

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
            //return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return null;
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblOldPass;
    private javax.swing.JTextField txtBday;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JPasswordField txtPassword3;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
