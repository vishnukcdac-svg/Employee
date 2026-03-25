package com.employee.exceptions;

import org.springframework.http.HttpStatus;

public class MissingParameterException extends RuntimeException{
   private String massage;
   private HttpStatus status;

    public MissingParameterException(String message) {
        this.massage = message;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public String getMassage() {
        return massage;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
