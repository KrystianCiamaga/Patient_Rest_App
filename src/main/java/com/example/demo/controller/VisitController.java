package com.example.demo.controller;

import com.example.demo.dto.VisitDto;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visits")
public class VisitController {


    private VisitService visitService;
    private PatientRepository patientRepository;

    public VisitController(VisitService visitService, PatientRepository patientRepository) {
        this.visitService = visitService;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/{id}")
    public VisitDto getById(@PathVariable Long id){

        return visitService.findById(id);

    }

    @GetMapping("/all")
    public List<VisitDto> getAll(){
        return visitService.getAll();

    }

    @PostMapping
    public Long addVisit(@RequestBody VisitDto visitDto, Principal principal){

        Long visitId =visitService.addVisit(principal.getName(),visitDto);
        return visitId;

    }




}
