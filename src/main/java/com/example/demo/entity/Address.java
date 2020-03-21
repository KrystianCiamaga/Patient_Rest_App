package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
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

    @OneToMany
    private Set<Patient> patient;






}
