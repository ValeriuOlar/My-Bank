/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.services;

import com.myBank.model.Account;
import com.myBank.model.Customer;
import com.myBank.model.Transaction;
import com.myBank.model.TransactionType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valeriu Olariu x14103460
 */
public class TransactionService {
    
    // Initialise a static list to contain all transactions
    public static List<Transaction> list = new ArrayList<>();
    
    // Get all transactions
    public List<Transaction> getAllTransactions(){
        return list;
    }
   
    // Get all Transactions for a Customer
    public List<Transaction> getAllCustomerTransactions(int custId){
        
        if(list.isEmpty()){
            return list;
        } else {
        // Arraylist to store customers transactions
        List<Transaction> customerTransactions = new ArrayList<>();
        
        // Retrieving customer by customer Id
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomer(custId);
        
        // Creating a list to store retrieved customer's accounts
        List<Account> accounts = customer.getAccounts();
        
        // Iterating through all customer's accounts and 
        // retrieving transactions
        for(Account a: accounts){
            customerTransactions = a.getTransactions();
            
        }
        
        return customerTransactions;
        }
    }
    
    // Create a new transaction
    public Transaction processTransaction(int accId, Transaction transaction){
        // Retrieve account(s) using id
        AccountService accountservice = new AccountService();
        Account operatingAccount = accountservice.getAccount(accId);
        
        // Create global transaction for recipient
        Transaction recipientTransaction = new Transaction();
        
        // Guardcode to prevent recipient from being set if only one account exists
        Account recipientAccount = new Account();
        if((accountservice.getAllAccounts().size() > 1) && (transaction.getRecipientAccountId() != 0)){
            recipientAccount = accountservice.getAccount(transaction.getRecipientAccountId());

        }
        
        // Create operational variables
        float currBalance = operatingAccount.getBalance();
        float updatedBalance = 0.0f;
        float transAmount = 0.0f;
        
        // Unpack information from incoming transaction object
        TransactionType transType = transaction.getTransType();
        transAmount = transaction.getAmount();
        
        // Add operatingAccount Id from incoming Transaction
        transaction.setOperatingAccountId(accId);
        
        // Show current Balance on transaction before updating balance
        transaction.setCurrBalance(currBalance);
        

        // WORK AREA
        if(transType == TransactionType.CREDIT){
            updatedBalance = currBalance + transAmount;
            transaction.setUpdatedBalance(updatedBalance);
        } 
        else if ((transType == TransactionType.DEBIT) && (transAmount < currBalance)) {
            updatedBalance = currBalance - transAmount;
            transaction.setUpdatedBalance(updatedBalance);
        } 
        else if (transType == TransactionType.TRANSFER){
            if (transAmount < currBalance){
              // Set recipient transaction parameters

              recipientTransaction.setCurrBalance(recipientAccount.getBalance());
              recipientTransaction.setAmount(transAmount);
              recipientTransaction.setOperatingAccountId(accId);
              recipientTransaction.setRecipientAccountId(transaction.getRecipientAccountId());
              recipientTransaction.setTransType(transaction.getTransType());
              
              // Updating balance from operating account
              updatedBalance = currBalance - transAmount;
                            
              
              // Update recipients balance
              recipientAccount.setBalance(recipientAccount.getBalance() + transAmount);
              
              // Update recipient transaction parameters & add to recipient account
              recipientTransaction.setUpdatedBalance(recipientAccount.getBalance());
              recipientAccount.addTransaction(recipientTransaction);
              
              // Set operating transactions parameters
              transaction.setUpdatedBalance(updatedBalance);
              recipientTransaction.setId(list.size() + 1);
              list.add(recipientTransaction);
            } 
            
        }
        
      
        
        
        // Update account balance
        operatingAccount.setBalance(updatedBalance);
        
        
        // Transaction from incoming JSON object
        // via TransactionResource's POST annotated processTransaction method
        // added to retrieved account
        operatingAccount.addTransaction(transaction);
        
        
        
        // The transaction id is set by incrementing TransactionService's list size
        // and transaction is added to the list
        transaction.setId(list.size() + 1);

        
        list.add(transaction);
        
        // Logging information
        System.out.println("201 - resource created: /transactions/" + String.valueOf(transaction.getId()));
        return transaction;
    }
   
}
