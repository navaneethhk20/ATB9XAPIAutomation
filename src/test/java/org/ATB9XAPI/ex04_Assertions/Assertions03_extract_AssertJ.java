package org.ATB9XAPI.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class Assertions03_extract_AssertJ {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    //Extract the output and compare with expected value.
    @Test
    public void test(){
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

       bookingId = response.then().extract().path("bookingid");
       String firstname = response.then().extract().path("booking.firstname");
       String lastname = response.then().extract().path("booking.lastname");

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Nithu");
        Assert.assertEquals(lastname, "Hosur");

        //AssertJ
        assertThat(bookingId).isNotNull().isNotNegative().isNotZero();
        assertThat(firstname).isEqualTo("Nithu").isNotEmpty().isNotNull().isNotBlank();
        assertThat(lastname).isEqualTo("Hosur").isNotBlank().isNotNull().isNotEmpty();
    }
}
