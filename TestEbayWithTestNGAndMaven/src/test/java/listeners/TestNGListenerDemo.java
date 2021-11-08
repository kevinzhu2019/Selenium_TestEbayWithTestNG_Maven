package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)//this line can be removed if using testng.xml to bind listeners
public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("I am inside test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside test 2, here is the real case");
//		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("abcd");
		
		driver.close();
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside test 3");
		throw new SkipException("This test is skipped");
	}
	
	@Test
	public void test4() {
		System.out.println("I am inside test 4");
	}
}
