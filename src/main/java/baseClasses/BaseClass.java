package baseClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Selenium_Utils;

public class BaseClass {
	
	protected static WebDriver driver;
	
	public static void launchBrowser(String browser) throws IOException {
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(Selenium_Utils.getPropertiValue("url"));
		Selenium_Utils.implicitWait(driver, 10);
			
		}		
		
	}


