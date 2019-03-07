package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseTest;

public class ContactsPage extends BaseTest {	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();		
	}
	
	public void selectContacts(String name){
		 driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContacts(String title, String fName, String lName, String compName){
		//Title
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);

		firstName.sendKeys(fName);  	//First Name
		lastName.sendKeys(lName);       //Last Name
		companyName.sendKeys(compName);  //Company Name
		saveBtn.click();                 //Save Button
		
	}
	
	//Selecting CheckBox (Divided into two lines)
	public boolean verifyContactsByName(String name){
		return driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
			   + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).isDisplayed();																		   
	}
		
	
	
	
	
	
	
}