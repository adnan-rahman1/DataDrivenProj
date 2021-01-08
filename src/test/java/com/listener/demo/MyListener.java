package com.listener.demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Run on each test");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Just Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Just failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Just skipped");

    }

    public void onStart(ITestContext context) {
        System.out.println("######################################");
        System.out.println("On Start testing run");
        ITestNGMethod[] allTestMethods = context.getAllTestMethods();
        for(ITestNGMethod iTestNGMethod: allTestMethods) {
            System.out.println(iTestNGMethod.getMethodName());
        }
        System.out.println("######################################");
    }

    public void onFinish(ITestContext context) {
        System.out.println("On finish test run");
    }
}
