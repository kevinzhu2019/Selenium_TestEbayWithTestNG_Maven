package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static void main(String[] arg) {
		seleniumWait();
	}
	
	public static void seleniumWait() {
		
//		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		driver.findElement(By.xpath("//div[@class='aajZCb']//input[@name='btnK']")).sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//below is to test explicitlyWait and ******IT WILL BE FAILED AFTER 10 SECONDS!!!!!!!******
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='abc']")));
		ele.sendKeys(Keys.ENTER);
		
		driver.close();
		driver.quit();
	}
}
