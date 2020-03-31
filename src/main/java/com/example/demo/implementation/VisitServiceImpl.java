package com.example.demo.implementation;

import com.example.demo.dto.VisitDto;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Visit;
import com.example.demo.exception.PatientException.PatientNotFoundException;
import com.example.demo.exception.VisitException.VisitNotFoundException;
import com.example.demo.mapper.VisitMapper;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.VisitRepository;
import com.example.demo.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService {

    private VisitRepository visitRepository;
    private PatientRepository patientRepository;

    public VisitServiceImpl(VisitRepository visitRepository, PatientRepository patientRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public VisitDto findById(Long id) {

        Optional<Visit> visit = visitRepository.findById(id);
        VisitDto visitDto= VisitMapper.mapVisitToVisitDto(visit.orElseThrow(() ->new VisitNotFoundException(id)));
        return visitDto;
    }

    @Override
    public List<VisitDto> getAll() {

        List<VisitDto> visitDtos= visitRepository.findAll().stream()
                .map(VisitMapper::mapVisitToVisitDto)
                .collect(Collectors.toList());
        return visitDtos;
    }

    @Override
    public Long addVisit(String userName,VisitDto visitDto) throws PatientNotFoundException {

        Optional<Patient> patient=patientRepository.findByAccount_Login(userName);
        Visit visit = new Visit();
        VisitMapper.mapVisitDtoToVisit(visit,visitDto);
        patient.orElseThrow(() -> new PatientNotFoundException()).addVisit(visit);

        visitRepository.save(visit);
        return visit.getId();
    }

    @Override
    public VisitDto updateVisit(Long id, VisitDto visitDto) {
        return null;
    }
}
