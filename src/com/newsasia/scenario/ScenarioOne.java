package com.newsasia.scenario;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.newsasia.commonMethods.*;



public class ScenarioOne {
	static WebDriver driver=null;
	
	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) throws Exception {
		driver=CommonMethods.ChooseBrowser(browserName);
		driver.manage().window().maximize();
		driver.get("https://www.channelnewsasia.com/");
	}
	
	@Test
	public void Validate() throws InterruptedException {
		
		//Assert for headlines
		String mainPageHeadline= CommonMethods.homePageHeadline();
		String articlePageHeadline= CommonMethods.articleHeadline();
		Assert.assertEquals(articlePageHeadline, mainPageHeadline);
		
		CommonMethods.scrollDown();
		CommonMethods.waitForJSandJQueryToLoad();
		CommonMethods.scrollDown();
		CommonMethods.waitForJSandJQueryToLoad();
		
		Thread.sleep(1000);
		
		String fetchHeadlineTitleText= CommonMethods.fetchHeadlineTitle();
		String fetchArticleHeadlineText= CommonMethods.fetchArticleHeadline();
		Assert.assertEquals(fetchArticleHeadlineText, fetchHeadlineTitleText);
		
		CommonMethods.clickReadArticle();

	}
	
	@AfterTest
	public void tearDownTest() {
		CommonMethods.Stop();
	}

}
