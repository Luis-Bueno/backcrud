package com.backcrud.backcrud.security.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthCredentials {

    private String email;
    private String password;

}
