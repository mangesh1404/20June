package ListnersProg;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener, IRetryAnalyzer{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started and details are  "+result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed and details are    "+result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed and details are  "+result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	@Override//Method of IretryAnalyzer
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}
