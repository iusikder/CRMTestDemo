package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseTest {	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "Contact_Sheet";
	
	ContactsPageTest(){
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp(){
		init();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the Page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsByName(){
		contactsPage.selectContacts("David Chris"); //Assertion is not used here. I have to check Youtube videos to see how I can salve this problem....
	}
	
	@Test(priority=3)
	public void selectMultipleContactsByName(){
		contactsPage.selectContacts("David Chris");
		contactsPage.selectContacts("ABCD EFGH"); 
	}
	
	@Test(priority=4, dataProvider= "getCRMTestData")
	public void validateCreateNewContactsTest(String title, String fName, String lName, String compName){
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContacts(title, fName, lName, compName);	
		homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsByName("David Chris"));
	}


	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
