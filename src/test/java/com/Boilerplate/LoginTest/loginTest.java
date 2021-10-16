package com.Boilerplate.LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Boilerplate.pages.Base;
import com.Boilerplate.pages.LoginPage;

public class loginTest extends Base{
	
	
	@Test(priority = 1)
	public void loginTest_001() {
		LoginPage logpage=new LoginPage(driver);
		logpage.loginToApp("prem@boilerplate.co", "12345678");
		String dashboardurl=driver.getCurrentUrl();
	    Assert.assertEquals("https://app.boilerplate.co/n/requestor#dashboard", dashboardurl);
	}
     
	@Test(priority = 2)
	public void loginTest_002() {
		LoginPage logpage=new LoginPage(driver);
		String errmsg=logpage.loginWithInvalidPass("prem@boilerplate.co", "123456789");
		System.out.println(errmsg);
	    Assert.assertEquals(errmsg,"You’ve entered an incorrect password. Please check that you have entered it correctly. If that doesn’t resolve your issue, use the Forgot Password link below.");
	}
}
