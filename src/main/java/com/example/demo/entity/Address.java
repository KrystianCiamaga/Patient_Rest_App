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

    @NonNull
    private String place;

    private String zipp_code;

    @NonNull
    private String house_number;

    @NonNull
    private String country;

    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
    private List<Patient> patient;






}
