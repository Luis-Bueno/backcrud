package com.backcrud.backcrud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backcrud.backcrud.security.validations.UserValidations;


@Configuration
public class ValidationsConfig {

@Bean
public UserValidations userValidations(){
    return new UserValidations();
}
    
}
