package com.example.employeesystemapi.controller;

import com.example.employeesystemapi.entity.Employee;
import com.example.employeesystemapi.model.EmployeeRequest;
import com.example.employeesystemapi.model.EmployeeResponse;
import com.example.employeesystemapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmpController {
    private final EmployeeService employeeService;

    public EmpController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        var employee = employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<EmployeeResponse>(employee, HttpStatus.CREATED);
    }

    @PostMapping("{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable ("id") long id, @RequestBody EmployeeRequest employeeRequest){
         return new ResponseEntity<EmployeeResponse> (employeeService.updateEmployee(employeeRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteEmployee(@PathVariable ("id") long id){
        employeeService.deleteById(id);
        return new ResponseEntity<String>("employee successfully deleted", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable ("id") long id){
        return new ResponseEntity<EmployeeResponse>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List> findALl(){
        return new ResponseEntity<List>(employeeService.findAll(), HttpStatus.OK);
    }
}
