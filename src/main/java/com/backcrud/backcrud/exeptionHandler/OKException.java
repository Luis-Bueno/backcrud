package com.backcrud.backcrud.exeptionhandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OKException extends Exception{
    public OKException(String message){
        super(message);
    }
}
