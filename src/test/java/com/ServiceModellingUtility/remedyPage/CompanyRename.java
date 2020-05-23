package com.ServiceModellingUtility.remedyPage;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//import com.thoughtworks.selenium.webdriven.commands.Click;

public class CompanyRename extends SMUBasePage{
	public WebDriver driver;
	
	
	
	@FindBy(xpath="//textarea[contains(@id,'880000000')]")
	private WebElement activeCompany;
	
	@FindBy(xpath="//img[@id='reg_img_880000009']")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[contains(text(),'OK')]")
	private WebElement okButton;
	
	@FindBy(xpath="//textarea[contains(@id,'880000001')]")
	private WebElement newName;
	
	@FindBy(xpath="//div[contains(text(),'Initiate')]")
	private WebElement initiateButton;
	
	@FindBy(xpath="//td[contains(text(),'Rename')]")
	private WebElement renameStatus;
	
	@FindBy(xpath="//div[contains(text(),'Reset') and @style='width: 75px;']")
	private WebElement resetButton;
	
	@FindBy(xpath="//div[contains(text(),'Cancel ')]")
	private WebElement cancelButton;	
	
	@FindBy(xpath="//div[contains(text(),'View Results in SMU')]")
	private WebElement ViewButton;
	
	public CompanyRename(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void EnterActivecompany(String ActiveCompany,WebDriver driver) throws InterruptedException{
		
	
		if(activeCompany.isEnabled()){
			Reporter.log(getTimeStamp() +": Company is Enabled", true);
		}
		else
		{
			Reporter.log(getTimeStamp() +": Company is Disabled", true);
		}
		activeCompany.sendKeys(ActiveCompany);
		Reporter.log(getTimeStamp() +": Active company name is entered by the user", true);	
				
		searchButton.click();
		Reporter.log(getTimeStamp() +": Search button is clicked by the user", true);		
		Thread.sleep(4000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		
			driver.switchTo().window(child);
			okButton.click();
			Thread.sleep(1000);
			driver.switchTo().window(parent);		
	}	
	
	public void EnterNewName(String newname) throws InterruptedException{
		newName.sendKeys(newname);
		Reporter.log(getTimeStamp() +": New name for the Company is entered by the user", true);		
		initiateButton.click();
		Reporter.log(getTimeStamp() +": Initiate button is clicked by the user", true);		
	}
	
	public void InitiateCompanyRename(WebDriver driver) throws InterruptedException{				
		initiateButton.click();
		Reporter.log(getTimeStamp() +": Initiate button is clicked by the user", true);		
	}
	
	public void validateCompanyRenameStatus(WebDriver driver) throws InterruptedException {
		
		long start = System.currentTimeMillis();

		if (renameStatus.getText().contains("in-Progress")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'in-Progress')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}
		
		if (renameStatus.getText().contains("Completed")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Completed')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}

		if (renameStatus.getText().contains("MDM")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'MDM')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}

		if (renameStatus.getText().contains("Foundation")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Foundation')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}
		
		if (renameStatus.getText().contains("Asset")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Asset')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}

		if (renameStatus.getText().contains("CI")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'CI')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}

		if (renameStatus.getText().contains("Incident")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Incident')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}

		if (renameStatus.getText().contains("AIMS")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'AIMS')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}
		
		if (renameStatus.getText().contains("Sucessfully")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Sucessfully')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}

		if (renameStatus.getText().equalsIgnoreCase("Success")) {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
			Thread.sleep(4000);
		} else {
			Reporter.log(getTimeStamp() +": "+renameStatus.getText(), true);
		}
		
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;		
		DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
		df.setTimeZone(TimeZone.getTimeZone("GMT+5.5"));		
		Reporter.log(getTimeStamp() +": Total Time consumed to complete Company rename process is: " +df.format(new Date(totalTime)), true);
						
	}
						

	public void clickOnResetButton(WebDriver driver) throws InterruptedException {				
			resetButton.click();
			Reporter.log(getTimeStamp() +": Reset Button is clicked", true);			
			Thread.sleep(3000);
	}
	
	public void clickOnCancelButton(WebDriver driver) throws InterruptedException {				
		cancelButton.click();
		Reporter.log(getTimeStamp() +": Cancel Button is clicked", true);		
		Thread.sleep(3000);
		
	}	
	
	public void clickOnViewResult() throws InterruptedException {
		Thread.sleep(5000);
		ViewButton.click();
		Reporter.log(getTimeStamp() +": View results button clicked by the user", true);
		
	}
}


		