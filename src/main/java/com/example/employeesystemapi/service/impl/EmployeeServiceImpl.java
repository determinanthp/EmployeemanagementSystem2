package com.example.employeesystemapi.service.impl;

import com.example.employeesystemapi.entity.Employee;
import com.example.employeesystemapi.exception.CustomException;
import com.example.employeesystemapi.model.EmployeeRequest;
import com.example.employeesystemapi.model.EmployeeResponse;
import com.example.employeesystemapi.model.MapperUtils;
import com.example.employeesystemapi.repository.EmployeeRepo;
import com.example.employeesystemapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo){this.employeeRepo= employeeRepo; }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee= MapperUtils.toEmployee(employeeRequest);
        employee= employeeRepo.save(employee);
        return MapperUtils.toEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request, Long id) {
        Employee employee= employeeRepo.findById(id).orElseThrow(()->{throw new RuntimeException("employee:" + "id" + id);});
        if (request.getName() != null){
            employee.setName(request.getName());
            if (request.getDepartment() != null){
                employee.setDepartment(request.getDepartment());
            }
            employee= employeeRepo.save(employee);
        }
        return MapperUtils.toEmployeeResponse(employee);
    }


    @Override
    public boolean deleteById(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new CustomException("employee not found:" + HttpStatus.NOT_FOUND));
        employeeRepo.delete(employee);
        return true;
    }

    @Override
    public EmployeeResponse findById(Long id) {
        return MapperUtils.toEmployeeResponse(employeeRepo.findById(id).get());
    }

    @Override
    public List<EmployeeResponse> findAll() {
        return employeeRepo.findAll().stream().map(employee ->
             MapperUtils.toEmployeeResponse(employee)
        ).collect(Collectors.toList());
    }
}
