package com.SpringBootExceptionHandlingApplication.ExceptionHandling.Exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	 public EmployeeNotFoundException(String message) {
	        super(message);
	    }

}
