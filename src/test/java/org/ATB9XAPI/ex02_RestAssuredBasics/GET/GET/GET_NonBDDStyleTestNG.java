package org.ATB9XAPI.ex02_RestAssuredBasics.GET.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GET_NonBDDStyleTestNG {
    @Test
    public void test_GET_NonBDDStyleTestNG_Negaive(){
        String pincode5 = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode5)
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }
    @Test
    public void test_GET_NonBDDStyleTestNG_Postive(){
        String pincode6 = "573129";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode6)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
