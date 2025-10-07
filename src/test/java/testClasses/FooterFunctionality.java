package testClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClasses.BaseClass;
import pomClasses.Contactpage;
import pomClasses.FacebookPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.MyntraPage;
import pomClasses.PaymentPage;
import pomClasses.PolicyOfCancellationAndReturnsPage;
import utils.Selenium_Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterClass;

public class FooterFunctionality extends BaseClass {
 
	SoftAssert soft;
	
	HomePage home;
	LoginPage login;
	Contactpage contact;
	MyntraPage myntra;
	PaymentPage payment;
	PolicyOfCancellationAndReturnsPage policyOfCancellationAndReturns;
	FacebookPage facebook;
	
	@BeforeClass

	public void beforeClass() throws IOException 
	{
		soft = new SoftAssert();
		
		launchBrowser("chrome");
		
		home = new HomePage(driver);
		login = new LoginPage(driver);
		contact = new Contactpage(driver);
		myntra = new MyntraPage(driver);
		payment = new PaymentPage(driver);
		policyOfCancellationAndReturns = new PolicyOfCancellationAndReturnsPage(driver);
		facebook = new FacebookPage(driver);
		
//		home.clickOnLoginButton();
//		login.enterMobileNumberInInputField();
//		login.clickOnRequestOTPButton();
//		home.verifyHomeScreen(driver);
	}
 
	@BeforeMethod
  

	public void beforeMethod() {
  
	}
  
  
	@Test(priority = 1)
	public void verifyPresenceOfAboutSectionOptions() throws IOException {
		
		List<String> actual = home.actualAboutSectionOptionsList(driver);
		List<String> expected = home.expectedGetDataFromExcelSheetWithkey("HomePageData", "About section options");
		
		for(int i=0; i<actual.size(); i++)
		{
			System.out.println("actualAboutSectionOptionsList--> "+actual.get(i));
			System.out.println("expectedGetDataFromExcelSheetWithkey--> "+expected.get(i));
		}
		
		soft.assertEquals(actual, expected);
		soft.assertAll();
  
	}
	
	@Test(priority = 2)
	public void verifyNavigateToContactPage() {
		
		home.clickOnContactUs();
		soft.assertTrue(contact.contactPageVerify());
		soft.assertAll();
		driver.navigate().back();
		
	}
	
	@Test(priority = 3)
	public void verifyPresenceOfGroupComponentsSectionOptions() throws IOException {
		
		List<String> actual = home.actualGroupComponentsSectionOptionsList(driver);
		List<String> expected = home.expectedGetDataFromExcelSheetWithkey("HomePageData", "Group Components Section Options");
		
		for(int i=0; i<actual.size(); i++)
		{
			System.out.println("actualGroupComponentsSectionOptionsList--> "+actual.get(i));
			System.out.println("expectedGetDataFromExcelSheetWithkey--> "+expected.get(i));
		}
		
		soft.assertEquals(actual, expected);
		soft.assertAll();
		
	}
	@Test(priority = 4)
	public void verifyNavigateToMyntraPage() throws InterruptedException {
		
		home.clickOnMyntra();
		Selenium_Utils.switchFocus(driver, 1);
		soft.assertTrue(myntra.myntraPageVerify(driver));
		soft.assertAll();
		driver.close();
		Thread.sleep(1000);
		
	}
	
	@Test(priority = 5)
	public void verifyPresenceOfHelpSectionOptions() throws IOException {
		
		List<String> actual = home.actualHelpSectionOptionsList(driver);
		List<String> expected = home.expectedGetDataFromExcelSheetWithkey("HomePageData", "Help Section Options");
		
		for(int i=0; i<actual.size(); i++)
		{
			System.out.println("actualHelpSectionOptionsList--> "+actual.get(i));
			System.out.println("expectedGetDataFromExcelSheetWithkey--> "+expected.get(i));
		}
		
		soft.assertEquals(actual, expected);
		soft.assertAll();
		
		
	}
	
	
	@Test(priority = 6)
	public void verifyNavigateToPaymentsPage() {
		
		home.clickOnPayment();
		soft.assertTrue(payment.paymentPageVerify());
		soft.assertAll();
		driver.navigate().back();

	}
	
	@Test(priority = 7)
	public void verifyPresenceOfConsumerPolicySectionOptions() throws IOException {
		
		List<String> actual = home.actualConsumerPolicySectionOptionsList(driver);
		List<String> expected = home.expectedGetDataFromExcelSheetWithkey("HomePageData", "Consumer Policy Section Options");
		
		for(int i=0; i<actual.size(); i++)
		{
			System.out.println("actualConsumerPolicySectionOptionsList--> "+actual.get(i));
			System.out.println("expectedGetDataFromExcelSheetWithkey--> "+expected.get(i));
		}
		
		soft.assertEquals(actual, expected);
		soft.assertAll();

	}
	
	
	@Test(priority = 8)
	public void verifyNavigateToCancellationAndReturnsPage() {
		
		home.clickOnCancellationAndReturns();
		soft.assertTrue(policyOfCancellationAndReturns.policyOfCancellationAndReturnsPageVerify());
		soft.assertAll();
		driver.navigate().back();

	}
	
	@Test(priority = 9)
	public void verifyNavigateToFacebookPage() {
		
		home.clickOnfacebookIcon();
		soft.assertTrue(facebook.facebookPageVerify());
		soft.assertAll();
		driver.navigate().back();

	}
	
	@Test(priority = 10)
	public void verifyPresenceOfFooterBottomBarOptions() throws IOException {
		
		List<String> actual = home.actualFooterBottomBarOptionsList(driver);
		List<String> expected = home.expectedGetDataFromExcelSheetWithkey("HomePageData", "Footer Bottom Bar Options");
		
		for(int i=0; i<actual.size(); i++)
		{
			System.out.println("actualFooterBottomBarOptionsList--> "+actual.get(i));
			System.out.println("expectedGetDataFromExcelSheetWithkey--> "+expected.get(i));
		}
		
		soft.assertEquals(actual, expected);
		soft.assertAll();

	}
	
	@Test(priority = 11)
	public void verifyNavigateToAdvertisePage ()
	{
		home.clickOnAdvertise();
		
	}
	
	
	
  
	@AfterMethod
 
  
	public void afterMethod() {
  
	}

 

  
	@AfterClass
  
  
	public void afterClass() {
  
	}


}
