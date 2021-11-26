package com.Boilerplate.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Boilerplate.pages.Base;

public class commonUtils extends Base{

	
	public  void waitForNextAction(String value) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.urlToBe(value));
		
	}
}
