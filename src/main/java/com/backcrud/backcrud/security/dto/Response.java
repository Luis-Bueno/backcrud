package com.backcrud.backcrud.security.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    
    private int numOfErrors;
    private String message;

}
