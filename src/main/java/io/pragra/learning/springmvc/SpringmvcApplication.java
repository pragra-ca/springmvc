package io.pragra.learning.springmvc;

import io.pragra.learning.springmvc.entity.Student;
import io.pragra.learning.springmvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.SystemProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;


@SpringBootApplication
@RequiredArgsConstructor
@EnableWebMvc

public class SpringmvcApplication {

    private final StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);

    }




}
