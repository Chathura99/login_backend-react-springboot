package com.example.login_backend.controllers;
import com.example.login_backend.entities.User;
import com.example.login_backend.repository.UserDetailsRepository;
import com.example.login_backend.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private CustomUserService customUserService;

    @GetMapping("/test")
    public String test(){
        return "Hello!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDetailsRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userDetailsRepository.findById(id);
    }
}
