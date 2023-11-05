package com.cloud.addressservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cloud.addressservice.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{
    
    @Query(nativeQuery = true,value = "SELECT ea.* from springcloud.address ea, springcloud.employee e where e.id = ea.id and ea.id=:employeeId")
    Address findAddressByEmployeeId(@Param("employeeId") Integer employeeId);
}
