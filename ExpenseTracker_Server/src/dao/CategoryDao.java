
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Category;
import model.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author l0l
 */
public class CategoryDao {

    public CategoryDao() {
    }
    public String registerCategory(Category category){
        // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.save(category);
            tr.commit();
            // close session
            ss.close();
            return"Category Added Successfully";
    }
    public String updateCategory(Category category){
        // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.update(category);
            tr.commit();
            // close session
            ss.close();
            return"Category Updated Successfully";
    }
    public String deleteCategory(Category category){
        // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.delete(category);
            tr.commit();
            // close session
            ss.close();
            return"Category Deleted Successfully";
    }
    public List<Category> retrieveAllCategory(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Category> categoryList = ss.createQuery("select category from Category category").list();
            ss.close();
            return categoryList;
    }
//    public Category searchCategoryById(Category category){
//        try {
//            Session ss = HibernateUtil.getSessionFactory().openSession();
//            Category thecategory = (Category)ss.get(Category.class, category.getCategory_id());
//            
//                return thecategory;
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public Category searchCategoryByName(String category) throws SQLException {
//        try {
//        Session ss = HibernateUtil.getSessionFactory().openSession();
//        Query query = ss.createQuery("from Category where category_name = :name");
//        query.setParameter("name", category);
//        return (Category) query.uniqueResult();
//    } catch (Exception e) {
//        e.printStackTrace();
//        throw new SQLException("Error occurred while searching category by name.");
//    }
//        
//}
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

//    public Category searchCategoryByName(Category category) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    public Category searchCategoryByName(Category category) throws SQLException {
//        try {
//            Session ss = HibernateUtil.getSessionFactory().openSession();
//            Criteria criteria = ss.createCriteria(Category.class);
//            criteria.add(Restrictions.eq("category_name", category.getCategory_name()));
//            return (Category) criteria.uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SQLException("Error occurred while searching category by object.");
//        }
//    }
}
