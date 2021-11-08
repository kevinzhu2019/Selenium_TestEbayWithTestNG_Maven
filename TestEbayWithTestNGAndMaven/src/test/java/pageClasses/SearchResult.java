package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {

	WebDriver driver;
	@FindBy(xpath="//div[@id='gh-ac-box2']//input[@type='text']")
	WebElement searchBoxWithKeywords;
	@FindBy(xpath="//h1[@class='srp-controls__count-heading']//span[2]")
	WebElement resultWithKeyWords;
	
	public SearchResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifySearchBox() {
		String searchBoxValue = searchBoxWithKeywords.getAttribute("value");
		return searchBoxValue;
	}
	
	public String verifyResult() {
		String resultValue = resultWithKeyWords.getText();
		return resultValue;
	}
}
