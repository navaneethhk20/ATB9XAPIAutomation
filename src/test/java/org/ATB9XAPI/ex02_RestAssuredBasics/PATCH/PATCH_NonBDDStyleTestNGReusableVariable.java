package org.ATB9XAPI.ex02_RestAssuredBasics.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PATCH_NonBDDStyleTestNGReusableVariable {
    RequestSpecification r;
    Response resp1;
    ValidatableResponse vr;

    @Description("Verifying the PUT request")
    @Test
    public void test_PATCH_NonBDDStyle() {
        String token = "58948d1024a0351";
        String bookingid = "398";

        String payloadPatch= "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Nithu\"\n" +
                "}";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);

        requestSpecification.body(payloadPatch).log().all();

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
    }
}