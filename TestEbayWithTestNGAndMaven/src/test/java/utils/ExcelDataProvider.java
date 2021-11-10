package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}
	
	@Test(dataProvider = "test1Data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username + " | " + password);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "test1Data")
	public Object[][] getData() {
		String basePath = System.getProperty("user.dir");
		String path = basePath + "/excel/data.xlsx";
		Object data[][] = testData(path, "Sheet1");
		return data;
	}
	
	@AfterTest
	public void clear() {
		driver.close();
		driver.quit();
		System.out.println("Test is completed successfully");
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount - 1][colCount];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 0; j < colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
//				System.out.print(cellData + " | ");
				data[i - 1][j] = cellData;
			
			}
//			System.out.println();
		}
		return data;
	}
}
