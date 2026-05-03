package com.example.demo.exception;

import java.time.LocalDateTime;

public abstract class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(String message) {
        this.timeStamp = LocalDateTime.now();
        this.status = getStatus();     
        this.error = getTipoErro();     
        this.message = message;
    }

    protected abstract int getStatus();     
    protected abstract String getTipoErro(); 
}

