package com.backcrud.backcrud.exeptionhandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InternalException extends Exception {
    public InternalException(String message){
        super(message);
    }
}
