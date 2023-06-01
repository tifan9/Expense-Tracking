
package service.Implementation;

import dao.ExpenseDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Category;
import model.Expense;
import service.ExpenseService;

/**
 *
 * @author l0l
 */
public class ExpenseServiceImpl extends UnicastRemoteObject implements ExpenseService{

    public ExpenseServiceImpl() throws RemoteException{
        super();
    }
    private ExpenseDao dao= new ExpenseDao();
    @Override
    public String registerExpense(Expense expense) throws RemoteException {
        return dao.registerExpense(expense);
    }

    @Override
    public String updateExpense(Expense expense) throws RemoteException {
        return dao.updateExpense(expense);
    }

    @Override
    public String deleteExpense(Expense expense) throws RemoteException {
        return dao.deleteExpense(expense);
    }

    @Override
    public List<Expense> retrieveAllExpense() throws RemoteException {
        return dao.retrieveAllExpense();
    }

    @Override
    public List<Category> retrieveAllCategory() throws RemoteException {
        return dao.retrieveAllCategory();
    }

    @Override
    public Expense searchExpenseById(Expense expense) throws RemoteException {
        return dao.searchExpenseById(expense);
    }

//    @Override
//    public Category searchCategoryById(Category category) throws RemoteException {
//        return dao.searchCategoryById(category);
//    }

    @Override
    public Category searchCategoryByName(Category category) throws RemoteException {
        return dao.searchCategoryByName(category);
    }

    

    
}
