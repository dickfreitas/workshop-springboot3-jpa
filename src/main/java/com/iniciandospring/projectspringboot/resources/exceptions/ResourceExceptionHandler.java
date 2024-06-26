package com.iniciandospring.projectspringboot.resources.exceptions;

import com.iniciandospring.projectspringboot.services.exceptions.DatabaseExceptions;
import com.iniciandospring.projectspringboot.services.exceptions.EntityNotFoundExceptions;
import com.iniciandospring.projectspringboot.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e , HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standard = new StandardError(Instant.now() , status.value() , error , e.getMessage() , request.getRequestURI());

        return ResponseEntity.status(status).body(standard);
    }


    @ExceptionHandler(DatabaseExceptions.class)
    public ResponseEntity<StandardError> database(DatabaseExceptions e , HttpServletRequest request){
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standard = new StandardError(Instant.now() , status.value() , error , e.getMessage() , request.getRequestURI());

        return ResponseEntity.status(status).body(standard);
    }

    @ExceptionHandler(EntityNotFoundExceptions.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundExceptions e , HttpServletRequest request){
        String error = "It is not possible to update this user";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standard = new StandardError(Instant.now() , status.value() , error , e.getMessage() , request.getRequestURI());

        return ResponseEntity.status(status).body(standard);
    }



}
