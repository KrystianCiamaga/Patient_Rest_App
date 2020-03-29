package com.example.demo.exception.MedicineException;

public class MedicineNoutFoundException extends RuntimeException {


    public MedicineNoutFoundException() {

        super("Cant find any medicines");

    }
}
