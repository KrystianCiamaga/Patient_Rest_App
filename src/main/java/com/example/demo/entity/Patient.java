package com.example.demo.entity;

import com.example.demo.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Patient {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;

    private String last_name;

    private String pesel;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phone_number;

    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "patients_medicines",
    joinColumns = @JoinColumn(name = "patient_id"),inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicineList;


    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "patient")
    private Account account;



}
