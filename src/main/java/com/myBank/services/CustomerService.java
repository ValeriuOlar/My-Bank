/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myBank.services;

import com.myBank.model.Account;
import com.myBank.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valeriu Olariu x14103460
 */
public class CustomerService {
    
    // Initialise list to contain all customers
    public static List<Customer> list = new ArrayList<>();
    
    // Get all customers
    public List<Customer> getAllCustomers(){
        return list;
    }
    
    // Create a new customer
    public Customer createCustomer(Customer c){
        c.setId(list.size() + 1);
        list.add(c);
        
        System.out.println("201 - resource created: /customers/" + String.valueOf(c.getId()));
        return c;
    }
    
    // Get cutomer by id
    public Customer getCustomer(int id){
        return list.get(id - 1);
    }
    
    // Update Customer's email
    public Customer setEmail(int id, String email){
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.getCustomer(id);
        customer.setEmail(email);
        
        System.out.println("This is the email sent in " + email);
        return customer;
        
    }

    
}
