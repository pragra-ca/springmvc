package io.pragra.learning.springmvc;

import io.pragra.learning.springmvc.entity.Student;
import io.pragra.learning.springmvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@RequiredArgsConstructor
@EnableWebMvc

public class SpringmvcApplication {

    private final StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);
    }


    CommandLineRunner runner(){
        return args -> {
            service.createStudent(Student.builder().firstName("Akash").lastName("Mani").build());
            service.createStudent(Student.builder().firstName("Gaurav").lastName("Puri").build());
            service.createStudent(Student.builder().firstName("Rutika").lastName("").build());
        };
    }

}
