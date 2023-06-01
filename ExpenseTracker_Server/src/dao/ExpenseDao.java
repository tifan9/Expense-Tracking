
package dao;

import java.util.List;
import model.Category;
import model.Expense;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author l0l
 */
public class ExpenseDao {

    public ExpenseDao() {
    }
    public String registerExpense(Expense expense){
        // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.save(expense);
            tr.commit();
            // close session
            ss.close();
            return"Expenses Added Successfully";
    }
    public String updateExpense(Expense expense){
        // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.update(expense);
            tr.commit();
            // close session
            ss.close();
            return"Expenses Update Successfully";
    }
    public String deleteExpense(Expense expense){
        // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.delete(expense);
            tr.commit();
            // close session
            ss.close();
            return"Expenses Deleted Successfully";
    }
        public List<Expense> retrieveAllExpense(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Expense> expenseList = ss.createQuery("select expense from Expense expense").list();
            ss.close();
            return expenseList;
    }
            public List<Category> retrieveAllCategory(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Category> categoryList = ss.createQuery("select category from Category category").list();
            ss.close();
            return categoryList;
    }
      public Expense searchExpenseById(Expense expense){
          try {
              Session ss = HibernateUtil.getSessionFactory().openSession();
              Expense thexpense = (Expense)ss.get(Expense.class, expense.getExpense_id());
              return thexpense;
          } catch (Exception e) {
              e.printStackTrace();
          }
          return null;
      }
//      public Category searchCategoryById(Category category){
//        try {
//            Session ss = HibernateUtil.getSessionFactory().openSession();
//            Category thecategory = (Category)ss.get(Category.class, category.getCategory_id());
//            
//                return thecategory;
//            
//        } catch (Exception e){ 
//            e.printStackTrace();
//        }
//        return null;
//    }
      public Category searchCategoryByName(Category category){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Category thecategory = (Category)ss.get(Category.class, category.getCategory_name());
            
                return thecategory;
            
        } catch (Exception e){ 
            e.printStackTrace();
        }
        return null;
    }
}
