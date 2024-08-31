package com.spring.chapter_2.DataTransferObject;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


 @AllArgsConstructor
 
 @NoArgsConstructor
 public class EmployeeDTO {
 
 private Long employeeId;
 
 private String employeeName;
 
 
 public Long getEmployeeId() { return employeeId; } 
 public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
 public String getEmployeeName() { return employeeName; } 
 public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
 
 
 
 }
	
