/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package healthcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PUBLIC
 */
public class Channel extends javax.swing.JFrame {

    /**
     * Creates new form Channel
     */
    public Channel() {
        initComponents();
        Connect();
        autoId();
        LoadDoctor();
        LoadPatient();
        Channel_table();
    }
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String chno;
    
    public class Doctor{
        String id;
        String name;
        public Doctor(String id,String name){
            this.id=id;
            this.name=name;
        }
        public String toString(){
            return name;
        }
    }
    
    public class Patient { 
        String id; 
        String name; 
        public Patient( String id, String name ) 
        { 
            this.id = id; 
            this.name = name; 
        } 

      
        public String toString() 
        { 
            return name; 
        } 
    }

 
    public void LoadDoctor()
       {
           
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","Rakesh@108");
             pst = con.prepareStatement("select * from doctor");
              rs = pst.executeQuery();
             txtdoctor.removeAll();
             
             while(rs.next())
             {
                 String id1 = rs.getString(1);
            
                txtdoctor.addItem(new Doctor(rs.getString(1),rs.getString(2)) );
             }

        } catch (ClassNotFoundException ex) {
          //  Logger.getLogger(channel.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         //   Logger.getLogger(channel.class.getName()).log(Level.SEVERE, null, ex);
        }           
       }
    
    public void LoadPatient()
       {
           
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","Rakesh@108");
             pst = con.prepareStatement("select * from patient");
              rs = pst.executeQuery();
             txtpatient.removeAll();
             
             while(rs.next())
             {
                 String id1 = rs.getString(1);
            
                txtpatient.addItem(new Patient(rs.getString(1),rs.getString(2)) );
             }

        } catch (ClassNotFoundException ex) {
          //  Logger.getLogger(channel.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         //   Logger.getLogger(channel.class.getName()).log(Level.SEVERE, null, ex);
        }           
       }
    
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare","root","Rakesh@108");
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
  
       
         
    }
    public void autoId() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "Rakesh@108");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT COUNT(channelno) FROM Channel");
            rs.next();
            int channelCount = rs.getInt(1);
            lblchno.setText("CH" + String.format("%03d", channelCount + 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
public void Channel_table() {
    try {
        pst = con.prepareStatement("SELECT * FROM channel");
        ResultSet Rs = pst.executeQuery();
        ResultSetMetaData RSMD = Rs.getMetaData();
        int C = RSMD.getColumnCount();
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        
        // Clear existing rows in the table
        DFT.setRowCount(0);

        while (Rs.next()) {
            Vector v2 = new Vector();
            for (int i = 1; i <= C; i++) {
                v2.add(Rs.getString("channelno"));
                v2.add(Rs.getString("doctorname"));
                v2.add(Rs.getString("patientname"));
                v2.add(Rs.getString("roomno"));
                v2.add(Rs.getString("date"));

                
            }
            DFT.addRow(v2);
        }
    } catch (Exception e) {
        e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblchno = new javax.swing.JLabel();
        txtdoctor = new javax.swing.JComboBox();
        txtpatient = new javax.swing.JComboBox();
        txtroom = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtdate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 132, 240));

        jPanel2.setBackground(new java.awt.Color(196, 219, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Channel Registration"));

        jLabel1.setText("Doctor name");

        jLabel2.setText("Channel no");

        jLabel6.setText("Patient name");

        jLabel7.setText("Channel date");

        jLabel8.setText("Room no");

        lblchno.setText("jLabel3");

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DELETE");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("YYYY-MM-DD");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "channel no", "doctor id ", "patient iid", "room no", "date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("EXIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblchno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdoctor, 0, 112, Short.MAX_VALUE)
                                .addComponent(txtpatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton2)
                        .addGap(43, 43, 43)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblchno))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(16, 16, 16))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );

        jLabel4.setText("                                            CHANNEL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    String chno=lblchno.getText();
    Doctor d=(Doctor) txtdoctor.getSelectedItem();
    Patient p=(Patient) txtpatient.getSelectedItem();
    String date=txtdate.getText();;
    String room=txtroom.getValue().toString();
    
    
          
        try {
       
            pst = con.prepareStatement("insert into Channel(channelno,doctorname,patientname,roomno,date)values(?,?,?,?,?)" );
            pst.setString(1, chno);
            pst.setString(2,d.id);
            pst.setString(3, p.id);
            pst.setString(4, room);
            pst.setString(5, date);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Appointment created");
            
            
            lblchno.setText("");
            txtdoctor.setSelectedIndex(-1);
            txtpatient.setSelectedIndex(-1);
            txtroom.setValue(0);
            txtdate.setText("");
            Channel_table();
            autoId();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(healthcare.Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
     // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel) jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
         chno =d1.getValueAt(selectIndex, 0).toString();
        JOptionPane.showMessageDialog(this, chno);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          
        try {
            String chno=lblchno.getText();
       
            pst = con.prepareStatement("delete from channel where channelno =?" );
            pst.setString(1, chno);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Appointment deleted");
            
            
            lblchno.setText("");
            txtdoctor.setSelectedIndex(-1);
            txtpatient.setSelectedIndex(-1);
            txtroom.setValue(0);
            txtdate.setText("");
            Channel_table();
            autoId();
            jButton1.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(healthcare.Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
     // TODO add your handling code here:
  
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        // TODO add your handling code here:
          DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
         int selectIndex = jTable1.getSelectedRow(); 
         lblchno.setText(d1.getValueAt(selectIndex, 0).toString());
         txtdoctor.setSelectedItem(d1.getValueAt(selectIndex, 1).toString());
         txtpatient.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
          txtroom.setValue(Integer.parseInt(d1.getValueAt(selectIndex, 3).toString()));
        txtdate.setText(d1.getValueAt(selectIndex, 4).toString());
        
        jButton1.setEnabled(false);
        
        
        
      
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Channel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblchno;
    private javax.swing.JTextField txtdate;
    private javax.swing.JComboBox txtdoctor;
    private javax.swing.JComboBox txtpatient;
    private javax.swing.JSpinner txtroom;
    // End of variables declaration//GEN-END:variables
}
