package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {
	
	@FindBy(xpath = "//span[contains(@class,'x1lliihq x6ikm8r x10wlt62 x1n2onr6 xg8')]") private WebElement facebookPageText;

	
	
	public FacebookPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean facebookPageVerify() {
		
		if (facebookPageText.isDisplayed() && facebookPageText.getText().endsWith("See more from Flipkart")) 
		{
			return true; 
		}
			
		else {
			return false;
		}
		
	}
	
	
}
