package com.cloud.employeeservice.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloud.employeeservice.enity.Employee;
import com.cloud.employeeservice.feignClient.AddressClient;
import com.cloud.employeeservice.repo.EmployeeRepo;
import com.cloud.employeeservice.response.AddressResponse;
import com.cloud.employeeservice.response.EmployeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeService {

    // private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressClient addressClient;

    
    public ResponseEntity<List<EmployeeResponse>> getEmployees(){
        var employees = employeeRepo.findAll();
        var employeeList = Arrays.asList(modelMapper.map(employees,EmployeeResponse[].class));
        // System.out.println("employeList-> "+employeeList);

        // from address server
        var addressess = addressClient.getAddressess();
        // System.out.println("addressess-> "+ addressess);

        var addressMap = new HashMap<Integer,AddressResponse>();
        for( AddressResponse addRes : addressess.getBody()){
            addressMap.put(addRes.getId(), addRes);
        }

        for ( EmployeeResponse empRes : employeeList){
            if(addressMap.containsKey(empRes.getId())){
                empRes.setAddressResponse(addressMap.get(empRes.getId()));
            }
        }
        System.out.println("employeList-> "+employeeList);

        return ResponseEntity.ok().body(employeeList);
    }

    public ResponseEntity<EmployeeResponse> getEmployeeById(Integer id) {
        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        System.out.println("here->");
        AddressResponse addressResponse = addressClient.getAddressById(id).getBody();
        employeeResponse.setAddressResponse(addressResponse);
        return ResponseEntity.ok().body(employeeResponse);
    }

}
