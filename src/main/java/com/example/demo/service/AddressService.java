package com.example.demo.service;

import com.example.demo.dto.AddressDto;

import java.util.List;
import java.util.Set;

public interface AddressService {


    Set<AddressDto> findAll();

    AddressDto findById(Long id) throws Exception;

    AddressDto updateAddress(Long id, AddressDto locationDto);





}
