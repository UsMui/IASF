package com.example.springmvc.service;



import com.example.springmvc.entity.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);
    List<Product> getAllProduct();
    void deleteProduct(Long id);
    Product findById(Long id);
}
