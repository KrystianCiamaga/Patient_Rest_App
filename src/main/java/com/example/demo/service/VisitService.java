package com.example.demo.service;

import com.example.demo.dto.VisitDto;
import com.example.demo.entity.Visit;
import com.example.demo.exception.PatientException.PatientNotFoundException;

import java.util.List;

public interface VisitService {


    VisitDto findById(Long id);
    List<VisitDto> getAll();
    Long addVisit(String userName,VisitDto visitDto) throws PatientNotFoundException;
    VisitDto updateVisit(Long id,VisitDto visitDto) ;





}
