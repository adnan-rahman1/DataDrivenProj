package com.excel.demo;

import com.listener.demo.MyListener;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

@Listeners(MyListener.class)
public class SmokeTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test executed");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test executed");
    }

    @Test
    public void testOne() {
        System.out.println("Executing test one");
    }

    @Test
    public void testTwo() {
        System.out.println("Executing test two");
        throw new SkipException("Just skipped");
    }
}
