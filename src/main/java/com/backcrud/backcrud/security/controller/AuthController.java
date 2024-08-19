package com.backcrud.backcrud.security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.backcrud.backcrud.entity.User;
import com.backcrud.backcrud.security.dto.AuthCredentials;
import com.backcrud.backcrud.security.dto.Response;
import com.backcrud.backcrud.security.service.AuthService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200"})

public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    private ResponseEntity<Response> register(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity<HashMap<String, String>> login(@RequestBody AuthCredentials user) throws Exception {
        HashMap<String, String> login = authService.login(user);
        if (login.containsKey("jwt")) {
            return new ResponseEntity<>(login, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
        }
    }
    
    

}
