package com.streetwear.backend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String cedula){
        super("User not found with cedula: " + cedula);
    }
}