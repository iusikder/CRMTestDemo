package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
//IMPORTANT NOTE: Application has changed recently, so I started the application from the Login Page. 
//Not from the actual Page.

public class LoginPageTest extends BaseTest {
	LoginPage loginPage;	
	TestUtil testUtil;
	HomePage homePage;
	
	public LoginPageTest(){ 
		super();           //super keyword will call the Constructor of Super Class
	}
	
	
	
	
	@BeforeMethod
	public void setUp(){
		init();
		loginPage = new LoginPage();		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO Log In Screen");	
	}
	
	//This is not required, because I'm starting the page in different way.
	/*@Test(priority=2)
	public void signUpLinkTest() throws Exception{
		testUtil.wait(4);
		//Thread.sleep(4000);
		boolean flag = loginPage.validateSignUpLink();
		Assert.assertTrue(flag);
	}*/
	
	@Test(priority=2)
	public void login(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void teadDown(){
		driver.quit();
	}
}






