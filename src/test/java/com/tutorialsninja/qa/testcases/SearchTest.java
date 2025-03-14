package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNija.qa.base.BaseTest;
import com.tutorialsNinja.qa.pages.SearchPage;

public class SearchTest extends BaseTest{
	WebDriver driver;
	SearchPage searchpage;
	
	public SearchTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver=initilizeBrowserAndOpenApplication("chrome");
		searchpage=new SearchPage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct()
	{
		searchpage=searchpage.searchForProduct("HP");
		Assert.assertTrue(searchpage.getItemFound().isDisplayed());
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidaProduct()
	{
		searchpage=searchpage.searchForProduct("Hundai");
		Assert.assertEquals(searchpage.getNoItemsFound(),"There is no product that matches the search criteria.");
	}
	
	@Test(priority=3)
	public void verifyWithoutProvidingAnyProduct()
	{
		searchpage=searchpage.searchForProduct("");
		Assert.assertEquals(searchpage.getNoItemsFound(),"There is no product that matches the search criteria.");
	}

}
