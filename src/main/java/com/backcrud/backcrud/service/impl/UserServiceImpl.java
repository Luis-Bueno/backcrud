package com.backcrud.backcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.dto.UserDTO;
import com.backcrud.backcrud.dto.UserRequest;
import com.backcrud.backcrud.dto.UserResponse;
import com.backcrud.backcrud.entity.User;
import com.backcrud.backcrud.entity.UserRol;
import com.backcrud.backcrud.repository.UserRepository;
import com.backcrud.backcrud.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

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

    @Override
    public User saveOrUpdate(User user) {
       return userRepository.save(user);
    }

    @Transactional 
    public UserResponse updateUser(UserRequest userRequest) {
       
        User user = User.builder()
        .id(userRequest.getId())
        .username(userRequest.getUsername())
        .email(userRequest.getEmail())
        .rol(UserRol.USER)
        .build();
        
        userRepository.updateUser(user.id, user.username, user.email);

        return new UserResponse("El usuario se registró satisfactoriamente");
    }
}
