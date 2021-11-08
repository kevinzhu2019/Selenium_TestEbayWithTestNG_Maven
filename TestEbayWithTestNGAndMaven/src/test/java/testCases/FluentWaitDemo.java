package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		test();
	}
	
	public static void test() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Abcd");
		//Below line will intermittently fail without "wait"
//		driver.findElement(By.xpath("//div[@class='aajZCb']//input[@name='btnK']")).sendKeys("\n");
		//Below line will be failed without "wait"(We will manually navigate page to second page)
//		driver.findElement(By.xpath("//a[@href='https://nda.nih.gov/abcd']")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)//Map<Node> map = new HashMap<Node>()
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement searchButton = wait.until(new Function<WebDriver, WebElement> () {
			public WebElement apply(WebDriver driver) {
				WebElement button = driver.findElement(By.xpath("//div[@class='aajZCb']//input[@name='btnK']"));
				if(button.isEnabled()) {
					System.out.println("Search button found");
				}
				return button;
			}
		});
		searchButton.click();
		
		WebElement page2 = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement secondPage = driver.findElement(By.xpath("//a[@aria-label='Page 2']"));
				if(secondPage.isEnabled()) {
					System.out.println("page2 element is clickable now");
				}
				return secondPage;
			}
		});
		page2.click();
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkEle = driver.findElement(By.xpath("//a[@href='https://nda.nih.gov/abcd']"));
				if(linkEle.isEnabled()) {
					System.out.println("link element found");
				}
				return linkEle;
			}
		});
		
		element.click();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
