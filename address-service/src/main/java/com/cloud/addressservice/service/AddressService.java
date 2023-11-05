package com.cloud.addressservice.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloud.addressservice.entity.Address;
import com.cloud.addressservice.repo.AddressRepo;
import com.cloud.addressservice.response.AddressResponse;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<List<AddressResponse>> getAddressess(){
        var addresses = addressRepo.findAll();
        var addressList = Arrays.asList(modelMapper.map(addresses,AddressResponse[].class));
        return ResponseEntity.ok().body(addressList);
    }

    public ResponseEntity<AddressResponse> getAddressByEmpoyeeId(Integer employeeId){
        System.out.println("employeeId->"+employeeId);
        Address address = addressRepo.findAddressByEmployeeId(employeeId);
        System.out.println("addrres->"+address);
        System.out.println("addressResponse->"+modelMapper.map(address,AddressResponse.class).toString());
        return ResponseEntity.ok().body(modelMapper.map(address,AddressResponse.class));
    }
}
