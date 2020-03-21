package com.example.demo.controller;


import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;



    @GetMapping
    public Set<PatientDto> findAll(){

        return patientService.findAll();
    }

    @GetMapping("{id}")
    public PatientDto findById(@PathVariable Long id) throws Exception {

        return patientService.findById(id);
    }


    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){

         patientService.deleteById(id);
    }



}
