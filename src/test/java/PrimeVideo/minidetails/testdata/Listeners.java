package PrimeVideo.minidetails.testdata;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PrimeVideo.minidetails.GlobalProperties.ExtentReporterMD;

public class Listeners extends TestData implements ITestListener {
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
				extentTest.get().fail(result.getThrowable());
				
					try {
						driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
					} catch (Exception ecp) {
						ecp.printStackTrace();
					}try {
					String path=getScreenshot(result.getMethod().getMethodName(),driver);
					extentTest.get().addScreenCaptureFromPath(path);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
			@Override
			public void onFinish(ITestContext context) {
				report.flush();
	}
}

