package test;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.SwagLabAddToCartPage;
import pom.SwagLabLoginPage;

public class SwagLabAddToCartTest extends BaseTest{

	

	@BeforeMethod
	public void openSwaglab() {
		driver = Browser.LaunchBrowser("https://www.saucedemo.com/");
		
	}

	@Test(priority = 1)
	public void testLoginBystandard_user() {
		
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		
		SwagLabAddToCartPage swagLabAddToCartPage =new SwagLabAddToCartPage(driver);
		swagLabAddToCartPage.clickOnSauceLabsBackpack();
		
		
		
		Assert.assertTrue(swagLabAddToCartPage.isitemAdded());
		

	}
	
	@AfterMethod 
	public void closeBrowser() {
		driver.close();
	}
	
	

}
