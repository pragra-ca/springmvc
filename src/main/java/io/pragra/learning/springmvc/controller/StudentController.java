package io.pragra.learning.springmvc.controller;

import io.pragra.learning.springmvc.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/student")
    public String getAllStudent(Model model){
        model.addAttribute("students", service.getAll());
        return "student";
    }
}
