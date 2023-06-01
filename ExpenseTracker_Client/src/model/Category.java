
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author l0l
 */
public class Category implements Serializable{
    //private int category_id;
    private String category_name;
    private List<Expense> expense = new ArrayList<>();
    // constructor 

    public Category() {
    }
    // constroctor for id

    public Category(String category_name) {
        this.category_name = category_name;
    }

//    public Category(int category_id) {
//        this.category_id = category_id;
//    }
    // constructor with arg

    

   

    
    // get and setters

//    public int getCategory_id() {
//        return category_id;
//    }
//
//    public void setCategory_id(int category_id) {
//        this.category_id = category_id;
//    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Expense> getExpense() {
        return expense;
    }

    public void setExpense(List<Expense> expense) {
        this.expense = expense;
    }


    
}
