/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mushfika
 */
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.util.Date;

public class IssueInfo extends javax.swing.JFrame {

    /**
     * Creates new form IssueInfo
     */
 Connection conn=null;
ResultSet rs = null;
PreparedStatement pst = null;

    public IssueInfo() {
        initComponents();
         conn=Connect.ConnectDB();
         create_table();
    }
    
    public void update_table()
    {
        try{
             String sql="select * from Issue where BookId LIKE ?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,text_search.getText());
            rs=pst.executeQuery();
            table_issue.setModel(DbUtils.resultSetToTableModel(rs));
            
            text_search.setText(null);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void create_table()
    {
        try{
        String sql="select * from issue ";
          pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        table_issue.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
public String  date_conversion(String Value4,String Value5)
{
    DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
    Date startDate;
    Date endDate;
     try {
        startDate = df.parse(Value4);
        endDate=df.parse(Value5);
        String newDateString = df.format(startDate);
        String newDateString1=df.format(endDate);
       
        if(startDate.before(endDate))
            return Integer.toString(0);
        else if(startDate.equals(endDate))
            return Integer.toString(0);
        else if(startDate.after(endDate))
            return Integer.toString(5);
            
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
}
     return null;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        text_search = new javax.swing.JTextField();
        button_search = new javax.swing.JButton();
        text_mem = new javax.swing.JTextField();
        text_book = new javax.swing.JTextField();
        text_issue = new javax.swing.JTextField();
        text_return = new javax.swing.JTextField();
        text_expiry = new javax.swing.JTextField();
        button_save = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_issue = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("SEARCH");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Member Id");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Isssue Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Book Id");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Return Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Expiry Date");

        button_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_search.setForeground(new java.awt.Color(204, 0, 153));
        button_search.setText("SEARCH");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        button_save.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_save.setForeground(new java.awt.Color(153, 0, 153));
        button_save.setText("SAVE");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_delete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_delete.setForeground(new java.awt.Color(153, 0, 153));
        button_delete.setText("DELETE");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_update.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        button_update.setForeground(new java.awt.Color(153, 0, 153));
        button_update.setText("UPDATE");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        table_issue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MemberId", "BookId", "IssueDate", "ReturnDate", "ExpiryDate", "Fine"
            }
        ));
        table_issue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_issueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_issue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(text_search, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_search))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(button_save))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addComponent(text_book, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(text_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(button_delete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(button_update))
                                            .addComponent(text_return, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                    .addComponent(text_issue, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_mem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(571, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_search))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(text_mem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_issue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_save)
                            .addComponent(button_delete)
                            .addComponent(button_update)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        
        try{
            String sql="Insert into Issue(MemberId,BookId,IssueDate,ReturnDate,ExpiryDate) values(?,?,?,?,?)";
            
            pst=conn.prepareStatement(sql);
            pst.setString(1,text_mem.getText());
              pst.setString(2,text_book.getText());
                pst.setString(3,text_issue.getText());
                  pst.setString(4,text_return.getText());
                    pst.setString(5,text_expiry.getText());
                    
                    pst.execute();
                    
                    text_mem.setText(null);
                    text_book.setText(null);
                    text_issue.setText(null);
                    text_return.setText(null);
                    text_expiry.setText(null);
            
                    JOptionPane.showMessageDialog(null,"Saved");
        }
        catch(Exception e)
        {
              text_mem.setText(null);
                    text_book.setText(null);
                    text_issue.setText(null);
                    text_return.setText(null);
                    text_expiry.setText(null);
            JOptionPane.showMessageDialog(null,e);
        }
        create_table();
    }//GEN-LAST:event_button_saveActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        String sql="Delete from Issue where MemberId=?";
        
        try{
            
            pst=conn.prepareStatement(sql);
            pst.setString(1,text_mem.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Deleted");
            
              text_mem.setText(null);
                    text_book.setText(null);
                    text_issue.setText(null);
                    text_return.setText(null);
                    text_expiry.setText(null);
        }
        catch(Exception e)
        {
              text_mem.setText(null);
                    text_book.setText(null);
                    text_issue.setText(null);
                    text_return.setText(null);
                    text_expiry.setText(null);
            JOptionPane.showMessageDialog(null,e);
        }
        create_table();
    }//GEN-LAST:event_button_deleteActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        
        
        try{
            
            String Value1=text_mem.getText();
            String Value2=text_book.getText();
            String Value3=text_issue.getText();
            String Value4=text_return.getText();
            String Value5=text_expiry.getText();
            
           
            String Value6=date_conversion(Value4,Value5);
            
            String sql="update Issue set Fine= ' "+Value6+" ' where MemberId=' "+Value1+" ' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Updated");
            
        }
        catch(Exception e)
        {
               text_mem.setText(null);
                    text_book.setText(null);
                    text_issue.setText(null);
                    text_return.setText(null);
                    text_expiry.setText(null);
            JOptionPane.showMessageDialog(null,e);
        }
        create_table();
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        
          try{
            
            String sql="select * from Issue where BookId=?";
               pst=conn.prepareStatement(sql);
              pst.setString(1,text_search.getText());
              rs=pst.executeQuery();
              
              if(rs.next())
              {
                /*   String add1=rs.getString("MemberId");
                text_member.setText(add1);
                 String add2=rs.getString("MemberName");
                text_name.setText(add2);
                String add3=rs.getString("Dept");
                text_dept.setText(add3);
                 String add4=rs.getString("ContactNo");
                text_con.setText(add4);*/
                update_table();
              }
              text_search.setText(null);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_button_searchActionPerformed

    private void table_issueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_issueMouseClicked
        
        try{
             int row = table_issue.getSelectedRow();
                 String Table_click=(table_issue.getModel().getValueAt(row,0).toString());
            String sql = "select * from Issue where MemberId=' "+Table_click+" ' ";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
           while(rs.next())
                {
                  String add1=rs.getString("MemberId");
                    text_mem.setText(add1);
                  String add2=rs.getString("BookId");
                  text_book.setText(add2);
                  String add3=rs.getString("IssueDate");
                  text_issue.setText(add3);
                  String add4=rs.getString("ReturnDate");
                  text_return.setText(add4);
                  String add5=rs.getString("ExpiryDate");
                  text_expiry.setText(add5);
              }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_table_issueMouseClicked

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
            java.util.logging.Logger.getLogger(IssueInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_save;
    private javax.swing.JButton button_search;
    private javax.swing.JButton button_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_issue;
    private javax.swing.JTextField text_book;
    private javax.swing.JTextField text_expiry;
    private javax.swing.JTextField text_issue;
    private javax.swing.JTextField text_mem;
    private javax.swing.JTextField text_return;
    private javax.swing.JTextField text_search;
    // End of variables declaration//GEN-END:variables
}
