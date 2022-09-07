package com.ficai4.backend.exceptions;

import com.ficai4.utils.ErrorMessages;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException() {
        super(ErrorMessages.ALUNO_NOT_FOUND);
    }
}
