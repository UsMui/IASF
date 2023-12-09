package com.example.springmvc.service.impl;

import com.example.springmvc.entity.Product;
import com.example.springmvc.repository.ProductRepository;
import com.example.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void saveProduct(Product product) {
        try{
            productRepository.save(product);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        try{
            productRepository.deleteById(id);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public Product findById(Long id) {
       Optional<Product> product = productRepository.findById(id);
       return product.orElse(null);
    }
}
