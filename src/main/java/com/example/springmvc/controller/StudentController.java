package com.example.springmvc.controller;

import com.example.springmvc.entity.Student;
import com.example.springmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/getAll")
    public String getAll(ModelMap modelMap){
        String view="allStudent";
        try{
            List<Student> students = studentService.getAllStudent();
            modelMap.addAttribute("students",students);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @GetMapping("/createStudent")
    public String getCreateStudent(ModelMap modelMap){
        String view="createStudent";
        try{
            Student student = new Student();
            modelMap.addAttribute("student",student);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @GetMapping("/studentdelete")
    public String deleteStudent(@RequestParam Long id, ModelMap modelMap){
        String view="allStudent";
        try{
            studentService.deleteStudent(id);
            List<Student> students = studentService.getAllStudent();
            modelMap.addAttribute("students",students);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @GetMapping("/studentupdate")
    public String getupdateStudent(@RequestParam Long id,ModelMap modelMap){
        String view = "createStudent";
        try{
            Student studentupdate = studentService.findById(id);
            modelMap.addAttribute("studentupdate",studentupdate);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }
    @PostMapping("/studentupdate")
    public String update(@ModelAttribute("studentupdate") Student studentupdate,ModelMap modelMap){
        String view = "allStudent";
        try{
            studentService.saveStudent(studentupdate);
            List<Student> students = studentService.getAllStudent();
            modelMap.addAttribute("students",students);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return view;
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student,

                              ModelMap modelMap) {
        String view = "allStudent";
        try {
//            if (thumbnailFile != null && !thumbnailFile.isEmpty()) {
//                String fileName = StringUtils.cleanPath(thumbnailFile.getOriginalFilename());
//                student.setThumbnail(fileName);
//
//                // Save the file to the server
//                String uploadDir = "C:\\Users\\MystUphng\\IdeaProjects\\springmvc\\src\\main\\resources\\upload";
//                Path uploadPath = Paths.get(uploadDir);
//
//                if (!Files.exists(uploadPath)) {
//                    Files.createDirectories(uploadPath);
//                }
//
//                try {
//                    Path filePath = uploadPath.resolve(fileName);
//                    Files.copy(thumbnailFile.getInputStream(), filePath);
//                } catch (IOException e) {
//                    throw new IOException("Could not save file: " + fileName, e);
//                }
//            }
            studentService.saveStudent(student);
            List<Student> students = studentService.getAllStudent();
            modelMap.addAttribute("students",students);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return view;
    }

}
