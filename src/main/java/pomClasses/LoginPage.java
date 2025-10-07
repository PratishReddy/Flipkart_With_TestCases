package pomClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Selenium_Utils;

public class LoginPage {
	
	By loginTextBy = By.xpath("//span[@class='KIOyzU']");
	@FindBy(xpath = "//input[@class='r4vIwl BV+Dqf']") private WebElement enterMobileNumberField;
	@FindBy(xpath = "//input[@class='r4vIwl _5BVqVB tuMj3n BV+Dqf']") private WebElement innerEnterMobileNumberField;
	@FindBy(xpath = "//button[@class='QqFHMw twnTnD _7Pd1Fp']") private WebElement requestOTPButton;
	@FindBy(xpath = "//input[@class='r4vIwl IX3CMV']") private WebElement enterOTPField;
	@FindBy(xpath = "//span[@class='llBOFA']") private WebElement errorMassage;
	@FindBy(xpath = "//div[@class='eIDgeN']") private WebElement toastMassage;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public boolean verifyLoginScreen(WebDriver driver) {
	
		WebElement text = Selenium_Utils.explicitWait(driver, 20, loginTextBy);
		
		if(text.isDisplayed())
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
		
	
	public String enterMobileNumberInInputField() throws IOException  {
		
		enterMobileNumberField.sendKeys(Selenium_Utils.getPropertiValue("mobile"));
		
		return Selenium_Utils.getPropertiValue("mobile");	
	}
	
	public String getTextFromMobileNumberInInputField() {
		
		@SuppressWarnings("deprecation")
		String value = innerEnterMobileNumberField.getAttribute("value");
		return value;
	}
	
	
	public void clickOnRequestOTPButton() {
		
		requestOTPButton.click();
		
	}
	
	
	public boolean verifyEnterOTPField() {
	
		if(enterOTPField.isDisplayed()) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
		
	
	public String enterInvalidMobileNumberInInputField() throws IOException 
	{
		enterMobileNumberField.sendKeys(Selenium_Utils.getPropertiValue("invalidMobileNumber"));
		String number = Selenium_Utils.getPropertiValue("invalidMobileNumber");
		return number;
		
	}
	
	
	public boolean verifyErrorMassage() throws IOException {
		
		String expectedErrorMassage = Selenium_Utils.getPropertiValue("errorMassage");
		String actualErrorMassage = errorMassage.getText();
		
		if(actualErrorMassage.equals(expectedErrorMassage)) 
		{
			return true;
		}
		else 
		{
			return false;
		}

	}	
	
	public String enternotRegistedMobileNumberInInputField(WebDriver driver) throws IOException  
	{	
		enterMobileNumberField.sendKeys(Selenium_Utils.getPropertiValue("notRegistedMobileNumber"));
		String notRegistedMobileNumber = Selenium_Utils.getPropertiValue("notRegistedMobileNumber");	
		return notRegistedMobileNumber;
		
	}
	
	
	public boolean verifyToastMassage() throws IOException {
		
		if(toastMassage.getText().equals(Selenium_Utils.getPropertiValue("toastMassage")))
		{
			return true;
		}
		else 
		{
			return false;
		}		
		
	}
		
				



}
