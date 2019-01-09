/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.resources;

import com.myBank.model.Account;
import com.myBank.model.Transaction;
import com.myBank.model.TransactionType;
import com.myBank.services.TransactionService;
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

@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    // Create a new instance of TransactionService
    private TransactionService transactionService = new TransactionService();
    
    // Type           : Sub-resource 
    // Parent Resource: CustomerResource
    // Function       : Create a lodgement(credit) to a specified account id based on
    //                  transfer type [DEBIT, CREDIT, TRANSFER]
    @POST
    public Transaction processTransaction(@PathParam("accountID") int accId, Transaction t){
        System.out.println("Processing Transaction");
        return transactionService.processTransaction(accId, t);

    }
    

    // Get all accounts
    @GET
    public List<Transaction> showCustomerTransactions(@PathParam("customerID") int custId){
        System.out.println("Retrieving all transactions for customerID " + String.valueOf(custId));
        return transactionService.getAllCustomerTransactions(custId);
    }
    
    @GET
    @Path("/all")
    public List<Transaction> showAllTransactions(){
        System.out.println("Retrieving all transactions...");
        return transactionService.getAllTransactions();
    }
    
}
