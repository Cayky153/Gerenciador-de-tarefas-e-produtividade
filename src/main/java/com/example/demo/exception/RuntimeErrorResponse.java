package com.example.demo.exception;

public class RuntimeErrorResponse extends ErrorResponse {
    public RuntimeErrorResponse(String message) {
        super(message);
    }

    protected int getStatus() { return 500; }
    protected String getTipoErro() { return "Runtime Error"; }
}
