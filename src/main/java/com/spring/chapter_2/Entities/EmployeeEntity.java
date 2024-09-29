package com.spring.chapter_2.Entities;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.chapter_2.Entities.EmployeeEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="industry_ready")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited //for hibernate envers
public class EmployeeEntity extends AuditableEntity{
	
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

	@PrePersist
	void beforeSave(){}

	@PreUpdate
	void beforeUpdate(){}

	@PreRemove
	void beforeRemove(){}

	@PostPersist
	void afterSave(){}

	@PostUpdate
	void afterUpdate(){}

	@PostRemove
	void afterRemove(){}
}
