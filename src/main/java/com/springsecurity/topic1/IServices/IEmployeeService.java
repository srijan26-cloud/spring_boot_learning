package com.springsecurity.topic1.IServices;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;

import com.springsecurity.topic1.DataTransferObject.EmployeeDTO;
import com.springsecurity.topic1.Repositories.EmployeeRepository;

import jakarta.validation.Valid;

public interface IEmployeeService {

	EmployeeDTO getEmployeeById(Long Id);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO createNewEmployee(EmployeeDTO employeeDto);
	EmployeeDTO updateEmployeeDetails(Long id, @Valid EmployeeDTO employeeDto);
	boolean deleteEmployeeById(Long id);
	EmployeeDTO updatePartialEmployeeById(Long id, Map<String, Object> updates);
	
}