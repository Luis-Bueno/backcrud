package com.backcrud.backcrud.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backcrud.backcrud.entity.User;
import com.backcrud.backcrud.repository.UserRepository;
import com.backcrud.backcrud.security.dto.AuthCredentials;
import com.backcrud.backcrud.security.dto.Response;
import com.backcrud.backcrud.security.service.AuthService;
import com.backcrud.backcrud.security.service.JwtUtilityService;
import com.backcrud.backcrud.security.validations.UserValidations;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtilityService jwtUtilityService;
    @Autowired
    private UserValidations userValidations;

    public HashMap<String, String> login(AuthCredentials login) throws Exception {
        try {
            HashMap<String, String> jwt = new HashMap<>();
            Optional<User> user = userRepository.findByEmail(login.getEmail());

            if (user.isEmpty()) {
                jwt.put("error", "User Not Registered");
                return jwt;
            }

            if (verifyPassword(login.getPassword(), user.get().getPassword())) {
                jwt.put("jwt", jwtUtilityService.generateJWT(user.get().getId()));
            } else {
                jwt.put("error", "Authentication Failed");
            }
            return jwt;
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    public Response register(User user) throws Exception{
        try {
            Response response = userValidations.validate(user);

            if (response.getNumOfErrors() > 0 ){
                return response;
            }
            
            if (response.getNumOfErrors() == 0) {

            List<User> id=userRepository.findAll();
            System.out.println(id.size());

            for (int i=0; i == id.size(); i++){
                System.out.println(id.get(i));
                System.out.println(user);
                if (id.get(i).email == user.email){
                    response.setNumOfErrors(1);
                    response.setMessage("User Alredy Exist");
                    return response;
                }
            }


                System.out.println(id.size());
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
                user.setPassword(encoder.encode(user.getPassword()));
                userRepository.save(user);
                response.setMessage("User Registred Successfully");
                return response;
                
            }

            response.setMessage("User Cannot be Registred");
            return response;


        }catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }

}