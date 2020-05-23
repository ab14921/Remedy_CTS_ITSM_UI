package com.AIMS.remedyPage;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.Generic.remedyPage.Baseclass;

//import com.thoughtworks.selenium.webdriven.commands.Click;

public class AIMSHome extends Baseclass {
	int Counter = 0;
	boolean ciGroupFound = false;
	public WebDriver driver;	
	
	@FindBy(xpath = "//span[contains(text(),'Main Actions')]")
	private WebElement mainActions;
	@FindBy(xpath = "(//span[contains(text(),'Create')])[1]")
	private WebElement create;
	@FindBy(xpath = "(//textarea[contains(@id,'830010020')])[2]")
	private WebElement instructionId;
	@FindBy(xpath = "(//textarea[contains(@id,'830010046')])[2]")
	private WebElement customer;
	@FindBy(xpath = "(//textarea[contains(@id,'WIN_1_8')])[4]")
	private WebElement shortDescription;
	@FindBy(xpath = "(//textarea[contains(@id,'830010023')])[2]")
	private WebElement externalNote;
	@FindBy(xpath = "//textarea[contains(@id,'830010024')]")
	private WebElement internalNote;
	@FindBy(xpath = "//textarea[contains(@id,'830010043')]")
	private WebElement eventID;	
	@FindBy(xpath = "(//label[contains(text(),'Service Zone')]//preceding::input[contains(@id,'830010047')])[1]")
	private WebElement serviceZoneButton;
	@FindBy(xpath = "(//label[contains(text(),'Service Zone')]//preceding::input[contains(@id,'830010047')])[2]")
	private WebElement CIButton;
	@FindBy(xpath = "(//label[contains(text(),'Service Zone')]//preceding::input[contains(@id,'830010047')])[3]")
	private WebElement CIGroupButton;
	@FindBy(xpath = "(//label[contains(text(),'Service Zone')]//preceding::input[contains(@id,'830010047')])[4]")
	private WebElement SiteLocationButton;
	@FindBy(xpath = "(//label[contains(text(),'Service Zone')]//preceding::input[contains(@id,'830010047')])[5]")
	private WebElement OrganizationButton;
	@FindBy(xpath = "(//label[contains(text(),'Service Zone')]//preceding::input[contains(@id,'830010047')])[6]")
	private WebElement DepartmentButton;
	@FindBy(xpath = "(//label[contains(text(),'Service Zone')]//preceding::input[contains(@id,'830010047')])[7]")
	private WebElement serviceAccountButton;
	@FindBy(xpath = "//textarea[contains(@id,'830010048')]")
	private WebElement serviceZoneField;
	@FindBy(xpath = "(//div[@class='MenuTableContainer']/table[@class='MenuTable']/tbody/tr)[1]")	
	private WebElement serviceZoneValue;
	@FindBy(xpath = "(//div[@class='MenuTableContainer']/table[@class='MenuTable']/tbody/tr/td)[1]")
	private WebElement noEntries;
	@FindBy(xpath = "//div[contains(text(),'Add')]")
	private WebElement addMatchingCriteria;
	@FindBy(xpath = "//img[contains(@id,'830010281')]")
	private WebElement CISearchButton;
	@FindBy(xpath = "//textarea[contains(@id,'830010268')]")
	private WebElement computerSystemNameCI;
	@FindBy(xpath = "(//div[contains(text(),'Search')])[2]")
	private WebElement CISearch;
	@FindBy(xpath = "//div[contains(text(),'Select')]")
	private WebElement selectButton;
	@FindBy(xpath = "//img[contains(@id,'830010315')]")
	private WebElement CIGroupSearch;
	@FindBy(xpath = "//div[contains(text(),'Add')]")
	private WebElement addCIGroup;
	@FindBy(xpath = "//div[contains(text(),'Close')]")
	private WebElement closeSMACGroupChooser;
	@FindBy(xpath = "//textarea[contains(@id,'850010049')]//parent::div[contains(@id,'850010049')]/child::a[@class='btn btn3d menu']")
	private WebElement siteSearch;
	@FindBy(xpath = "(//div[@class='MenuTableContainer']/table/tbody/tr)[1]")
	private WebElement siteValue;
	@FindBy(xpath = "//img[contains(@id,'850010315')]")
	private WebElement orgDeptChooser;
	@FindBy(xpath = "//div[contains(@id,'1000000010')]/child::a[@class='btn btn3d menu']")
	private WebElement oganizationDropDown;
	@FindBy(xpath = "(//div[@class='MenuTableContainer']/table/tbody/tr/td)[1]")
	private WebElement orgDeptValue;
	@FindBy(xpath = "(//div[contains(text(),'Search')])[2]")
	private WebElement searchOrgDept;
	@FindBy(xpath = "(//table[@id='T301391467']/tbody/tr)[2]")
	private WebElement orgDept;
	@FindBy(xpath = "//div[contains(text(),'Select')]")
	private WebElement selectRecord;
	@FindBy(xpath = "//div[contains(@id,'200000006')]/child::a[@class='btn btn3d menu']")
	private WebElement departmentDropDown;
	@FindBy(xpath = "//div[contains(@id,'850010051')]/child::a")
	private WebElement serviceAccountDropDown;
	@FindBy(xpath = "(//div[@class='MenuTableContainer']/table/tbody/tr)[1]")
	private WebElement serviceAccountValue;		
	@FindBy(xpath = "//div[contains(text(),'Save')]")
	private WebElement saveInstruction;	
	@FindBy(xpath = "(//div[contains(text(),'Logout')])[2]")
	private WebElement logoutAIMS;
	
	
	public AIMSHome (WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);		
	}
	
	public void addInstructionsForTheCustomer(String P_customer,WebDriver driver) throws InterruptedException{
		
		mainActions.click();		
		Reporter.log(getTimeStamp() +": Main Actions clicked by the user", true);
		Thread.sleep(2000);
		create.click();
		Thread.sleep(2000);
		Reporter.log(getTimeStamp() +": create option clicked by the user", true);
		customer.click();
		customer.sendKeys(P_customer);
		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();		
		Reporter.log(getTimeStamp() +": customer has been populated by the user", true);
		shortDescription.sendKeys("Test");
		Thread.sleep(1000);
		externalNote.sendKeys("Test");
		Thread.sleep(1000);
		internalNote.sendKeys("Test");
		Thread.sleep(2000);				
	}
	
	public void addMatchingCriteriaForServiceZone(WebDriver driver) throws InterruptedException{
		
		eventID.click();
		eventID.clear();
		String uniqueid = UUID.randomUUID().toString().substring(0, 16);
		eventID.sendKeys(uniqueid);		
		serviceZoneField.click();		
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 1800);
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("(//div[@class='MenuTableContainer']/table[@class='MenuTable']/tbody/tr)[1] | (//div[@class='MenuTableContainer']/table[@class='MenuTable']/tbody/tr/td)[1]"))).click();
//		if (noEntries.getText().contains("no entries")){
//			noEntries.click();
//			Reporter.log(getTimeStamp() +": No Service Zone found, ANY has been populated", true);
//		}else{
//			serviceZoneValue.click();
//			Reporter.log(getTimeStamp() +": Service Zone has been populated", true);
//		}
		
		addMatchingCriteria.click();
		Reporter.log(getTimeStamp() +": Matching Criteria has been added for Service Zone", true);	
		Thread.sleep(2000);
	}

	public void addMatchingCriteriaForCI(WebDriver driver) throws InterruptedException{
		
		eventID.click();
		eventID.clear();
		String uniqueid = UUID.randomUUID().toString().substring(0, 16);
		eventID.sendKeys(uniqueid);
		CIButton.click();
		Reporter.log(getTimeStamp() +": CI is selected as Association type", true);	
		String parentWindow = driver.getWindowHandle();
		CISearchButton.click();
		Thread.sleep(2000);
		switchToNewWindow(2);
		try{
			computerSystemNameCI.sendKeys("s");
			CISearch.click();		
			WebDriverWait wait = new WebDriverWait(driver, 1800);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='T830010350']/tbody/tr)[2]")));
			selectButton.click();		
			Thread.sleep(2000);
			driver.switchTo().window(parentWindow);
			addMatchingCriteria.click();
			Reporter.log(getTimeStamp() +": Matching Criteria has been added for CI", true);
		}catch (Exception e){			
			driver.close();
			driver.switchTo().window(parentWindow);
			Reporter.log(getTimeStamp() +": No CI found for the search criteria", true);
		}	
		Thread.sleep(2000);
	}
	
	public void addMatchingCriteriaForCIGroup(WebDriver driver) throws InterruptedException{
		
		eventID.click();
		eventID.clear();
		String uniqueid = UUID.randomUUID().toString().substring(0, 16);
		eventID.sendKeys(uniqueid);
		CIGroupButton.click();
		Reporter.log(getTimeStamp() +": CI Group is selected as Association type", true);	
		String parentWindow = driver.getWindowHandle();
		CIGroupSearch.click();
		Thread.sleep(2000);
		switchToNewWindow(2);
		List <WebElement> CIGroupTable = driver.findElements(By.xpath("//table[contains(@id,'T870000102')]/tbody/tr"));
		Reporter.log(getTimeStamp() +": Total no of CIgroup Table rows:" +CIGroupTable.size(), true);
		Actions a = new Actions(driver);
		
		if(CIGroupTable.size() > 1) {			
			Thread.sleep(2000);			
			FindValidCIGroup:
			for (int i=2; i<=CIGroupTable.size(); i++)
			{
			   WebElement CITableRow = driver.findElement(By.xpath("(//table[contains(@id,'T870000102')]/tbody/tr)["+i+"]"));			   			   
			   a.doubleClick(CITableRow).perform();
			   List<WebElement> count = driver.findElements(By.tagName("iframe"));
			   String groupType = driver.findElement(By.xpath("(//table[contains(@id,'T870000102')]/tbody/tr)[2]/td[5]/nobr/span")).getText();
			   System.out.println("groupType :"+groupType);
			   if (groupType.contains("1")){
				   System.out.println("inside groupType");
				   driver.findElement(By.xpath("(//table[contains(@id,'T870000102')]/tbody/tr)[2]/td[5]/nobr/span")).click();
				   addCIGroup.click();					   
				   driver.switchTo().window(parentWindow);
				   ciGroupFound = true;
				   break FindValidCIGroup;
			   }else{
				   System.out.println("outside groupType");
				   driver.switchTo().frame(1);
				   Thread.sleep(3000);
				   driver.findElement(By.xpath("//a[contains(text(),'OK')]")).click();
				   Reporter.log(getTimeStamp() +": OK Button clicked by the user", true);
				   driver.switchTo().defaultContent();
				   Thread.sleep(2000);
			   }		   
		   				   
			}			
			if(ciGroupFound){
				addMatchingCriteria.click();
				Reporter.log(getTimeStamp() +": Matching criteria has been added for the CI group", true);				
			}else{
				Reporter.log(getTimeStamp() +": No Valid CIGroup found", true);
				closeSMACGroupChooser.click();
				Reporter.log(getTimeStamp() +": SMACGroup chooser window has been closed", true);
			}
		}else{
			closeSMACGroupChooser.click();			
			driver.switchTo().window(parentWindow);
			Reporter.log(getTimeStamp() +": No CIGroup found", true);
		}
		Thread.sleep(2000);
	}
	
	public void addMatchingCriteriaForSiteLocation(WebDriver driver) throws InterruptedException{
		
		eventID.click();
		eventID.clear();
		String uniqueid = UUID.randomUUID().toString().substring(0, 16);
		eventID.sendKeys(uniqueid);
		SiteLocationButton.click();
		siteSearch.click();
		Thread.sleep(3000);
		siteValue.click();
		Thread.sleep(1000);
		addMatchingCriteria.click();
		Reporter.log(getTimeStamp() +": Matching Criteria has been added for Site/Location", true);
		Thread.sleep(2000);
		
	}
	
	public void addMatchingCriteriaForOrganization(WebDriver driver) throws InterruptedException{
		
		eventID.click();
		eventID.clear();
		String uniqueid = UUID.randomUUID().toString().substring(0, 16);
		eventID.sendKeys(uniqueid);
		OrganizationButton.click();
		String parentWindow = driver.getWindowHandle();
		orgDeptChooser.click();
		Thread.sleep(2000);
		switchToNewWindow(2);
		oganizationDropDown.click();
		Thread.sleep(1000);
		orgDeptValue.click();
		searchOrgDept.click();
		Thread.sleep(1000);
		orgDept.click();
		selectRecord.click();
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		addMatchingCriteria.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-40)");		
		Reporter.log(getTimeStamp() +": Matching Criteria has been added for the Organization", true);
		Thread.sleep(2000);
	}
	
	public void addMatchingCriteriaForDepartment(WebDriver driver) throws InterruptedException{
		
		eventID.click();
		eventID.clear();
		String uniqueid = UUID.randomUUID().toString().substring(0, 16);
		eventID.sendKeys(uniqueid);
		DepartmentButton.click();
		String parentWindow = driver.getWindowHandle();
		orgDeptChooser.click();
		Thread.sleep(2000);
		switchToNewWindow(2);
		oganizationDropDown.click();
		Thread.sleep(1000);		
		orgDeptValue.click();
		Thread.sleep(1000);
		departmentDropDown.click();
		Thread.sleep(1000);
		orgDeptValue.click();
		Thread.sleep(1000);
		searchOrgDept.click();
		Thread.sleep(1000);
		orgDept.click();
		selectRecord.click();
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		addMatchingCriteria.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-40)","");
		Reporter.log(getTimeStamp() +": Matching Criteria has been added for the Department", true);
		Thread.sleep(4000);
	}
	
	public void addMatchingCriteriaForServiceAccount(WebDriver driver) throws InterruptedException{
		
		serviceAccountButton.click();
		serviceAccountDropDown.click();
//		WebDriverWait wait = new WebDriverWait(driver, 1800);
//		wait.until(ExpectedConditions. visibilityOfElementLocated(By.xpath("(//div[@class='MenuTableContainer']/table/tbody/tr)[1]")));
		Thread.sleep(4000);
		System.out.println("noEntries: "+noEntries.getText());
		if(noEntries.getText().contains("no")){
			Reporter.log(getTimeStamp() +": No Service Account found", true);
		}else{
			serviceAccountValue.click();
			Thread.sleep(2000);
			addMatchingCriteria.click();
			Reporter.log(getTimeStamp() +": Matching Criteria has been added for the Service Account", true);
		}		
		Thread.sleep(2000);
	}
	
	public void saveAIMSInstruction(WebDriver driver) throws InterruptedException{
		
		Thread.sleep(2000);
		saveInstruction.click();		
		Reporter.log(getTimeStamp() +": AIMS instruction " +instructionId.getAttribute("value")+" has been saved", true);
		
	}
	
	public void logoutFromAIMS(WebDriver driver) throws InterruptedException {				
		logoutAIMS.click();		
		Reporter.log(getTimeStamp() +": User has been logged out of AIMS", true);				
		driver.quit();
	}
	
}


		