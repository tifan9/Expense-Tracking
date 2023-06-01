
package view;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.Expense;
import model.User;
import service.CategoryService;
import service.ExpenseService;
import service.UserService;

/**
 *
 * @author l0l
 */
public class ExpenseView extends javax.swing.JFrame {
    DefaultTableModel tableModel = new DefaultTableModel();
    
    /**
     * Creates new form Expense
     */
    public ExpenseView() {
        initComponents();
        UserComboId();
        CategoryComboId();
//        addExpenseColumnTable();
//        addExpenseTable();
        table();
    }

    private void UserComboId(){
        try {
            useridCombo.removeAllItems();
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
            UserService service = (UserService)registry.lookup("user");
            List<User> userList = service.retrieveAllUser();
            if(userList != null){
                for(User user : userList){
                    useridCombo.addItem(user.getUser_id()+"-" +user.getUsername());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void CategoryComboId(){
        try {
            catidCombo.removeAllItems();
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
            CategoryService service = (CategoryService)registry.lookup("category");
            List<Category> categoryList = service.retrieveAllCategory();
            if(categoryList != null){
                for(Category category : categoryList){
                    catidCombo.addItem(category.getCategory_name());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void addExpenseColumnTable(){
        tableModel.addColumn("ID");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Description");
        tableModel.addColumn("StartedDate");
        tableModel.addColumn("Category");
        tableModel.addColumn("User");
        tbl_display.setModel(tableModel);
    }
    private void addExpenseTable(){
        try {
            tableModel.setRowCount(0);
            Registry registry = LocateRegistry.getRegistry(6000);
            ExpenseService service = (ExpenseService)registry.lookup("expense");
            CategoryService catserv= (CategoryService)registry.lookup("category");
            UserService userservice= (UserService)registry.lookup("user");
            List<Expense> expenseList = service.retrieveAllExpense();
            if(expenseList !=null){
                for(Expense exp: expenseList){
                    User id= new User();
                    int userId = id.getUser_id();
                    id=exp.getUser();
                    Category cat = new Category();
                    String catId = cat.getCategory_name();
                    cat=exp.getCategory();
                    
                    tableModel.addRow(new Object[]{
                        exp.getExpense_id(),
                        exp.getAmount(),
                        exp.getDescription(),
                        exp.getStarted_date(),
                        cat.getCategory_name(),
                        id.getUsername(),
                        //exp.getUser()
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void table(){
        try {
            Registry registry = LocateRegistry.getRegistry(6000);
            ExpenseService service = (ExpenseService)registry.lookup("expense");
            CategoryService catserv= (CategoryService)registry.lookup("category");
            UserService userservice= (UserService)registry.lookup("user");
            List<Expense> expenseList = service.retrieveAllExpense();
            int i=1000;
//            i=expenseList.getColumnCount();
            DefaultTableModel Df= (DefaultTableModel)tbl_display.getModel();
            Df.setRowCount(0);
            for(Expense exp: expenseList){
                User id= new User();
                    int userId = id.getUser_id();
                    //String userId = id.getUsername();
                    id=exp.getUser();
                    Category cat = new Category();
                    String catId = cat.getCategory_name();
                    //String catId = cat.getCategory_name();
                    cat=exp.getCategory();
                Vector v= new Vector();
                for(int j=1; j<=i; j++){
                    v.add(exp.getExpense_id());
                    v.add(exp.getAmount());
                    v.add(exp.getDescription());
                    v.add(exp.getStarted_date());
                    v.add(cat.getCategory_name());
                    v.add(id.getUser_id()+"-" +id.getUsername());
                }Df.addRow(v);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        amounttxt = new javax.swing.JTextField();
        useridCombo = new javax.swing.JComboBox<>();
        catidCombo = new javax.swing.JComboBox<>();
        registerbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        expno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_display = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desctxt = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        searchbtn1 = new javax.swing.JButton();
        searchbtn2 = new javax.swing.JButton();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EXPENSES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        jLabel2.setText("User_ID");

        jLabel3.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        jLabel3.setText("Category_ID");

        jLabel4.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        jLabel4.setText("Amount");

        amounttxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        useridCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        catidCombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        registerbtn.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        registerbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Actions-document-save-all-icon.png"))); // NOI18N
        registerbtn.setText("RECORD");
        registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbtnActionPerformed(evt);
            }
        });

        updatebtn.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        updatebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-update-30.png"))); // NOI18N
        updatebtn.setText("UPDATE");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
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

        expno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tbl_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Amount", "Description", "Started date", "Category", "Users"
            }
        ));
        tbl_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_displayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_display);

        jLabel6.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        jLabel6.setText("Description");

        desctxt.setColumns(20);
        desctxt.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        desctxt.setRows(5);
        jScrollPane2.setViewportView(desctxt);

        jButton5.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-category-24.png"))); // NOI18N
        jButton5.setText("CATEGORY");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century", 0, 16)); // NOI18N
        jLabel7.setText("Expense No");

        searchbtn1.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        searchbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-home-30.png"))); // NOI18N
        searchbtn1.setText("HOME");
        searchbtn1.setBorderPainted(false);
        searchbtn1.setFocusPainted(false);
        searchbtn1.setFocusable(false);
        searchbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtn1ActionPerformed(evt);
            }
        });

        searchbtn2.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        searchbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        searchbtn2.setText("DISPLAY");
        searchbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtn2ActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-print-30.png"))); // NOI18N
        print.setText("PRINT");
        print.setBorderPainted(false);
        print.setFocusPainted(false);
        print.setFocusable(false);
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(expno, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 357, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(catidCombo, 0, 181, Short.MAX_VALUE)
                                            .addComponent(useridCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(amounttxt))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton5)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(registerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(expno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchbtn1)
                            .addComponent(print))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(useridCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(catidCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(amounttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updatebtn)
                        .addGap(18, 18, 18)
                        .addComponent(deletebtn)
                        .addGap(18, 18, 18)
                        .addComponent(registerbtn)
                        .addGap(51, 51, 51)
                        .addComponent(searchbtn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            CategoryView category= new CategoryView();
            category.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void registerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbtnActionPerformed
        // TODO add your handling code here:
        try {
            if(expno.getText().trim().isEmpty() || amounttxt.getText().trim().isEmpty()|| desctxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required","Empty Fields",JOptionPane.ERROR_MESSAGE);
            }
            // 4th validation
            else if(amounttxt.getText().startsWith("-")){
                JOptionPane.showMessageDialog(null, "Amount should no be Negative","",JOptionPane.ERROR_MESSAGE);
                
            }
            // numeric validation
            else if (!amounttxt.getText().matches("\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a numeric value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                DefaultTableModel Df= (DefaultTableModel)tbl_display.getModel();
                int selectedIndex= tbl_display.getSelectedRow();
                Expense expense = new Expense();
                String userId= useridCombo.getSelectedItem().toString();
                String CatId= catidCombo.getSelectedItem().toString();
                double amount= Double.parseDouble(amounttxt.getText());
                int uid= Integer.parseInt(userId.substring(0,userId.indexOf("-")));
                //int cid = Integer.parseInt(CatId.substring(0,CatId.indexOf("-")));
                expense.setExpense_id(expno.getText());
                User usid= new User(uid);
                expense.setUser(usid);
                Category caid= new Category(CatId);
                expense.setCategory(caid);
                expense.setAmount(amount);
                expense.setDescription(desctxt.getText());
                expense.setStarted_date(new Date());
                Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
                ExpenseService service = (ExpenseService)registry.lookup("expense");
                String response = service.registerExpense(expense);
                JOptionPane.showMessageDialog(null, response,"Success",JOptionPane.INFORMATION_MESSAGE);
                expno.setText("");
                amounttxt.setText("");
                desctxt.setText("");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }table();
    }//GEN-LAST:event_registerbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
//      
        try {
                DefaultTableModel Df= (DefaultTableModel)tbl_display.getModel();
                int selectedIndex= tbl_display.getSelectedRow();
            Expense expense = new Expense();
                String userId= useridCombo.getSelectedItem().toString();
                String CatId= catidCombo.getSelectedItem().toString();
                double amount= Double.parseDouble(amounttxt.getText());
                int uid= Integer.parseInt(userId.substring(0,userId.indexOf("-")));
                //int cid = Integer.parseInt(CatId.substring(0,CatId.indexOf("-")));
                expense.setExpense_id(expno.getText());
                User usid= new User(uid);
                expense.setUser(usid);
                Category caid= new Category(CatId);
                expense.setCategory(caid);
                expense.setAmount(amount);
                expense.setDescription(desctxt.getText());
                expense.setStarted_date(new Date());
                Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
                ExpenseService service = (ExpenseService)registry.lookup("expense");
                String response = service.updateExpense(expense);
                JOptionPane.showMessageDialog(null, response,"Success",JOptionPane.INFORMATION_MESSAGE);
                expno.setText("");
                amounttxt.setText("");
                desctxt.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }table();
            
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        try {
                int del = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete?","delete",JOptionPane.YES_NO_OPTION);
                if(del==0){
                     DefaultTableModel Df= (DefaultTableModel)tbl_display.getModel();
                int selectedIndex= tbl_display.getSelectedRow();
            Expense expense = new Expense();
                String userId= useridCombo.getSelectedItem().toString();
                String CatId= catidCombo.getSelectedItem().toString();
                double amount= Double.parseDouble(amounttxt.getText());
                int uid= Integer.parseInt(userId.substring(0,userId.indexOf("-")));
                //int cid = Integer.parseInt(CatId.substring(0,CatId.indexOf("-")));
                expense.setExpense_id(expno.getText());
                User usid= new User(uid);
                expense.setUser(usid);
                Category caid= new Category(CatId);
                expense.setCategory(caid);
                expense.setAmount(amount);
                expense.setDescription(desctxt.getText());
                expense.setStarted_date(new Date());
                Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
                ExpenseService service = (ExpenseService)registry.lookup("expense");
                String response = service.deleteExpense(expense);
                JOptionPane.showMessageDialog(null, response,"Success",JOptionPane.INFORMATION_MESSAGE);
                expno.setText("");
                amounttxt.setText("");
                desctxt.setText("");
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }table();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void tbl_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_displayMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel Df= (DefaultTableModel)tbl_display.getModel();
            int selectedIndex = tbl_display.getSelectedRow();
            Registry registry = LocateRegistry.getRegistry(6000);
            CategoryService catserv= (CategoryService)registry.lookup("category");
            UserService userservice= (UserService)registry.lookup("user");
            ExpenseService service = (ExpenseService)registry.lookup("expense");
            List<Expense> expenseList = service.retrieveAllExpense();
//            catidCombo.setSelectedItem(Df.getValueAt(selectedIndex, 3).toString());
//            useridCombo.setSelectedItem(Df.getValueAt(selectedIndex, 4).toString());
            String userId= useridCombo.getSelectedItem().toString();
            String CatId= catidCombo.getSelectedItem().toString();
            int uid= Integer.parseInt(userId.substring(0,userId.indexOf("-")));
            //int cid = Integer.parseInt(CatId.substring(0,CatId.indexOf("-")));
            if (expenseList != null && selectedIndex >= 0 && selectedIndex < expenseList.size()) {
                Expense exp = expenseList.get(selectedIndex);
                User usid= new User(uid);
                exp.setUser(usid);
                Category caid= new Category(CatId);
                exp.setCategory(caid);
                useridCombo.setSelectedItem(uid);
                catidCombo.setSelectedItem(caid);
              }
            
            expno.setText( Df.getValueAt(selectedIndex, 0).toString());
            amounttxt.setText( Df.getValueAt(selectedIndex, 1).toString());
            desctxt.setText(Df.getValueAt(selectedIndex, 2).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_displayMouseClicked

    private void searchbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtn1ActionPerformed
        // TODO add your handling code here:
                try {
            View expense= new View();
            expense.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchbtn1ActionPerformed

    private void searchbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtn2ActionPerformed
        // TODO add your handling code here:
        try {
            SearchExpense expense= new SearchExpense();
            expense.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchbtn2ActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try {
            MessageFormat header = new MessageFormat("Expense Table");
            MessageFormat footer = new MessageFormat("0,number,interger");
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.PORTRAIT);
            tbl_display.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(null,"\n"+"Printed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amounttxt;
    private javax.swing.JComboBox<String> catidCombo;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextArea desctxt;
    private javax.swing.JTextField expno;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton print;
    private javax.swing.JButton registerbtn;
    private javax.swing.JButton searchbtn1;
    private javax.swing.JButton searchbtn2;
    private javax.swing.JTable tbl_display;
    private javax.swing.JButton updatebtn;
    private javax.swing.JComboBox<String> useridCombo;
    // End of variables declaration//GEN-END:variables
}
