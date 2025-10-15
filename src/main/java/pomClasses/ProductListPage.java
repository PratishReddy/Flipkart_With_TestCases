package pomClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jspecify.annotations.Nullable;
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
	@FindBy(xpath = "//span[@class='BUOuZu']/span[text()]") private WebElement searchedText;
	@FindBy(xpath = "//input[@class='zDPmFV']") private WebElement searchedTextInInputField;
	@FindBy(xpath = "//div[@class='zg-M3Z _0H7xSG']") private WebElement sortByOptionSelected;
	@FindBy(xpath = "//div[@class='sHCOk2']/div[text()]") private List<WebElement> sortByOptions;
	@FindBy(xpath = "(//div[@class='KzDlHZ'])[1]") private WebElement firstProductTitle;
	@FindBy(xpath = "//div[@class='KzDlHZ']") private List<WebElement> allProductTitles;
	@FindBy(xpath = "//div[@class='yPq5Io']") private List<WebElement> allProductImages;
	@FindBy(xpath = "//div[@class='Nx9bqj _4b5DiR']") private List<WebElement> allProductPrices;
	@FindBy(xpath = "//div[@class='A8uQAd']//div[@class='XqNaEv']") private List<WebElement> allCheckBoxesAddToCompare;
	@FindBy(xpath = "//a[@class='RCafFg']") private WebElement comparePopUp;
	@FindBy(xpath = "//div[@class='_7WsdxO']") private List<WebElement> allTooltip;
	@FindBy(xpath = "//div[@class='kPozUL']") private WebElement snackBar;
	@FindBy(xpath = "//span[text()='REMOVE ALL']") private WebElement comparePopUpRemoveAllButton;
	@FindBy(xpath = "//div[@class='_0BvurA']/section") private List<WebElement> filterSections;
	
	
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
	
	public boolean verifyNavigateToProductListPage(WebDriver driver) {
		
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
	
	@SuppressWarnings("deprecation")
	public String expectedSearchedProductText() {
		
	return searchedTextInInputField.getAttribute("value");
		
	}
	
	public String searchedProductTextInProductList() {
		
		return searchedText.getText();
		
	}
	
	
	public boolean verifyRelevanceSortByOptionSelected() {
		
		if(sortByOptionSelected.getText().equals("Relevance"))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyCountOfProducts() {
		
		int countOfProduct = listOfProduct.size();
		
		System.out.println("Count Of Product --> "+countOfProduct);
		
		if(countOfProduct == 24)
		{
			return true;
		}
		else {
			return false;
		}
	
	}
	
	public List<String> actualSortByOptions() {
		
		List<String> list = new ArrayList<>();
		
		for(WebElement options : sortByOptions)
		{
			list.add(options.getText());
		}
			
		return list;
	}
	

	public String productTitleColour() {
		
		
		return firstProductTitle.getCssValue("color");
		
	}
	
	public void hoverOnfirstProductTitle(WebDriver driver) {
		
		Selenium_Utils.hoverOnByActionClass(driver, firstProductTitle);
		
	}
	
	public boolean verifyProductImages(WebDriver driver) {
	    boolean allVisible = true;

	    for (WebElement image : allProductImages) {
	        Selenium_Utils.scrollByActions(driver, image);

	        try { 
	        	Selenium_Utils.visibilityOf(driver, 5, image);
	        	
	            if (!image.isDisplayed()) {
	                System.out.println("Image not displayed: " + image);
	                allVisible = false;
	            }
	        } catch (Exception e) {
	            System.out.println("Exception while verifying image: " + e.getMessage());
	            allVisible = false;
	        }
	    }

	    System.out.println(allVisible ? "All product images are visible"
	                                  : "Some product images are not visible");
	    return allVisible;
	}

	
	
	public boolean verifyProductTitle(WebDriver driver) {
		
		boolean allVisible = true;

	    for (WebElement title : allProductTitles) {
	        Selenium_Utils.scrollByActions(driver, title);

	        try { 
	        	Selenium_Utils.visibilityOf(driver, 5, title);
	        	
	            if (!title.isDisplayed()) {
	                System.out.println("Title not displayed: " + title);
	                allVisible = false;
	            }
	        } catch (Exception e) {
	            System.out.println("Exception while verifying title: " + e.getMessage());
	            allVisible = false;
	        }
	    }

	    System.out.println(allVisible ? "All product titles are visible"
	                                  : "Some product titles are not visible");
	    return allVisible;
		
	}

	public boolean verifyProductPrice(WebDriver driver) {
	
		boolean allVisible = true;

	    for (WebElement price : allProductPrices) {
	        Selenium_Utils.scrollByActions(driver, price);

	        try { 
	        	Selenium_Utils.visibilityOf(driver, 5, price);
	        	
	            if (!price.isDisplayed()) {
	                System.out.println("Price not displayed: " + price);
	                allVisible = false;
	            }
	        } catch (Exception e) {
	            System.out.println("Exception while verifying price: " + e.getMessage());
	            allVisible = false;
	        }
	    }

	    System.out.println(allVisible ? "All product prices are visible"
	                                  : "Some product prices are not visible");
	    return allVisible;
		
	}
	
	public boolean verifyProductAddToCompare() throws InterruptedException {
		
		allCheckBoxesAddToCompare.get(1).click();
		Thread.sleep(1000);
		if(comparePopUp.isDisplayed())
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean verifyComparePopup() throws InterruptedException {
		
		allCheckBoxesAddToCompare.get(1).click();
		Thread.sleep(1000);
		if(comparePopUp.isDisplayed())
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean verifyTooltipOfComapareProducts(WebDriver driver) throws InterruptedException {
		
		allCheckBoxesAddToCompare.get(0).click();
		Thread.sleep(500);
		
		if(allTooltip.get(0).isDisplayed())
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean verifyAddToCompareMaximumProducts() throws InterruptedException {
		
		for(int i=0; i<=4;  i++)
		{
			allCheckBoxesAddToCompare.get(i).click();
		}
		Thread.sleep(500);
		
		if (snackBar.isDisplayed()) 
		{
			
			return true;
			
		}
		else {
			return false;
		}
		
		
	}
	
	public boolean verifyCompareTooltipRemoveAllButton(WebDriver driver) throws InterruptedException {
		
		for(int i=0; i<=3;  i++)
		{
			allCheckBoxesAddToCompare.get(i).click();
		}
		
		comparePopUpRemoveAllButton.click();
		Thread.sleep(500);
		
		try {
			comparePopUp.isDisplayed();
			return false;
			
		} catch (Exception e) {
			
			return true;
		}
		
	}
	
	public boolean veriryFilterSection(WebDriver driver) {
		
		boolean allVisible = true;

	    for (WebElement sections : filterSections) {

	        try { 
	        	Selenium_Utils.visibilityOf(driver, 5, sections );
	        	
	            if (!sections.isDisplayed()) {
	                System.out.println("Filter section displayed: " + sections);
	                allVisible = false;
	            }
	        } catch (Exception e) {
	            System.out.println("Exception while verifying Filter section: " + e.getMessage());
	            allVisible = false;
	        }
	    }

	    System.out.println(allVisible ? "All Filter sections visible"
	                                  : "Some Filter sections are not visible");
	    return allVisible;
	
	}
	
	
	public void veriryFilter() {
		
		
		
	}
	
	
	
	
}
