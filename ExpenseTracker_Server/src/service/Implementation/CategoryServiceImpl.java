
package service.Implementation;

import dao.CategoryDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import service.CategoryService;

/**
 *
 * @author l0l
 */
public class CategoryServiceImpl extends UnicastRemoteObject implements CategoryService{

    public CategoryServiceImpl() throws RemoteException{
        super();
    }
    private CategoryDao dao= new CategoryDao();
    @Override
    public String registerCategory(Category category) throws RemoteException {
        return dao.registerCategory(category);
    }

    @Override
    public String updateCategory(Category category) throws RemoteException {
        return dao.updateCategory(category);
    }

    @Override
    public String deleteCategory(Category category) throws RemoteException {
        return dao.deleteCategory(category);
    }

    @Override
    public List<Category> retrieveAllCategory() throws RemoteException {
        return dao.retrieveAllCategory();
    }

//    @Override
//    public Category searchCategoryById(Category category) throws RemoteException {
//        return dao.searchCategoryById(category);
//        
//    }

//    @Override
//    public Category searchCategoryByName(Category category) throws RemoteException {
//        try {
//            return dao.searchCategoryByName(category);
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    @Override
    public Category searchCategoryByName(Category category) throws RemoteException {
        return dao.searchCategoryByName(category);
    }

    

    
}
