package com.example.demo.controller;

import com.example.demo.dto.VisitDto;
import com.example.demo.email.MailService;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.VisitRepository;
import com.example.demo.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.security.Principal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visits")
@AllArgsConstructor
public class VisitController {


    private VisitService visitService;
    private VisitRepository visitRepository;
    private PatientRepository patientRepository;
    private MailService mailService;



    @GetMapping("/{id}")
    public VisitDto getById(@PathVariable Long id){

        return visitService.findById(id);

    }

    @GetMapping("/all")
    public List<VisitDto> getAll(){
        return visitService.getAll();

    }

    @PostMapping
    public Long addVisit(@RequestBody VisitDto visitDto, Principal principal) throws MessagingException {

        Long visitId =visitService.addVisit(principal.getName(),visitDto);


       String a= mailService.sendNewVisit(principal.getName(),visitDto);


        return visitId;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){

        visitRepository.deleteById(id);

    }




}
