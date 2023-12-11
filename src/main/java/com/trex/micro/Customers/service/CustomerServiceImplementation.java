package com.trex.micro.Customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trex.micro.Customers.entity.Customers;
import com.trex.micro.Customers.exception.CustomerException;
import com.trex.micro.Customers.repository.CustomersRepository;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomersRepository cR;
    @Override
    public Customers getCustomerById(Integer id) {

        return cR.findById(id).orElseThrow( () -> new CustomerException("No customer found with id : " +id));

    }

    @Override
    public List<Customers> getCustomers() {
        return cR.findAll();
    }

    @Override
    public Customers saveCustomer(Customers customers) {
        return cR.save(customers);
    }

    @Override
    public Customers updateCustomer(Customers customers) {

         Boolean doesExist = cR.existsById(customers.getCustomerId());

         return doesExist ? cR.save(customers) : null;
    }

    @Override
    public Integer deleteCustomer(Integer id) {
        
        cR.deleteById(id);
        return id;
    }
    
}
