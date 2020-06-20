package com.ListenersEx;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest1 implements ITestListener,IRetryAnalyzer{
	
	int counter=0;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("am in on test start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("am in onTestSuccess");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("am in onTestFailure");
		System.out.println(result.getTestName());
		System.out.println(result.getTestClass());
		try {
			GetScreenShot.capture(LoginTestCases1.driver, result.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("am in onTestFailure");
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("am in onTestFailedButWithinSuccessPercentage");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("am in onStart");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("am in onFinish");
		
	}

	@Override
	 public boolean retry(ITestResult result) {
	 //WebDriver driver=new ffdrvr();
	 // check if the test method had RetryCountIfFailed annotation
	 RetryCountIfFailed annotation = result.getMethod().getConstructorOrMethod().getMethod()
	 .getAnnotation(RetryCountIfFailed.class);
	 // based on the value of annotation see if test needs to be rerun
	 if((annotation != null) && (counter < annotation.value()))
	 {
	 counter++;
	 return true;
	 }
	 return false;
	 }
	}
	
