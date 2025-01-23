package org.ATB9XAPI.ex02_RestAssuredBasics.GET.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PUT_NonBDDStyleTestNGReusableVariable {
    RequestSpecification r;
    Response resp1;
    ValidatableResponse vr;

    @Description("Verifying the PUT request")
    @Test
    public void test_PUT_NonBDDStyle() {
        String token = "f55ca4353b9d8e1";
//        String token = "abc";
        String bookingid = "2542";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"8Jipm\",\n" +
                "    \"lastname\" : \"Brefrown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
    }
}