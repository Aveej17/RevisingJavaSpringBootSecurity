package org.example.LearningAuthentication.controller;

import org.example.LearningAuthentication.request.UserCreateRequest;
import org.example.LearningAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/signup")
    public ResponseEntity createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) throws Exception {
        userService.createUser(userCreateRequest);

        ResponseEntity entity =  new ResponseEntity("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/login")
    public void getUser(){
        System.out.println("you are reaching get user controller");
    }
}
