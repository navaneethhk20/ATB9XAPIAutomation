package org.ATB9XAPI.ex03_SampleTestngExamples;

import org.testng.annotations.Test;

public class AlwaysOn {
    @Test(alwaysRun = true)
    public void test90(){
        System.out.println("Always on");
    }
    @Test(alwaysRun = true)
    public void test91(){
        System.out.println("Always on not mentioned but still will run");
    }
}
