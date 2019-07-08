package com.orangeHRM.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mercury.pages.LoginPage;
import com.mercury.utility.BrowserFactory;
import com.orangeHRM.pages.LoginPageOrangeHRM;

public class LoginTest {
	
	BrowserFactory browserfactory;
	LoginPageOrangeHRM loginPageOrangeHRM;
	WebDriver driver;
	
	
	@BeforeMethod
	public void browserAppLaunch() {
		
		driver=BrowserFactory.startBrowserApp("chrome", "https://opensource-demo.orangehrmlive.com/");
		
	}
	@Test(priority = 0, enabled=true , description="TC_001: Verifying valid login functionality")
	public void verifyValidLogin() {
		try {
			
		
			
		loginPageOrangeHRM = PageFactory.initElements(driver, LoginPageOrangeHRM.class);
		loginPageOrangeHRM.userNameEntry("Admin"); // Entering valid User name.
		loginPageOrangeHRM.passwordEntry("admin123 "); // Entering valid Password.
		loginPageOrangeHRM.clickLoginButton(); // Clicking on Login Button.
		//Assert.assertEquals(true, loginPage.verifyValidLogin()); // Verifying valid login scenario.
		Assert.assertTrue(loginPageOrangeHRM.verifyValidLogin());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	

	@AfterMethod
	public void closeApp() {
		driver.quit();
		
	}
}
