package com.example.springmvc.controller;

import com.example.springmvc.entity.Customer;
import com.example.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/getFormCreateCustomer")
    public String getFormCreate(ModelMap modelMap){
        String view ="createOrUpdateCustomerForm";
        try{
            Customer customer = new Customer();
            modelMap.addAttribute("customer",customer);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;

    }
    @PostMapping("/createOrUpdate")
    public String saveOrUpdate(@ModelAttribute("customer") Customer customer,ModelMap modelMap){
        String view="redirect:/customer/getAll";
        try{

                customerService.saveCustomer(customer);



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("customerupdate") Customer customerupdate,ModelMap modelMap){
        String view="redirect:/customer/getAll";
        try{

            customerService.saveCustomer(customerupdate);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @GetMapping("/getAll")
    public String getAll(ModelMap modelMap){
        String view = "listCustomer";
        try{
            List<Customer> customers = customerService.getAllCustomer();
            modelMap.addAttribute("customers",customers);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, ModelMap modelMap){
        String view = "listCustomer";
        try{
            customerService.deleteCustomer(id);
            List<Customer> customers = customerService.getAllCustomer();
            modelMap.addAttribute("customers",customers);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @GetMapping("/update")
    public String update(@RequestParam Long id, ModelMap modelMap){
        String view ="createOrUpdateCustomerForm";
        try{
            Customer customerupdate = customerService.findById(id);
            modelMap.addAttribute("customerupdate",customerupdate);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return view;
    }

}
