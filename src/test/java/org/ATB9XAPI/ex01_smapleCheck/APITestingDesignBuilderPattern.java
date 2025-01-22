package org.ATB9XAPI.ex01_smapleCheck;

public class APITestingDesignBuilderPattern {
    public APITestingDesignBuilderPattern step1(){
        System.out.println("Step1");
        return this;
    }
    public APITestingDesignBuilderPattern step2(){
        System.out.println("Step2");
        return this;
    }
    public APITestingDesignBuilderPattern step3(String param2){
        System.out.println(param2);
        return this;
    }

    public static void main(String[] args) {
        APITestingDesignBuilderPattern bp = new APITestingDesignBuilderPattern();
        bp.step1().step2().step3("Navaneeth");
    }
}
