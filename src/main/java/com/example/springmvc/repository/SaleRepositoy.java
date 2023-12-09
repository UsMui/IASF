package com.example.springmvc.repository;

import com.example.springmvc.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositoy extends JpaRepository<Sale,Long> {
}
