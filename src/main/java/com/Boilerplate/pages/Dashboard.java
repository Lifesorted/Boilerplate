package com.Boilerplate.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Boilerplate.Utils.GetExcelData;
import com.Boilerplate.Utils.commonUtils;

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
	
	@FindBy(xpath = "//div[@class=\"main-items svelte-1krcujt\"]/child::div")
	WebElement menuelements;
	
	@FindBy(xpath = "//span[@class=\"action-icon svelte-phaa53\"]")
	WebElement searchicon;

	@FindBy(xpath = "//span[@class=\"search-bar svelte-phaa53\"]/descendant::input")
	WebElement searchinput;
	
	@FindBy(xpath = "//div[@class=\"recipient-info clickable svelte-1rok1zs active\"]/descendant::div[5]")
	WebElement searchres;
	
	@FindBy(xpath="//div[@class=\"modal-x svelte-ecw1as\"]")
	WebElement guidecross;
	
	@FindBy(xpath="//div[contains(text(),'Checklists')]")
	WebElement checklistmenu;
	
	@FindBy(xpath="//div[@class=\"recipient-info clickable svelte-1rok1zs active\"]/descendant::div[@class=\"container svelte-v1j8fd\"]")
	WebElement listmenuElement;
	
	@FindBy(xpath = "//div[contains(text(),'Delete')]")
	WebElement deleteaction;
	
	@FindBy(xpath = "//input[@placeholder=\"delete\"]")
	WebElement deleteinput;
	
	@FindBy(xpath = "//button[@class=\"danger-solid svelte-9ranqv\"]")
	WebElement deletebtn;
	
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
    
    public String getListElements(){
    	List<WebElement> elemeList=driver.findElements(By.xpath("//div[@class=\"item-text svelte-1krcujt\"]"));
    	String text = "";
    	for (WebElement webElement : elemeList) {
    		text += webElement.getText()+ ", ";
    		
		}
		return text;
    }
	
    public String searchResult() {
    	guidecross.click();
    	String result="";
    	if (searchicon.isDisplayed()) {
			searchicon.click();
			searchinput.sendKeys(GetExcelData.getSearchData());
			result=searchres.getText();
			return result;
		} else {
           System.out.println("No search icon found");
		}	
    	
    	return result;
	}
    
    public boolean switchToMenuLink() {
    	guidecross.click();
    	if (checklistmenu.isEnabled()) {
			checklistmenu.click();
			return true;
		} else {
			return false;
		}
    	
    }
    
    
    public void deletefromDashboard() {
    	commonUtils.waitForNextAction(driver, 30, guidecross);
		if(listmenuElement.isDisplayed()) {
			listmenuElement.click();
			deleteaction.click();
			deleteinput.sendKeys("delete");
			commonUtils.waitForNextAction(driver, 30, deletebtn);
		}else {
			System.out.println("Hamburger icon not present");
		}
	}

}