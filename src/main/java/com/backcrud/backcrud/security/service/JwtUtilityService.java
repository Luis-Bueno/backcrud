package com.backcrud.backcrud.security.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

public interface JwtUtilityService {

    public String generateJWT(Integer userId) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, JOSEException;
    public JWTClaimsSet parseJWT(String jwt) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, ParseException, JOSEException;

}
