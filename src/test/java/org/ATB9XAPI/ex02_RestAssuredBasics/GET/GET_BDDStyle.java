package org.ATB9XAPI.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;

public class GET_BDDStyle {
    public static void main(String[] args) {
        //Postive test case
        String pincode = "573129";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
        //Negative test case
        String pincode1 = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode1)
                .when().log().all().get()
                .then().log().all().statusCode(404);
    }
}
