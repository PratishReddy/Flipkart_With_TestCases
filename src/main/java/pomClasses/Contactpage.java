package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	
	
	@FindBy(xpath = "//h1[@class='ogUXNW']") private WebElement contactPageText;
	
	
	public Contactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public boolean contactPageVerify() {
		
		if (contactPageText.isDisplayed() && contactPageText.getText().endsWith("Flipkart Help Center | 24x7 Customer Care Support")) 
		{
			return true; 
		}
			
		else {
			return false;
		}
	
	}
	
}
