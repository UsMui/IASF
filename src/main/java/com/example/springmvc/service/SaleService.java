package com.example.springmvc.service;

import com.example.springmvc.entity.Sale;

import java.util.List;

public interface SaleService {
    void saveSale(Sale sale);
    List<Sale> getAllSale();

    void deleteSale(Long id);

    Sale findById(Long id);

}
