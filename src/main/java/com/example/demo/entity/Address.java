package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String place;

    private String zipp_code;

    private String house_number;

    private String country;

    @OneToMany(mappedBy = "address")
    private List<Patient> patient;






}
