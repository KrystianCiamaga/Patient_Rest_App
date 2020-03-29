package com.example.demo.implementation;


import com.example.demo.dto.MedicineDto;
import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Medicine;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.mapper.MedicineMapper;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PatientServiceImpl implements PatientService {



    private PatientRepository patientRepository;

    private AccountRepository accountRepository;

    private MedicineRepository medicineRepository;

    public PatientServiceImpl(PatientRepository patientRepository, AccountRepository accountRepository, MedicineRepository medicineRepository) {
        this.patientRepository = patientRepository;
        this.accountRepository = accountRepository;
        this.medicineRepository = medicineRepository;
    }

    @Override
    @Transactional
    public Set<PatientDto> findAll() {

        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::mapPatientToPatientDto)
                .collect(Collectors.toSet());

    }

    @Override
    @Transactional
    public PatientDto findById(Long id) throws Exception {

        Optional<Patient> patient = patientRepository.findById(id);

        return PatientMapper.mapPatientToPatientDto(patient.orElseThrow(() -> new PatientNotFoundException(id)));
    }


    @Override
    @Transactional
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        Patient patient = patientRepository.getOne(id);
        Patient newPatient = PatientMapper.mapPatientDtoToPatient(patient, patientDto);
        patientRepository.save(newPatient);
        return patientDto;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }


    @Override
    public Long addPatient(PatientDto patientDto, String username) {

        Account account=accountRepository.findByLogin(username);
        Patient patient = account.getPatient();
        Patient afterMapping = PatientMapper.mapPatientDtoToPatient(patient,patientDto);
        account.setPatient(afterMapping);
        Account newAccount= accountRepository.save(account);

        return newAccount.getPatient().getId();
    }

    @Override
    @Transactional
    public Long addMedicines(Long id, MedicineDto medicineDto) {

        Medicine newMedicine=new Medicine();
        Medicine medicine = MedicineMapper.mapMedicineDtoToMedicine(newMedicine,medicineDto);
        Optional<Patient> patient = patientRepository.findById(id);
        patient.orElseThrow(() ->new PatientNotFoundException(id)).addMedicine(medicine);
        medicineRepository.save(medicine);

        return medicine.getId();
    }
}