package com.spring.chapter_2.IServices;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.spring.chapter_2.DataTransferObject.EmployeeDTO;
import com.spring.chapter_2.Repositories.EmployeeRepository;

import jakarta.validation.Valid;

public interface IEmployeeService {

	Optional<EmployeeDTO> getEmployeeById(Long Id);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO createNewEmployee(EmployeeDTO employeeDto);
	Optional<EmployeeDTO> updateEmployeeDetails(Long id, @Valid EmployeeDTO employeeDto);
	boolean deleteEmployeeById(Long id);
	EmployeeDTO updatePartialEmployeeById(Long id, Map<String, Object> updates);
	
}