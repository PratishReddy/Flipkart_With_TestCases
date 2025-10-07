package pomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Selenium_Utils;

public class ProductPage {

	By addToCartButtonBy = By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']");
	@FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2']") private WebElement addToCartButton;
	
	
	public ProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnAddToCartButton(WebDriver driver) throws InterruptedException 
	{
		
		WebElement element = Selenium_Utils.explicitWait(driver, 10, addToCartButtonBy);
		element.click();
		Thread.sleep(2000);
	}
	
	
}
