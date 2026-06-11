package PrimeVideo.minidetails.GlobalProperties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterMD {
public static ExtentReports getExtentReport() {
	
	String path="C:\\Users\\Vijayalakshmi\\democicd\\minidetails\\Report\\index.html";
	ExtentSparkReporter esp=new ExtentSparkReporter(path);
	esp.config().setReportName("Minidetails Result");
	esp.config().setDocumentTitle("MiniDetail");
	ExtentReports report=new ExtentReports();
	report.attachReporter(esp);
	report.setSystemInfo("Tester", "Thavithu");
	return report;
	
	
}
}
