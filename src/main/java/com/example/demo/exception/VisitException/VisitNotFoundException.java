package com.example.demo.exception.VisitException;

public class VisitNotFoundException extends RuntimeException {


    public VisitNotFoundException(Long id) {


        super("Could not find visit with "+id+" id.");


    }
}
