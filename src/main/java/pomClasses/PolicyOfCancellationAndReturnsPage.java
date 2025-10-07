package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyOfCancellationAndReturnsPage {
	
	
	@FindBy(xpath = "//h1[@id='order-cancellation-and-return-policy']") private WebElement policyOfCancellationAndReturnsPageText;
	
	
	public PolicyOfCancellationAndReturnsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public boolean policyOfCancellationAndReturnsPageVerify() {
		
		if (policyOfCancellationAndReturnsPageText.isDisplayed() && policyOfCancellationAndReturnsPageText.getText().equals("Order Cancellation and Return Policy")) 
		{
			return true; 
		}
			
		else {
			return false;
		}
	
	}

}
