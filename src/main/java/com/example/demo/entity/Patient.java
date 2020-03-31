package com.example.demo.entity;

import com.example.demo.enums.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @NonNull
    private String first_name;

    @NonNull
    private String last_name;

    @NonNull
    private String pesel;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NonNull
    private String phone_number;

    @NonNull
    @Email
    private String email;

    @ManyToOne
    private Address address;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "patients_medicines",
    joinColumns = @JoinColumn(name = "patient_id"),inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicineList;


    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "patient")
    private Account account;



    public void addMedicine(Medicine medicine){

        medicineList.add(medicine);
    }

}
