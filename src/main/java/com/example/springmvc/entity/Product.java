package com.example.springmvc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long ProdID;

    @Column(name="productname")
    private String ProdName;

    @Column(name="description")
    private String Description;

    @Column(name="dateofmanf")
    private Date DateOfManf;

    @Column(name="price")
    private Double Price;

    @OneToMany(mappedBy = "product")
    private List<Sale> sales;


}
