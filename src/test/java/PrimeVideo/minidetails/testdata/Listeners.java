package PrimeVideo.minidetails.testdata;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PrimeVideo.minidetails.GlobalProperties.ExtentReporterMD;

public class Listeners implements ITestListener {
	ExtentReports report=ExtentReporterMD.getExtentReport();
	ThreadLocal<ExtentTest>  extentTest=new ThreadLocal();
	ExtentTest test;
	@Override 	public void onTestStart(ITestResult result) 
	{ 	
		test=report.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
		
		} 	
	
		@Override 	public void onTestSuccess(ITestResult result) {
			if(result.getStatus()==ITestResult.SUCCESS) {
				extentTest.get().log(Status.PASS, "Test Case is Passed");
				
			}
			
			
			
			}
		
			@Override 	public void onTestFailure(ITestResult result) { 
				extentTest.get().log(Status.FAIL, "Test Case is Failed");
				
				
			}
			@Override
			public void onFinish(ITestContext context) {
				report.flush();
	}
}

