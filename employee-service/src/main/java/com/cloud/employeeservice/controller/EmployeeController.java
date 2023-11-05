package com.cloud.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.employeeservice.enity.Employee;
import com.cloud.employeeservice.response.EmployeeResponse;
import com.cloud.employeeservice.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    // @Autowired 
    private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }   

    @GetMapping(value="/employees")
    public ResponseEntity<List<EmployeeResponse>> getEmploye() {
        return employeeService.getEmployees();
    }
    
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") Integer id){
        return this.employeeService.getEmployeeById(id);
    }
}
