package com.example.demo.controller;


import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/addresses")
public class AddressControler {


    private AddressRepository addressRepository;
    private AddressService addressService;

    public AddressControler(AddressRepository addressRepository, AddressService addressService) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @GetMapping
    public Set<AddressDto> findAll(){

        return addressService.findAll();

    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable Long id) throws Exception {

        return addressService.findById(id);

    }

    @PutMapping("/{id}")
    public AddressDto updateAddress(@PathVariable Long id,@RequestBody AddressDto addressDto){

       return  addressService.updateAddress(id,addressDto);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){

        addressRepository.deleteById(id);

    }


}
