package com.herokuapp.herokuappinfo;

import com.herokuapp.model.RestfullPojo;
import com.herokuapp.model.TokenPojo;
import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullPostTest extends TestBase {

    @Test
    public void createRestfullBooking() {
        Map<String, String> bookingdates = new HashMap<>();//creating map variable which is key and value
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        RestfullPojo restfullPojo = new RestfullPojo();
        restfullPojo.setFirstname("Nima");
        restfullPojo.setLastname("Roy");
        restfullPojo.setTotalprice(501);
        restfullPojo.setDepositpaid(true);
        restfullPojo.setBookingdates(bookingdates);
        restfullPojo.setAdditionalneeds("Deals");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(restfullPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    }

