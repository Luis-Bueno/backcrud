package com.backcrud.backcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backcrud.backcrud.dto.UserDTO;
import com.backcrud.backcrud.dto.UserRequest;
import com.backcrud.backcrud.dto.UserResponse;
import com.backcrud.backcrud.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:4200"})
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") int id) {
        UserDTO userDTO = userService.getById(id);
        if (userDTO==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping()
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }
     
}
