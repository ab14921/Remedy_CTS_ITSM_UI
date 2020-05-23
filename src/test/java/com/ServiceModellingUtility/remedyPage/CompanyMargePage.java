package com.ServiceModellingUtility.remedyPage;

import java.sql.Driver;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CompanyMargePage extends SMUBasePage {

	
	public WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Merge')]")
	private WebElement MergePage;
	@FindBy(xpath = "//textarea[contains(@id,'880000000')]")
	private WebElement MergeThisCompany;

	@FindBy(xpath = "//textarea[contains(@id,'536870923')]")
	private WebElement IntoThisCompany;

	@FindBy(xpath = "//div[contains(text(),'Reset')]")
	private WebElement ResetButton;

	@FindBy(xpath = "//div[contains(text(),'Initiate')]")
	private WebElement Initiate;

	@FindBy(xpath = "(//td[@class='f9 trimJustl'])[6]")
	private WebElement MergeStatus;

	@FindBy(xpath = "//div[contains(text(),'Cancel ')]")
	private WebElement CancelButton;

	@FindBy(xpath = ".//*[@id='WIN_0_536870929']/table/tbody/tr/td")
	private WebElement MergeStatusMsg;

	@FindBy(xpath = "(//nobr[@class='dp'])[1]")
	private WebElement SearchedResult;

	@FindBy(xpath = "//div[contains(text(),'OK')]")
	private WebElement OkButton;

	@FindBy(xpath = "//img[@id='reg_img_536870922']")
	private WebElement SearchButtonSign;

	@FindBy(xpath = "//textarea[contains(@id,'536870936')]")
	private WebElement ErrorMsg;

	@FindBy(xpath = "//div[contains(text(),'INC')]")
	private WebElement Incidentno;

	@FindBy(xpath = "//div[contains(text(),'View Results in SMU')]")
	private WebElement View_Results_in_SMU_Button;

	@FindBy(xpath = "(//img[contains(@id,'handlerTN')])[1]")
	private WebElement ExpandButtonCompany;

	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[1]")
	private WebElement ExpandResultButtonone;

	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[2]")
	private WebElement ExpandResultButtontwo;

	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[3]")
	private WebElement ExpandResultButtonthree;

	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[4]")
	private WebElement ExpandResultButtonfour;

	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[5]")
	private WebElement ExpandResultButtonfive;

	@FindBy(xpath = "//td[contains(text(),'SERVICE')]")
	private WebElement SMUPage;

	@FindBy(xpath = "(//a[contains(@id,'titleTN')])[4]")
	private WebElement CompanyParent;

	public CompanyMargePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void testCompanyMergePage() throws InterruptedException {
		try {
			MergePage.isDisplayed();
			Reporter.log(getTimeStamp() +": user have permission to merge companies", true);			
		} catch (Exception e) {
			Reporter.log(getTimeStamp() +": user do not have permission to merge companies", true);			
		}

	}

	public void testcompanyMarge(String comp1, String comp2, WebDriver driver)
			throws InterruptedException {
		MergeThisCompany.sendKeys(comp1);
		clickOnSourceCompanySearchButton();
		Thread.sleep(3000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> it = allWindowHandles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		OkButton.click();
		Reporter.log(getTimeStamp() +": Entered company into sourcecompany field", true);		
		Thread.sleep(1000);
		driver.switchTo().window(parent);
		IntoThisCompany.sendKeys(comp2);
		clickOnDestinationCompanySearchButton();
		Thread.sleep(3000);
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		Iterator<String> it1 = allWindowHandles1.iterator();
		String parent1 = it1.next();
		String child1 = it1.next();
		driver.switchTo().window(child1);
		Thread.sleep(2000);
		OkButton.click();
		Reporter.log(getTimeStamp() +": Entered company into destinationcompany field", true);		
		driver.switchTo().window(parent1);
		Thread.sleep(2000);		
	}

	public void testcompanyMarge1(String comp) throws InterruptedException {
		MergeThisCompany.sendKeys(comp);
		Reporter.log(getTimeStamp() +": Entered company into MergeThisCompany field", true);		
	}

	public void testInitiateButton(WebDriver driver)
			throws InterruptedException {
		Initiate.click();
		Reporter.log(getTimeStamp() +": Clicked on initiate button", true);		
		Thread.sleep(10000);

	}

	public void mergeStatus(WebDriver driver) throws InterruptedException {

		long start = System.currentTimeMillis();
		
		if (MergeStatus.getText().contains("Initiated")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Initiated')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}

		if (MergeStatus.getText().contains("in-Progress")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'in-Progress')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}
		if (MergeStatus.getText().contains("Completed")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Completed')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}

		if (MergeStatus.getText().contains("MDM")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'MDM')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}

		if (MergeStatus.getText().contains("Remedy-FoundationData")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Remedy-FoundationData')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}
		if (MergeStatus.getText().contains("Remedy-AssetData")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Remedy-AssetData')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}

		if (MergeStatus.getText().contains("Remedy-CIData")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Remedy-CIData')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}

		if (MergeStatus.getText().contains("Remedy-IncidentData")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Remedy-IncidentData')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}

		if (MergeStatus.getText().contains("Remedy-AimsData")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Remedy-AimsData')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}
		if (MergeStatus.getText().contains("Completed Sucessfully")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			WebDriverWait wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath("//td[contains(text(),'Completed Sucessfully')]")));
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}

		if (MergeStatus.getText().equalsIgnoreCase("Success")) {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
			Thread.sleep(2000);
		} else {
			Reporter.log(getTimeStamp() +": "+MergeStatus.getText(), true);
		}
		
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;		
		DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
		df.setTimeZone(TimeZone.getTimeZone("GMT+5.5"));		
		Reporter.log(getTimeStamp() +": Total Time consumed to complete Company Merge process is: " +df.format(new Date(totalTime)), true);

	}

	public void handleError() throws InterruptedException {

		try {
			Incidentno.click();
			Reporter.log(getTimeStamp() +": Clicked on Incident link", true);			
		} catch (Exception e) {
			Reporter.log(getTimeStamp() +": No incident created", true);			
		}
	}

	public void clickOnViewResultInSMU() throws InterruptedException {
		try {
			View_Results_in_SMU_Button.click();
			Reporter.log(getTimeStamp() +": Clicked on View result in SMU button", true);			
			Thread.sleep(2000);

		} catch (Exception e) {
			Reporter.log(getTimeStamp() +": Companies are not successfully merged", true);			
		}
	}

	public void expandResult() throws InterruptedException {

		if (SMUPage.isDisplayed()) {
			Reporter.log(getTimeStamp() +": SMU Page is displayed", true);			
			Thread.sleep(5000);
			try {
				ExpandButtonCompany.click();
				Reporter.log(getTimeStamp() +": Clicked on Expand button", true);				
			} catch (Exception e) {
				Reporter.log(getTimeStamp() +": No company has been displayed in SMU page", true);				
			}

			ExpandResultButtonone.click();
			Thread.sleep(2000);
			ExpandResultButtontwo.click();
			Thread.sleep(2000);
			ExpandResultButtonthree.click();
			Thread.sleep(2000);
			ExpandResultButtonfour.click();
			Thread.sleep(2000);
			ExpandResultButtonfive.click();
			Thread.sleep(2000);

		}
	}

	public void mergeStatusMessage() throws InterruptedException {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log(getTimeStamp() +": "+MergeStatusMsg.getText(), true);		
	}

	public void testResetButton() throws InterruptedException {
		ResetButton.click();
		Reporter.log(getTimeStamp() +": Clicked on reset button", true);		
		Thread.sleep(3000);
		MergeThisCompany.clear();
		IntoThisCompany.clear();
		Thread.sleep(3000);

	}

	public void testCompanyTextFieldFunctionality() throws InterruptedException {
		if (MergeThisCompany.isEnabled() && IntoThisCompany.isEnabled()) {
			Reporter.log(getTimeStamp() +": company fields are enabled after clicking on reset button", true);			
		}

	}

	public void clickOnCancelButton() throws InterruptedException {
		CancelButton.click();
		Reporter.log(getTimeStamp() +": Clicked on cancel button", true);		
		Thread.sleep(2000);
	}

	public void test_COM_Company_Table() {

	}

}
