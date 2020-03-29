package com.example.demo.exception;

public class PatientNotFoundException extends RuntimeException {


    public PatientNotFoundException(long id) {

        super("Could not find patient with "+id+" id");

    }
}
