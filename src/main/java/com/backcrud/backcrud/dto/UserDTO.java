package com.backcrud.backcrud.dto;

import java.io.Serializable;

import com.backcrud.backcrud.entity.UserRol;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
    private int id;
    private String username;
    private UserRol rol;
}
