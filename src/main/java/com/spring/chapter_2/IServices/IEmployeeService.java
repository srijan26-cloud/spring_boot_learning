package com.spring.chapter_2.IServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.spring.chapter_2.DataTransferObject.EmployeeDTO;
import com.spring.chapter_2.Repositories.EmployeeRepository;

public interface IEmployeeService {

	Optional<EmployeeDTO> getEmployeeById(Long Id);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO createNewEmployee(EmployeeDTO employeeDto);
	
}