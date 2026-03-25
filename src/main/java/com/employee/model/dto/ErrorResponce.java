package com.employee.model.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponce {
    private String massage;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ErrorResponce(String massage, HttpStatus status) {
        this.massage = massage;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
