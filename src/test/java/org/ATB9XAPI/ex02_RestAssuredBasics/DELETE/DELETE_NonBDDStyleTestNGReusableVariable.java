package org.ATB9XAPI.ex02_RestAssuredBasics.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DELETE_NonBDDStyleTestNGReusableVariable {
    RequestSpecification r;
    Response resp1;
    ValidatableResponse vr;

    @Description("Verifying the PUT request")
    @Test
    public void test_PATCH_NonBDDStyle() {
        String token = "e7d1eef5b2cb186";
        String bookingid = "2626";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.cookie("token",token);

        Response response = requestSpecification.when().delete();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(201);
    }
}