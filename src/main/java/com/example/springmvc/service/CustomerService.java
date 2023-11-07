package com.example.springmvc.service;

import com.example.springmvc.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    void deleteCustomer(Long id);
    Customer findById(Long id);
}
