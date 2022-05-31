package com.herokuapp.model;

import javax.xml.ws.Response;

public class TokenPojo {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    String token;
//    public String createToken() {
//        TokenPojo tokenPojo = new TokenPojo();
//        tokenPojo.setUsername("admin");
//        tokenPojo.setPassword("password123");
//
//        Response response = given()
//                .header("Content-Type", "application/json")
//                .body(tokenPojo)
//                .when()
//                .post("/auth");
//        response.then().statusCode(200);
//        token = (response.path("token"));//4be6e0b29fb9f2a
//        response.prettyPrint();
//        return token;
    }


