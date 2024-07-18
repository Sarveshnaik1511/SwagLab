package test;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.Parametrization;
import utility.Reports;
import utility.ScreenShot;


// @Listeners annotation is of TestNG,
// It reads the information of tests and passes the information to the specified class
// we always write this outsite the class and specify in which class we need to transfer the information
@Listeners (test.Listeners.class)




// BaseTest Class has been inherited here and variable declared in base class has got value from this class
public class SwagLabLoginTest extends BaseTest {
	
	
	
	// Before test annotation will exicute before the start of test.
	// this method calls method of reports class
	
//	@BeforeTest
//	public void configureReporting() {
//	reports=	Reports.configureReports();
//	}
	
	@BeforeMethod
	public void openSwaglab() {
	driver =Browser.LaunchBrowser("https://www.saucedemo.com/");
	}
	
	
	
	@Test (priority = 1)
	public void testLoginBystandard_user() throws EncryptedDocumentException, IOException {
		
		// createTest method will accepts method name in its argument whose reports to be generated
		// this method is required to send the report or data to the ExtentReports
		// createTest method returns ExtentTest class
		// so we declared a variable in BaseTest and that variable got value from here
		// so basically the data has stored in test variable
		
		test =reports.createTest("testLoginBystandard_user");
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		
		//made an object of parametrization class
		Parametrization value =new Parametrization();
		
		//with help of parametrization, assigned data from excel sheet to the input field
		
		swagLabLoginPage.enterUserName(value.getData("SwagLabLoginSheet", 1, 0));
		swagLabLoginPage.enterPassword(value.getData("SwagLabLoginSheet", 1, 1));
	
		swagLabLoginPage.clickOnLogin();
		
		Assert.assertTrue(false);
		
		
	}
	@Test (priority = 2)
	public void testLoginBylocked_out_user() throws IOException {
		test =reports.createTest("testLoginBylocked_out_user");
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		
		Parametrization value =new Parametrization();
		swagLabLoginPage.enterUserName(value.getData("SwagLabLoginSheet", 2, 0));
		//swagLabLoginPage.enterUserName("locked_out_user");
		
		swagLabLoginPage.enterPassword(value.getData("SwagLabLoginSheet", 2, 1));
		//swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		
		ScreenShot.takeScreenShot(driver, "ss1");
	}
	@Test (priority =3, dependsOnMethods ="testLoginBystandard_user" )
	public void loginByproblem_user() throws EncryptedDocumentException, IOException  {
		test =reports.createTest("loginByproblem_user");
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		Parametrization value =new Parametrization();
		swagLabLoginPage.enterUserName(value.getData("SwagLabLoginSheet", 3, 0));
		swagLabLoginPage.enterPassword(value.getData("SwagLabLoginSheet", 3, 1));
		swagLabLoginPage.clickOnLogin();
		
		
		
		
		
	}
	
	@Test (priority = 4)
	public void loginByperformance_glitch_user() throws EncryptedDocumentException, IOException {
		test =reports.createTest("loginByperformance_glitch_user");
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		Parametrization value =new Parametrization();
		swagLabLoginPage.enterUserName(value.getData("SwagLabLoginSheet", 4, 0));
		swagLabLoginPage.enterPassword(value.getData("SwagLabLoginSheet", 4, 1));
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test (priority =5)
	public void loginByerror_user() throws EncryptedDocumentException, IOException {
		test =reports.createTest("loginByerror_user");
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		Parametrization value =new Parametrization();
		swagLabLoginPage.enterUserName(value.getData("SwagLabLoginSheet", 5, 0));
		swagLabLoginPage.enterPassword(value.getData("SwagLabLoginSheet", 5, 1));
		swagLabLoginPage.clickOnLogin();
	}
	@Test (priority =6)
	public void loginByvisual_user() throws EncryptedDocumentException, IOException {
		test =reports.createTest("loginByvisual_user");
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		Parametrization value =new Parametrization();
		swagLabLoginPage.enterUserName(value.getData("SwagLabLoginSheet", 6, 0));
		swagLabLoginPage.enterPassword(value.getData("SwagLabLoginSheet", 6, 1));
		swagLabLoginPage.clickOnLogin();
	}
	

	// according to the conditions get satisfy, this will log the data to the reports
	@AfterMethod
	public void addReportStatus(ITestResult result) {
//		if(result.getStatus()==ITestResult.SUCCESS) {
//			test.log(Status.PASS, result.getName());
//		}
//		else if (result.getStatus()==ITestResult.FAILURE) {
//			test.log(Status.FAIL, result.getName());
//		}
//		else {
//			test.log(Status.SKIP, result.getName());
//		}
		
		driver.close();
		
	}
	
	// now to send the logged data to the attachReporter
//	@AfterTest
//	public void publishReport() {
//		
//		// this method will flush the data/ send the data to ExtentSparkReporter 
//			reports.flush();
//			
//	}
}
