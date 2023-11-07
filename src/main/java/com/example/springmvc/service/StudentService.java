package com.example.springmvc.service;

import com.example.springmvc.entity.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> getAllStudent();

    void deleteStudent(Long id);
    Student findById(Long id);
    List<Student> findByName(String name);
}
