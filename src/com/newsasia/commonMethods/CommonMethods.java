package com.newsasia.commonMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods extends BaseCommonMethods{
static WebDriverWait wait = new WebDriverWait(driver,30);
	
	public static String homePageHeadline(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"feature-card__heading-link feature-card__heading-link--\"]")));
		WebElement headline= driver.findElement(By.xpath("//*[@class=\"feature-card__heading-link feature-card__heading-link--\"]"));
		String headlineText=headline.getText();
		Assert.assertNotNull(headlineText);
		headline.click();
		return headlineText;
	}
	
	public static String articleHeadline(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"h1 h1--page-title\"]")));
		String ArticleHeadline= driver.findElement(By.xpath("//*[@class=\"h1 h1--page-title\"]")).getText();
		return ArticleHeadline;	
	}
	
	public static void scrollDown(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");	
		
	}
	
	public static boolean waitForJSandJQueryToLoad() {

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          // no jQuery present
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
	        .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	public static void clickReadArticle(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[3]/div[2]/div/a[contains(text(),'Expand to read the full story')]")));
		WebElement readBtn= driver.findElement(By.xpath("//article[3]/div[2]/div/a[contains(text(),'Expand to read the full story')]"));
		js.executeScript("arguments[0].scrollIntoView();", readBtn);
		readBtn.click();	
	}
	
	public static String fetchHeadlineTitle(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"h5 h5-- article-navigation__heading\"]")));
		String fetchHeadlineTitleText=driver.findElement(By.xpath("//*[@class=\"h5 h5-- article-navigation__heading\"]")).getText();
		return fetchHeadlineTitleText;
		
	}
	
	public static String fetchArticleHeadline(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[3]/div[1]/div[2]/div/section/div/h1")));
		String fetchArticleHeadlineText= driver.findElement(By.xpath("//article[3]/div[1]/div[2]/div/section/div/h1")).getText().trim();
		return fetchArticleHeadlineText;
		
	}
	
	public static void clickHamburgerMenu(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"all-section-menu main-menu__link\"]")));
		WebElement allSections= driver.findElement(By.xpath("//*[@class=\"all-section-menu main-menu__link\"]"));
		allSections.click();
	}
	
	public static void clickonWeather(){
//		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href=\"https://www.channelnewsasia.com/weather\"]")));
//		WebElement weatherLink=driver.findElement(By.xpath("//*[@href=\"https://www.channelnewsasia.com/weather\"]"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href=\"https://www.channelnewsasia.com/weather\"]"))).click();
		System.out.print("Success");
	}
	
	public static void searchWeather(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"asia-lists tabular-list\"]")));
		String city= driver.findElement(By.xpath("//*[@class=\"tabular-list__view\"]/li[21]/div[1]/div[1]")).getText();
		if (city.equalsIgnoreCase("singapore")) {
			String maxTemp=driver.findElement(By.xpath("//*[@class=\"tabular-list__view\"]/li[21]/div[2]/span[1]")).getText();
			String minTemp=driver.findElement(By.xpath("//*[@class=\"tabular-list__view\"]/li[21]/div[2]/span[2]")).getText();
			String condition=driver.findElement(By.xpath("//*[@class=\"tabular-list__view\"]/li[21]/div[1]/div[2]")).getText();
			System.out.println("CITY: "+city);
			System.out.println("Maximum temprature: "+maxTemp);
			System.out.println("Minimum temprature: "+minTemp);
			System.out.println("Condition: "+condition);
		}
	}
	
}
