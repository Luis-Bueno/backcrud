package com.backcrud.backcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.dto.UserDTO;
import com.backcrud.backcrud.dto.UserRequest;
import com.backcrud.backcrud.dto.UserResponse;
import com.backcrud.backcrud.entity.User;

@Service
public interface UserService {
    public UserDTO getById(int id);
    public UserResponse updateUser(UserRequest userRequest);
    public UserDTO getByEmail(String email);
    public List<User> getAllUsers();
}
