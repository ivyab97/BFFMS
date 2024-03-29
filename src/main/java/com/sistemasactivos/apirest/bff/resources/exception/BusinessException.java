package com.sistemasactivos.apirest.bff.resources.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class BusinessException extends RuntimeException{
    private HttpStatus httpStatus;
    
    public BusinessException(HttpStatus httpStatus, String message){
        super(message);
        this.httpStatus = httpStatus;
    }
}
