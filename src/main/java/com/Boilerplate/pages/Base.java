package com.Boilerplate.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
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
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-notifications");
			DesiredCapabilities capability=DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, options);
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
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot takeshot=(TakesScreenshot)driver;
			File srcFile=takeshot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile,new File("./Screenshots/"+result.getName()+".png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
            System.out.println("No need of screenshot");
		}
		driver.quit();
	}
}
