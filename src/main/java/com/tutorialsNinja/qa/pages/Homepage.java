package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']") 
	private WebElement myAccoundDropdown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerButton;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnMyAccount()
	{
		myAccoundDropdown.click();
	}
	
	public LoginPage navigateToLoginPage()
	{
		loginOption.click();
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterOption() {
		registerButton.click();
		return new RegisterPage(driver);
		
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		myAccoundDropdown.click();
		registerButton.click();
		return new RegisterPage(driver);
	}
}
