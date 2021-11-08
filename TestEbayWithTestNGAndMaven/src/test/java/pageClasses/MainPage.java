package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Search for anything']")
	WebElement searchBox;
	@FindBy(xpath="//input[@class='btn btn-prim gh-spr']")
	WebElement searchButton;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void gotoSearchResultPage(String keyWords) {
		searchBox.sendKeys(keyWords);
		searchButton.click();
	}
}
