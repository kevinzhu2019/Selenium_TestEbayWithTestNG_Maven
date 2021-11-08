package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoItDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		test();
	}
	
	public static void test() throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://html-file-upload.netlify.app/single/index.html");
		
//		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("\n");
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		action.moveToElement(upload).build().perform();
		action.click(upload).build().perform();
		
		Runtime.getRuntime().exec("C:\\Users\\kevin\\eclipse-workspace\\TestEbayWithTestNGAndMaven\\src\\test\\java\\testCases\\autoitDemo.exe");
		
		Thread.sleep(2000);

	}
	
}
