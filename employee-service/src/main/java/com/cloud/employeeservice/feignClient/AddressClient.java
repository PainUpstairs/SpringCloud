package com.cloud.employeeservice.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloud.employeeservice.response.AddressResponse;

@FeignClient(name = "ADDRESS-SERVICE", path = "/address-app/api")
public interface AddressClient {
    @GetMapping(value = "/address/{id}")
    ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") Integer id);

    @GetMapping(value = "/addressess")
    ResponseEntity<List<AddressResponse>> getAddressess();
}
