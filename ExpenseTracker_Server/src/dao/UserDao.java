
package dao;

import java.util.List;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author l0l
 */
public class UserDao {
// create constructor
    public UserDao() {
    }
    public String registerUser(User user){
        
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.save(user);
            tr.commit();
            // close session
            ss.close();
            return"User Registered Successfully";
    }
    // update
    public String updateUser(User user){
        
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.update(user);
            tr.commit();
            // close session
            ss.close();
            return"User Updated Successfully";
    }
    // delete
    public String deleteUser(User user){
        
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // create transaction
            Transaction tr = ss.beginTransaction();
            // perform operation
            ss.delete(user);
            tr.commit();
            // close session
            ss.close();
            return"User deleted Successfully";
    }
    // retrieve
    public List<User> retrieveAllUser(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<User> userList = ss.createQuery("select user from User user").list();
            ss.close();
            return userList;
    }
    
}
