package com.demo.otlp.customer.dao;

import com.demo.otlp.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    public List<Customer> findByFirstNameContainingIgnoreCase(String name);
}
