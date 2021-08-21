package io.pragra.learning.springmvc.controller;

import io.pragra.learning.springmvc.entity.ErrorMessage;
import io.pragra.learning.springmvc.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handle404(RuntimeException ex){
        ErrorMessage message = ErrorMessage.builder().errCode("APP800").desc(ex.getMessage()).timeOfError(new Date()).build();
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleInternalServer(RuntimeException ex){
        ErrorMessage message = ErrorMessage.builder().errCode("APP404").desc(ex.getMessage()).timeOfError(new Date()).build();
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

}
