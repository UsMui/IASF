package com.example.springmvc.controller;

import com.example.springmvc.entity.Employee;
import com.example.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getFormCreate")
    public String getFormCreate(ModelMap modelMap){
        String view ="createEmployee";
        try{
            Employee employee = new Employee();
            modelMap.addAttribute("employee",employee);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;

    }
    @PostMapping("/createEmployee")
    public String saveOrUpdate(@ModelAttribute("employee") Employee employee, ModelMap modelMap){
        String view="allEmployee";
        try{
            if(employee.getWage()>=0 && employee.getName()!=null){
                employeeService.saveEmployee(employee);
            }

            List<Employee> employees = employeeService.findAllEmployees();
            modelMap.addAttribute("employees",employees);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @GetMapping("/getAll")
    public String getAll(ModelMap modelMap){
        String view="allEmployee";
        try{
            List<Employee> employees = employeeService.findAllEmployees();
            modelMap.addAttribute("employees",employees);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
}
