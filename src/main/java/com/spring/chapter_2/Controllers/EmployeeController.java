package com.spring.chapter_2.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.chapter_2.DataTransferObject.EmployeeDTO;
import com.spring.chapter_2.DataTransferObject.TestDTO;
import com.spring.chapter_2.Services.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
		//System.out.println("EmployeeController init");
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		//System.out.println("Method called");
		List<EmployeeDTO> getAllEmployees = employeeService.getAllEmployees();
		
		return ResponseEntity.ok(getAllEmployees);
	}
	
	@GetMapping("/getMyName")
	public TestDTO getMyName(){
		//System.out.println("Method called");
		return new TestDTO("Srijan");
	}
	
	@GetMapping(value = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){
		
		 Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
		 //System.out.println("getEmployeeID "+ employeeDTO.isPresent());
	        try {
//	        	System.out.println("Result:: "+employeeDTO
//				        .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
//				        .orElseThrow(() -> new Exception("Employee not found with id: "+id)));
				return employeeDTO
				        .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
				        .orElseThrow(() -> new Exception("Employee not found with id: "+id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO employeeDto){
		EmployeeDTO createdEmployee = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
}
