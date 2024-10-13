package com.springsecurity.topic1.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.topic1.DataTransferObject.EmployeeDTO;
import com.springsecurity.topic1.Services.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
		//System.out.println("EmployeeController init");
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
	{
		List<EmployeeDTO> getAllEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok(getAllEmployees);
	}
	
	@GetMapping(value = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) 
	{
		 EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
	     return ResponseEntity.ok(employeeDTO);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO employeeDto)
	{
		EmployeeDTO createdEmployee = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployeeDetails(@RequestBody @Valid EmployeeDTO employeeDto, @PathVariable(name = "employeeId") Long id)
	{
		EmployeeDTO updateEmployee = employeeService.updateEmployeeDetails(id,employeeDto);
		return new ResponseEntity<>(updateEmployee , HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{employeeId}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable(name = "employeeId") Long Id)
	{
		boolean gotDeleted = employeeService.deleteEmployeeById(Id);
		return ResponseEntity.ok(gotDeleted);
	}
	
	@PatchMapping(value = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@PathVariable(name = "employeeId" ) Long Id,@RequestBody Map<String,Object> updates)
	{
		EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(Id,updates);
		return ResponseEntity.ok(employeeDTO);
	}
}
