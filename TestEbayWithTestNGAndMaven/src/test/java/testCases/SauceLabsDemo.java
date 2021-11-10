package testCases;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {
	
	static RemoteWebDriver driver;

	public static void main(String[] args) throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("Windows 10");
		options.setBrowserVersion("latest");
		
		Map<String, Object> sauceOptions = new HashMap<String, Object>();
		sauceOptions.put("username", System.getenv("oauth-kevinzhu.zyk-54789"));
		sauceOptions.put("accessKey", System.getenv("f8b45554-6977-43c4-9efa-ebf681b8cdbd"));
//		sauceOptions.put("name", testInfo.getDisplayName());
		
		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");
		
		driver = new RemoteWebDriver(url, options);

		
//		System.setProperty("webdriver.chrome.driver", "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");
		driver.findElement(By.xpath("//div[@class='UUbT9']//input[@name='btnK']")).sendKeys("\n");
		System.out.println(driver.getTitle());
		
		driver.quit();
		System.out.println("Test completed");
		
	}
}
