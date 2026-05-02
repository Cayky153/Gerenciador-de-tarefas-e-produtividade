package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity <ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String,String> errors= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(
				error ->
				errors.put(error.getField(), error.getDefaultMessage()));
		ErrorResponse errorResponse = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"Validation Error",
				errors.toString()
				);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex) {

	    ErrorResponse error = new ErrorResponse(
	            LocalDateTime.now(),
	            500,
	            "Runtime Error",
	            ex.getMessage()
	    );

	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body(error);
	}
	
}
