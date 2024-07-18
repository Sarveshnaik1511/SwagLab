package test;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


// BaseTest class is used to store variables and methods that will be used again and again
public class BaseTest {
	// has completed driver and got its value from SwagLabLoginTest
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test; 

}
