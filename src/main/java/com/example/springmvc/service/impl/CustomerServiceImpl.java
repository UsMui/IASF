package com.example.springmvc.service.impl;

import com.example.springmvc.entity.Customer;
import com.example.springmvc.repository.CustomerRepository;
import com.example.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void saveCustomer(Customer customer) {
        try{
            customerRepository.save(customer);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }


}
