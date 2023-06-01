
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Category;
import model.Expense;

/**
 *
 * @author l0l
 */
public interface ExpenseService extends Remote{
    String registerExpense(Expense expense) throws RemoteException;
    String updateExpense(Expense expense) throws RemoteException;
    String deleteExpense(Expense expense) throws RemoteException;
    List<Expense> retrieveAllExpense() throws RemoteException;
    List<Category> retrieveAllCategory() throws RemoteException;
    Expense searchExpenseById(Expense expense) throws RemoteException;
    //Category searchCategoryById(Category category) throws RemoteException;
    Category searchCategoryByName(Category category) throws RemoteException;
}
