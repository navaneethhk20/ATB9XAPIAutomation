package org.ATB9XAPI.ex05_PayLoadManagement.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Lab01POJO {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;
@Test
    public void test_Post(){

        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(1120);
        booking.setDepositpaid(false);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalfields("Breakfast");

        System.out.println(booking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()

        validatableResponse.body("booking.firstname",Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dutta"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
        validatableResponse.body("bookingid",Matchers.notNullValue());


        // TestNG Assertions  -

        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.


        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");


        // TestNG Assertions

        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Pramod");
        Assert.assertEquals(lastname,"Dutta");


        // AssertJ( 3rd- Lib to Assertions)

        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotNull().isNotBlank();



//        String s = ""; //Empty
//        String s2 = " "; //Blank

    }
}
