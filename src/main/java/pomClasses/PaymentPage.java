package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	
	@FindBy(xpath = "//h2[@id='-payments-']") private WebElement paymentPageText;
	
	
	
	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public boolean paymentPageVerify() {
		
		if (paymentPageText.isDisplayed() && paymentPageText.getText().endsWith("Payments")) 
		{
			return true; 
		}
			
		else {
			return false;
		}
		
		
	}
}
