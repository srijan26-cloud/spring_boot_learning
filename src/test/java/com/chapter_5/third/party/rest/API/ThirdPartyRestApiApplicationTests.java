package com.chapter_5.third.party.rest.API;

import com.chapter_5.third.party.rest.API.clients.Impl.EmployeeClientImpl;
import com.chapter_5.third.party.rest.API.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ThirdPartyRestApiApplicationTests {

	@Autowired
	private EmployeeClientImpl employeeClient;

	@Test
	void contextLoads() {
	}

	@Test
	@Order(3)
	void getEmployees() {
		List<EmployeeDTO> employeesList = employeeClient.getEmployees();
		System.out.println(employeesList);
		employeesList.stream().map(EmployeeDTO :: toString).forEach(System.out::println);
        }

	@Test
	@Order(2)
	void getEmployeeById() {
		EmployeeDTO employee = employeeClient.getEmployeeById(54L);
		System.out.println(employee);
	}

	@Test
	@Order(1)
	void createEmployee() {
		EmployeeDTO employeeDTO = new EmployeeDTO
				(null, "Mahajan" , "USER" , "srija@gam.com",3,
						LocalDate.of(2022,12,23),true, 234.43);
		EmployeeDTO employee = employeeClient.createEmployee(employeeDTO);
		System.out.println(employee);
	}
}
