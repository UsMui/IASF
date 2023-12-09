package com.example.springmvc.controller;

import com.example.springmvc.entity.Product;
import com.example.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/getAllProduct")
    public String getAll(ModelMap modelMap){
        String view ="listProduct";
        try{
            List<Product> products = productService.getAllProduct();
            modelMap.addAttribute("products",products);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }


}
