package com.assaabloy.practice;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest logger;

	@BeforeSuite
	public void setupAfterMethod() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("./index.html");
		extent.attachReporter(sparkReporter);
	}
	
	@AfterMethod
	public void checkStatus(Method m, ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail(result.getThrowable());
			logger.fail(m.getName()+" has failed");
		}
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass(m.getName()+" has Passed");
		}
		extent.flush();
	}
}
