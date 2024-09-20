package org.example.LearningAuthentication.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handle(Exception e){
        return new ResponseEntity<>(e.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserCreateException.class)
    public ResponseEntity<String> handleUserCreate(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
