package org.bpustaka.controller;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.port;
import static org.hamcrest.Matchers.equalTo;

import org.bpustaka.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@SqlGroup({
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value="classpath:testdata/mysql/before-member-test.sql"),
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value="classpath:testdata/mysql/after-member-test.sql")
})
public class MemberControllerTest {
	@Value("${local.server.port}")
    private Integer serverPort;
    
    @Before
    public void setUp(){
        port = serverPort;
    }
    
    @Test
    public void testGetMember(){
        System.out.println("Port : "+RestAssured.port);
        given()
            .log().all()
        .when()
            .get("/api/member")
        .then()
            .log().all()
            .statusCode(200)
            .body("content.find{it.username == 'azhar'}.fullname", equalTo("Azhar Khalid"));
    }
}
