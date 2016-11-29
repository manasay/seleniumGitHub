package in.jsoft.newtours.utility;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenersClass extends TestListenerAdapter {
	static int i = 0;
	public static int passCount = 0;

	@Override
	public void onTestStart(ITestResult tr) {
		System.out.println(i++  + " test is started");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		passCount++;
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		
	}
}
