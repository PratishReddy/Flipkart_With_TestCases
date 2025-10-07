package pomClasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Selenium_Utils;

public class ProductListPage {
	
	By firstProductBy = By.xpath("(//a[@class='CGtC98'])[1]");
	@FindBy(xpath = "//a[@class='CGtC98']") private List<WebElement> listOfProduct;
	@FindBy(xpath = "//img[@src='//static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/flipkart-plus_8d85f4.png']") private WebElement flipkartImage;
	
	@FindBy(xpath = "//a[@class='_9QVEpD']") private WebElement nextButton;
	@FindBy(xpath = "//span[@class='VU-ZEz']") private WebElement productName;
	@FindBy(xpath = "//div[@class='Nx9bqj CxhGGd']") private WebElement productPrice;
	@FindBy(xpath = "(//a[@class='CDDksN io5kcR'])[1]") private WebElement displaySize;
	By offerBy = By.xpath("//div[@class='UkUFwK WW8yVX']");
	
	public ProductListPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFlipkartImage(WebDriver driver) 
	{
		Selenium_Utils.explicitWait(driver, 10, firstProductBy);
		flipkartImage.click();
	}
	
	public boolean verifySearchIconClickable(WebDriver driver) {
		
		 WebElement element = Selenium_Utils.explicitWait(driver, 10, firstProductBy);
		
		 if(element.isDisplayed())
		 {
			 return true;
		 }
		 else 
		 {
			 return false;
		 }
	}
	
	public void clickOnFirstProduct(WebDriver driver) 
	{
		WebElement element = Selenium_Utils.explicitWait(driver, 10, firstProductBy);
		element.click();
	}

}
