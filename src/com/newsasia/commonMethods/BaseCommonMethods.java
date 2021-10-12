package com.newsasia.commonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseCommonMethods {

static WebDriver driver;

	public static WebDriver ChooseBrowser(String browserName) throws Exception {
		String projectPath= System.getProperty("user.dir");
		if(browserName.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/firefoxdriver/geckodriver");
				driver = new FirefoxDriver();
			}
		else if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver",projectPath+"//drivers/chromedriver/chromedriver");
				driver = new ChromeDriver();
			}
		else if(browserName.equalsIgnoreCase("Edge")){
				System.setProperty("webdriver.edge.driver",projectPath+"//drivers/edgedriver/msedgedriver");
				driver = new EdgeDriver();
			}
		else if(browserName.equalsIgnoreCase("safari")){
				driver = new SafariDriver();
			}
		else{
				throw new Exception("Browser is not correct");
			}
		return driver;
	}
	
	public static void Stop() {
		driver.quit();
	}
	
}
