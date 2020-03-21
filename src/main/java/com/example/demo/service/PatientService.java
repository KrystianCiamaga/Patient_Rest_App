package com.example.demo.service;

import com.example.demo.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {


    List<PatientDto> findAll();

    PatientDto findById(Long id) throws Exception;


    PatientDto updatePatient(Long id, PatientDto patientDto);

    void deleteById(Long id);

    Long addPatient(PatientDto patientDto, String username);

}
