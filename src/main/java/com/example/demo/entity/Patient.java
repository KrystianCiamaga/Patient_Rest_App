package com.example.demo.entity;

import com.example.demo.enums.Gender;
import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    private Address address;



}
