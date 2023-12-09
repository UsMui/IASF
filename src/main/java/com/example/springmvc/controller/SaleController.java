package com.example.springmvc.controller;

import com.example.springmvc.entity.Sale;
import com.example.springmvc.service.SaleService;
import com.example.springmvc.service.impl.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @GetMapping("/getAllSale")
    public String getAll(ModelMap modelMap){
        String view="listSale";
        try{
            List<Sale> sales = saleService.getAllSale();
            modelMap.addAttribute("sales",sales);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;

    }
}
