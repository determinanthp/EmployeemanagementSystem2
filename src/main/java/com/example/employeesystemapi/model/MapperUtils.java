package com.example.employeesystemapi.model;

import com.example.employeesystemapi.entity.Employee;

public class MapperUtils {
    public static Employee toEmployee(EmployeeRequest employeeRequest){
        return Employee.builder()
                .id(employeeRequest.getId())
                .name(employeeRequest.getName())
                .department(employeeRequest.getDepartment())
                .salary(employeeRequest.getSalary())
                .build();
    }

    public static EmployeeResponse toEmployeeResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();
    }
}
