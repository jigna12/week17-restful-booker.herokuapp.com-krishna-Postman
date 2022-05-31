package com.herokuapp.herokuappinfo;

import com.herokuapp.model.TokenPojo;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateToken {
    String token;

    public String gettingToken() {
        TokenPojo tokenPojo = new TokenPojo();
        tokenPojo.setUsername("admin");
        tokenPojo.setPassword("password123");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(tokenPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        token = (response.path("token"));//4be6e0b29fb9f2a
        response.prettyPrint();
        return token;
    }//using this clas for put and patch
}
