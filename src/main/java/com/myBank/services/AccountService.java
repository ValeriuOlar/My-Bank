/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.services;

import com.myBank.model.Account;
import com.myBank.model.Customer;
import com.myBank.model.SortCode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valeriu Olariu x14103460
 */
public class AccountService {
    
    // Initialise a static list to contain all accounts
    public static List<Account> list = new ArrayList<>();
    
    // Method to return all accounts
    public List<Account> getAllAccounts() {
        return list;
    }    
    
    // Get account by id
    public Account getAccount(int id){
        return list.get(id - 1);
    }

    // Method to return all accounts for a Customer by Id
    public List<Account> getAllAccountsForCustomer(int id) {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomer(id);
        return customer.getAccounts();
    }
    
    // Get Customer's account balance
    public Account getAccountBalance(int accId){
        // Retrieve account by id
        AccountService accountService = new AccountService();
        Account account = accountService.getAccount(accId);
        
        /* Creating new Account instance and transferring information 
           balance amount to new Account */
        Account balanceAccount = new Account();
        balanceAccount.setBalance(account.getBalance());
        balanceAccount.setCustId(account.getCustId());
        balanceAccount.setId(account.getId());
                
        
        System.out.println("Getting CustomerID " + String.valueOf(account.getCustId()) + "'s account no." + String.valueOf(accId) + " balance:");
        return balanceAccount;
    }
    
    // Create a new account
    public Account createAccount(int id, Account account) {
        // Customer is retrieved using their id
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomer(id);
        
        // Account created from incoming JSON object 
        // via AccountResource's POST annotated createAccount method
        // Customer id set and added to retrieved Customer
        account.setCustId(id);
        customer.addAccount(account);
        
        // The account id is set by incrementing AccountService's list size
        // and account added to list
        account.setId(list.size() + 1);
        list.add(account);
             
        // Logging information
        System.out.println("201 - resource created: /customers/customerID" + String.valueOf(customer.getId()) + "/accounts/accountNo" + String.valueOf(account.getId()));
        return account;
        
    }
    
    // Update Customer' sortcode
    public Account updateSortCode(int id, String sortcode){
        // Retrieve associated account via Accountservice and account id
        AccountService accountService = new AccountService();
        Account account = accountService.getAccount(id);
                
        // Check incoming sortcode and set using enum values    
        if(sortcode.equals(SortCode.BOFIE10.toString())){
            account.setSortCode(SortCode.BOFIE10);
        } else if (sortcode.equals(SortCode.BOFIE11.toString())){
            account.setSortCode(SortCode.BOFIE11);
        } else if (sortcode.equals(SortCode.BOFIE12.toString())){
            account.setSortCode(SortCode.BOFIE12);
        } else if (sortcode.equals(SortCode.BOFIE14.toString())){
            account.setSortCode(SortCode.BOFIE14);
        }

        // Update the account' sortcode
        return account;
        
    }
    
}
