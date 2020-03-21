package com.example.demo.implementation;


import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Patient;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepository patientRepository;


    @Override
    @Transactional
    public List<PatientDto> findAll() {
        List<Patient> allPatients = patientRepository.findAll();
        List<PatientDto> patientDtos = new ArrayList<>();
        allPatients.forEach(patient -> patientDtos.add(PatientMapper.mapPatientToPatientDto(patient)));

        return patientDtos;
}

    @Override
    @Transactional
    public PatientDto findById(Long id) throws Exception {

        Optional<Patient> patient=patientRepository.findById(id);

        return PatientMapper.mapPatientToPatientDto(patient.get());
    }


    @Override
    @Transactional
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById( Long id)
    {
        patientRepository.deleteById(id);
    }



    @Override
    public Long addPatient(PatientDto patientDto, String username) {
        return null;
    }
}