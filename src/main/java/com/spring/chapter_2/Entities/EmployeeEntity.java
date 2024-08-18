package com.spring.chapter_2.Entities;

import java.util.Objects;

import com.spring.chapter_2.Entities.EmployeeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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

	@Override
	public int hashCode() {
		return Objects.hash(EmployeeId, EmployeeName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		return Objects.equals(EmployeeId, other.EmployeeId) && Objects.equals(EmployeeName, other.EmployeeName);
	}
	
}
