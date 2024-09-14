package com.mapping.jpamapping.controllers;

import com.mapping.jpamapping.entities.EmployeeEntity;
import com.mapping.jpamapping.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.createNewEmployee(employeeEntity);
    }

    @GetMapping(path = "/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable  Long id){
        return employeeService.getEmployeeById(id);
    }
}

