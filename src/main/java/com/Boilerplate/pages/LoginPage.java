package com.Boilerplate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Boilerplate.Utils.commonUtils;

public class LoginPage extends Base {
	
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
	
	@FindBy(xpath = "//div[@class=\"buttons svelte-1aorqzv\"]/child::span[1]/child::button")
	WebElement adminbtn;
	
	@FindBy(xpath="//div[@class=\"error svelte-1tn0i9i\"]")
	WebElement loginerrorElement;
	
	@FindBy(xpath ="//div[@class='error svelte-1tn0i9i']")
	WebElement invalidemail;
	
	@FindBy(xpath = "//div[@class='forgot svelte-1tn0i9i']/child::a")
	WebElement forgetlink;
	
	@FindBy(xpath = "//div[@class='input-with-icon svelte-fju3o0']/child::input")
	WebElement forgetEmail;
	
	@FindBy(xpath = "//div[@class='buttons svelte-tqwzjz']/child::span/child::button")
	WebElement sendlink;
	
	@FindBy(xpath = "//div[@class='toast-container sevelte-1ijrbo5']/child::div[@class='toast-message sevelte-1ijrbo5']")
	WebElement notificationtext;
	
	@FindBy(xpath = "//div[@class='logo svelte-1tn0i9i']/child::img")
	WebElement applogo;
	
	@FindBy(xpath = "//button[@class='primary svelte-oviy1s noLeftPad']")
	WebElement recbtn;
	@FindBy(xpath = "//button[@class='white svelte-oviy1s noLeftPad']")
	WebElement midlogoutbtn;
	
	public void commonLogin(String username,String pass) {
		 loginemail.sendKeys(username);
	     loginpass.sendKeys(pass);
	     loginbtn.click();
	}
	
	public Dashboard loginToApp() {
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
	
	public String loginWithInvalidEmail(String username,String pass) {
		 loginemail.sendKeys(username);
	     loginpass.sendKeys(pass);
	     loginbtn.click();
	     String errormsg=invalidemail.getText();
	     return errormsg;
	}
	
	public boolean isforgetlinkExist() {
		if (forgetlink.isDisplayed()) {
			return true;
		} else {
            return false;
		}
	}
	
	public String sendForgetLink(String forgetmail) {
		forgetlink.click();
		forgetEmail.sendKeys(forgetmail);
		sendlink.click();
		//utils.waitForNextAction("https://app.boilerplate.co/login");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return driver.getCurrentUrl();
	}
	
	public boolean isLogoPresent() {
		if (applogo.isDisplayed()) {
			return true;
		} else {
            return false;
		}
	}
	
	public Recipient navigateRecipient() {
		recbtn.click();
		
		return new Recipient();
	}
	
	public void midLogout() {
		if (midlogoutbtn.isDisplayed()) {
		  midlogoutbtn.click();
		} else {
           System.out.println("button not displayed");
		}
			
	}
}