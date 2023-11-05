package com.cloud.employeeservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeResponse {
    private Integer id;
    private String name;
    private String email;
    private String bloodgroup;
    public AddressResponse addressResponse;
}
