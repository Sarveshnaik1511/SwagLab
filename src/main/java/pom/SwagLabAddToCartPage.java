package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabAddToCartPage {

	@FindBy (id ="add-to-cart-sauce-labs-backpack") private WebElement clickAddToCart;
	@FindBy (xpath = "//button[text()='Remove']") private WebElement remove;
	
	
	public SwagLabAddToCartPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnSauceLabsBackpack() {
		clickAddToCart.click();
	}
	public boolean isitemAdded() {
//	boolean b= remove.isDisplayed();
//	return b;
	
	return remove.isDisplayed();
	}
}
