package org.ATB9XAPI.ex01_smapleCheck;

import io.restassured.RestAssured;

public class APITesting002 {
    public static void main(String[] args) {
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/560018")
                .when()
                .log().all().get()
                .then().log().all().statusCode(200);

        //Negative test case
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/568")
                .when()
                .log().all().get()
                .then().log().all().statusCode(404);
    }
}
