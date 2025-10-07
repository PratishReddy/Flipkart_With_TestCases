package testClasses;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.ProductListPage;
import pomClasses.ProductPage;
import utils.Selenium_Utils;

public class TopMenubarFunctionality extends BaseClass{
	
	SoftAssert soft;
	
	HomePage home;
	LoginPage login;
	ProductListPage productList;
	ProductPage product;
	
	@BeforeClass
	public void beforeClass() throws IOException 
	{
		soft = new SoftAssert();
		
		launchBrowser("chrome");
		
		home = new HomePage(driver);
		login = new LoginPage(driver);
		productList = new ProductListPage(driver);
		product = new ProductPage(driver);
		
		home.clickOnLoginButton();
		login.enterMobileNumberInInputField();
		login.clickOnRequestOTPButton();
		home.verifyHomeScreen(driver);
		
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@Test(priority = 1)
	public void verifyPresenceOfFlipkartImage() 
	{
		soft.assertTrue(home.verifyPresenceOfFlipkartImage(), "Flipkart Image is not displayed on Home Page");
		soft.assertAll();
		
	}
	
	@Test(priority = 2)
	public void verifyPageReloadAndNavigateToHomePage() throws IOException, InterruptedException 
	{
		home.searchProduct("Mobile");
		home.clickOnSearchIcon();
		productList.clickOnFlipkartImage(driver);
		soft.assertTrue(home.verifyPageReloadAndNavigateToHomePage(), "After clicking on Flipkart Image, Page is not reloaded and not navigated to Home Page");
		soft.assertAll();
	}
	
	@Test(priority = 3)
	public void VerifyPresenceOfSearchField() throws IOException, InterruptedException 
	{
		soft.assertTrue(home.VerifyPresenceOfSearchField(), "Search Input Field is not displayed on Home Page");
		soft.assertAll();
	}
	
	@Test(priority = 4)
	public void verifyTrendingProductListAppeared() throws IOException, InterruptedException 
	{
		home.clickOnSearchInputField();
		soft.assertTrue(home.verifyTrendingProductListAppeared(), "Trending Product List is not appeared after clicking on Search Input Field");
		soft.assertAll();
		home.clickOnSearchIcon();
	}
	
	@Test(priority = 5)
	public void verifySearchHistoryTextAppeared() throws IOException, InterruptedException 
	{
		soft.assertEquals(home.SearchProductsForVerifySearchHistory(driver), home.getTextFromSearchHistory(driver,5), "Search History Text is not appeared after searching a product");
		soft.assertAll();
	}
	
	
	@Test(priority = 6)
	public void verifySearchIconClickable() throws IOException, InterruptedException 
	{
		home.clickOnSearchInputField();
		home.searchProduct("Mobile");
		home.clickOnSearchIcon();
		soft.assertTrue(productList.verifySearchIconClickable(driver), "After clicking on Search Icon, Product List is not displayed");
		soft.assertAll();
		driver.navigate().back();
	}
	
	@Test(priority = 7)
	public void verifyUserProfileOptionListAppeared() throws IOException, InterruptedException 
	{	
		home.mouseHoverOnUserProfileIcon(driver);
		
		List<String> expectedListOptions = home.expectedGetDataFromExcelSheetWithkey("HomePageData", "ProfileMenu options");	
		List<String> actualListOptions = home.getUserProfileOptionListFromFlipkart(driver);
		
		
		for(int i=0; i<=expectedListOptions.size()-1; i++)
		{
			System.out.println("actualListOptions--> "+actualListOptions.get(i));
			System.out.println("expectedListOptions --> "+expectedListOptions.get(i));
			
			soft.assertTrue(actualListOptions.get(i).contains(expectedListOptions.get(i)));
			soft.assertAll();
		}
	}
	
	@Test(priority = 8)
	public void verifyAppearanceOfCartOption() throws IOException, InterruptedException 
	{
		soft.assertTrue(home.verifyAppearanceOfCartOption(), "Cart Option is not displayed on Top Menubar");
		soft.assertAll();
		
	}
	
	@Test(priority = 9)
	public void verifyTheCartItemCount() throws IOException, InterruptedException 
	{
		int before = home.beforeAddToCartCount();
		home.searchProduct("Mobile");
		home.clickOnSearchIcon();
		productList.clickOnFirstProduct(driver);
		Selenium_Utils.switchFocus(driver, 1);
		product.clickOnAddToCartButton(driver);
		driver.close();
		Selenium_Utils.switchFocus(driver, 0);
		driver.navigate().back();
		driver.navigate().refresh();
		int after = home.afterAddToCartCount();
		
		System.out.println("beforeAddToCartCount--> "+ before);
		System.out.println("afterAddToCartCount--> "+after);
		
		soft.assertEquals(after,(before+1), "Product not added to cart" );	
		soft.assertAll();
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}

}
