package com.backcrud.backcrud.exeptionhandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConflictException extends Exception{

    public ConflictException(String message){
        super(message);
    }

}
