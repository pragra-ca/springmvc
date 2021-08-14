package io.pragra.learning.springmvc.controller.rest;

import io.pragra.learning.springmvc.entity.ErrorMessage;
import io.pragra.learning.springmvc.entity.Student;
import io.pragra.learning.springmvc.service.StudentService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService service;

    @GetMapping("/student")
    public List<Student> getAllstudent(){
        return service.getAll();
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorMessage.class)),
                    description = "Student not found for the record"
            ),
            @ApiResponse(
                    responseCode = "200",content = @Content(schema = @Schema(implementation = Student.class))
            ),
            @ApiResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ErrorMessage.class)))
    }
    )
    @GetMapping(value = "/student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentbyId(@PathVariable("studentId") Long id ){
        Optional<Student> student = service.findById(id);
        if(student.isPresent()){
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.status(404).body(ErrorMessage.builder().errCode("APP404").desc("No Record Found for the id").timeOfError(new Date()));
    }
}
