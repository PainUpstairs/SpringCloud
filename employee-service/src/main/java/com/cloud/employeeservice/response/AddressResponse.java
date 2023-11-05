package com.cloud.employeeservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressResponse {

    private Integer id;
    private String lane1;
    private String lane2;
    private String state;
    private String zip;
    private Integer employeeID;
}
