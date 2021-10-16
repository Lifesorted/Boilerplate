package com.Boilerplate.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Boilerplate.Utils.GetPropertyData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected WebDriver driver;
		
	@Parameters({"Browser"})
	@BeforeMethod
	public void setUp(String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if (Browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}else {
			System.out.println("No associated driver found");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(GetPropertyData.getPropertyData().get("Base_Url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
