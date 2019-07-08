package com.mercury.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.utility.FileReading;
import com.mercury.utility.WaitElement;

public class LoginPage {
	
	/* Global declaration of WebDriver Object */
	WebDriver driver;
	WaitElement waitelement;
	FileReading fileReading;
	Logger logger = Logger.getLogger("LoginPage");
	
	
	/* Object identification block */
	@FindBy(xpath="//input[@name='userName']")
	WebElement txtBoxUserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtBoxPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	/* Constructor definition */ 
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/* Method to enter User name */
	public void userNameEntry(String userName)
	{
		PropertyConfigurator.configure("Log4j.properties");
		WaitElement.waitForElement(txtBoxUserName, 30, driver);
		txtBoxUserName.sendKeys("dasd");
		logger.info("MethodName: userNameEntry > Username has been entered successfully");
	}
	
	/* Method to enter password */
	public void passwordEntry(String password)
	{
		WaitElement.waitForElement(txtBoxPassword, 30, driver);
		txtBoxPassword.sendKeys("dasd");
		logger.info("MethodName: passwordEntry > Password has been entered successfully");
	}
	
	/* Method to click on login button */
	public FlightFinderPage clickLoginButton()
	{
		WaitElement.waitForElement(btnLogin, 50, driver);
		btnLogin.click();
		logger.info("MethodName: clickLoginButton > Login Button has been clicked successfully");
		WaitElement.waitTill(5000);
		return PageFactory.initElements(driver, FlightFinderPage.class);
	}
	
	/* Verifying valid login */
	public boolean verifyValidLogin()
	{		
		String expTitle = "Find a Flight: Mercury Tours:";
		String actTitle = driver.getTitle();
		
		if(expTitle.equals(actTitle)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/* Verifying invalid login */
	public boolean verifyInValidLogin()
	{
		String expTitle = "Find a Flight: Mercury Tours:";
		String actTitle = driver.getTitle();
		
		if(expTitle!=(actTitle)) {
			return true;
		}else {
			return false;
		}
	}
	
	/* Verifying login functionality with multiple login credential using Data Driven Approach */
	public void verifyDataDrivenLogin() throws IOException, InterruptedException
	{
		List<List<String>> cred1 = FileReading.loginDataDriven("./data/dataexcel.xlsx", "login");
		
		
		//System.out.println(cred1);
		
		System.out.println(cred1.get(0).size());
		System.out.println(cred1.get(1).size());
		
		for(int i = 0; i<cred1.get(0).size(); i++)
		{
				txtBoxUserName.sendKeys(cred1.get(0).get(i));
				System.out.println(cred1.get(0).get(i));
				txtBoxPassword.sendKeys(cred1.get(1).get(i));
				System.out.println(cred1.get(1).get(i));
				btnLogin.click();
				Thread.sleep(5000);
				
				//*********************************
				
				List <WebElement> radioRound = driver.findElements(By.xpath("//input[@value='roundtrip']"));
				
				if(radioRound.size()>0)
				{
					FileInputStream fis = new FileInputStream("./data/dataexcel.xlsx");
			        FileOutputStream fos = null;
			        XSSFWorkbook workbook = new XSSFWorkbook(fis);
			        XSSFSheet sheet = workbook.getSheet("login");
			        XSSFRow row = null;
			        XSSFCell cell = null;
			        XSSFFont font = workbook.createFont();
			        XSSFCellStyle style = workbook.createCellStyle();
			 
			        row = sheet.getRow(i+1);
			        if(row == null)
			            row = sheet.createRow(i+1);
			 
			        cell = row.getCell(2);
			        if(cell == null)
			            cell = row.createCell(2);
			 
			        cell.setCellValue("Login Successful");
			 
			        fos = new FileOutputStream("./data/dataexcel.xlsx");
			        workbook.write(fos);
			       // fos.close();
				}
				else
				{
					FileInputStream fis = new FileInputStream("./data/dataexcel.xlsx");
			        FileOutputStream fos = null;
			        XSSFWorkbook workbook = new XSSFWorkbook(fis);
			        XSSFSheet sheet = workbook.getSheet("login");
			        XSSFRow row = null;
			        XSSFCell cell = null;
			        XSSFFont font = workbook.createFont();
			        XSSFCellStyle style = workbook.createCellStyle();
			 
			        row = sheet.getRow(i+1);
			        if(row == null)
			            row = sheet.createRow(i+1);
			 
			        cell = row.getCell(2);
			        if(cell == null)
			            cell = row.createCell(2);
			 
			        cell.setCellValue("Login Failed");
			 
			        fos = new FileOutputStream("./data/dataexcel.xlsx");
			        workbook.write(fos);
			       // fos.close();
				}
				
				
				//**********************************

				Thread.sleep(4000);
				
				WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
				home.click();
		}
	}

}
	

