package com.chapter_5.third.party.rest.API.clients;

import com.chapter_5.third.party.rest.API.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployeeById(Long employeeId);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
}
