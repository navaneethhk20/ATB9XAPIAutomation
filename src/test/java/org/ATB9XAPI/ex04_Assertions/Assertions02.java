package org.ATB9XAPI.ex04_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions02 {
    @Test
    public void hardAssertion(){
        System.out.println("Hard assertion start");
        Boolean is_neeru_male = true;
        Assert.assertTrue(is_neeru_male);
        System.out.println("End of the program");
        Assert.assertEquals("Pramod", "Pramod");
        System.out.println("End");
    }
    @Test
    public void softAssertion(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This is will be executed");
        softAssert.assertAll();

    }

}
