package com.backcrud.backcrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.dto.UserDTO;
import com.backcrud.backcrud.dto.UserRequest;
import com.backcrud.backcrud.dto.UserResponse;
import com.backcrud.backcrud.entity.User;
import com.backcrud.backcrud.repository.UserRepository;
import com.backcrud.backcrud.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserDTO getById(int id) {
    //   return userRepository.findById(id);
        User user = userRepository.findById(id).orElse(null);

        if(user!=null){
            UserDTO userDTO = UserDTO.builder()
            .id(user.id)
            .username(user.username)
            .email(user.email)
            .build();
            return userDTO;
        }
        return null;
    }

    @Transactional 
    public UserResponse updateUser(UserRequest userRequest) {
       
        User user = User.builder()
        .id(userRequest.getId())
        .username(userRequest.getUsername())
        .email(userRequest.getEmail())
        .build();
        
        userRepository.updateUser(user.id, user.username, user.email);

        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    @Override
    public UserDTO getByEmail(String email) {
        // return userRepository.findByEmail(email);
        User user = userRepository.findByEmail(email).orElse(null);
        System.out.println(userRepository.findByEmail(email));
        System.out.println(email);
        if(user!=null){
            UserDTO userDTO = UserDTO.builder()
            .id(user.id)
            .username(user.username)
            .email(user.email)
            .build();
            return userDTO;
        }
        return null;
    }

}
