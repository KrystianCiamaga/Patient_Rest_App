package com.example.demo.dto;

import com.example.demo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;


    @NotBlank
    private String pesel;

    @NotNull
    private Gender gender;


    @NotBlank
    private String email;


    @NotBlank
    private String phone_number;

}
