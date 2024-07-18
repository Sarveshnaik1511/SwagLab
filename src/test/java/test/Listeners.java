package test;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utility.Reports;
import utility.ScreenShot;

// we can extend the class as well as implement the interface in same class
// we have declared a variable driver in BaseTest and used here by inheriting its property in Listeners class
// same baseTest class is inherited in test class and from there driver variable got its value,
// and then we used that value filled variable here in this class

public class Listeners extends BaseTest implements ITestListener{
	
	
	// ITestResult is in interface, it recieves all the results or information of tests,whether a test passes, fails,skipped etc.
	// ITestResult is an interface and not belong to webDriver, It belongs to TestNG
	// so we complete its method in class. i.e implements ITestInterface methods in Listeners Class
	// ITestResult is an interface that we pass as an argument of method, 
	// So it recieves the Information of test behaviour 
	// and that information get saved in a varible that we are passing along with it. eg method_Name (ITestResult result)
	// @listeners, this is the TestNg annotation that gives all the information to the ITestResult
	
	
	public void onStart(ITestContext result) {
		reports=	Reports.configureReports();
		
	}
	public void onFinish(ITestContext result) {
		reports.flush();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started " + result.getName());
	}
	
	// this are all methods present in ITestListener interface in incomplete form
	// we implement those incomplete methods in this class
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed "+ result.getName());
		test.log(Status.PASS, result.getName());
		
	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName());
		System.out.println("Test Failed "+result.getName());
		
		try {
			
			// listners class have receaved the completed driver from BaseTest class 
			ScreenShot.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName());
		System.out.println("Test Skipped "+result.getName());
	}

}
