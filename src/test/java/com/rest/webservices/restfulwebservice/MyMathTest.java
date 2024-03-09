package com.rest.webservices.restfulwebservice;

import com.rest.webservices.restfulwebservice.Controller.MyMath;
import org.junit.Assert;
import org.junit.Test;


public class MyMathTest {

    MyMath myMath = new MyMath();

    @Test
    public void testWihElements(){

        int ans = myMath.calSum(new int[]{1,2,3});
        System.out.println(ans);
        int expectedRes = 6;
        Assert.assertEquals(ans,expectedRes);
    }

    @Test
    public void testWihNoElements(){

        int ans = myMath.calSum(new int[]{});
        System.out.println(ans);
        int expectedRes = 0;
        Assert.assertEquals(ans,expectedRes);
    }
}
