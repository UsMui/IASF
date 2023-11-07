package com.example.springmvc.repository;

import com.example.springmvc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findCustomerById(Long id);
}
