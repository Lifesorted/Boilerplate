package com.Boilerplate.LoginTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Boilerplate.pages.Base;
import com.Boilerplate.pages.Dashboard;
import com.Boilerplate.pages.LoginPage;

public class ReqDashboardTest extends Base{

	LoginPage loginpage;
	Dashboard dashboard;
	
	@BeforeMethod
	public void initialize() {
		loginpage=new LoginPage(driver);
		dashboard=new Dashboard(driver);
	}
	
	@Test(priority = 0,enabled = false)
	public void dashboardViewTest() {
         loginpage.commonLogin("prem@boilerplate.co", "12345678");
         loginpage.loginToApp();
         String checklisturl=dashboard.verifyDashboard();
         Assert.assertEquals(checklisturl, "https://app.boilerplate.co/n/requestor#checklists");
	}
	
	@Test(priority = 1,enabled = true)
	public void verifySearchField() {
	     loginpage.commonLogin("prem@boilerplate.co", "12345678");
	     loginpage.loginToApp();
	     boolean searchval=dashboard.searchFieldExist();
	     Assert.assertEquals(searchval, true);
    }
}