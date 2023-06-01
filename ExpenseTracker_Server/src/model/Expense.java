
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author l0l
 */
@Entity
@Table(name="expense")
public class Expense implements Serializable{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String expense_id;
    private Double amount;
    //private Date date;
    private String description;
    private Date started_date;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="category_name")
    private Category category;
   
//    @OneToMany(mappedBy = "expense_id")
//    private List<Category> categories = new ArrayList<>();
    // constructors with no arg

    public Expense() {
    }
    // search by id category

    public Expense(Category category) {
        this.category = category;
    }

    public Expense(String expense_id) {
        this.expense_id = expense_id;
    }

    public Expense(String expense_id, Double amount, String description, Date started_date, User user, Category category) {
        this.expense_id = expense_id;
        this.amount = amount;
        this.description = description;
        this.started_date = started_date;
        this.user = user;
        this.category = category;
    }
    

    

    

    
    // get and setters

    public String getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(String expense_id) {
        this.expense_id = expense_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

  
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStarted_date() {
        return started_date;
    }

    public void setStarted_date(Date started_date) {
        this.started_date = started_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    
}
