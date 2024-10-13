package com.springsecurity.topic1.Entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springsecurity.topic1.Entities.EmployeeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employeeTable")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long employeeId;
	
	private String employeeName;
	
	private String employeeRole;
	
	private String employeeEmail;
	
    private Integer employeeAge;
    
    private LocalDate employeeDateOfJoining;
    
    @JsonProperty("employeeIsActive")
    private Boolean employeeIsActive;

    private Double employeeSalary;

}
