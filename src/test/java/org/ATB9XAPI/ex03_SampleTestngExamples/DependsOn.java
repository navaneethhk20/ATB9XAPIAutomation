package org.ATB9XAPI.ex03_SampleTestngExamples;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void server(){
        System.out.println("Server will run first");
    }

    @Test(dependsOnMethods = "server")
    public void test1(){
        System.out.println("I will run 2nd");
    }
    @Test(dependsOnMethods = "server")
    public void test2(){
        System.out.println("I will run 3rd");
    }
}
