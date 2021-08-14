package io.pragra.learning.springmvc.controller;

import io.pragra.learning.springmvc.entity.Student;
import io.pragra.learning.springmvc.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/student")
    public String getAllStudent(Model model){
        model.addAttribute("students", service.getAll());
        return "student";
    }

    @PostMapping("/student")
    public String createStudent(@ModelAttribute("student") Student student, Model model){
        service.createStudent(student);
        model.addAttribute("students", service.getAll());
        return "student";
    }


    @GetMapping("/addstudent")
    public String getAllStudentS(Model model){
        model.addAttribute("student", new Student());
        return "addstudent";
    }
}
