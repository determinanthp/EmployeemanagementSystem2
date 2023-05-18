package com.example.employeesystemapi.model;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class EmployeeRequest {

    @Id
    private Long id;
    private String name;
    private double salary;
    private String department;
    
}
