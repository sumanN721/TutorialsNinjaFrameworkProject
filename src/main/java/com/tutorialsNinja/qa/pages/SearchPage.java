package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search")
	private WebElement enterProductName;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	WebElement searchbutton;
	
	@FindBy(linkText="HP LP3065")
	WebElement itemFound;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	WebElement noItemsFound;
	
	public void enterProductName(String item)
	{
		enterProductName.sendKeys(item);
	}
	
	public void clickSearchbutton()
	{
		searchbutton.click();
	}
	
	public WebElement getItemFound()
	{
		return itemFound;
	}
	
	public String getNoItemsFound()
	{
		return noItemsFound.getText();
	}
	
	public SearchPage searchForProduct(String item)
	{
		enterProductName.sendKeys(item);
		searchbutton.click();
		return new SearchPage(driver);
	}
	

}
