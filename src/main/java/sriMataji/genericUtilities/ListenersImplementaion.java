package sriMataji.genericUtilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementaion implements ITestListener{
    
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodName= result.getMethod().getMethodName();   // capture name of mthod--- get mothd and get name
		//System.out.println(methodName+ "Test script execution started");
		test=report.createTest(methodName); // Create a new ExtentTest instance for each test start
		test.log(Status.INFO, methodName+ "Test script execution started ");
	}
	
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();   // capture name of mthod--- get mothd and get name
		//System.out.println(methodName+ "Test script execution Success");
		test.log(Status.PASS, methodName + "Test script execution Success");
	}
	
	public void onTestFailure(ITestResult result) {
		String methodName= result.getMethod().getMethodName();   // capture name of mthod--- get mothd and get name
		
		//System.out.println(methodName+ "Test script execution Failed");
	    //System.out.println(result.getThrowable());
		test.log(Status.FAIL, methodName);
		
		String scrrenShotName= methodName+"-"+new JavaUtility().getSystemDateInFormat();
	    
		WebDriverUtility wUtil= new WebDriverUtility();
	    try {
			String path= wUtil.takesScreenShot(BaseClass.sDriver, scrrenShotName);
		    test.addScreenCaptureFromPath(path);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();   // capture name of mthod--- get mothd and get name
		//System.out.println(methodName+ "Test script execution Skipped");
		//System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution Started");		
		ExtentSparkReporter htmlReporter= new ExtentSparkReporter(".\\ExtentReporter\\Report"+ new JavaUtility().getSystemDateInFormat()+".html");
		
		htmlReporter.config().setDocumentTitle("");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		report= new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Base Browser","Firefox" );
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter-Name", "Ravish");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");	
		report.flush();
	}	
	
}
