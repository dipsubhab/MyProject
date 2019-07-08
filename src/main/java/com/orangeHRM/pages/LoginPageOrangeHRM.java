package com.orangeHRM.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.pages.FlightFinderPage;
import com.mercury.utility.FileReading;
import com.mercury.utility.WaitElement;

public class LoginPageOrangeHRM {
	
	
	/* Global declaration of WebDriver Object */
	
	WebDriver driver;
	WaitElement waitelement;
	FileReading fileReading;
		
	/* Object identification block */
	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement txtBoxUserName;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement txtBoxPassword;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement btnLogin;
	
	/* Constructor definition */ 
	public LoginPageOrangeHRM(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/* Method to enter User name */
	public void userNameEntry(String userName)
	{
		
		WaitElement.waitForElement(txtBoxUserName, 30, driver);
		txtBoxUserName.sendKeys("Admin");
		
	}
	
	/* Method to enter password */
	public void passwordEntry(String password)
	{
		WaitElement.waitForElement(txtBoxPassword, 30, driver);
		txtBoxPassword.sendKeys("admin123");
		
	}
	
	/* Method to click on login button */
	public void clickLoginButton()
	{
		WaitElement.waitForElement(btnLogin, 50, driver);
		btnLogin.click();
	    WaitElement.waitTill(5000);
		
	}
	

	/* Verifying valid login */
	public boolean verifyValidLogin()
	{		
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		
		if(expTitle.equals(actTitle)) {
			return true;
		}else {
			return false;
		}
	}

}
