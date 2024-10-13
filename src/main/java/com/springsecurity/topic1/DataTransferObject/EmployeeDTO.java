package com.springsecurity.topic1.DataTransferObject;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.springsecurity.topic1.Annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
 
	private Long employeeId;
 
	@NotBlank(message = "Name of employee should not be blank")
    @Size(min = 3, max = 10, message = "Number of characters in name should be in the range: [3, 10]")
	private String employeeName;
 
	@EmployeeRoleValidation
	private String employeeRole;
	
	@NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be a valid email")
	private String employeeEmail;
	
	@NotNull(message = "Age of the employee cannot be blank")
    @Max(value = 80, message = "Age of Employee cannot be greater than 80")
    @Min(value = 18, message = "Age of Employee cannot be less than 18")
    private Integer employeeAge;
    
	@PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate employeeDateOfJoining;
    
	@AssertTrue(message = "Employee should be active")
    @JsonProperty("employeeIsActive")
    private Boolean employeeIsActive;
    
    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99" , message = "The salary can be less than or equal to 100000.99")
    @DecimalMin(value = "100.50", message = "The salary can be greater than or equal to 100.50")
    private Double employeeSalary;
 
}
	
