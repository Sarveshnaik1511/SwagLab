package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	public static WebDriver LaunchBrowser(String url) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\\\Automation softwares\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		return driver;
	}

}
