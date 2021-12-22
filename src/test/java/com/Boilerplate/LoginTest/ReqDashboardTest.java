package com.Boilerplate.LoginTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Boilerplate.Utils.GetExcelData;
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
	
	@Test(priority = 1,enabled = false)
	public void verifySearchField() {
	     loginpage.commonLogin("prem@boilerplate.co", "12345678");
	     loginpage.loginToApp();
	     boolean searchval=dashboard.searchFieldExist();
	     Assert.assertEquals(searchval, true);
    }
	
	@Test(priority = 2,enabled = false)
	public void allMenulinks() {
		 loginpage.commonLogin("prem@boilerplate.co", "12345678");
	     loginpage.loginToApp();
	     String element=dashboard.getListElements();
	     System.out.println(element);
	     Assert.assertEquals(element, "Dashboard, Checklists, Templates, Contacts, Review, Preferences, Log Out, ");
	}
	
	@Test(priority = 3,enabled = false)
	public void verifySearchResult() {
		loginpage.commonLogin("prem@boilerplate.co", "12345678");
	    loginpage.loginToApp();
	    try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    String searchval=dashboard.searchResult();
	    System.out.println(searchval);
	    Assert.assertEquals(searchval, GetExcelData.getSearchData());    
	}
	
	@Test(priority=4,enabled = false)
	public void switchToNextMenu() {
		loginpage.commonLogin("prem@boilerplate.co", "12345678");
	    loginpage.loginToApp();
	    boolean switchmenu=dashboard.switchToMenuLink();
	    Assert.assertTrue(switchmenu);
	}
	
	@Test(priority=5,enabled = true)
	public void deleteContact() {
		loginpage.commonLogin("prem@boilerplate.co", "12345678");
	    loginpage.loginToApp();
	    dashboard.deletefromDashboard();
	}
	
	
	
}