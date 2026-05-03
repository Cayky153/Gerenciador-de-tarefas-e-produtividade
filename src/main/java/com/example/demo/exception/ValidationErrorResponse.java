package com.example.demo.exception;

public class ValidationErrorResponse extends ErrorResponse {
    public ValidationErrorResponse(String message) {
        super(message);
    }

    protected int getStatus() { return 400; }
    protected String getTipoErro() { return "Validation Error"; }
}