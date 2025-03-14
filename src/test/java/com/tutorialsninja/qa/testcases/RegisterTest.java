package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNija.qa.base.BaseTest;
import com.tutorialsNija.qa.utils.Utilities;
import com.tutorialsNinja.qa.pages.AccountPage;
import com.tutorialsNinja.qa.pages.Homepage;
import com.tutorialsNinja.qa.pages.RegisterPage;

public class RegisterTest extends BaseTest{
	
WebDriver driver;
RegisterPage registerpage;

public RegisterTest() throws IOException
{
	super();
}

	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		driver=initilizeBrowserAndOpenApplication("chrome");
		
		Homepage homepage=new Homepage(driver);
		registerpage=homepage.navigateToRegisterPage();
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
	
	@Test(priority=1)
	public void VerifyRegisterAnAccountWithmandatoryFields()
	{
		AccountPage accountpage=registerpage.registerWithMaditoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimestamp(), dataProp.getProperty("telephoneNo"), dataProp.getProperty("password"), dataProp.getProperty("password"));
		Assert.assertEquals(accountpage.AccountCreatedConfirm(), dataProp.getProperty("accountSuccessfullyCreated"));
	}
	
	@Test(priority=2)
	public void verifyRegisterAccoundByProvidingAllFiel()
	{
		AccountPage accountpage=registerpage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimestamp(), dataProp.getProperty("telephoneNo"), dataProp.getProperty("password"), dataProp.getProperty("password"));
		Assert.assertEquals(accountpage.AccountCreatedConfirm(), dataProp.getProperty("accountSuccessfullyCreated"));
	}
	@Test(priority=3)
	public void verifyRegisterAccountWithExistingEmailAddress()
	{
		registerpage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),prop.getProperty("username"), dataProp.getProperty("telephoneNo"), dataProp.getProperty("password"), dataProp.getProperty("password"));
		Assert.assertEquals(registerpage.getDuplicateEmailAddressWarning(), dataProp.getProperty("duplicateWarningMessege"),"Account already created");
	}
	
	@Test(priority=4)
	public void verifyRegisterOnAccountWithoutFillingAnydetails()
	{
		
		registerpage.clikOnContinueButton();
		Assert.assertTrue(registerpage.getPrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")));
		Assert.assertTrue(registerpage.getFirstNameWarning().contains(dataProp.getProperty("firstNameWarning")));
		Assert.assertTrue(registerpage.getLastNameWarning().contains(dataProp.getProperty("lastNameWarning")));
		Assert.assertTrue(registerpage.getEmailWarning().contains(dataProp.getProperty("emailWarning")));
		Assert.assertTrue(registerpage.getTelephoneWarning().contains(dataProp.getProperty("telephoneWarning")));
		Assert.assertTrue(registerpage.getPasswordWarning().contains(dataProp.getProperty("passwordWarning")));
		
		
	}

}
