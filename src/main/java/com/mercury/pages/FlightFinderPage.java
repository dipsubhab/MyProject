package com.mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mercury.utility.WaitElement;

public class FlightFinderPage {
	
	/* Global declaration of WebDriver Object */
	WebDriver driver;
	WaitElement waitelement;
	
	@FindBy(xpath = "//input[@value='roundtrip']")
	WebElement radioBtnRoundTrip;
	
	@FindBy(xpath = "//input[@value='oneway']")
	WebElement radioBtnOneWay;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	public static WebElement drpdwnDepartingFrom;
	
	/* Constructor definition */ 
	public FlightFinderPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean verifyDefaultSelectionRoundTrip() {
		
		WaitElement.waitForElement(radioBtnOneWay, 30, driver);
		WaitElement.waitForElement(radioBtnRoundTrip, 30, driver);
		
		if(radioBtnRoundTrip.isSelected() == true && radioBtnOneWay.isSelected() == false)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	public boolean departingFromValueSelection(WebElement element, String value)
	{
		WaitElement.waitForElement(element, 30, driver);
		Select s1 = new Select(element);
		
		WaitElement.waitTill(3000);
		
		s1.selectByVisibleText(value);
		
		WaitElement.waitTill(5000);
		
		if(element.getText().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	
	
	
	
}
