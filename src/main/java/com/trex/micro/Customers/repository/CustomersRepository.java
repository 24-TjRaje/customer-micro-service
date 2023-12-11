package com.trex.micro.Customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trex.micro.Customers.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    
}
