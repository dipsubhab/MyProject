package com.automationtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	WebDriver driver;
	
	
	/* Object identification block */
	@FindBy(xpath="//input[@name='userName']")
	WebElement txtBoxUserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtBoxPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	/* Constructor definition */
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	

}
