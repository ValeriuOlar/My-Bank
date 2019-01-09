/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.resources;

import com.myBank.model.Account;
import com.myBank.model.Customer;
import com.myBank.services.CustomerService;
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
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    
    @POST
    public Customer postCustomer(Customer c){
        return customerService.createCustomer(c);
    }
    
    @POST
    @Path("/{customerId}/update/email/{email}")
    public Customer updateEmail(@PathParam("customerId") int id, @PathParam("email") String email){
        System.out.println("Updating Customer " + String.valueOf(1) +"'s email" );
        return customerService.setEmail(id, email);
    }
    
    // Retrieve customer by ID
    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id){
        System.out.println("Retrieving Customer " + String.valueOf(id));
        return customerService.getCustomer(id);
    }
    
    @GET
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    
    // Access Account Sub-Resource
    @Path("/{customerID}/accounts")
    public AccountResource getAcountsResource(){
        System.out.println("Getting accounts subresources...");
        return new AccountResource();
    }
    
    // Create an account through Sub-Resource Account
    @Path("/{customerID}/accounts/new")
    public AccountResource postAccount(){
        System.out.println("Posting accounts subresource...");
        return new AccountResource();
    }
    
    // Lodge(credit) specified account Id for specified customer Id
    // via Account sub resource
    @Path("/{customerID}/transactions")
    public TransactionResource customerTransactions(){
        System.out.println("Routing to transaction subresource...");
        return new TransactionResource();
    }
    
}
