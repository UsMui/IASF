package com.example.springmvc.service.impl;

import com.example.springmvc.entity.Employee;
import com.example.springmvc.repository.EmployeeRepository;
import com.example.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void saveEmployee(Employee employee) {
        try{
            if(employee.getName()!=null && employee.getWage()>=0){
                employeeRepository.save(employee);
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
