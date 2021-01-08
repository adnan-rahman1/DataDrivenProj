package com.excel.demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SanityTest {
    @Test
    @Parameters({"customer_name", "email"})
    public void testFour(String name, String email) {
        System.out.println("My name is : " + name);
        System.out.println("Email: " + email);
        System.out.println("Executing test four");
    }
}
