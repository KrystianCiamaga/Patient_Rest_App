package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.enums.Gender;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;


@Service
public class Demo implements CommandLineRunner {


    @Autowired
    private PasswordEncoder passwordEncoder;

    private AccountRepository accountRepository;

    private PatientRepository patientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public Demo(AccountRepository accountRepository, PatientRepository patientRepository, AddressRepository addressRepository, AuthorityRepository authorityRepository) {
        this.accountRepository = accountRepository;
        this.patientRepository = patientRepository;

    }

    @Override
    public void run(String... args) throws Exception {


        Visit visit=new Visit();
        visit.setDoctorsOfficeNumber(10);
        visit.setVisitDate(LocalDateTime.of(2002, Month.MARCH, 1, 1, 1));




        Patient patient=new Patient();

        patient.setEmail("adrian@o2.pl");
        patient.setFirst_name("Jarek");
        patient.setGender(Gender.Male);
        patient.setPesel("7537457");
        patient.setLast_name("Kowalski");
        patient.setPhone_number("63434734734");

        patient.setVisits(Collections.singletonList(visit));


        Address address=new Address();
        address.setZipp_code("27570");
        address.setHouse_number("20");
        address.setCountry("Poland");
        address.setPlace("Iwaniska");

        patient.setAddress(address);

        Account account=new Account();

        account.setPassword(passwordEncoder.encode("password"));
        account.setLogin("user");
        //account.setActive(true);


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

        Account account1=new Account();

        account1.setPassword(passwordEncoder.encode("password"));
        account1.setLogin("ola");
        account1.setActive(true);


        Patient patient1=new Patient();

        patient1.setEmail("wojon@o2.pl");
        patient1.setFirst_name("Ola");
        patient1.setGender(Gender.Female);
        patient1.setPesel("75323632");
        patient1.setLast_name("Kowalska");
        patient1.setPhone_number("63434734734");

        Authority authority1=new Authority();

        authority1.setAuthority("ROLE_USER");
        authority1.setAccount(account1);

        Set<Authority> secik2=new HashSet<>();
        secik2.add(authority1);

        account1.setAuthoritySet(secik2);

        //patient1.setMedicineList(lista);


        patient1.setAccount(account1);

        patient1.setAddress(address);

        account1.setPatient(patient1);

        //patientRepository.save(patient1);


        addressRepository.save(address);

        patientRepository.save(patient);
        patientRepository.save(patient1);


        accountRepository.save(account);
        accountRepository.save(account1);










    }
}
