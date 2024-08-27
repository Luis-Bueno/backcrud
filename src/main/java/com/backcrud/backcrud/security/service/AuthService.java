package com.backcrud.backcrud.security.service;

import java.util.HashMap;

import com.backcrud.backcrud.entity.User;
import com.backcrud.backcrud.security.dto.AuthCredentials;
import com.backcrud.backcrud.security.dto.Response;



public interface AuthService {

    public HashMap<String, String> login(AuthCredentials login) throws Exception;
    public Response register(User user) throws Exception;

}
