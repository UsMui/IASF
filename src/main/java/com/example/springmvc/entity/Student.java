package com.example.springmvc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String tel;
    private String thumbnail;
    private Date birthday;


}
