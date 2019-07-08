package com.mercury.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElement {
	
	public static void waitForElement(WebElement element, int waitTime, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
public static void waitTill(int waitTime) {
		try {
			Thread.sleep(waitTime);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
