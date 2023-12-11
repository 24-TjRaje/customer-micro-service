package com.trex.micro.Customers.service;

import java.util.List;

import com.trex.micro.Customers.entity.Customers;

public interface CustomerService {
    

    public Customers getCustomerById(Integer id);
    
    public List<Customers> getCustomers();

    public Customers saveCustomer(Customers customers);

    public Customers updateCustomer(Customers customers);

    public Integer deleteCustomer(Integer id);

    
}
