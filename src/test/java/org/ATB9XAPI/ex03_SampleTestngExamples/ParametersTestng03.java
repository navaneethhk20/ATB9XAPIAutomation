package org.ATB9XAPI.ex03_SampleTestngExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestng03{
    @Parameters("browser")
    @Test
    public void test1(String value) {
        System.out.println("Browser is " + value);

        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my Testing Chrome");
        }
        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my Firefox");
        }

    }
}
