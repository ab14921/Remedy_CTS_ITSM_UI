package com.ServiceModellingUtility.remedyPage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//import com.thoughtworks.selenium.webdriven.commands.Click;

public class OrganizationSplit extends SMUBasePage {
	public WebDriver driver;
	
	@FindBy(xpath = "//textarea[contains(@id,'880000000')]")
	private WebElement companyName;

	@FindBy(xpath = "//img[contains(@id,'880000009')]")
	private WebElement searchButton;

	@FindBy(xpath = "//div[contains(text(),'OK')]")
	private WebElement okButton1;

	@FindBy(xpath = "//textarea[contains(@id,'880000001')]")
	private WebElement organizationName;

	@FindBy(xpath = "//div[contains(text(),'Initiate')]")
	private WebElement initiateButton;

	@FindBy(xpath = "//div[contains(text(),'Confirm')]")
	private WebElement confirmButton;

	@FindBy(xpath = "//textarea[contains(@id,'880999210')]")
	private WebElement abbreviation;

	@FindBy(xpath = "//div[contains(text(),'OK')]")
	private WebElement okButton2;

	@FindBy(xpath = "(//td[@class='f9 trimJustl'])[3]")
	private WebElement OrgSplitStatus;
	
	@FindBy(xpath = "//div[contains(text(),'View Results in SMU')]")
	private WebElement viewResultsButton;
	
	@FindBy(xpath = "(//img[contains(@id,'handlerTN')])[1]")
	private WebElement expandTheCompany;
	
	@FindBy(xpath = "(//img[contains(@id,'handlerTN')])[2]")
	private WebElement expandTheOrganization;
	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[2]")
	private WebElement expandResultsButtonOne;
	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[3]")
	private WebElement expandResultsButtonTwo;
	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[4]")
	private WebElement expandResultsButtonThree;
	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[5]")
	private WebElement expandResultsButtonFour;
	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[6]")
	private WebElement expandResultsButtonFive;
	
	@FindBy(xpath = "(//div[contains(text(),'Logout')])[4]")
	private WebElement logoutButton;

	public OrganizationSplit(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void EnterTheCompanyName(String P_CompanyName, WebDriver driver)
			throws InterruptedException {

		if (companyName.isEnabled()) {
			Reporter.log(getTimeStamp() +": Company is Enabled", true);
		} else {
			Reporter.log(getTimeStamp() +": Company is Disabled", true);
		}
		companyName.sendKeys(P_CompanyName);
		Reporter.log(getTimeStamp() +": The company name is entered by the user", true);
		searchButton.click();
		Reporter.log(getTimeStamp() +": Search button is clicked by the user", true);		
		Thread.sleep(4000);
		String parentWindow = driver.getWindowHandle();
		switchToNewWindow(2);
		okButton1.click();
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow);		
	}
	
	public void SelectTheOrgToSplit(String P_Org, WebDriver driver)
			throws InterruptedException {

		if (organizationName.isEnabled()) {
			Reporter.log(getTimeStamp() +": Organization Enabled", true);
		} else {
			Reporter.log(getTimeStamp() +": Organization Disabled", true);
		}

		organizationName.click();
		organizationName.sendKeys(P_Org);
		Thread.sleep(2000);
		organizationName.sendKeys(Keys.ENTER);
		Reporter.log(getTimeStamp() +": The Organization to be split is Selected by the user", true);
		Thread.sleep(2000);
	}

	public void InitiateTheSplit(WebDriver driver)
			throws InterruptedException {

		initiateButton.click();
		Reporter.log(getTimeStamp() +": Initiate button has been clicked by the user", true);
	}

	public void PreSplitValidation(String P_Abbreviation, WebDriver driver)
			throws InterruptedException {

		Reporter.log(getTimeStamp() +": User has been moved to Validation page", true);		
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		switchToNewWindow(2);
		confirmButton.click();
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow);		
		Thread.sleep(5000);
		switchToNewWindow(2);
		abbreviation.sendKeys(P_Abbreviation);
		okButton2.click();
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow);	
		Thread.sleep(4000);
	}

	public void validateOrgSplitStatus(WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(5000);

		if (OrgSplitStatus.getText().contains("Initiated")) {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
			Reporter.log("                       Waiting for next status...", true);
			WebDriverWait wait = new WebDriverWait(driver, 1800);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Initiated')]")));
		} else {

			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
		}			
		
		if (OrgSplitStatus.getText().contains("progress")) {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
			Reporter.log("                       Waiting for next status...", true);
			WebDriverWait wait = new WebDriverWait(driver, 1800);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'progress')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
		}
		
		if (OrgSplitStatus.getText().contains("Completed")) {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
			Reporter.log("                       Waiting for next status...", true);
			WebDriverWait wait = new WebDriverWait(driver, 1800);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Completed')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
		}

		if (OrgSplitStatus.getText().contains("Remedy")) {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
			Reporter.log("                       Waiting for next status...", true);
			WebDriverWait wait = new WebDriverWait(driver, 1800);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Remedy')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
		}

		if (OrgSplitStatus.getText().contains("MDM")) {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
			Reporter.log("                       Waiting for next status...", true);
			WebDriverWait wait = new WebDriverWait(driver, 1800);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'MDM')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
		}

		if (OrgSplitStatus.getText().contains("Sucessfully")) {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
			Reporter.log("                       Waiting for next status...", true);
			WebDriverWait wait = new WebDriverWait(driver, 1800);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Sucessfully')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
		}

		if (OrgSplitStatus.getText().equalsIgnoreCase("Success")) {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
			Thread.sleep(2000);
		} else {
			Reporter.log(getTimeStamp() +": "+OrgSplitStatus.getText(), true);
		}
		Thread.sleep(8000);
	}
	
	public void viewTheResultsInSMU(WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(3000);
		viewResultsButton.click();
		Reporter.log(getTimeStamp() +": View Results button Clicked by the User", true);
		Thread.sleep(8000);
		expandTheCompany.click();
		Reporter.log(getTimeStamp() +": New company is expanded by the User", true);
		Thread.sleep(2000);
		expandTheOrganization.click();
		Reporter.log(getTimeStamp() +": Organization is expanded by the User", true);
		Thread.sleep(2000);
		expandResultsButtonOne.click();
		Reporter.log(getTimeStamp() +": Departments by Company is expanded by the User", true);
		Thread.sleep(3000);
		expandResultsButtonTwo.click();
		Reporter.log(getTimeStamp() +": People by Company is expanded by the User", true);
		Thread.sleep(5000);
		expandResultsButtonThree.click();
		Reporter.log(getTimeStamp() +": SA and SZ by Company is expanded by the User", true);
		Thread.sleep(4000);
		expandResultsButtonFour.click();
		Reporter.log(getTimeStamp() +": Configuration Items by Company is expanded by the User", true);
		Thread.sleep(6000);
		expandResultsButtonFive.click();
		Reporter.log(getTimeStamp() +": Default Authorization groups by Company is expanded by the User", true);
		Thread.sleep(3000);			
		driver.quit();
	}
}
