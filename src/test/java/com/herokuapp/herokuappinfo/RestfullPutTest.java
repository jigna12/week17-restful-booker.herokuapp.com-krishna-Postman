package com.herokuapp.herokuappinfo;


import com.herokuapp.model.RestfullPojo;
import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfullPutTest extends TestBase {

    @Test
    public void updateBookingWithPut() {

        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();

        Map<String, String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        RestfullPojo restFulPojo = new RestfullPojo();

        restFulPojo.setFirstname("Nema");
        restFulPojo.setLastname("Roy");
        restFulPojo.setTotalprice(501);
        restFulPojo.setDepositpaid(true);
        restFulPojo.setBookingdates(bookingdates);
        restFulPojo.setAdditionalneeds("Veggie Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token =" + token)
                .basePath("/booking")
                .pathParam("id", 2088)
                .body(restFulPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}

