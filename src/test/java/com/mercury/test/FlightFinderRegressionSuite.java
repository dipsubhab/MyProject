package com.mercury.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.pages.FlightFinderPage;
import com.mercury.pages.LoginPage;
import com.mercury.utility.BrowserFactory;

public class FlightFinderRegressionSuite {
	
	BrowserFactory browserFactory;
	LoginPage loginPage;
	WebDriver driver;
	FlightFinderPage flightFinderPage;
	
	@BeforeMethod
	public void browserAppLaunch() {
		driver = BrowserFactory.startBrowserApp("chrome", "http://newtours.demoaut.com/");
	}
	
	/*
	 * TC_001: Verifying default selection of flight type.
	 */
	@Test(priority = 0, enabled=true, description="TC_001: Verifying default selection of flight type.")
	public void verifyDefaultSelectionFlightType() {
		try {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.userNameEntry("dasd"); // Entering valid User name.
		loginPage.passwordEntry("dasd"); // Entering valid Password.
		flightFinderPage = loginPage.clickLoginButton(); // Clicking on Login Button.
		Assert.assertEquals(true, flightFinderPage.verifyDefaultSelectionRoundTrip());
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	/*
	 * TC_002: Verifying departing from desired value selection.
	 */
	@Test(priority = 1, enabled=true, description="TC_001: Verifying default selection of flight type.")
	public void verifyDepartingFromValueSelection() {
		try {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.userNameEntry("dasd"); // Entering valid User name.
		loginPage.passwordEntry("dasd"); // Entering valid Password.
		flightFinderPage = loginPage.clickLoginButton(); // Clicking on Login Button.
		Assert.assertEquals(true, flightFinderPage.departingFromValueSelection(flightFinderPage.drpdwnDepartingFrom, "London"));
		
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
