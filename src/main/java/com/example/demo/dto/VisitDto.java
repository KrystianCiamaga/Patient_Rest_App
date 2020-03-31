package com.example.demo.dto;

import com.example.demo.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {


    private int doctorsOfficeNumber;
    private LocalDate visitDate;




}
