package com.example.demo.controller;


import com.example.demo.dto.MedicineDto;
import com.example.demo.dto.PatientDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Patient;
import com.example.demo.exception.MedicineException.MedicineNoutFoundException;
import com.example.demo.mapper.MedicineMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;
    private PatientRepository patientRepository;
    private AccountRepository accountRepository;
    private MedicineRepository medicineRepository;

    public PatientController(PatientService patientService, PatientRepository patientRepository, AccountRepository accountRepository, MedicineRepository medicineRepository) {
        this.patientService = patientService;
        this.patientRepository = patientRepository;
        this.accountRepository = accountRepository;
        this.medicineRepository = medicineRepository;
    }

    @GetMapping
    public Set<PatientDto> findAll(){
        return patientService.findAll();
    }


    @GetMapping("/{id}")
    public PatientDto findById(@PathVariable Long id) throws Exception {

        return patientService.findById(id);
    }



    @PostMapping("/register")
    public Long addPatient(@RequestBody PatientDto patientDto,Principal principal){

        String userName = principal.getName();

        return patientService.addPatient(patientDto,userName);

    }


    @PostMapping("/medicines")
    public Long addMedicine(@RequestBody MedicineDto medicineDto,Principal principal)
    {
        Account account= accountRepository.findByLogin(principal.getName());

       Long newMedicineId = patientService.addMedicine(account.getPatient().getId(),medicineDto);

       return newMedicineId;

    }

    @GetMapping("/medicines")
    public List<MedicineDto> getMedicines(Principal principal){

        Account account=accountRepository.findByLogin(principal.getName());

        Optional<Patient> patient=patientRepository.findById(account.getPatient().getId());

        List<MedicineDto> medicineDtos=patient.get().getMedicineList()
                .stream()
                .map(MedicineMapper::mapMedicineToMedicineDto)
                .collect(Collectors.toList());

        if(medicineDtos.isEmpty())
            throw new MedicineNoutFoundException();

        return medicineDtos;
    }


    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){

         patientService.deleteById(id);
    }



    @PutMapping("/{id}")
    public PatientDto updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        return patientService.updatePatient(id, patientDto);
    }



}
