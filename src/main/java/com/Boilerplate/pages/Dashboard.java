package com.Boilerplate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends Base {
	
	public Dashboard() {
		// TODO Auto-generated constructor stub
	}
	
	public Dashboard(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Checklists']")
	WebElement checklist;
	
	@FindBy(xpath="//input[@placeholder=\"Search Dashboard\"]")
	WebElement searchElement;

	public String verifyDashboard() {
	     if (checklist.isDisplayed()) {
			checklist.click();
		} else {
            System.out.println("Checklist option not displaying");
		}
	     return driver.getCurrentUrl();
	}
	
    public boolean searchFieldExist() {
    	if (searchElement.isDisplayed()) {
			return true;
		} else {
            return false;
		}
    }	
	

}