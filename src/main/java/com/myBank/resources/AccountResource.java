/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.resources;

import com.myBank.model.Account;
import com.myBank.model.SortCode;
import com.myBank.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Valeriu Olariu x14103460
 */

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    // Create a new instance of AccountService
    private AccountService accountService = new AccountService();

    // Get all accounts
    @GET
    @Path("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    
    
    /* Get all accounts for a particular customer based on ID    
       Routed from Customer Resource */
    @GET
    public List<Account> getAccounts(@PathParam("customerID") int id){
        System.out.println("Getting all accounts for customer " + id);
        return accountService.getAllAccountsForCustomer(id);
    }

    
    // Get account balance
    @GET
    @Path("/{accountID}/balance")
    public Account getAccountBalance(@PathParam("accountID") int accId){
        return accountService.getAccountBalance(accId);
    }
    
    // Create a new account for a particular customer based on ID
    // Routed from Customer Resource
    @POST
    public Account createAccount(@PathParam("customerID") int id, Account account){
        System.out.println("Creating a new account for customer " + id);
        return accountService.createAccount(id, account);
    }
    
    // Update account's sorcode
    @POST
    @Path("/{accountID}/update/sortcode/{sortcode}")
    public Account updateSortCode(@PathParam("accountID") int id, @PathParam("sortcode") String sortcode){
        System.out.println("Updating Account " + String.valueOf(id) +"'s sortcode" );
        return accountService.updateSortCode(id, sortcode);
    }
      
    // Retrieve all transactions for a specified customer
    @Path("/{customerID}/transactions/all")
    public TransactionResource showCustomerTransactions(){
        System.out.println("Posting to transaction subresource...");
        return new TransactionResource();
    }
    
    // Create a transction for a customer
    @Path("{accountID}/transactions/")
    public TransactionResource startTransaction(){
        System.out.println("Posting to transaction subresource...");
        return new TransactionResource();
    }
    
}
