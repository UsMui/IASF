package com.example.springmvc.service;

import com.example.springmvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
}
