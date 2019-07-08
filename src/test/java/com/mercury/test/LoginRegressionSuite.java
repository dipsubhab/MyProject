package com.mercury.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mercury.pages.LoginPage;
import com.mercury.utility.BrowserFactory;

public class LoginRegressionSuite {
	
	BrowserFactory browserFactory;
	LoginPage loginPage;
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	// 1234
	@BeforeMethod
	public void browserAppLaunch() {
		
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		
		driver = BrowserFactory.startBrowserApp("chrome", "http://newtours.demoaut.com/");
	}
	
	/*
	 * TC_001: Verifying valid login functionality
	 * Validation only by me.
	 */
	@Test(priority = 0, enabled=false, description="TC_001: Verifying valid login functionality")
	public void verifyValidLogin() {
		try {
			
		test = extent.createTest("Verifying Valid Login");
			
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.userNameEntry("dasd"); // Entering valid User name.
		loginPage.passwordEntry("dasd"); // Entering valid Password.
		loginPage.clickLoginButton(); // Clicking on Login Button.
		//Assert.assertEquals(true, loginPage.verifyValidLogin()); // Verifying valid login scenario.
		Assert.assertTrue(loginPage.verifyValidLogin());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	/*
	 * TC_002: Verifying invalid login functionality
	 */
	@Test(priority = 1, enabled=false, description="TC_002: Verifying invalid login functionality")
	public void verifyInvalidLogin() {
		try 
		{
		test = extent.createTest("Verifying invalid Login");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.userNameEntry("dasd123"); // Entering invalid User name.
		loginPage.passwordEntry("dasd123"); // Entering invalid Password.
		loginPage.clickLoginButton(); // Clicking on Login Button.
		Assert.assertEquals(true, loginPage.verifyInValidLogin()); // Verifying valid login scenario.
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	/*
	 * TC_003: Verifying login data driven testing
	 */
	@Test(priority = 2, enabled=true, description="TC_003: Verifying login data driven testing")
	public void verifyDataDrivenLogin() {
		try 
		{
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.verifyDataDrivenLogin(); // Verifying valid login scenario.
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	@AfterMethod
	public void closeApp(ITestResult testResults) {
		driver.quit();
		if(testResults.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "The failure exception below");
			test.log(Status.FAIL, testResults.getThrowable());
		}
		else if(testResults.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "The Test case is passed");
		}
		else if(testResults.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, testResults.getThrowable());
		}
	}
	
	@AfterClass
	public void reportWriter()
	{
		extent.flush();
	}
}
