/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Valeriu Olariu x14103460
 */

@XmlRootElement
public class Transaction {

    // PRIVATE FIELDS
    private int id;

    
    private int operatingAccountId;
    private int recipientAccountId;
    private String description;
    private TransactionType transType;
    private float currBalance;
    private float amount;
    private float updatedBalance;
    private Date date;

    // Constructors
    public Transaction(){
        
    }
    
    public Transaction(int id, TransactionType transType, float currBalance, String description){
        this.id = id;
        this.transType = transType;
        this.currBalance = currBalance;
        this.description = description;
        this.date = new Date();
  
    }
    
    // PUBLIC PROPERTIES
    public int getId() {    
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getTransType() {
        return transType;
    }

    public void setTransType(TransactionType transType) {
        this.transType = transType;
    }

    public float getCurrBalance() {
        return currBalance;
    }

    public void setCurrBalance(float currBalance) {
        this.currBalance = currBalance;
    }
    
    public float getAmount() {
        return amount;
    }

    public void setAmount(float transferAmount) {
        this.amount = transferAmount;
    }
    
    public float getUpdatedBalance() {
        return updatedBalance;
    }

    public void setUpdatedBalance(float updatedBalance) {
        this.updatedBalance = updatedBalance;
    }
    
    public int getOperatingAccountId() {
        return operatingAccountId;
    }

    public void setOperatingAccountId(int operatingAccountId) {
        this.operatingAccountId = operatingAccountId;
    }

    public int getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(int recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
