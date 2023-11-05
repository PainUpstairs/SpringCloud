package com.cloud.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.employeeservice.enity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    
}
