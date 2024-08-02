package com.backcrud.backcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backcrud.backcrud.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    /* 
    @Autowired
    UserService userservice;
    */
    
    @PostMapping(value = "demo")
    public String welcome() {
        return "Protected Metodo";
    }
    
}
