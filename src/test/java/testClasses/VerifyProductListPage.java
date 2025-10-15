package testClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.ProductListPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterClass;

public class VerifyProductListPage extends BaseClass {
	
	SoftAssert soft;
	
	HomePage home;
	LoginPage login;
	ProductListPage productL;
	
	@BeforeClass
	  
	public void beforeClass() throws IOException {
		  
		 
		launchBrowser("Chrome");
		
		home = new HomePage(driver);
		login = new LoginPage(driver);
		productL = new ProductListPage(driver);
		
		soft = new SoftAssert();
		
//		home.clickOnLoginButton();
//		login.enterMobileNumberInInputField();
//		login.clickOnRequestOTPButton();
//		home.verifyHomeScreen(driver);
	  }
 
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		
		home.searchProduct("Mobile");
		home.clickOnSearchIcon();
 
	}
  
  
	@Test(priority = 1)
	public void verifyNavigateToProductListPage() throws InterruptedException, IOException {
		
		soft.assertTrue(productL.verifyNavigateToProductListPage(driver));
		soft.assertAll();

	}
	
	@Test(priority = 2)
	public void verifySerchedTextInProductListPage() {
		
		String actual = productL.searchedProductTextInProductList();
		String expected = productL.expectedSearchedProductText();
		
		System.out.println("actual --> " + actual);
		System.out.println("expected --> " + expected);
		
		soft.assertEquals(actual,expected, "Serched Text InProductList Page is not Present" );
		soft.assertAll();
	
	}
	
	@Test(priority = 3)
	public void verifyRelevanceSortByOptionSelected() {
		
		soft.assertTrue(productL.verifyRelevanceSortByOptionSelected(), "Relevance SortBy Option Not Selected");
		soft.assertAll();
		
		
	}
	
	@Test(priority = 4)
	public void verifyCountOfProducts() {
		
		soft.assertTrue(productL.verifyCountOfProducts(), "count of products are not 24");
		soft.assertAll();
	}
	
	@Test(priority = 5)
	public void verifyPresenceOfSortBy () throws IOException {
		
		List<String> actual = productL.actualSortByOptions();
		List<String> expected = home.expectedGetDataFromExcelSheetWithkey("ProductlistPage", "Sort By Options");
		
		for(int i=0; i<actual.size(); i++)
		{
			System.out.println("Actual options --> " + actual.get(i));
			System.out.println("Expected options --> " + expected.get(i));
		}
		
		soft.assertEquals(actual, expected, "sort By options are not present.");
		
		
	}
	
	@Test(priority = 6)
	public void verifyProductTitleChangeColour()
	{
		String beforeHoverProductTitleColour = productL.productTitleColour();
		productL.hoverOnfirstProductTitle(driver);
		String afterHoverProductTitleColour = productL.productTitleColour();
		System.out.println("beforeHoverProductTitleColour --> "+beforeHoverProductTitleColour);
		System.out.println("afterHoverProductTitleColour --> "+afterHoverProductTitleColour);
		
		soft.assertNotEquals(beforeHoverProductTitleColour, afterHoverProductTitleColour, "Product Title not Change Colour after hovering");
		soft.assertAll();
	}
	
	@Test(priority = 7)
	public void verifyProductImages() throws InterruptedException {
		
		soft.assertTrue(productL.verifyProductImages(driver), "Product image is not visible.");
		soft.assertAll();
	}
	
	@Test(priority = 8)
	public void verifyProductTitle() {
		
		soft.assertTrue(productL.verifyProductTitle(driver), "Product Title is not visible.");
		soft.assertAll();
	
	}
	
	@Test(priority = 9)
	public void verifyProductPrice() {
		
		soft.assertTrue(productL.verifyProductPrice(driver), "Product Price is not visible.");
		soft.assertAll();
	
	}
	
	@Test(priority = 10)
	public void verifyProductAddToCompare() throws InterruptedException {
		
		soft.assertTrue(productL.verifyProductAddToCompare(), "Product Not Add To Compare");
		soft.assertAll();
		
	}
	
	@Test(priority = 11)
	public void verifyComparePopup() throws InterruptedException {
		
		soft.assertTrue(productL.verifyProductAddToCompare(), "Product Not Add To Compare");
		soft.assertAll();
		
	}
	
	@Test(priority = 12)
	public void verifyTooltipOfComapareProducts() throws InterruptedException {
		
		soft.assertTrue(productL.verifyTooltipOfComapareProducts(driver), "Tooltip Of Comapare Products not visible.");
		soft.assertAll();
		
	}
	
	@Test(priority = 13)
	public void verifyAddToCompareMaximumProducts() throws InterruptedException {
		
		soft.assertTrue(productL.verifyAddToCompareMaximumProducts(), " Add To Compare Maximum Products is not 4");
		soft.assertAll();
		
	}
	
	@Test(priority = 14)
	public void verifyCompareTooltipRemoveAllButton() throws InterruptedException {
		
		soft.assertTrue(productL.verifyCompareTooltipRemoveAllButton(driver), "Compare Tooltip RemoveAll Button Not Working");
		soft.assertAll();
		
	}
	
	@Test(priority = 15)
	public void veriryFilterSection() throws InterruptedException {
		
		soft.assertTrue(productL.veriryFilterSection(driver), "Filter Section not visible");
		soft.assertAll();
		
	}
	
	@Test(priority = 16)
	public void veriryFilter() throws InterruptedException {
		
		soft.assertTrue(productL.veriryFilterSection(driver), "Filter Section not visible");
		soft.assertAll();
		
	}
	

  @AfterMethod
  public void afterMethod() {
	  
	  driver.navigate().back();
  }


  

  @AfterClass
  public void afterClass() {
	  
	  if(driver!=null) 
		{
			driver.quit();
		}
  }

}
