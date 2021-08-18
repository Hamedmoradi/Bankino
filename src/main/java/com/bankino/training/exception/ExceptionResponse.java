package com.bankino.training.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

    private HttpStatus status;
    private String description;

    public ExceptionResponse() {
    }

    public ExceptionResponse(HttpStatus status, String description) {
        this.status = status;
        this.description = description;
    }

    public ExceptionResponse(String description) {
        this.description = description;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
