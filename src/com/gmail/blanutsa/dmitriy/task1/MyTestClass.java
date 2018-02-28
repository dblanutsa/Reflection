package com.gmail.blanutsa.dmitriy.task1;

import com.gmail.blanutsa.dmitriy.task1.Parameters;

public class MyTestClass {

    private String str = "saf";

    public String getStr() {
        return str;
    }

    @Parameters(param1 = 7, param2 = 8)
    public static void test(int a, int b){
        System.out.println(a + " " + b);
    }

}
