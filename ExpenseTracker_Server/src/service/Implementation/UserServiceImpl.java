
package service.Implementation;

import dao.UserDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.User;
import service.UserService;

/**
 *
 * @author l0l
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService{

    public UserServiceImpl() throws RemoteException{
        super();
    }
    private UserDao dao = new UserDao();
    @Override
    public String registerUser(User user) throws RemoteException {
        return dao.registerUser(user);
    }

    @Override
    public String updateUser(User user) throws RemoteException {
        return dao.updateUser(user);
    }

    @Override
    public String deleteUser(User user) throws RemoteException {
        return dao.deleteUser(user);
    }

    @Override
    public List<User> retrieveAllUser() throws RemoteException {
        return dao.retrieveAllUser();
    }
    
}
