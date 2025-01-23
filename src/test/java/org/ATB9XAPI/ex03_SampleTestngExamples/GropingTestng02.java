package org.ATB9XAPI.ex03_SampleTestngExamples;

import org.testng.annotations.Test;

public class GropingTestng02 {
    @Test(groups = {"sanity", "qa"})
    public void sanitytest1(){
        System.out.println("Sanity");
        System.out.println("qa");
    }
    @Test(groups = {"regression", "ta"})
    public void regressiontest1(){
        System.out.println("regression");
        System.out.println("ta");
    }
    @Test(groups = {"smoke", "pa"})
    public void smoketest1(){
        System.out.println("smoke");
        System.out.println("pa");
    }
}
