package pomClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.type.PrimitiveType;

import io.qameta.allure.Step;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Selenium_Utils;

public class HomePage {
	
//  1.
	@FindBy(xpath = "//div[@class='_38VF5e']") private WebElement loginbutton;		
	By userNameBy = By.xpath("//a[@class='_1TOQfO']");
	@FindBy(xpath = "//*[text()='My Profile']") private WebElement myProfileButton;
	@FindBy(xpath = "(//div[@class='_38VF5e'])[2]") private WebElement cartButton;
	@FindBy(xpath = "(//a[@class='_1krdK5 _3jeYYh'])[1]") private WebElement cartButtonText;
	@FindBy(xpath = "//input[@class='Pke_EE']") private WebElement searchInputField;
	@FindBy(xpath = "//button[@class='_2iLD__']") private WebElement searchButton;
	@FindBy(xpath = "//span[@class='_30XB9F']") private WebElement popUpCloseButton;
	@FindBy(xpath = "//img[@src='https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkheaderlogo_exploreplus-44005d.svg']") private WebElement flipkartImage;
	@FindBy(xpath = "//div[@class='_3l09Bv']") private WebElement trendingProductsText;
	@FindBy(xpath = "//span[@class='_2U7eDE']") private WebElement countOfItemsInCart;
	@FindBy(xpath = "(//div[@class='_3I5N7v'])[1]/following-sibling::a") private List<WebElement> footerAboutSectionOptionList;
	@FindBy(xpath = "//div[@class='_1ZMrY_']") private WebElement footer;
	@FindBy(xpath = "((//div[@class='_3I5N7v'])[1]/following-sibling::a)[1]") private WebElement contactUs;
	@FindBy(xpath = "((//div[@class='_3I5N7v'])[2]/following-sibling::a)") private List<WebElement> footerGroupComponentsSectionOptionList;
	@FindBy(xpath = "((//div[@class='_3I5N7v'])[2]/following-sibling::a)[1]") private WebElement myntra;
	@FindBy(xpath = "((//div[@class='_3I5N7v'])[3]/following-sibling::a)") private List<WebElement> footerHelpSectionOptionList;
	@FindBy(xpath = "((//div[@class='_3I5N7v'])[3]/following-sibling::a)[1]") private WebElement payment;
	@FindBy(xpath = "((//div[@class='_3I5N7v'])[4]/following-sibling::a)") private List<WebElement> footerConsumerPolicySectionOptionList;
	@FindBy(xpath = "((//div[@class='_3I5N7v'])[4]/following-sibling::a)[1]") private WebElement cancellationAndReturns;
	@FindBy(xpath = "//img[@alt='Facebook']") private WebElement facebookIcon;
	@FindBy(xpath = "//div[@class='c4gehN']") private List<WebElement> footerBottomBarOptions;
	@FindBy(xpath = "(//div[@class='c4gehN'])[2]") private WebElement advertise;
	
	//	2.
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	@Step
	public void clickOnLoginButton()
	{
		try {
			popUpCloseButton.click();
		} catch (Exception e) {
		
			System.out.println("No pop up displayed");
		}
		
		loginbutton.click();	
		
	}
	
	@Step
	public boolean verifyHomeScreen(WebDriver driver) throws IOException 
	{
		WebElement profileNameOnHomePage = Selenium_Utils.explicitWait(driver, 300, userNameBy);
		
		if(profileNameOnHomePage.getText().equals(Selenium_Utils.getPropertiValue("username")))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	public boolean verifyPresenceOfFlipkartImage() 
	{
		if(flipkartImage.isDisplayed())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	@Step
	public void searchProduct(String productName) throws InterruptedException, IOException 
	{	
		searchInputField.sendKeys(productName);
	}
	
	public void clickOnFlipkartImage() 
	{
		flipkartImage.click();
	}
	
	public boolean verifyPageReloadAndNavigateToHomePage() {
		
		if(flipkartImage.isDisplayed()) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public boolean VerifyPresenceOfSearchField() 
	{
		if(searchInputField.isDisplayed() && searchInputField.getAttribute("placeholder").equals("Search for Products, Brands and More"))
		{
			return true;
		}
		else 
		{
			return false;
		}	
	}
	
	
	public void clickOnSearchInputField() 
	{
		searchInputField.click();
	}
	
	public void clickOnSearchIcon() 
	{
		searchButton.click();	
	}


	public boolean verifyTrendingProductListAppeared() {
		if(trendingProductsText.isDisplayed() && trendingProductsText.getText().equals("Trending"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	public List<String> SearchProductsForVerifySearchHistory(WebDriver driver) 
	{
		List<String> products = new ArrayList<String>();
		products.add("Mobile");
		products.add("Laptop");
		products.add("TVs");
		products.add("Watch");
		products.add("Sunglasses");
		products.add("Shoes");
		
		for(String product: products) 
		{
			searchInputField.sendKeys(product);
			searchButton.click();
			driver.navigate().back();
			
		}
		
		products.remove(0);
		Collections.reverse(products);
		
		for(String product: products) 
		{
			System.out.println("Searched product: "+product);
		}
		return products;
	}
	
	public List<String> getTextFromSearchHistory(WebDriver driver, int expectedCount) throws InterruptedException 
	{
		searchInputField.click();
		Thread.sleep(2000);
		List<String> products = new ArrayList<String>();
		for(int i=1; i<=expectedCount; i++) 
		{
			WebElement searchedHistoryText = driver.findElement(By.xpath("(//div[@class='YGcVZO'])["+i+"]"));
			
			products.add(searchedHistoryText.getText());
			System.out.println("Searched history text: "+searchedHistoryText.getText());
		}
		
		return products;
	}


	public void mouseHoverOnUserProfileIcon(WebDriver driver) {
		
		Selenium_Utils.hoverOnByActionClass(driver, loginbutton);
		
		
	}


	public List<String> expectedGetDataFromExcelSheetWithkey(String sheetName, String key) throws IOException {
		
		String values = Selenium_Utils.getDataFromExcelSheet(sheetName, key);
		String[] expectedMenuOptionsArray=values.split(",");		
		
		List<String> options = Arrays.asList(expectedMenuOptionsArray);
		
		return options;
		
	}
	
	public List<String> getUserProfileOptionListFromFlipkart(WebDriver driver) {
		List<String> options = new ArrayList<String>();
		for(int i=1; i<=9; i++) 
		{
			 String option = driver.findElement(By.xpath("(//a[@class='yx2hEq']/*[text()])["+i+"]")).getText();
			 
			 options.add(option);
		}
		
		
		for(String option: options) 
		{
			System.out.println("User Profile Option from Flipkart: "+option);
		}
		
		
		return options;
	}
	

	public boolean verifyAppearanceOfCartOption() {
		
		if(cartButton.isDisplayed() && cartButtonText.getText().equals("Cart"))
		{
			System.out.println("text of cart button --> "+cartButton.getText());
			return true;
		}
		else 
		{
			return false;
		}

	}
	
	public int beforeAddToCartCount() 
	{
	
		try {
			 String beforeAddToCartCount = countOfItemsInCart.getText();
			 
			 int beforeAddToCartCountInt = Integer.parseInt(beforeAddToCartCount);
			return beforeAddToCartCountInt;
			
		} catch (Exception e) {
		
			return 0;
			
		}	
			
	}
	
	public int afterAddToCartCount() 
	{	
		 String afterAddToCartCount = countOfItemsInCart.getText();
		 int afterAddToCartCountInt = Integer.parseInt(afterAddToCartCount);
		 return afterAddToCartCountInt;
	}
	

	
	public List<String> actualAboutSectionOptionsList(WebDriver driver) {
		
		Selenium_Utils.scrollByActions(driver, footer);
		
		List<String> listOfOptions = new ArrayList<>();
		for(WebElement options:footerAboutSectionOptionList)
		{
			listOfOptions.add(options.getText());
		}
		
		return listOfOptions;
		
	}
	
	public void clickOnContactUs() {
		
		contactUs.click();
		
	}
	

	public List<String> actualGroupComponentsSectionOptionsList(WebDriver driver) {
		
		Selenium_Utils.scrollByActions(driver, footer);
		
		List<String> listOfOptions = new ArrayList<>();
		for(WebElement options:footerGroupComponentsSectionOptionList)
		{
			listOfOptions.add(options.getText());
		}
		
		return listOfOptions;
		
	}
	

	public void clickOnMyntra() {
		
		myntra.click();
		
	}
	
	public List<String> actualHelpSectionOptionsList(WebDriver driver) {
		
		Selenium_Utils.scrollByActions(driver, footer);
		
		List<String> listOfOptions = new ArrayList<>();
		for(WebElement options:footerHelpSectionOptionList)
		{
			listOfOptions.add(options.getText());
		}
		
		return listOfOptions;
		
	}
	
	
	public void clickOnPayment() {
		
		payment.click();
		
	}
	
	
	public List<String> actualConsumerPolicySectionOptionsList(WebDriver driver) {
		
		Selenium_Utils.scrollByActions(driver, footer);
		
		List<String> listOfOptions = new ArrayList<>();
		for(WebElement options:footerConsumerPolicySectionOptionList)
		{
			listOfOptions.add(options.getText());
		}
		
		return listOfOptions;	
	}
	
	public void clickOnCancellationAndReturns() {
		
		cancellationAndReturns.click();
		
	}
	
	public void clickOnfacebookIcon() {
		
		facebookIcon.click();
		
	}
	
	public List<String> actualFooterBottomBarOptionsList(WebDriver driver) {
		
		Selenium_Utils.scrollByActions(driver, footer);
		
		List<String> listOfOptions = new ArrayList<>();
		for(WebElement options:footerBottomBarOptions)
		{
			listOfOptions.add(options.getText());
		}
		
		return listOfOptions;	
	}
	
	public void clickOnAdvertise() {
		
		advertise.click();
		
	}

}
