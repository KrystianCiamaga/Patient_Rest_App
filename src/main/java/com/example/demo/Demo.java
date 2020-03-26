package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.enums.Gender;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class Demo implements CommandLineRunner {


    @Autowired
    private PasswordEncoder passwordEncoder;

    private AccountRepository accountRepository;

    private PatientRepository patientRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public Demo(AccountRepository accountRepository, PatientRepository patientRepository, AddressRepository addressRepository, AuthorityRepository authorityRepository) {
        this.accountRepository = accountRepository;
        this.patientRepository = patientRepository;

    }

    @Override
    public void run(String... args) throws Exception {


        Patient patient=new Patient();

        patient.setEmail("adrian@o2.pl");
        patient.setFirst_name("Jarek");
        patient.setGender(Gender.Male);
        patient.setPesel("7537457");
        patient.setLast_name("Kowalski");
        patient.setPhone_number("63434734734");


        Address address=new Address();
        address.setZipp_code("27570");
        address.setHouse_number("20");
        address.setCountry("Poland");
        address.setPlace("Iwaniska");

        patient.setAddress(address);

        Account account=new Account();

        account.setPassword(passwordEncoder.encode("password"));
        account.setLogin("user");
        account.setEnabled(true);


        Authority nowa=new Authority();
        nowa.setAuthority("ROLE_ADMIN");
        nowa.setAccount(account);


        Authority authority=new Authority();

        authority.setAuthority("ROLE_USER");
        authority.setAccount(account);

        Set<Authority> secik=new HashSet<>();
        secik.add(authority);
        secik.add(nowa);

        account.setAuthoritySet(secik);
        account.setPatient(patient);

        patient.setAccount(account);




        Medicine medicine1=new Medicine();
        medicine1.setDose(500);
        medicine1.setName("Amotax");

        Medicine medicine2=new Medicine();
        medicine2.setDose(200);
        medicine2.setName("Zinnat");

        List<Medicine> lista=new ArrayList<>();
        lista.add(medicine1);
        lista.add(medicine2);

        patient.setMedicineList(lista);


        patientRepository.save(patient);
        accountRepository.save(account);









    }
}
