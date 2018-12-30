/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Valeriu Olariu x14103460
 */
@XmlRootElement
public class Account {

    // PRIVATE FIELDS
    private int id;
    private int custId;
    private String accName;
    private SortCode sortCode;
    private float balance;
    
    private List<Transaction> transactions = new ArrayList<>();
    
    // CONSTRUCTORS
    public Account(){
        
    }
    
    public Account(int id, int custId, String accName, SortCode sortCode, float balance){
        this.id = id;
        this.custId = custId;
        this.accName = accName;
        this.sortCode = sortCode;
        this.balance = balance;
    }
    
    
    // PROPERTIES TO ACCESS FIELDS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public SortCode getSortCode() {
        return sortCode;
    }

    public void setSortCode(SortCode sortCode) {
        this.sortCode = sortCode;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public float getBalance() {
        return balance;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }    
  
}
