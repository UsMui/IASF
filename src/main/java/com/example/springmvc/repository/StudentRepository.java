package com.example.springmvc.repository;

import com.example.springmvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    void deleteById(Long id);
    Student findStudentById(Long id);

    List<Student> findStudentByName(String name);
}
