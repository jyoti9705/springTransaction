package com.example.springtransaction.vo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class SaveEmployeeRequestDTO {

    private String employeeName;
    private String employeeEmail;
    private String departmentName;
}
