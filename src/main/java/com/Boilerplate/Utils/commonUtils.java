package com.Boilerplate.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtils{

	public static void waitForNextAction(WebDriver driver,int timeout,WebElement element) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
}
