package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-email")
	private WebElement emailInput;
	
	@FindBy(id="input-password")
	private WebElement passwordInpout;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(css = ".alert-dismissible")
	private WebElement warningMessage;
	
	
	public void enterEmail(String email)
	{
		emailInput.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordInpout.sendKeys(password);
	}
	
	public AccountPage clickOnLogin()
	{
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public WebElement warningMessage()
	{
		return warningMessage;
	}
	
	public AccountPage login(String emailText, String passwordText)
	{
		emailInput.sendKeys(emailText);
		passwordInpout.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	
	
}
