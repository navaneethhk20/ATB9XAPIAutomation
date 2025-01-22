package org.ATB9XAPI.ex01_smapleCheck;

public class APITestingNoDesignPattern {
    public void step1(){
        System.out.println("Step1");
    }
    public void step2(){
        System.out.println("Step2");
    }
    public void step3(String param1){
        System.out.println(param1);
    }

    public static void main(String[] args) {
       APITestingNoDesignPattern ndp = new APITestingNoDesignPattern();
       ndp.step1();
       ndp.step2();
       ndp.step3("Nithu");
    }
}
