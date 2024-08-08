package com.backcrud.backcrud.service;

import org.springframework.stereotype.Service;

import com.backcrud.backcrud.dto.UserDTO;
import com.backcrud.backcrud.dto.UserRequest;
import com.backcrud.backcrud.dto.UserResponse;
import com.backcrud.backcrud.entity.User;

@Service
public interface UserService {
    public User saveOrUpdate(User user);
    public UserDTO getById(int id);
    public UserResponse updateUser(UserRequest userRequest);
}
