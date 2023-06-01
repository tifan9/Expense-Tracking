/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Category;
import service.CategoryService;

/**
 *
 * @author l0l
 */
public class CategoryView extends javax.swing.JFrame {
    DefaultTableModel tableModel = new DefaultTableModel();
    /**
     * Creates new form Category
     */
    public CategoryView() {
        initComponents();
        addCategoryColumnTable();
        addCategory();
    }
    // add table
    private void addCategoryColumnTable(){
        //tableModel.addColumn("ID");
        tableModel.addColumn("Category Name");
        categoryTable.setModel(tableModel);
    }
    // display data in table
    private void addCategory(){
        try {
            tableModel.setRowCount(0);
            Registry registry = LocateRegistry.getRegistry(6000);
            CategoryService catserv= (CategoryService)registry.lookup("category");
            List<Category> categoryList= catserv.retrieveAllCategory();
            if(categoryList != null){
                for(Category cat: categoryList){
                    tableModel.addRow(new Object[]{
                        //cat.getCategory_id(),
                        cat.getCategory_name()
                    });
                }
            }
//            Iterator iterator = categoryList.iterator();
//            while(iterator.hasNext()){
//                Category cat = (Category) iterator.next();
//                Object[] rowData = {cat.getCategory_id(), cat.getCategory_name()};
//                tableModel.addRow(rowData);
//                
//            }
//            categoryTable.setModel(tableModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        expense = new javax.swing.JButton();
        searchtxt = new javax.swing.JTextField();
        searchbtn2 = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CATEGORY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        jLabel2.setText("Category_Name");

        nametxt.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N

        addbtn.setBackground(new java.awt.Color(204, 204, 204));
        addbtn.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        addbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addbtn.setText("ADD");
        addbtn.setBorder(null);
        addbtn.setBorderPainted(false);
        addbtn.setFocusPainted(false);
        addbtn.setFocusable(false);
        addbtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addbtn.setPreferredSize(new java.awt.Dimension(10, 10));
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(categoryTable);

        expense.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        expense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-general-ledger-30.png"))); // NOI18N
        expense.setText("EXPENSES");
        expense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenseActionPerformed(evt);
            }
        });

        searchtxt.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N

        searchbtn2.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        searchbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        searchbtn2.setText("Search");
        searchbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtn2ActionPerformed(evt);
            }
        });

        deletebtn.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        deletebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin-2-icon.png"))); // NOI18N
        deletebtn.setText("DELETE");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(expense, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn2))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(expense)
                    .addComponent(deletebtn))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void expenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenseActionPerformed
        // TODO add your handling code here:
        try {
            ExpenseView expense= new ExpenseView();
            expense.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_expenseActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
        try {
            JButton accountbtn = new JButton("");
            accountbtn.setBorderPainted(false);
            if(nametxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter something","Empty Fields",JOptionPane.ERROR_MESSAGE);

            }else{
                //int id = Integer.parseInt(idtxt.getText());
                Category category= new Category();
                //category.setCategory_id(id);
                category.setCategory_name(nametxt.getText());
                Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
                CategoryService catserv= (CategoryService)registry.lookup("category");
                String response = catserv.registerCategory(category);
                JOptionPane.showMessageDialog(null, response,"Success",JOptionPane.INFORMATION_MESSAGE);
                //
                nametxt.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        addCategory();
    }//GEN-LAST:event_addbtnActionPerformed

    private void searchbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtn2ActionPerformed
        // TODO add your handling code here:
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
            CategoryService catserv= (CategoryService)registry.lookup("category");
            String name = searchtxt.getText();
            Category cat = new Category(name);
            Category ca = catserv.searchCategoryByName(cat);
            if(ca!=null){
                String categoryName = ca.getCategory_name();
                // validate case sensitive
            if (categoryName.equalsIgnoreCase(name)) {
                nametxt.setText(categoryName);
                nametxt.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Category not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Category not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchbtn2ActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        try {
            int del = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete?","delete",JOptionPane.YES_NO_OPTION);
            if(del==0){
                //int id = Integer.parseInt(idtxt.getText());
                Category category= new Category();
                //category.setCategory_id(id);
                category.setCategory_name(nametxt.getText());
                Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
                CategoryService catserv= (CategoryService)registry.lookup("category");
                String response = catserv.deleteCategory(category);
                JOptionPane.showMessageDialog(null, response,"Success",JOptionPane.INFORMATION_MESSAGE);
                nametxt.setText("");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }addCategory();
    }//GEN-LAST:event_deletebtnActionPerformed

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
            java.util.logging.Logger.getLogger(CategoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton expense;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JButton searchbtn2;
    private javax.swing.JTextField searchtxt;
    // End of variables declaration//GEN-END:variables
}
