package com.tutorialsninja.qa.testcases;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tutorialsNija.qa.base.BaseTest;
import com.tutorialsNija.qa.utils.Utilities;
import com.tutorialsNinja.qa.pages.AccountPage;
import com.tutorialsNinja.qa.pages.Homepage;
import com.tutorialsNinja.qa.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	WebDriver driver;
	
	LoginPage loginpage;
	public LoginTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver=initilizeBrowserAndOpenApplication(prop.getProperty("browser"));
		Homepage homepage=new Homepage(driver);
		homepage.clickOnMyAccount();
		loginpage=homepage.navigateToLoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}

	@Test(priority=1, dataProvider="testData")
	public void verifyLoginWithValidCredentials(String username, String password)
	{
		
		AccountPage accountPage=loginpage.login(username, password);
		Assert.assertTrue(accountPage.verifyAccount().isDisplayed());
	}
	
	
	@DataProvider(name="testData")
	public String[][] testData() throws IOException
	{
		String[][] testData=Utilities.getTestDatafromExcel("suman");
		return testData;
	}
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials()
	{
		loginpage.login("suman"+Utilities.generateEmailWithTimestamp()+"@gmail.com", dataProp.getProperty("invalidaPassword"));
		Assert.assertTrue(loginpage.warningMessage().isDisplayed());
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword()
	{
		loginpage.enterEmail("suman"+Utilities.generateEmailWithTimestamp()+"@gmail.com");
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickOnLogin();
		Assert.assertTrue(loginpage.warningMessage().isDisplayed());
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword()
	{
		loginpage.login(prop.getProperty("username"), dataProp.getProperty("invalidaPassword"));
		Assert.assertTrue(loginpage.warningMessage().isDisplayed());
	}
	
	@Test(priority=5)
	public void VerifyWithoutProvidingCredentials()
	{
		loginpage.clickOnLogin();
		Assert.assertTrue(loginpage.warningMessage().isDisplayed());
	}
	
	
	
}
