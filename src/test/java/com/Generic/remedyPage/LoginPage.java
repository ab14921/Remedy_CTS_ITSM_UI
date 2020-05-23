package com.Generic.remedyPage;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ServiceModellingUtility.remedyPage.SMUBasePage;
import com.Generic.remedyPage.Baseclass;

public class LoginPage extends SMUBasePage {

	@FindBy(id = "username-id")
	private WebElement UserName;
	@FindBy(id = "pwd-id")
	private WebElement pwd;
	@FindBy(id = "login")
	private WebElement loginbtn;
	@FindBy(xpath = "//td[contains(text(),'Welcome,')]")
	private WebElement HomePage;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void Login_to(WebDriver driver, String un, String pw) throws InterruptedException {
		
		try {
			driver.findElement(By.id("username-id")).sendKeys(un);			
			Reporter.log(getTimeStamp() +": User Name TextBox found", true);			
			byte[] decodedBytes = Base64.decodeBase64(pw);
			Thread.sleep(3000);
			Thread.sleep(3000);
			driver.findElement(By.id("pwd-id")).sendKeys(new String(decodedBytes));			
			Reporter.log(getTimeStamp() +": Password TextBox found", true);			
			Thread.sleep(3000);			
			Reporter.log(getTimeStamp() +": Password Encrypted", true);			
			driver.findElement(By.id("login")).click();			
			Reporter.log(getTimeStamp() +": Login Successful", true);			
			Thread.sleep(12000);
		} catch (Exception e) {			
			Reporter.log(getTimeStamp() +": Login failed", true);			
		}
	}

	
	public void validateHomePage() throws InterruptedException {
		if (HomePage.isDisplayed()) {			
			Reporter.log(getTimeStamp() +": user is redirected to home page", true);			
		}
	}
	
	

}
