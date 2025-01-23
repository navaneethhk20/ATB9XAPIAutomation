package org.ATB9XAPI.ex03_SampleTestngExamples;

import org.testng.annotations.Test;

public class InvocationCount {
    @Test(invocationCount = 5)
    public void test50(){
        System.out.println("test50");
    }

}
