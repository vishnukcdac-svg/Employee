package com.employee.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundExceptions extends  RuntimeException {

    public String getMassage() {
        return massage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    String massage;
    private HttpStatus status;

    public ResourceNotFoundExceptions(String massage) {
        this.massage = massage;
        this.status = status.NOT_FOUND;
    }
}
