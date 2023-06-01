
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Category;

/**
 *
 * @author l0l
 */
public interface CategoryService extends Remote{
    String registerCategory(Category category) throws RemoteException;
    String updateCategory(Category category) throws RemoteException;
    String deleteCategory(Category category) throws RemoteException;
    List<Category> retrieveAllCategory() throws RemoteException;
    Category searchCategoryById(Category category) throws RemoteException;
    Category searchCategoryByName(Category category) throws RemoteException;
}
