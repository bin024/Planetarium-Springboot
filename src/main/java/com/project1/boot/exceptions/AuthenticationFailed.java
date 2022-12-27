package com.project1.boot.exceptions;

public class AuthenticationFailed extends RuntimeException {
    public AuthenticationFailed(String message){
        super(message);
    }
}
