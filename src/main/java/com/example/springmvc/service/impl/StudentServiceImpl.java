package com.example.springmvc.service.impl;

import com.example.springmvc.entity.Student;
import com.example.springmvc.repository.StudentRepository;
import com.example.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void saveStudent(Student student) {
        try{
            studentRepository.save(student);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findStudentByName(name);
    }
}
