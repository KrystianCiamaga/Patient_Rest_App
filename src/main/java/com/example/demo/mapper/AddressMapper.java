package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.Address;

public class AddressMapper {


    public static AddressDto mapAddressToAddressDto(Address address){

        AddressDto addressDto=new AddressDto();


        addressDto.setCountry(address.getCountry());
        addressDto.setHouse_number(address.getHouse_number());
        addressDto.setPlace(address.getPlace());
        addressDto.setZipp_code(address.getZipp_code());
        return addressDto;

    }

    public static Address mapAddressDtoToAddress(Address address,AddressDto addressDto){

        address.setCountry(addressDto.getCountry());
        address.setHouse_number(addressDto.getHouse_number());
        address.setZipp_code(addressDto.getZipp_code());


        return address;


    }



}
