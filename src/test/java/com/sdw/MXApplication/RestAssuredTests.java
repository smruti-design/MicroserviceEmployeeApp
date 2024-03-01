package com.sdw.MXApplication;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

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
}
