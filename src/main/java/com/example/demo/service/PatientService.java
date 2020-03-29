package com.example.demo.service;

import com.example.demo.dto.MedicineDto;
import com.example.demo.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface PatientService {


    Set<PatientDto> findAll();

    PatientDto findById(Long id) throws Exception;

    PatientDto updatePatient(Long id, PatientDto patientDto);

    void deleteById(Long id);

    Long addPatient(PatientDto patientDto, String username);

    Long addMedicines(Long id, MedicineDto medicineDto);

}
