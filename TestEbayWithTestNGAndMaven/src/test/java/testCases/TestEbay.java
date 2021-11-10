package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import pageClasses.MainPage;
import pageClasses.SearchResult;

public class TestEbay {

	String chromeDriverPath = "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe";
	String firefoxDriverPath = "C:\\selenium_java\\geckodriver_win64\\geckodriver.exe";
	String searchingKeyword = "sega astro city";
	WebDriver driver;
	MainPage objMainPage;
	SearchResult objSearchResult;
	public static String browserName;
	
	@BeforeTest
	public void setup() {
		PropertiesFile.setProperties();
		PropertiesFile.getProperties();
		System.out.println("browserName = " + browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}

		driver.get("http://www.ebay.com");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void searchThingsandVerify() {
		objMainPage = new MainPage(driver);
		objMainPage.gotoSearchResultPage(searchingKeyword);
		objSearchResult = new SearchResult(driver);
		Assert.assertEquals(objSearchResult.verifySearchBox(), searchingKeyword);
		Assert.assertEquals(objSearchResult.verifyResult(), searchingKeyword);
		System.out.println("test test test");
	}
	
	@AfterTest
	public void clear() {
		driver.close(); 
		driver.quit();
		System.out.println("Test is completed");
	}
}
