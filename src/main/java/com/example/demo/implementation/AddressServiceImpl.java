package com.example.demo.implementation;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressRepository addressRepository;


    @Override
    @Transactional
    public Set<AddressDto> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(AddressMapper::mapAddressToAddressDto)
                .collect(Collectors.toSet());

    }

    @Override
    @Transactional
    public AddressDto findById(Long id) throws Exception {

        Optional<Address> address=addressRepository.findById(id);

        AddressDto addressDto=AddressMapper.mapAddressToAddressDto(address.get());

        return addressDto;
    }


    @Override
    @Transactional
    public AddressDto updateAddress(Long id, AddressDto locationDto) {

       Address address= addressRepository.getOne(id);

       Address newAddress = AddressMapper.mapAddressDtoToAddress(address,locationDto);
        addressRepository.save(newAddress);

        return locationDto;

    }





}
