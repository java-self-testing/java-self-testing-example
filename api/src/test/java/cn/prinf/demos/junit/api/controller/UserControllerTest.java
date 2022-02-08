package cn.prinf.demos.junit.api.controller;

import cn.prinf.demos.junit.api.TestBase;
import org.apache.groovy.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;

class UserControllerTest extends TestBase {

    @Test
    void should_list_all_users() {
        given()
                .contentType("application/json")
                .when()
                .get("/users")
                .then().statusCode(200)
                .body("$.size()", is(2))
                .body("name", hasItem("admin"));
    }

    @Test
    void should_add_user() {
        given()
                .contentType("application/json")
                .body(Maps.of(
                        "name", "test-user",
                        "email", "test@email.com",
                        "password", "123456"
                ))
                .when()
                .post("/users")
                .then().statusCode(201);
    }

    @Test
    void extract_response_example() {
       String body =  given()
                .contentType("application/json")
                .when()
                .get("/users").getBody().print();

        Assertions.assertEquals("[{\"id\":\"admin-id\",\"name\":\"admin\",\"role\":\"ADMIN\",\"email\":\"admin@test.com\",\"password\":\"$2a$10$Q9xt3B2Ixe0tGnbCjVWAbunD4lYdf5PpMSYGyLNrD4S38FGUt4NMC\",\"createdAt\":\"2020-12-16T21:45:41.147Z\",\"updatedAt\":\"2020-12-16T21:45:41.147Z\"}]", body);
    }
}
