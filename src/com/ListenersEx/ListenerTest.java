package com.ListenersEx;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class ListenerTest implements ITestListener{
	 
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " test is started ");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " test is passed ");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " test is failed ");
		try {
			GetScreenShot.capture(LoginTestCases1.driver, result.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " test is skipped ");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println(" testSuite is started ");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" test is finished ");

	}

}
