package com.example.login_backend.controllers;
import com.example.login_backend.entities.User;
import com.example.login_backend.repository.UserDetailsRepository;
import com.example.login_backend.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private CustomUserService customUserService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDetailsRepository.findAll();
    }
}
