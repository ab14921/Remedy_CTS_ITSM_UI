package com.Generic.remedyPage;

import java.sql.Timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.ServiceModellingUtility.remedyPage.SMUBasePage;


public class HomePage extends SMUBasePage{
	
	@FindBy(xpath = "(//img[contains(@artxt,'Show Application List')])")
	private WebElement Appchev;
	@FindBy(xpath = "(//span[contains(text(),'Service Modeling Utility')])[1]")
	private WebElement ServiceModelingUtility;
	@FindBy(xpath = "//span[contains(text(),'Merge')]")
	private WebElement Merge;
	@FindBy(xpath = "(//div[@class='f9'][contains(.,'Logout')]")
	private WebElement logout;
	@FindBy(xpath = "(//span[contains(text(),'Company Rename')])[1]")
	private WebElement companyRename;
	@FindBy(xpath = "(//span[contains(text(),'Organization Split')])")
	private WebElement organizationSplit;
	@FindBy(xpath = "(//span[contains(text(),'Service Modeling Utility (SMU)')])")
	private WebElement SMU;
	@FindBy(xpath = "//span[contains(text(),'Quick Links')]")
	private WebElement quickLinks;
	@FindBy(xpath = "(//span[contains(text(),'Show Next')])[1]")
	private WebElement showNext;
	@FindBy(xpath = "//span[contains(text(),'Alert Instruction Management System')]")
	private WebElement AIMS;
		
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void companyMarge(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", Appchev);
		Reporter.log(getTimeStamp() +": Application chevron button clicked", true);
		Thread.sleep(3000);
		try {
			Reporter.log(getTimeStamp() +": User have an option on the fly-out menu for Company Merge", true);			
			ServiceModelingUtility.click();
			Reporter.log(getTimeStamp() +": ServiceModelingUtility link clicked", true);			
			Thread.sleep(3000);
			Merge.click();
			Reporter.log(getTimeStamp() +": Navigate to Merge page", true);			
			Thread.sleep(10000);
		} catch (Exception e) {
			Reporter.log(getTimeStamp() +": User do not have an option on the fly-out menu for Company Merge", true);			
		}
		
	}
	
	public void companyRename(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", Appchev);		
		Reporter.log(getTimeStamp() +": Application chevron button clicked", true);		
		Thread.sleep(3000);
		try{		
		ServiceModelingUtility.click();
		Reporter.log(getTimeStamp() +": ServiceModelingUtility link clicked", true);		
		Thread.sleep(2000);
		companyRename.click();
		Reporter.log(getTimeStamp() +": User has a permission on the fly-out menu for Company Rename", true);
		Reporter.log(getTimeStamp() +": Navigate to company rename page", true);		
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
		Reporter.log(getTimeStamp() +": User do not have a permission on the fly-out menu for Company rename", true);		
		}
		

	}
	
	public void organizationSplit(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", Appchev);
		Reporter.log(getTimeStamp() +": Application chevron button clicked", true);		
		Thread.sleep(3000);
		try{			
		ServiceModelingUtility.click();
		Reporter.log(getTimeStamp() +": ServiceModelingUtility link clicked", true);		
		Thread.sleep(2000);
		organizationSplit.click();
		Reporter.log(getTimeStamp() +": User has a permission on the fly-out menu for Organization Split", true);	
		Reporter.log(getTimeStamp() +": Navigate to Organization Split page", true);		
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
		Reporter.log(getTimeStamp() +": User do not have a permission on the fly-out menu for Organization Split", true);		
		}
	}
	
	public void SMU(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", Appchev);		
		Reporter.log(getTimeStamp() +": Application chevron button clicked", true);		
		Thread.sleep(3000);
		try{			
		ServiceModelingUtility.click();		
		Reporter.log(getTimeStamp() +": ServiceModelingUtility link clicked", true);		
		Thread.sleep(2000);
		SMU.click();		
		Reporter.log(getTimeStamp() +": User has a permission on the fly-out menu for SMU", true);		
		Reporter.log(getTimeStamp() +": Navigate to SMU page", true);		
		Thread.sleep(10000);
		}
		catch(Exception e)
		{		
		Reporter.log(getTimeStamp() +": User do not have a permission on the fly-out menu for SMU", true);		
		}
	
	}
	
	public void AIMS(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", Appchev);		
		Reporter.log(getTimeStamp() +": Application chevron button clicked", true);		
		Thread.sleep(3000);
		
		try{
		Actions action = new Actions(driver);
		action.moveToElement(quickLinks).perform();
//		quickLinks.click();				
		Reporter.log(getTimeStamp() +": Quick Links has been clicked", true);		
		Thread.sleep(2000);
			try{
				action.moveToElement(showNext).perform();
//				showNext.click();
				}
			catch (Exception e){
				Reporter.log(getTimeStamp() +": AIMS option displayed on the same list", true);
			}
		AIMS.click();
		Reporter.log(getTimeStamp() +": User has a permission on the fly-out menu for AIMS", true);		
		Reporter.log(getTimeStamp() +": Navigate to AIMS page", true);		
		Thread.sleep(4000);
		}
		catch(Exception e)
		{		
		Reporter.log(getTimeStamp() +": User do not have a permission on the fly-out menu for AIMS", true);
		Reporter.log(e.getMessage());
		logout(driver);		
		}
	
	}
	
	public void logout(WebDriver driver) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", logout);		
		Reporter.log(getTimeStamp() +": Application logged out", true);		
		Thread.sleep(5000);
		driver.close();
	}

	public void closingBrowser(WebDriver driver) {
		driver.close();
	}

}
