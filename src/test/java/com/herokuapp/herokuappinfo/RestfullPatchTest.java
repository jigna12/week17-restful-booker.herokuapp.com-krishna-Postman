package com.herokuapp.herokuappinfo;

import com.herokuapp.model.BookingPojo;
import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestfullPatchTest extends TestBase {

    @Test
    public void updateProductWithPatch(){
        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Tina");
        bookingPojo.setLastname("Shah");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token =" + token)
                .basePath("/booking")
                .pathParam("id", 2088)
                .body(bookingPojo)
                .when()
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    }

