package com.backcrud.backcrud.exeptionhandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotFoundException extends Exception {

    public NotFoundException(String message){
        super(message);
    }
}