package com.Boilerplate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder=\"Email Address\"]")
	WebElement loginemail;
	
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	WebElement loginpass;
	
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement loginbtn;
	
	@FindBy(xpath = "//div[@class=\"buttons svelte-1n94w13\"]/child::span[1]/child::button")
	WebElement adminbtn;
	
	@FindBy(xpath="//div[@class=\"error svelte-1tn0i9i\"]")
	WebElement loginerrorElement;
	
	public Dashboard loginToApp(String username,String pass) {
		     loginemail.sendKeys(username);
		     loginpass.sendKeys(pass);
		     loginbtn.click();
		     adminbtn.click();
		     
		     return new Dashboard();   
	}
	
	public String loginWithInvalidPass(String username,String pass) {
		 loginemail.sendKeys(username);
	     loginpass.sendKeys(pass);
	     loginbtn.click();
	     String errormsg=loginerrorElement.getText();
	     return errormsg;
	}
}