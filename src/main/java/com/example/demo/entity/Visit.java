package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {


    @Id
    @GeneratedValue
    private Long id;


    private int doctorsOfficeNumber;

    private LocalDate visitDate;

    @ManyToOne()
    private Patient patient;



}
