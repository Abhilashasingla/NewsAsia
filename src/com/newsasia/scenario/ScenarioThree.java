package com.newsasia.scenario;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newsasia.commonMethods.CommonMethods;

public class ScenarioThree {

static WebDriver driver=null;
	
	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) throws Exception {
		driver=CommonMethods.ChooseBrowser(browserName);
		driver.manage().window().maximize();
		driver.get("https://www.channelnewsasia.com/news/international");
	}
	
	@Test
	public void Validate() throws InterruptedException {
		CommonMethods.clickHamburgerMenu();
		CommonMethods.clickonWeather();
		CommonMethods.searchWeather();

	}
	
	@AfterTest
	public void tearDownTest() {
		CommonMethods.Stop();
	}

}
