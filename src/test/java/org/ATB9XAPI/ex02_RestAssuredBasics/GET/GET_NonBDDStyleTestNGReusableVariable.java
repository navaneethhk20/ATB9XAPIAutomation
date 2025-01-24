package org.ATB9XAPI.ex02_RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_NonBDDStyleTestNGReusableVariable {
    RequestSpecification r;
    Response resp1;
    ValidatableResponse vr;
    @Description("Verifying the Negative test case with -1")
    @Test
    public void test_GET_NonBDDStyleTestNG_Negaive(){
        String pincode = "-1";
       r = RestAssured
               .given();
                r.baseUri("https://api.zippopotam.us");
                r.basePath("/IN/" + pincode);
              resp1 = r.when().log().all().get();
               vr = resp1.then()
                       .log().all()
                       .statusCode(404);
    }
    @Description("Verifying the Negative test case with - 000000")
    @Test
    public void test_GET_NonBDDStyleTestNG_Negaive2(){
        String pincode = "000000";
        r = RestAssured
                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        resp1 = r.when().log().all().get();
        vr = resp1.then()
                .log().all()
                .statusCode(404);
    }
    @Description("Verifying the Negative test case with - 78poki")
    @Test
    public void test_GET_NonBDDStyleTestNG_Negaive3(){
        String pincode = "78poki";
        r = RestAssured
                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        resp1 = r.when().log().all().get();
        vr = resp1.then()
                .log().all()
                .statusCode(404);
    }
    @Description("Verifying the Postive test case with - 573129")
    @Test
    public void test_GET_NonBDDStyleTestNG_Positive(){
        String pincode = "573129";
        r = RestAssured
                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        resp1 = r.when().log().all().get();
        vr = resp1.then()
                .log().all()
                .statusCode(200);
    }
}
