package com.ficai4.backend.exceptions;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException(String message) {
        super(message);
    }
}
