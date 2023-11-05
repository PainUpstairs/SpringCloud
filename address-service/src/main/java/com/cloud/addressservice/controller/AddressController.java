package com.cloud.addressservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.addressservice.response.AddressResponse;
import com.cloud.addressservice.service.AddressService;

@RestController()
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addressess")
    public ResponseEntity<List<AddressResponse>> getAddressess() {
        return addressService.getAddressess();
    }

    @GetMapping(value = "/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") Integer employeeId){
        var address = "fsfs";
        System.out.println("employeeid->"+employeeId);
        return addressService.getAddressByEmpoyeeId(employeeId);
    }

}
