package com.spring.chapter_2.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.chapter_2.DataTransferObject.EmployeeDTO;
import com.spring.chapter_2.Entities.EmployeeEntity;
import com.spring.chapter_2.IServices.IEmployeeService;
import com.spring.chapter_2.Repositories.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;
	
	public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
//		System.out.println("EmployeeService init");
	}
	
	@Override
	public Optional<EmployeeDTO> getEmployeeById(Long Id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(Id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));    
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
//		employeeEntities.stream().forEach(EmployeeEntity::getEmployeeId);
		return employeeEntities
			   .stream()
			   .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
			   .collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO createNewEmployee(EmployeeDTO employeeDto) {
		// TODO Auto-generated method stub
		EmployeeEntity toSaveEmployeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
		EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEmployeeEntity);
		return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
	}

}