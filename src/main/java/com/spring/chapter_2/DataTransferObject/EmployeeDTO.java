package com.spring.chapter_2.DataTransferObject;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	private Long EmployeeId;
	
	private String EmployeeName;
	
	
	public Long getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(Long employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	
	

}

