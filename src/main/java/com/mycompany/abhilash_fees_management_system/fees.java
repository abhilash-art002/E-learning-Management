/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.abhilash_fees_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author abhil
 */

public class fees extends javax.swing.JFrame {

    /**
     * Creates new form fees
     */
    public void displayCashFirst(){
        lblcheque.setVisible(false);
        ddnum.setVisible(false);
        txt_cheque_no.setVisible(false);
        txt_dd_no.setVisible(false);
        lblbankno.setVisible(false);
        txt_card.setVisible(false);
         modeupi.setVisible(false);
        combo_upi.setVisible(false);
         lblcardno.setVisible(false);
        txt_card.setVisible(false);
        txt_bank1.setVisible(false);
        txt_rNum.setVisible(true);
        lbl_reciver.setVisible(true);
    }
    boolean validation(){
       if(txt_rNum.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please Enter reciver Name First");
           return false;
           
       }
       if(txt_date.getDate()==null){
           JOptionPane.showMessageDialog(this,"Please Enter date");
           return false;
           
       }
       if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+")==false){
           JOptionPane.showMessageDialog(this,"Please Enter Amount (in number)");
           return false;
           
       } if(combo_modepayment.getSelectedItem().toString().equalsIgnoreCase("check")){
           if(txt_cheque_no.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please Enter Cheque No");
           return false;
           }
           if(txt_bank1.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please Enter Bank Name");
           return false;
           }
           
       
           
       }
       if(combo_modepayment.getSelectedItem().toString().equalsIgnoreCase("dd")){
           if(ddnum.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please Enter dd No");
           return false;
           }
           if(txt_bank1.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please Enter Bank Name");
           return false;
           }
           
       
           
       }
       

       
       

       return true;
        
        
    }
    public String insertData(){
         String formattedDate ;
        int receiptno=Integer.parseInt(txt_recipt.getText());
        String sname=txt_recvier_name1.getText();
        int rollno=Integer.parseInt(txt_rNum.getText());
        String pMode=combo_modepayment.getSelectedItem().toString();
        String chequeno=txt_cheque_no.getText();
        String bankname=txt_bank1.getText();
        String ddno=txt_dd_no.getText();
        String coursename=combo_modepayment.getSelectedItem().toString();
        String gst=txt_cgst.getText();
        float total=Float.parseFloat(txt_total.getText());
        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");

// Get the selected date from the JDateChooser
Date date = txt_date.getDate();

if (date != null) {
    // Format the date to the desired string representation
       formattedDate = sd1.format(date);
      
} else {
    // Handle the case when no date is selected
    return "No date selected";
}                                                              

        float amount=Float.parseFloat(txt_amount.getText());
        float cgst=Float.parseFloat(txt_cgst.getText());   
        float sgst=Float.parseFloat(txt_sgst.getText());
        //String totalinwords=txt_tatal_in_words.getText();
        //String remark=jTextAreal.getText();
        int yearl=Integer.parseInt(fromyear.getText());
        int year2=Integer.parseInt(toyear.getText());
        
        String status="";
        try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               String url="jdbc:mysql://localhost:3306/elearning?zeroDateTimeBehavior=CONVERT_TO_NULL";
               Connection con= DriverManager.getConnection(url,"root","");
               String sql = "insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
               PreparedStatement st = con.prepareStatement(sql); 
               st.setInt(1,receiptno);
               st.setString(2,sname);
               st.setInt(3,rollno);
               st.setString(4,pMode);
               st.setString(5,chequeno);
               st.setString(6,bankname);
               st.setString(7,ddno);
               st.setString(8,coursename);
               st.setString(9,gst);
               st.setFloat (10,total);
                st.setString(11, formattedDate);
               st.setFloat (12, amount);
               st.setFloat(13,cgst);
               st.setFloat(14,sgst);
               st.setInt(15, yearl);
               st.setInt(16, year2);
               
              int c= st.executeUpdate();
              
              if(c==1)
              {
                 status="Success" ;
              }
              else{
                  status="Failed" ;
              }
               
                       
             }catch(Exception e1){
            e1.printStackTrace();
        }
        return status;
        
        
    }
    
    public fees() {
        initComponents();
        displayCashFirst();
        fill(); 
       int r= getRnum();
       r++;
       txt_recipt.setText(Integer.toString(r));
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_recipt = new javax.swing.JLabel();
        lbl_mode_payment = new javax.swing.JLabel();
        ddnum = new javax.swing.JLabel();
        combo_modepayment = new javax.swing.JComboBox<>();
        lblcheque = new javax.swing.JLabel();
        txt_recipt = new javax.swing.JTextField();
        lblbankno = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        txt_dd_no = new javax.swing.JTextField();
        txt_card = new javax.swing.JTextField();
        txt_date = new com.toedter.calendar.JDateChooser();
        lblgstin = new javax.swing.JLabel();
        lblgstin2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        toyear = new javax.swing.JTextField();
        fromyear = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txt_sgst = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        txt_cgst = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_course_name = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_reciver = new javax.swing.JLabel();
        txt_rNum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_recvier_name1 = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txt_cheque_no = new javax.swing.JTextField();
        combo_upi = new javax.swing.JComboBox<>();
        modeupi = new javax.swing.JLabel();
        lblcardno = new javax.swing.JLabel();
        txt_bank1 = new javax.swing.JTextField();
        combocourse = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton3.setText("Course List");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("D:\\2ND SEMESTER\\JAVA TECHNOLOGIES\\REPORT\\project Image\\project Image\\back.png")); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 255, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("D:\\2ND SEMESTER\\JAVA TECHNOLOGIES\\REPORT\\project Image\\project Image\\logout.png")); // NOI18N
        jButton6.setText("Logout");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\2ND SEMESTER\\JAVA TECHNOLOGIES\\REPORT\\icons\\systemIcon.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(63, 63, 63)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_recipt.setText("Recipt no");
        jPanel2.add(lbl_recipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lbl_mode_payment.setText("Mode of Payment");
        jPanel2.add(lbl_mode_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        ddnum.setText("DD no.");
        jPanel2.add(ddnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        combo_modepayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CASH", "UPI", "CREDIT CARD", "CHEQUE" }));
        combo_modepayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_modepaymentActionPerformed(evt);
            }
        });
        jPanel2.add(combo_modepayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        lblcheque.setText("cheque no");
        jPanel2.add(lblcheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        txt_recipt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_recipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 100, -1));

        lblbankno.setText("Bank Name");
        jPanel2.add(lblbankno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lbldate.setText("Date");
        jPanel2.add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        txt_dd_no.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_dd_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dd_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));

        txt_card.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cardActionPerformed(evt);
            }
        });
        jPanel2.add(txt_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));
        jPanel2.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 120, -1));

        lblgstin.setText("GST No.");
        jPanel2.add(lblgstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        lblgstin2.setText("AW123M50");
        jPanel2.add(lblgstin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 90, 20));
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        toyear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        toyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toyearActionPerformed(evt);
            }
        });
        jPanel4.add(toyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 100, -1));

        fromyear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fromyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromyearActionPerformed(evt);
            }
        });
        jPanel4.add(fromyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(255, 0, 51));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 170, 610, 26));

        txt_sgst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        jPanel4.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 110, -1));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel4.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 110, -1));

        txt_total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        jPanel4.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 110, -1));

        jLabel19.setText("GST 7%");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(255, 0, 51));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 610, 26));

        jLabel20.setText("SGST 7%");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        txt_cgst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        jPanel4.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 110, -1));

        jLabel21.setText("TOTAL");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 326, -1, 20));

        txt_course_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_nameActionPerformed(evt);
            }
        });
        jPanel4.add(txt_course_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 180, -1));

        jSeparator4.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator4.setForeground(new java.awt.Color(255, 0, 51));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 160, 26));

        jLabel12.setText("Sr No");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel16.setText("Head");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jLabel17.setText("Amount");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, -1));

        lbl_reciver.setText(" Name");
        jPanel4.add(lbl_reciver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, -1));

        txt_rNum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_rNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rNumActionPerformed(evt);
            }
        });
        jPanel4.add(txt_rNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 150, -1));

        jLabel10.setText(" Roll No.");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        txt_recvier_name1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_recvier_name1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_recvier_name1ActionPerformed(evt);
            }
        });
        jPanel4.add(txt_recvier_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 210, -1));

        print.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon("D:\\2ND SEMESTER\\JAVA TECHNOLOGIES\\REPORT\\project Image\\project Image\\submit.png")); // NOI18N
        print.setText("SUBMIT");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel4.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        jLabel15.setText("No. of class per week");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 120, -1));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setText("Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 539, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(59, 59, 59))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(86, 86, 86))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 670, 470));

        txt_cheque_no.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cheque_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cheque_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cheque_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));

        combo_upi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phone Pay", " " }));
        combo_upi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_upiMouseClicked(evt);
            }
        });
        combo_upi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_upiActionPerformed(evt);
            }
        });
        jPanel2.add(combo_upi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        modeupi.setText("Mode of UPI");
        jPanel2.add(modeupi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        lblcardno.setText("Card No.");
        jPanel2.add(lblcardno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txt_bank1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank1ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_bank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 100, -1));

        combocourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocourseActionPerformed(evt);
            }
        });
        jPanel2.add(combocourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jLabel1.setText("Price & Range");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1month - $3200", "3month - $3900", "6month - $4300", "1year - $4500", "1.5year - $4800", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        jLabel3.setText("course");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
search l2=new search()  ;
l2.show();
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
home l2=new home()  ;
l2.show();
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
home l2=new home()  ;
l2.show();
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
Start l2=new Start()  ;
l2.show();
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void combo_modepaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_modepaymentActionPerformed
        if(combo_modepayment.getSelectedIndex()==1)
        {
        lblcheque.setVisible(false);
        txt_cheque_no.setVisible(false);
        
        ddnum.setVisible(false);
        txt_dd_no.setVisible(false);
        lblbankno.setVisible(false);
        txt_bank1.setVisible(false);
        txt_card.setVisible(false); 
        modeupi.setVisible(false);
        combo_upi.setVisible(false);
        
        }
        if(combo_modepayment.getSelectedIndex()==0){
        lblcheque.setVisible(false);
        txt_cheque_no.setVisible(false);
        
        ddnum.setVisible(true);
        txt_dd_no.setVisible(true);
        lblbankno.setVisible(true);
        txt_bank1.setVisible(true);
        txt_card.setVisible(true);
        
        modeupi.setVisible(false);
        combo_upi.setVisible(false);
        lblcardno.setVisible(false);
        txt_card.setVisible(false);
    
} 
      if(combo_modepayment.getSelectedIndex()==4){
        lblcheque.setVisible(true);
        txt_cheque_no.setVisible(true);
        
        ddnum.setVisible(false);
        txt_dd_no.setVisible(false);
        lblbankno.setVisible(true);
        txt_bank1.setVisible(true);
        txt_card.setVisible(false);
        
        modeupi.setVisible(false);
        combo_upi.setVisible(false);
        lblcardno.setVisible(false);
        txt_card.setVisible(false);
      } 
       if(combo_modepayment.getSelectedIndex()==2){
        lblcheque.setVisible(false);
        txt_cheque_no.setVisible(false);
        
        ddnum.setVisible(false);
        txt_dd_no.setVisible(false);
        lblbankno.setVisible(false);
        txt_bank1.setVisible(false);
        txt_card.setVisible(false);
        
         modeupi.setVisible(true);
        combo_upi.setVisible(true);
        lblcardno.setVisible(false);
        txt_card.setVisible(false);
      }
       if(combo_modepayment.getSelectedIndex()==3){
          lblcheque.setVisible(false);
        txt_cheque_no.setVisible(false);
        
        ddnum.setVisible(false);
        txt_dd_no.setVisible(false);
        lblbankno.setVisible(false);
        txt_bank1.setVisible(false);
        txt_card.setVisible(false);
        
         modeupi.setVisible(false);
        combo_upi.setVisible(false);
        lblcardno.setVisible(true);
        txt_card.setVisible(true);
      }
       
      
    }//GEN-LAST:event_combo_modepaymentActionPerformed

    private void txt_dd_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dd_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dd_noActionPerformed

    private void txt_cardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cardActionPerformed

    private void txt_cheque_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cheque_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cheque_noActionPerformed

    private void txt_bank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(validation()==true){

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_rNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rNumActionPerformed

    private void txt_course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_nameActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
String s1=txt_amount.getText();
        float amt = Float.parseFloat(s1);

        float cgst=amt*0.07f;
        float sgst=amt*0.07f;

        txt_cgst.setText(Float.toString(cgst));
        txt_sgst.setText(Float.toString(sgst));
        float t=amt+cgst+sgst;
        txt_total.setText(Float.toString(t));        
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void combocourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocourseActionPerformed
String s1=combocourse.getSelectedItem().toString();
    txt_course_name.setText(s1);      // TODO add your handling code here:
    }//GEN-LAST:event_combocourseActionPerformed

    private void txt_recvier_name1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_recvier_name1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_recvier_name1ActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
    if(validation()==true)
    {
       

String s=insertData();

if(s.equals("Success"))

{

JOptionPane.showMessageDialog(this, "Trancastion successfully");
}
else

{

JOptionPane.showMessageDialog(this, "Record not inserted");

}
    }  
    }//GEN-LAST:event_printActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void toyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toyearActionPerformed

    private void fromyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromyearActionPerformed

    private void combo_upiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_upiActionPerformed


        // TODO add your handling code here:
    }//GEN-LAST:event_combo_upiActionPerformed

    private void combo_upiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_upiMouseClicked

upi l1=new upi()  ;
l1.show();
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_combo_upiMouseClicked
void fill(){
  
    try{
         Class.forName("com.mysql.cj.jdbc.Driver");
               String url="jdbc:mysql://localhost:3306/elearning?zeroDateTimeBehavior=CONVERT_TO_NULL";
               Connection con= DriverManager.getConnection(url,"root","");
               String sql = "SELECT CNAME FROM course1"; 
               
              PreparedStatement st = con.prepareStatement(sql);

 
              ResultSet rs = st.executeQuery(sql);  
    
    while (rs.next()) {
        combocourse.addItem(rs.getString("CNAME"));
        
    }
    
    }catch(Exception e){
        e.printStackTrace();
    }
}
public int getRnum(){
  int rno=0;
    try{
         Class.forName("com.mysql.cj.jdbc.Driver");
               String url="jdbc:mysql://localhost:3306/elearning?zeroDateTimeBehavior=CONVERT_TO_NULL";
               Connection con= DriverManager.getConnection(url,"root","");
               
               PreparedStatement st = con.prepareStatement("select max(reciept_no) from fees_details"); 
               ResultSet rs = st.executeQuery(); 
               
                   if(rs.next()==true)
                   {
                   rno=rs.getInt(1);
                   }
    
    
    }catch(Exception e){
        e.printStackTrace();
    }
    
    
    return rno;
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
            java.util.logging.Logger.getLogger(fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_modepayment;
    private javax.swing.JComboBox<String> combo_upi;
    private javax.swing.JComboBox<String> combocourse;
    private javax.swing.JLabel ddnum;
    private javax.swing.JTextField fromyear;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_mode_payment;
    private javax.swing.JLabel lbl_recipt;
    private javax.swing.JLabel lbl_reciver;
    private javax.swing.JLabel lblbankno;
    private javax.swing.JLabel lblcardno;
    private javax.swing.JLabel lblcheque;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblgstin;
    private javax.swing.JLabel lblgstin2;
    private javax.swing.JLabel modeupi;
    private javax.swing.JButton print;
    private javax.swing.JTextField toyear;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bank1;
    private javax.swing.JTextField txt_card;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque_no;
    private javax.swing.JTextField txt_course_name;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_dd_no;
    private javax.swing.JTextField txt_rNum;
    private javax.swing.JTextField txt_recipt;
    private javax.swing.JTextField txt_recvier_name1;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
