package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_Utils {
	
	public static String getPropertiValue(String key) throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream("D:\\eclipse-workspace\\FlipkartWithTestCases\\src\\main\\resources\\ConfigurationFiles\\config.properties");
		Properties properties= new Properties();
		properties.load(fileInputStream);
		String value = properties.getProperty(key);
		return value;	
	}

	public static WebElement explicitWait(WebDriver driver, int time, By element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement elements=wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return elements;	
	}
	
	public static void clickByJSE(WebDriver driver, WebElement element ) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);	
	}
	
	public static void implicitWait(WebDriver driver, int time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
	}
	public static void sendKeysByJSE(WebDriver driver, WebElement element, String sendKey) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '"+sendKey+"'", element);
		
	}
	
	public static void scrollIntoViewByJSE(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public static void scrollByActions(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
		
	}
	
	
	public static void enterKeyClickByActionClass(WebDriver driver) {
		
		Actions act = new Actions(driver);
		act.sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		
	}
	
	public static void hoverOnByActionClass(WebDriver driver, WebElement element) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public static String getDataFromExcelSheet(String sheetName,String key) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\PRATISH PC\\OneDrive\\Desktop\\FlipkartTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int lastRow = sheet.getLastRowNum();
		String value = "";
		for(int i=0; i<=lastRow; i++)
		{
			if(sheet.getRow(i).getCell(0).getStringCellValue().equals(key))
			{
				value=sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		workbook.close();
		return value;
	}
	
	public static void switchFocus(WebDriver driver, int windowIndex) {
		
		Set<String> ids = driver.getWindowHandles();
		List<String> listOfIds = new ArrayList<>(ids);	
		driver.switchTo().window(listOfIds.get(windowIndex));
		
	}
	

}
