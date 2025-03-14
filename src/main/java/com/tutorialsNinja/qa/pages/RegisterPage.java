package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-firstname")
	private WebElement firstNameAddressField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameAddressField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordAddressField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordAddressField;
	
	@FindBy(name="agree")
	private WebElement agreeCheckBoxAddressField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButtonAddressField;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsletter;
	
	@FindBy(xpath="//div[text()='Warning: E-Mail Address is already registered!']")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	WebElement passwordWarning;
	
	public void enterFirstName(String firstname)
	{
		firstNameAddressField.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		 lastNameAddressField.sendKeys(lastname);
	}
	
	public void enterEmail(String email)
	{
		 emailAddressField.sendKeys(email);
	}
	
	public void enterTelephone(String telephone)
	{
		 telephoneAddressField.sendKeys(telephone);
	}
	
	public void enterPassword(String password)
	{
		 passwordAddressField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword)
	{
		 confirmPasswordAddressField.sendKeys(confirmPassword);
	}
	
	public void enterAgreeCheckBox()
	{
		agreeCheckBoxAddressField.click();
	}
	public AccountPage clikOnContinueButton()
	{
		 continueButtonAddressField.click();
		 return new AccountPage(driver);
	}
	
	public void enterYesNewsLetter()
	{
		 newsletter.click();
	}
	
	public String getDuplicateEmailAddressWarning()
	
	{
		return duplicateEmailAddressWarning.getText();
	}

	public String getPrivacyPolicyWarning()
	{
		return privacyPolicyWarning.getText();
	}
	
	public String getFirstNameWarning()
	{
		return firstNameWarning.getText();
	}
	
	public String getLastNameWarning()
	{
		return lastNameWarning.getText();
	}
	
	public String getEmailWarning()
	{
		return emailWarning.getText();
	}
	
	public String getTelephoneWarning()
	{
		return telephoneWarning.getText();
	}
	
	public String getPasswordWarning()
	{
		return passwordWarning.getText();
	}
	
	public AccountPage registerWithMaditoryFields(String firstname, String lastname, String  email, String telephone, String password, String confirmPassword )
	{
		firstNameAddressField.sendKeys(firstname);
		 lastNameAddressField.sendKeys(lastname);
		 emailAddressField.sendKeys(email);
		 telephoneAddressField.sendKeys(telephone);
		 passwordAddressField.sendKeys(password);
		 confirmPasswordAddressField.sendKeys(confirmPassword);
		 agreeCheckBoxAddressField.click();
		 continueButtonAddressField.click();
		 return new  AccountPage(driver);
	}
	
	public AccountPage registerWithAllFields(String firstname, String lastname, String  email, String telephone, String password, String confirmPassword )
	{
		firstNameAddressField.sendKeys(firstname);
		 lastNameAddressField.sendKeys(lastname);
		 emailAddressField.sendKeys(email);
		 telephoneAddressField.sendKeys(telephone);
		 passwordAddressField.sendKeys(password);
		 confirmPasswordAddressField.sendKeys(confirmPassword);
		 newsletter.click();
		 agreeCheckBoxAddressField.click();
		 continueButtonAddressField.click();
		 return new  AccountPage(driver);
	}
}
