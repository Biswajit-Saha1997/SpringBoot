package com.SpringBootExceptionHandlingApplication.ExceptionHandling.Exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.SpringBootExceptionHandlingApplication.ExceptionHandling.Exception.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException ex) {

		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), 404, "Employee Not Found", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

//	    @ExceptionHandler(EmployeeAlreadyExistsException.class)
//	    public ResponseEntity<ErrorResponse> handleEmployeeAlreadyExists(
//	            EmployeeAlreadyExistsException ex) {
//
//	        ErrorResponse response = new ErrorResponse(
//	                LocalDateTime.now(),
//	                409,
//	                "Employee Already Exists",
//	                ex.getMessage()
//	        );
//
//	        return ResponseEntity
//	                .status(HttpStatus.CONFLICT)
//	                .body(response);
//	    }

//	    @ExceptionHandler(MethodArgumentNotValidException.class)
//	    public ResponseEntity<ErrorResponse> handleValidationException(
//	            MethodArgumentNotValidException ex) {
//
//	        String message = ex.getBindingResult()
//	                .getFieldErrors()
//	                .stream()
//	                .map(error ->
//	                        error.getField() + ": " +
//	                        error.getDefaultMessage())
//	                .collect(Collectors.joining(", "));
//
//	        ErrorResponse response = new ErrorResponse(
//	                LocalDateTime.now(),
//	                400,
//	                "Validation Failed",
//	                message
//	        );
//
//	        return ResponseEntity
//	                .badRequest()
//	                .body(response);
//	    }
//
//
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), 500, "Internal Server Error",
				"Something went wrong");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
//	
//	

}
