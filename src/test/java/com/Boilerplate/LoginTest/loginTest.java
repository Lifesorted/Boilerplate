package com.Boilerplate.LoginTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Boilerplate.pages.Base;
import com.Boilerplate.pages.LoginPage;

public class loginTest extends Base{
	
	LoginPage loginPage;
	
	public loginTest() {
		super();
	}
	
	@BeforeMethod
	public void initializeObject() {
		loginPage=new LoginPage(driver);
	}
	
	@Test(priority = 1,enabled = false)
	public void loginTest_001() {
		loginPage.commonLogin("prem@boilerplate.co", "12345678");
		loginPage.loginToApp();
		String dashboardurl=driver.getCurrentUrl();
	    Assert.assertEquals("https://app.boilerplate.co/n/requestor#dashboard", dashboardurl);
	}
     
	@Test(priority = 2,enabled = false)
	public void loginTest_002() {
		String errmsg=loginPage.loginWithInvalidPass("prem@boilerplate.co", "123456789");
		System.out.println(errmsg);
	    Assert.assertEquals(errmsg,"You’ve entered an incorrect password. Please check that you have entered it correctly. If that doesn’t resolve your issue, use the Forgot Password link below.");
	}
	
	@Test(priority = 3,enabled = false)
	public void loginTest_003() {
		String  errEmail=loginPage.loginWithInvalidEmail("prem@boilerplate.com", "12345678");
		System.out.println(errEmail);
		Assert.assertEquals(errEmail, "The email address you provided was not found. Please double check that you provided the correct one.");
	}
	
	@Test(priority = 4,enabled = false)
	public void loginTest_004() {
		Boolean  boolstatus=loginPage.isforgetlinkExist();
		System.out.println(boolstatus);
		Assert.assertTrue(boolstatus);
	}
	
	@Test(priority = 5,enabled = false)
	public void forgetLink_Test() {
	    String currenturl=	loginPage.sendForgetLink("baba@yopmail.com");
	    System.out.println(currenturl);
	    Assert.assertEquals(currenturl, "https://app.boilerplate.co/login");
	}
	
	@Test(priority = 6,enabled = false)
	public void isLogo_Present() {
		Boolean logostatus=loginPage.isLogoPresent();
		Assert.assertTrue(logostatus);
	}

	@Test(priority = 7,enabled=false)
	public void loginToRecipient() {
		loginPage.commonLogin("prem@boilerplate.co", "12345678");
		loginPage.navigateRecipient();
		String urlString=driver.getCurrentUrl();
		Assert.assertEquals(urlString, "https://app.boilerplate.co/n/recipientc");
	}
	
	@Test(priority = 8,enabled = true)
	public void modLogoutTest() {
		loginPage.commonLogin("prem@boilerplate.co", "12345678");
		loginPage.midLogout();
		String currenturl=driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://app.boilerplate.co/login");
	}
	
	
	
}