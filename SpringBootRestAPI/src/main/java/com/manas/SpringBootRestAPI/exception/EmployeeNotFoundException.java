package com.manas.SpringBootRestAPI.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Employee not found");
    }
    private static final long serialVersionUID = 1L;
}
