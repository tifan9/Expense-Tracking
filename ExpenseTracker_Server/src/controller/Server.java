
package controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.Implementation.CategoryServiceImpl;
import service.Implementation.ExpenseServiceImpl;
import service.Implementation.UserServiceImpl;

/**
 *
 * @author l0l
 */
public class Server {
    public static void main(String[] args){
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            // create registry
            // specify which port you want to use
            Registry registry= LocateRegistry.createRegistry(6000);
            registry.rebind("user", new UserServiceImpl());
            registry.rebind("category", new CategoryServiceImpl());
            registry.rebind("expense", new ExpenseServiceImpl());
            System.out.println("Server is running on port 6000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
