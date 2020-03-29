package com.example.demo.exception;

import com.example.demo.entity.Patient;
import org.hibernate.annotations.NotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PatientNotFoundAdvice {


   @ResponseBody
    @ExceptionHandler(PatientNotFoundException.class)
    @NotFound
    public String patientNotFoundHandler(PatientNotFoundException ex){


        return ex.getMessage();

    }


}
