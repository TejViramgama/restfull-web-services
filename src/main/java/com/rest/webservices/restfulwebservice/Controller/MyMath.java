package com.rest.webservices.restfulwebservice.Controller;

public class MyMath {

    public int calSum(int[] ar){
        int sum = 0;
        for (int n : ar){
            sum += n;
        }
        return sum;
    }
}
