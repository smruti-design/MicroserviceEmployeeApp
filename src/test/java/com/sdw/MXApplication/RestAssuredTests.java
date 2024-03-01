package com.sdw.MXApplication;

import com.sdw.MXApplication.model.Address;
import com.sdw.MXApplication.model.Employee;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAssuredTests {

    @LocalServerPort
    private int port;

    @Value("${base.url}")
    private String baseUrl;

    @Test
    public void testGetEmployeeByID(){
        given().
                baseUri(baseUrl)
                .port(port)
                .basePath("/employee/1")
                .get()
                .then()
                .assertThat().body("name", Matchers.equalTo("Smruti"));
    }

    @Test
    public void testGetEmployeeByID2(){
        //Arrange
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
        var response = given().
                baseUri(baseUrl)
                .port(port)
                .basePath("employee/1")
                .get();

        var responseEntity = response.body().as(Employee.class);

        //Assert
        assertThat(responseEntity).isEqualTo(employee) ;
    }
}
