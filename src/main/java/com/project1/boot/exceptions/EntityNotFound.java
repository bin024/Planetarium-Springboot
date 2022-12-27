package com.project1.boot.exceptions;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String message){
        super(message);
    }
    
}