package com.example.employeesystemapi.service;

import com.example.employeesystemapi.model.EmployeeRequest;
import com.example.employeesystemapi.model.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
     EmployeeResponse createEmployee(EmployeeRequest request);
     EmployeeResponse updateEmployee(EmployeeRequest request, Long id);
     boolean deleteById(Long id);
     EmployeeResponse findById(Long id);
     List<EmployeeResponse> findAll();
}
