
package com.trex.micro.Customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trex.micro.Customers.entity.Customers;
import com.trex.micro.Customers.exception.CustomerException;
import com.trex.micro.Customers.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService cS;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {

        return new ResponseEntity<List<Customers>>(cS.getCustomers(), HttpStatus.OK);
        
    }

     @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) {

        return new ResponseEntity<Customers>(cS.getCustomerById(id), HttpStatus.OK);
        
    }

     @PostMapping
    public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customer) {

        return new ResponseEntity<Customers>(cS.saveCustomer(customer), HttpStatus.CREATED);
        
    }

     @PutMapping
    public ResponseEntity<Customers> updateCustomers(@RequestBody Customers customer) {
        Customers response = cS.updateCustomer(customer);
        if (response==null) 
            throw new CustomerException(". Cannot update! No customer found with id : " +customer.getCustomerId());

        return new ResponseEntity<Customers>(cS.updateCustomer(customer), HttpStatus.OK);
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteCustomers(@PathVariable Integer id) {

        return new ResponseEntity<Integer>(cS.deleteCustomer(id), HttpStatus.OK);
        
    }

    
}