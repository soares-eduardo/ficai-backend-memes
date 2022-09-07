package com.ficai4.backend.exceptions;

public class BusinessException extends RuntimeException{
    
    public BusinessException(String message) {
        super(message);
    }
}