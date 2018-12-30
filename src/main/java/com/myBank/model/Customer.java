package com.myBank.model;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Valeriu Olariu x14103460
 */
@XmlRootElement
public class Customer {
    
    
    // PRIVATE FIELDS
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    
    private List<Account> accounts = new ArrayList<>();


    // CONSTRUCTORS
    public Customer() {

    }

    public Customer(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // PROPERTIES TO ACCESS FIELDS
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
   
    public String getFirstName(){
        return this.firstName;
    }    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    


    public String getName() {
        return firstName + " " + lastName;
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public void addAccount(Account account){
        this.accounts.add(account);
    }

}
