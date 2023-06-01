
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l0l
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6525602612852953060L;
    // Declare Variables
    private int user_id;
    private String username;
    private String email;
    private String password;
    //private Expense expense;
    private List<Expense> expense = new ArrayList<>();
    
    // Contructor no-arg

    public User() {
    }

    public User(int user_id) {
        this.user_id = user_id;
    }
    
    // Constructor with arg

    public User(Integer user_id, String username, String email, String password) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Get and Setters

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public List<Expense> getExpense() {
        return expense;
    }

    public void setExpense(List<Expense> expense) {
        this.expense = expense;
    }
}
