package testClasses;

import java.io.IOException;

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

public class LoginFunctionality extends BaseClass{ 
	
	SoftAssert soft;
	
	HomePage home;
	LoginPage login;
	ProductListPage productList;
	
	@BeforeClass
	public void beforeClass() throws IOException 
	{
		soft = new SoftAssert();
		
		launchBrowser("chrome");
		home = new HomePage(driver);
		login = new LoginPage(driver);
		productList = new ProductListPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{

	}
	
	@Test(priority = 1)
	public void verifyLoginScreen()
	{
		home.clickOnLoginButton();
		soft.assertTrue(login.verifyLoginScreen(driver), "Login screen is not displayed, TC is fail");
		driver.navigate().back();
	}
	
	@Test(priority = 2)
	public void  VerifyEnteredMobileNumber() throws IOException, InterruptedException 
	{
		home.clickOnLoginButton();
		soft.assertEquals(login.enterMobileNumberInInputField(), login.getTextFromMobileNumberInInputField(), "Mobile number is not matching, TC is fail");
		driver.navigate().back();
	
	}
	
	@Test(priority = 3)
	public void verifyEnterOTPField() throws IOException, InterruptedException 
	{
		home.clickOnLoginButton();
		login.enterMobileNumberInInputField();
		login.clickOnRequestOTPButton();
		soft.assertTrue(login.verifyEnterOTPField(), "Enter OTP field is not displayed, TC is fail");
		driver.navigate().back();
	
	}
	
	@Test(priority = 4)
	public void verifyErrorMassage() throws IOException, InterruptedException  
	{
		home.clickOnLoginButton();
		login.enterInvalidMobileNumberInInputField();
		login.clickOnRequestOTPButton();
		soft.assertTrue(login.verifyErrorMassage(), "Error massage is not displayed, TC is fail");
		driver.navigate().back();
		
	}
	
	@Test(priority = 5)
	public void  verifyToastMassage() throws IOException, InterruptedException 
	{
		home.clickOnLoginButton();
		login.enternotRegistedMobileNumberInInputField(driver);
		login.clickOnRequestOTPButton();
		soft.assertTrue(login.verifyToastMassage(), "Toast massage is not displayed, TC is fail");
		driver.navigate().back();
	}
	
	@Test(priority = 6)
	public void verifyHomeScreen() throws IOException, InterruptedException 
	{
		home.clickOnLoginButton();
		login.enterMobileNumberInInputField();
		login.clickOnRequestOTPButton();
		soft.assertTrue(home.verifyHomeScreen(driver), "Home screen is not displayed, TC is fail");
		driver.navigate().back();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		
	}
	
	@AfterClass
	public void afterClass()
	{
		if(driver!=null) 
		{
			driver.quit();
		}
		
	}
	

}
