/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package endassessment;

import static endassessment.Login.uname;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class MyAppointments extends javax.swing.JPanel {
    Connection con = null;
    PreparedStatement pre = null;
    ResultSet res = null;
    String uname = Login.getUsername();
    String status;
    /**
     * Creates new form AdminProfile
     */
    public MyAppointments() {
        initComponents();
        con = dbConnection.connect();
        txtBookingDate.setMinSelectableDate(new Date());
        fill_slots();
        uname = Login.getUsername();
        fill_appointments();
        ctrlBtn();            
    }
    
    public String getUserType(){
        
        try {
                
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery("select type from users where username = '" +uname+ "'");
                 if (rs.absolute(1)) {
                    status = rs.getString("type");
                } else {
                     
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return status;
    }
   
    public void ctrlBtn(){
        if(getUserType().equals("patient")){
            DeleteApBtn1.setVisible(false);
            
        }else if(getUserType().equals("receptionist")){
            DeleteApBtn1.setVisible(false);
            UpdateApBtn.setVisible(false);
        }else if(getUserType().equals("admin")){
            UpdateApBtn.setVisible(false);
            BookApBtn1.setVisible(false);
        }
    }
    
       public void fill_slots() {

        String sql = "select * from slots";
        try {
            pre = con.prepareStatement(sql);
            res = pre.executeQuery();

            while (res.next()) {
                txtTime.addItem(res.getString("slot"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
        }

    }
       
     public void fill_appointments() {
         String sql;
         if(getUserType().equals("admin")){
                 sql = "select id,patient, time, ap_date, doctor, doctor_type, status from appointments";
         }else{
                 sql = "select id,patient, time, ap_date, doctor, doctor_type, status from appointments where patient='"+uname+"'";
         }
        try {
            pre = con.prepareStatement(sql);
            res = pre.executeQuery();
            appointmentsTable.setModel(DbUtils.resultSetToTableModel(res));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblAvatar2 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtDoctorTypes = new javax.swing.JComboBox<>();
        UpdateApBtn = new javax.swing.JButton();
        lblPassword1 = new javax.swing.JLabel();
        txtTime = new javax.swing.JComboBox<>();
        lblPassword2 = new javax.swing.JLabel();
        txtDoctors = new javax.swing.JComboBox<>();
        txtBookingDate = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        appointmentsTable = new javax.swing.JTable();
        BookApBtn1 = new javax.swing.JButton();
        ClearFieldsBtn = new javax.swing.JButton();
        DeleteApBtn1 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        lblAvatar2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblAvatar2.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatar2.setText("Appoinments");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Appointment Date");

        lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Select Doctor Type");

        txtDoctorTypes.setBackground(new java.awt.Color(153, 153, 153));
        txtDoctorTypes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Doctor Type", "cardiologist", "pediatrician", "ophthalmologist", "ent", "dentist", "general" }));
        txtDoctorTypes.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtDoctorTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorTypesActionPerformed(evt);
            }
        });

        UpdateApBtn.setBackground(new java.awt.Color(0, 204, 255));
        UpdateApBtn.setForeground(new java.awt.Color(255, 255, 255));
        UpdateApBtn.setText("Update");
        UpdateApBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateApBtnActionPerformed(evt);
            }
        });

        lblPassword1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lblPassword1.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword1.setText("Time");

        txtTime.setBackground(new java.awt.Color(153, 153, 153));
        txtTime.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });

        lblPassword2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lblPassword2.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword2.setText("Available Doctors");

        txtDoctors.setBackground(new java.awt.Color(153, 153, 153));
        txtDoctors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Cardiologist", "2 - Pediatrician", "3 - Ophthalmologist", "4 - ENT", "5 - Dentist", "6 - General" }));
        txtDoctors.setSelectedIndex(-1);
        txtDoctors.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        appointmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        appointmentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(appointmentsTable);

        BookApBtn1.setBackground(new java.awt.Color(0, 204, 255));
        BookApBtn1.setForeground(new java.awt.Color(255, 255, 255));
        BookApBtn1.setText("Book");
        BookApBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookApBtn1ActionPerformed(evt);
            }
        });

        ClearFieldsBtn.setBackground(new java.awt.Color(0, 204, 255));
        ClearFieldsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearFieldsBtn.setText("Clear");
        ClearFieldsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearFieldsBtnActionPerformed(evt);
            }
        });

        DeleteApBtn1.setBackground(new java.awt.Color(0, 204, 255));
        DeleteApBtn1.setForeground(new java.awt.Color(255, 255, 255));
        DeleteApBtn1.setText("Delete");
        DeleteApBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteApBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(lblAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BookApBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(UpdateApBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(DeleteApBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(ClearFieldsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPassword)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword1)
                            .addComponent(lblPassword2)
                            .addComponent(txtBookingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDoctors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDoctorTypes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvatar2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPassword)
                        .addGap(18, 18, 18)
                        .addComponent(txtDoctorTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPassword2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsername)
                        .addGap(18, 18, 18)
                        .addComponent(txtBookingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPassword1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateApBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearFieldsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteApBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookApBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateApBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateApBtnActionPerformed
        if (txtDoctorTypes.getSelectedItem().equals("Select Doctor Type")) {
            JOptionPane.showMessageDialog(null, "Please selector Doctor Type");
        } else if (txtDoctors.getSelectedItem().equals("Select Doctor")) {
            JOptionPane.showMessageDialog(null, "Please selector Doctor");
        } else if (txtBookingDate.getDate().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please select date");
        } else if (txtTime.getSelectedItem().equals("Select Time")) {
            JOptionPane.showMessageDialog(null, "Please selector Time");
        } else {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(txtBookingDate.getDate());

            String sql2 = "SELECT * FROM appointments WHERE ap_date='" +date+ "' AND time='" + txtTime.getSelectedItem().toString() + "' AND doctor='" + txtDoctors.getSelectedItem().toString() + "'";
            try {
                pre = con.prepareStatement(sql2);
                res=pre.executeQuery();
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "The date and time occupied, please select a different date and time");

                } else {
                    int row = appointmentsTable.getSelectedRow();
                    String t = appointmentsTable.getModel().getValueAt(row, 0).toString();
                    String sql = "UPDATE appointments SET doctor='"+txtDoctors.getSelectedItem()+"', doctor_type='"+txtDoctorTypes.getSelectedItem()+"',ap_date='"+date+"',time='"+txtTime.getSelectedItem()+"' WHERE id='"+t+"'";
                    
                    pre = con.prepareStatement(sql);
                    pre.execute();
                    JOptionPane.showMessageDialog(null, "Booking modified Successfully", "Success", 1);
                    clear();
                    fill_appointments();

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error while modifying Booking", 2);
            }

        }

    }//GEN-LAST:event_UpdateApBtnActionPerformed

    private void txtDoctorTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorTypesActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM users WHERE type='" + txtDoctorTypes.getSelectedItem() + "'";
        try {
            pre = con.prepareStatement(sql);
            res = pre.executeQuery();
            txtDoctors.removeAllItems();
            while (res.next()) {
                txtDoctors.addItem(res.getString("username"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
        }
    }//GEN-LAST:event_txtDoctorTypesActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void appointmentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentsTableMouseClicked
        // TODO add your handling code here:
        setfields();

    }//GEN-LAST:event_appointmentsTableMouseClicked

    private void BookApBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookApBtn1ActionPerformed
        // TODO add your handling code here:
                if (txtDoctorTypes.getSelectedItem().equals("Select Doctor Type")) {
            JOptionPane.showMessageDialog(null, "Please selector Doctor Type");
        } else if (txtDoctors.getSelectedItem().equals("Select Doctor")) {
            JOptionPane.showMessageDialog(null, "Please selector Doctor");
        } else if (txtBookingDate.getDate().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please select date");
        } else if (txtTime.getSelectedItem().equals("Select Time")) {
            JOptionPane.showMessageDialog(null, "Please select Time");
        } else {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(txtBookingDate.getDate());

            String sql2 = "SELECT * FROM appointments WHERE ap_date='" +date+ "' AND time='" + txtTime.getSelectedItem().toString() + "' AND doctor='" + txtDoctors.getSelectedItem().toString() + "'";
            try {
                pre = con.prepareStatement(sql2);
                res=pre.executeQuery();
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "The date and time occupied, please select a different date and time");

                } else {
                    String sql = "insert into appointments (patient,doctor, doctor_type,ap_date,time) values ('" +uname+ "',"
                    + "'" + txtDoctors.getSelectedItem() + "','" + txtDoctorTypes.getSelectedItem() + "','" + date + "','" + txtTime.getSelectedItem() + "')";
                    pre = con.prepareStatement(sql);
                    pre.execute();
                    JOptionPane.showMessageDialog(null, "Booking Successfully done", "Success", 1);
                    fill_appointments();
                    clear();
                    

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error while searchig for Booking", 2);
            }

        }

    }//GEN-LAST:event_BookApBtn1ActionPerformed

    private void ClearFieldsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearFieldsBtnActionPerformed
        // TODO add your handling code here
        clear();
    }//GEN-LAST:event_ClearFieldsBtnActionPerformed

    private void DeleteApBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteApBtn1ActionPerformed
        // TODO add your handling code here:
        int row = appointmentsTable.getSelectedRow();
        String t = appointmentsTable.getModel().getValueAt(row, 0).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(txtBookingDate.getDate());
        String sql = "delete from appointments where id='" + t + "'";
        try {
            pre = con.prepareStatement(sql);
            pre.execute();
            JOptionPane.showMessageDialog(null, "Booking Cancelled", "Success", 1);
            clear();
            fill_appointments();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
        }

    }//GEN-LAST:event_DeleteApBtn1ActionPerformed
public void clear() {

        txtDoctorTypes.setSelectedIndex(0);
        txtDoctors.removeAllItems();
        txtTime.setSelectedIndex(0);
        txtBookingDate.setCalendar(null);
        
        UpdateApBtn.setEnabled(false);
        BookApBtn1.setEnabled(true);
        DeleteApBtn1.setEnabled(false);
         
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookApBtn1;
    private javax.swing.JButton ClearFieldsBtn;
    private javax.swing.JButton DeleteApBtn1;
    private javax.swing.JButton UpdateApBtn;
    private javax.swing.JTable appointmentsTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvatar2;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblUsername;
    private com.toedter.calendar.JDateChooser txtBookingDate;
    private javax.swing.JComboBox<String> txtDoctorTypes;
    private javax.swing.JComboBox<String> txtDoctors;
    private javax.swing.JComboBox<String> txtTime;
    // End of variables declaration//GEN-END:variables

private void setfields() {
        int row = appointmentsTable.getSelectedRow();
        String t = appointmentsTable.getModel().getValueAt(row, 0).toString();
        String sql = "select * from appointments where id='" + t + "' ";
        try {
            pre = con.prepareStatement(sql);
            res = pre.executeQuery();
            if (res.next()) {
                BookApBtn1.setEnabled(false);
                UpdateApBtn.setEnabled(false);
                ClearFieldsBtn.setEnabled(true);
                DeleteApBtn1.setEnabled(true);
                UpdateApBtn.setEnabled(true);
                //txtdob.setDate(res.getDate("dob"));
                txtBookingDate.setDate(res.getDate("ap_date"));
                txtTime.setSelectedItem(res.getString("time"));
                txtDoctorTypes.setSelectedItem(res.getString("doctor_type"));
                String doctor_name = res.getString("doctor");
                System.out.print("Doctor: " + doctor_name);

                String sql2 = "SELECT * FROM users WHERE type='" + res.getString("doctor_type") + "'";
                try {
                    pre = con.prepareStatement(sql2);
                    res = pre.executeQuery();
                    while (res.next()) {
                        txtDoctors.addItem(res.getString("username"));
                        if (res.getString("username") == doctor_name) {
                            txtDoctors.setSelectedItem(res.getString("username"));
                        }

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error occured", 2);
                }

            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error oc", 2);
        }

    }

}