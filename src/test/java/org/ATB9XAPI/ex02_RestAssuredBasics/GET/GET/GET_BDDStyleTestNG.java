package org.ATB9XAPI.ex02_RestAssuredBasics.GET.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GET_BDDStyleTestNG {
        @Test
        public void test_GET_BDDStyleTestNG_Negaive1(){
            String pincode3 = "-1";
            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode3)
                    .when().log().all().get()
                    .then().log().all().statusCode(404);
        }
        @Test
        public void test_GET_BDDStyleTestNG_Postive1(){
            String pincode4 = "573129";
            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode4)
                    .when().log().all().get()
                    .then().log().all().statusCode(200);
        }
    }

