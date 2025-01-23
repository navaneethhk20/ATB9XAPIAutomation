package org.ATB9XAPI.ex03_SampleTestngExamples;

import org.testng.annotations.Test;

public class EnableTestng04 {
    @Test(enabled = true)
    public void test001(){
        System.out.println("test1");
    }

@Test(enabled = false)
    public void test003(){
        System.out.println("test3");
    }
    @Test(enabled = true)
    public void test002(){
        System.out.println("test2");
    }
}
