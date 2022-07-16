package com.example.login_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")

public class GuestController {
    @GetMapping("/vws-home")
    public String home(){
        return "Welcome to VWS!";
    }
}
