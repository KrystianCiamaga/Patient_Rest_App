package com.example.demo.dto;

import com.example.demo.entity.Visit;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VisitDto {


    private int doctorsOfficeNumber;
    private LocalDateTime visitDate;



    public String getInformations(){

        return "Doctors office number: "+doctorsOfficeNumber+"\n"+
                "Visit date: "+visitDate;

    }


}
