package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long SiNo;

    @Column(name="salesmanid")
    private Long SalesmanID;


    @Column(name="salesman_name")
    private String SalesmanName;

    @Column(name="dos")
    private Date DOS;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    @JsonIgnore
    private Product product;


}
