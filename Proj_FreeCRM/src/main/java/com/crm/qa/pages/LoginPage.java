package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseTest;
import com.crm.qa.util.TestUtil;

public class LoginPage extends BaseTest{
	//Page Factory/ OR	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Classic CRM')]")
	WebElement linkClassicCRM;
	
	@FindBy(name="username") 
	public WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small' and @type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement linkSignUp;
	//@FindBy(xpath="//img[@class='img-responsive']")
	//WebElement crmLogo;
	
	//Initializing the Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSignUpLink(){
		return linkSignUp.isDisplayed();
	}
	
	/*public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}*/	
	
	
	public HomePage login(String uname, String pwrd){
		username.sendKeys(uname);			
		password.sendKeys(pwrd);		
		submitBtn.click();
		
		return new HomePage();
	}
	

}
