package com.springsecurity.topic1.Services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.springsecurity.topic1.DataTransferObject.EmployeeDTO;
import com.springsecurity.topic1.Entities.EmployeeEntity;
import com.springsecurity.topic1.Exceptions.ResourceNotFoundException;
import com.springsecurity.topic1.IServices.IEmployeeService;
import com.springsecurity.topic1.Repositories.EmployeeRepository;

import jakarta.validation.Valid;

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
	public EmployeeDTO getEmployeeById(Long Id) {
		// TODO Auto-generated method stub
		employeeExists(Id);
		//return employeeRepository.findById(Id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
		EmployeeEntity employeeEntity = employeeRepository.findById(Id).get();
		return modelMapper.map(employeeEntity, EmployeeDTO.class);
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
	public EmployeeDTO createNewEmployee(@Valid EmployeeDTO employeeDto) {
		// TODO Auto-generated method stub
		EmployeeEntity toSaveEmployeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
		EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEmployeeEntity);
		return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO updateEmployeeDetails(Long id, @Valid EmployeeDTO employeeDto) {
		// TODO Auto-generated method stub
		employeeExists(id);
		EmployeeEntity toUpdateEmployeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
		toUpdateEmployeeEntity.setEmployeeId(id);
		EmployeeEntity savedEmployeeEntity = employeeRepository.save(toUpdateEmployeeEntity);
		return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
	}

	@Override
	public boolean deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		employeeExists(id);
		employeeRepository.deleteById(id);
		return true;
	}

	@Override
	public EmployeeDTO updatePartialEmployeeById(Long id, Map<String, Object> updates) {
		// TODO Auto-generated method stub
		employeeExists(id);
		EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
		updates.forEach((field , value) -> {
			//field = Character.toTitleCase(field.charAt(0)) + field.substring(1);
			Field fieldToUpdate = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
			fieldToUpdate.setAccessible(true);
			ReflectionUtils.setField(fieldToUpdate, employeeEntity, value);
		});
		return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
	}
	
	private void employeeExists(Long Id) {
		boolean exists =  employeeRepository.existsById(Id);
		if(!exists) throw new ResourceNotFoundException("Employee not found with Id : "+ Id);
	}

}