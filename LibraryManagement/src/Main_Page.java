

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Christian
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main_Page extends javax.swing.JFrame {
Connection conn;
ResultSet rs;
PreparedStatement pst;
private String bookID;
    /**
     * Creates new form Main_Page
     */
    public Main_Page() {
        initComponents();
        conn = Javaconnect.ConnecrDb();
        loadTable();
    }

    public void delete(){
        String ID = bookID;
        String sql = "DELETE FROM Book WHERE ID ='"+ID+"'";
        try{
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            rs.close();
            pst.close();
            JOptionPane.showMessageDialog(null, "Book Has Been Removed!");
        }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }        
    }

    public void search(){
        String searchKey = searchBar_tField.getText();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "title", "writer", "page"}, 0);
          
        String sql = "SELECT * FROM Book WHERE ID LIKE '"+searchKey+"' OR title LIKE LOWER('%" +searchKey+"%') OR TITLE LIKE UPPER('"+searchKey+"%') OR TITLE LIKE '%"+searchKey+"%'";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){           
                    String ID = rs.getString("ID");
                    String title = rs.getString("title");
                    String writer = rs.getString("writer");
                    int page = rs.getInt("page");
                    model.addRow(new Object[]{ID, title, writer, page});

            } 

            if(model.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "No matching books found.");
            }
            Table1.setModel(model);            
            rs.close();
            pst.close();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }       
    }
    
    private void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "title", "writer", "page"}, 0);
        try{
            String sql = "SELECT * FROM Book";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String ID = rs.getString("ID");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                int page = rs.getInt("page");
                model.addRow(new Object[]{ID, title, writer, page});
            }
            Table1.setModel(model);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        button_AddNewBook = new javax.swing.JButton();
        button_DeleteBook = new javax.swing.JButton();
        button_UpdateData = new javax.swing.JButton();
        button_Exit = new javax.swing.JButton();
        button_Logout = new javax.swing.JButton();
        searchBar_tField = new javax.swing.JTextField();
        button_search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book ID", "Title", "Writer", "Page"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("MAIN PAGE");

        button_AddNewBook.setText("ADD NEW BOOK");
        button_AddNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AddNewBookActionPerformed(evt);
            }
        });

        button_DeleteBook.setText("DELETE BOOK");
        button_DeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DeleteBookActionPerformed(evt);
            }
        });

        button_UpdateData.setText("UPDATE DATA");
        button_UpdateData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_UpdateDataActionPerformed(evt);
            }
        });

        button_Exit.setText("Exit");
        button_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ExitActionPerformed(evt);
            }
        });

        button_Logout.setText("Logout");
        button_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_LogoutActionPerformed(evt);
            }
        });

        button_search.setText("SEARCH BOOK");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar_tField, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(button_Logout, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(button_Exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(button_AddNewBook, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                            .addComponent(button_DeleteBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(button_UpdateData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(button_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar_tField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_search))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_DeleteBook)
                        .addGap(18, 18, 18)
                        .addComponent(button_UpdateData)
                        .addGap(18, 18, 18)
                        .addComponent(button_AddNewBook)
                        .addGap(186, 186, 186)
                        .addComponent(button_Logout)
                        .addGap(18, 18, 18)
                        .addComponent(button_Exit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button_ExitActionPerformed

    private void button_AddNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AddNewBookActionPerformed
        setVisible(false);
        NewBook_Page ob = new NewBook_Page();
        ob.setVisible(true);
    }//GEN-LAST:event_button_AddNewBookActionPerformed

    private void button_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_LogoutActionPerformed
        setVisible(false);
        Login_Page ob = new Login_Page();
        ob.setVisible(true);
    }//GEN-LAST:event_button_LogoutActionPerformed

    private void button_DeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DeleteBookActionPerformed
        delete();
        loadTable();
    }//GEN-LAST:event_button_DeleteBookActionPerformed

    private void button_UpdateDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_UpdateDataActionPerformed
        setVisible(false);
        Update_Page ob = new Update_Page(bookID);
        ob.setVisible(true);
    }//GEN-LAST:event_button_UpdateDataActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked

        int row = Table1.getSelectedRow();       
        bookID = Table1.getModel().getValueAt(row, 0).toString();
        System.out.println("" +bookID);
    }//GEN-LAST:event_Table1MouseClicked

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        String searchKey = searchBar_tField.getText();        
        if(searchKey.isEmpty()){
            loadTable();
        }
        else{
            search();           
        }

    }//GEN-LAST:event_button_searchActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton button_AddNewBook;
    private javax.swing.JButton button_DeleteBook;
    private javax.swing.JButton button_Exit;
    private javax.swing.JButton button_Logout;
    private javax.swing.JButton button_UpdateData;
    private javax.swing.JButton button_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchBar_tField;
    // End of variables declaration//GEN-END:variables
}
