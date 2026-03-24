package com.employee.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestExceptions extends RuntimeException {

    String massage;
    HttpStatus status;

    public BadRequestExceptions(String massage) {
        this.massage = massage;
        this.status = status.BAD_REQUEST;
    }

    public String getMassage() {
        return massage;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
