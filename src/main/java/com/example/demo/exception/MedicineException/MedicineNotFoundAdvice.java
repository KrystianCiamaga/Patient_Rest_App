package com.example.demo.exception.MedicineException;


import com.example.demo.exception.PatientException.PatientNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MedicineNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(MedicineNoutFoundException.class)
    @NotFound
    public String patientNotFoundHandler(MedicineNoutFoundException ex){


        return ex.getMessage();

    }



}
