package com.sdw.MXApplication;

import com.sdw.MXApplication.model.Address;
import com.sdw.MXApplication.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MxApplicationTestsTestRestTemplate {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void testGetEmployeeById() {

		//Arrange
		final String baseUrl = "http://localhost:"+ port + "/employee/1";
		var employee = Employee.builder().id(1)
				.email("smruti.digiworl@gmail.com")
				.phone(1234567890)
				.address(Address.builder()
						.city("Bhubaneswar")
						.country("India")
						.street("Sachivalaya Marg").build())
				.name("Smruti")
				.build();


		//Act
		var responseEntity = this.restTemplate.getForObject(baseUrl, Employee.class);

		//Assert
		assertThat(responseEntity).isEqualTo(employee);
	}

	@Test
	void testGetEmployee() {

		//Arrange
		final String baseUrl = "http://localhost:"+ port + "/employee";
		var employee = Employee.builder().id(1)
				.email("smruti.digiworl@gmail.com")
				.phone(1234567890)
				.address(Address.builder()
						.city("Bhubaneswar")
						.country("India")
						.street("Sachivalaya Marg").build())
				.name("Smruti")
				.build();


		//Act
		var responseEntity = this.restTemplate.getForObject(baseUrl, Employee[].class);
		var responseEmployee = Arrays.stream(responseEntity)
				.filter(x-> x.getId() == 1)
						.findFirst()
								.get();

		//Assert
		assertThat(responseEmployee).isEqualTo(employee);
	}

}
