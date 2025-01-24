package org.ATB9XAPI.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Assertion_Hamcrest01 {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test01(){
        String payload = "{\n" +
                "    \"firstname\" : \"Nithu\",\n" +
                "    \"lastname\" : \"Hosur\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("booking.firstname", Matchers.equalTo("Nithu"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Hosur"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());

    }


}
