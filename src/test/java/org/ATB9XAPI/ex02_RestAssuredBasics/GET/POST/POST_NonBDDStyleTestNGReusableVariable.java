package org.ATB9XAPI.ex02_RestAssuredBasics.GET.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class POST_NonBDDStyleTestNGReusableVariable {
    RequestSpecification r;
    Response resp1;
    ValidatableResponse vr;
    @Description("Verifying the token generation")
    @Test
    public void test_POST_NonBDDStyle(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

               Response resp1 =   r.when().log().all().post();

               ValidatableResponse vr = resp1.then().log().all().statusCode(200);

    }

}
