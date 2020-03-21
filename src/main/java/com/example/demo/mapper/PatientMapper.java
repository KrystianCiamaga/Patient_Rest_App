package com.example.demo.mapper;

import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Patient;

public class PatientMapper {

    public static Patient mapPatientDtoToPatient(Patient patient, PatientDto patientDto){

        patient.setFirst_name(patientDto.getFirstName());
        patient.setLast_name(patientDto.getLastName());
        patient.setPesel(patientDto.getPesel());
        patient.setGender(patientDto.getGender());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone_number(patientDto.getPhone_number());
        // patient.setAddress(patientDto.getAddress());


        return patient;
    }

    public static PatientDto mapPatientToPatientDto(Patient patient) {

        PatientDto patientDto = new PatientDto();

        if (patient.getId() != null) {

            patientDto.setFirstName(patient.getFirst_name());
            patientDto.setLastName(patient.getLast_name());
            patientDto.setPesel(patient.getPesel());
            patientDto.setGender(patient.getGender());
            patientDto.setEmail(patient.getEmail());
            patientDto.setPhone_number(patient.getPhone_number());
            // patientDto.setAddress(patient.getAddress());

        }
        return patientDto;
    }
}

