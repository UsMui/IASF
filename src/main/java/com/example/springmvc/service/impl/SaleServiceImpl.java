package com.example.springmvc.service.impl;

import com.example.springmvc.entity.Sale;
import com.example.springmvc.repository.SaleRepositoy;
import com.example.springmvc.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepositoy saleRepositoy;
    @Override
    public void saveSale(Sale sale) {
        try{
            saleRepositoy.save(sale);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Sale> getAllSale() {
        return saleRepositoy.findAll();
    }

    @Override
    public void deleteSale(Long id) {
        saleRepositoy.deleteById(id);

    }

    @Override
    public Sale findById(Long id) {
        Optional<Sale> sale = saleRepositoy.findById(id);
        return sale.orElse(null);
    }
}
