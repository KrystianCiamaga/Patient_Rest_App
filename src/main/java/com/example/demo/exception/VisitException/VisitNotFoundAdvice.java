package com.example.demo.exception.VisitException;

import com.example.demo.exception.PatientException.PatientNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class VisitNotFoundAdvice {




    @ResponseBody
    @ExceptionHandler(VisitNotFoundException.class)
    @NotFound
    public String visitNotFoundHandler(VisitNotFoundException ex){

        return ex.getMessage();

    }





}
