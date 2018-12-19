/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.ConnectionDB;
import Code.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rajitha Shavinda
 */
public class subjectsStudentEnroll extends javax.swing.JFrame {

    /**
     * Creates new form Subjects
     */
    String stdID;

    public void setID(String s) {
        stdID = s;
    }

    public subjectsStudentEnroll() {
        initComponents();
        setLocationRelativeTo(null);
        LoadTbl();
    }

    private void LoadTbl() {
        try {

            java.sql.Connection con = ConnectionDB.Connect();

            //get all subject details
            String sql = "SELECT * FROM `subjects`";

            //java.sql.Statement>> 'Statement' object used for executing a static SQL statement and returning the results it produces.
            java.sql.Statement state = con.createStatement();

            //'ResultSet' >> A table of data representing a database result set, which is usually generated by executing a 'Statement' that queries the database.
            ResultSet rs = state.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) jTable.getModel();//table object

            while (rs.next()) {

                //add student details to table row by row
                model.addRow(new Object[]{rs.getString("sID"), rs.getString("SName"), rs.getString("Des")});

                jTable.setModel(model);
            }

            state.close(); //Statement

            rs.close(); // ResultSet

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //---------------------------------------------------------------------
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtKey = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 50, 452, 450);

        jButton1.setText("Enrol Me");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(490, 180, 150, 30);

        jButton3.setText("Unenrol me");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(490, 240, 150, 30);
        jPanel1.add(txtKey);
        txtKey.setBounds(490, 140, 150, 30);

        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(490, 313, 150, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Subjects");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(140, 0, 320, 40);

        jLabel4.setText("Enrolment key ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(490, 110, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int row = -1;

        row = jTable.getSelectedRow(); //get select row number

        if (row == -1) {

            JOptionPane.showMessageDialog(null, "Please select an item");

        } else {
            try {
                String subjetId;

                subjetId = jTable.getValueAt(row, 0).toString();//get selected sbject's id

                java.sql.Connection con = ConnectionDB.Connect();

                //query: get selected subject details
                String sql = "SELECT * FROM `subjects` where sID='" + subjetId + "'";

                java.sql.Statement state = con.createStatement();

                ResultSet rs = state.executeQuery(sql);

                rs.next();

                String key = rs.getString("Key"); //get selected subjet's Enrolment key 
                String name = rs.getString("SName"); //get selected subjet's name

                if (key.equals(txtKey.getText())) {//if subject Enrolment key  equals to student input

                    //get current user details
                    String sql1 = "SELECT * FROM `student` where `ID`='" + stdID + "';";

                    rs = state.executeQuery(sql1);

                    rs.next();

                    String subjects = rs.getString("subjects");//get enrol SubjectIDs
                    String subjNames = rs.getString("subNames");//get enroled subjets 

                    subjects += " " + subjetId; //Ex: FIT<SPACE>MIT
                    subjNames += "#" + name;//Ex: FIT#MIT

                    //update user details with newly added subject
                    String str = "UPDATE `student` SET `subjects`='" + subjects + "', `subNames`='" + subjNames + "'   Where `ID`='" + stdID + "';";

                    Statement statement = con.createStatement();

                    statement.executeUpdate(str);//update

                    statement.close();

                    JOptionPane.showMessageDialog(null, "sucessfully enrolled");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid key");
                }

                txtKey.setText("");//clear text box
                state.close(); //Statement

                rs.close(); // ResultSet

            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        StudentProfile s = new StudentProfile();
        s.getStudent(stdID); //send student Id to "StudentProfile" interface
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = -1;

        row = jTable.getSelectedRow(); //get select row number

        if (row == -1) {

            JOptionPane.showMessageDialog(null, "Please select an item");

        } else {
            try {
                //get confirmation message's answer to the "dialogButton1" variable (yes || no)
                   int dialogButton1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to unenrol this subject?", "Unenrol", JOptionPane.YES_NO_OPTION);

                if (dialogButton1 == 0) {//if user click yes

                    
                String subjetId;

                subjetId = jTable.getValueAt(row, 0).toString(); //get selected sbject's id

                java.sql.Connection con = ConnectionDB.Connect();

                //query: get selected subject details
                String sql = "SELECT * FROM `subjects` where sID='" + subjetId + "'";

                java.sql.Statement state = con.createStatement();

                ResultSet rs = state.executeQuery(sql);//

                rs.next();

                String name = rs.getString("SName"); //get selected subjet's name

                String sql1 = "SELECT * FROM `student` where `ID`='" + stdID + "';";  //get current user details

                rs = state.executeQuery(sql1);

                rs.next();

                String subjects = rs.getString("subjects");//get enroled SubjectIDs
                String subjNames = rs.getString("subNames");//get enroled subjets 

                subjects = subjects.replace(subjetId, " ");//Ex: Before :FIT<SPACE>MIT ||After :FIT<SPACE><SPACE>
                subjNames = subjNames.replace(name, "#");//Ex: Before :FIT#MIT ||After :FIT##

                //update user details with removed subject details
                String str = "UPDATE `student` SET `subjects`='" + subjects + "', `subNames`='" + subjNames + "'   Where `ID`='" + stdID + "';";

                Statement statement = con.createStatement();

                statement.executeUpdate(str);//update

                statement.close();

                JOptionPane.showMessageDialog(null, "sucessfully Unenrolled");

                state.close(); //Statement

                rs.close(); // ResultSet
                }
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(subjectsStudentEnroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subjectsStudentEnroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subjectsStudentEnroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subjectsStudentEnroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new subjectsStudentEnroll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtKey;
    // End of variables declaration//GEN-END:variables
}