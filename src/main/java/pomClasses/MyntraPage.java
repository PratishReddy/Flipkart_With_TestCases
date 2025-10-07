package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyntraPage {

	
	public MyntraPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public boolean myntraPageVerify(WebDriver driver) {
		
		System.out.println("currentURL --> "+driver.getCurrentUrl());
		if (driver.getCurrentUrl().equals("https://www.myntra.com/")) 
		{
			return true; 
		}
			
		else {
			return false;
		}
	
	}

}
