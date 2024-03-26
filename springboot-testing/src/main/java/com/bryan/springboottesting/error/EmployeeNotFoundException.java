package com.bryan.springboottesting.error;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
