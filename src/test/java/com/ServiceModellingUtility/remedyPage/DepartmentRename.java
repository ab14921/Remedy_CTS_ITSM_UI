package com.ServiceModellingUtility.remedyPage;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//import com.thoughtworks.selenium.webdriven.commands.Click;

public class DepartmentRename extends SMUBasePage {
	public WebDriver driver;
//	private static final String BLANK_SPACE=" ";
//	String Dept_name;
	boolean dept_found;
	
	@FindBy(xpath = "//div[contains(text(),'Cancel Editing')]")
	private WebElement cancelEditing;
	@FindBy(xpath = "//img[contains(@id,'536870977')]")
	private WebElement editDepartment;
	@FindBy(xpath = "//textarea[contains(@id,'200000006')]")
	private WebElement newDepartment;
	@FindBy(xpath = "//textarea[contains(@id,'536872917')]")
	private WebElement defaultSourceCompanyId;
	@FindBy(xpath = "//div[@class='MenuTableContainer']/table/tbody/tr[1]/td[1]")
	private WebElement defaultSourceCompanyIdValue;
	@FindBy(xpath = "//input[contains(@id,'rc0id536870919')]")
	private WebElement defaultSiteId;
	@FindBy(xpath = "//textarea[contains(@id,'536870927')]")
	private WebElement defaultSiteIdField;
	@FindBy(xpath = "//div[@class='MenuTableContainer']/table/tbody/tr[1]/td[1]")
	private WebElement defaultSiteIdvalue;
	@FindBy(xpath = "//textarea[contains(@id,'536870928')]")
	private WebElement pendingzervicezoneField;
	@FindBy(xpath = "//div[@class='MenuTableContainer']/table/tbody/tr[1]/td[1]")
	private WebElement pendingzervicezone;
	@FindBy(xpath = "(//div[contains(text(),'Save')])[2]")
	private WebElement save;		
	@FindBy(xpath = "(//div[contains(text(),'Logout')])[2]")
	private WebElement logout;
	
	public DepartmentRename(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}	
	
	public void renamethedepartment(String P_Dept, String P_Dept_new, WebDriver driver)
			throws InterruptedException {
		
		List <WebElement> Expander = driver.findElements(By.xpath("//img[contains(@id,'handlerTN')]"));		
		Reporter.log(getTimeStamp() +": Total No of expand buttons are:" +Expander.size(), true);
		Thread.sleep(4000);
		
		for (int i=1; i<=Expander.size(); i++)
		{
		   driver.findElement(By.xpath("(//img[contains(@id,'handlerTN')])["+i+"]")).click();
		}
		
		List <WebElement> TElements = driver.findElements(By.xpath("//a[contains(@id,'titleTN')]"));
		Reporter.log(getTimeStamp() +": Total No of elements(Company/Organization/Department) are:" +TElements.size(), true);
		Thread.sleep(2000);

	    
		for (int i=1; i<=TElements.size(); i++)
		{
			if(driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).getText().equals(P_Dept)) {
		    driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).click();
		    Reporter.log(getTimeStamp() +": The Department has been selected to rename", true);
		    dept_found = true;
		   }		    
		}
		
		if(!dept_found){
			Reporter.log(getTimeStamp() +": No such department found", true);
			cancelEditing.click();
			Thread.sleep(3000);
			clickOnLogout(driver);
		}
		else {
			Thread.sleep(3000);
			editDepartment.click();
			Reporter.log(getTimeStamp() +": Edit Department button is clicked by the user", true);		
			Thread.sleep(4000);
			String parentWindow = driver.getWindowHandle();
			switchToNewWindow(2);
			newDepartment.clear();
			newDepartment.sendKeys(P_Dept_new);
			Reporter.log(getTimeStamp() +": New name for the department entered by the user", true);
			defaultSourceCompanyId.click();
			Thread.sleep(2000);
			defaultSourceCompanyIdValue.click();
			Reporter.log(getTimeStamp() +": Default source company ID selected by the user", true);
			Thread.sleep(2000);
			if (defaultSiteId.isSelected()) {
				Reporter.log(getTimeStamp() +": Default site ID radio button is already checked", true);
				Thread.sleep(3000);
			} else{
				defaultSiteId.click();		
				Reporter.log(getTimeStamp() +": Default site Id is checked by the user", true);
				Thread.sleep(3000);
			}		
			defaultSiteIdField.click();
			Thread.sleep(3000);
			defaultSiteIdvalue.click();
			Reporter.log(getTimeStamp() +": Site Id for default service zone is populated by the user", true);
			Thread.sleep(3000);
			pendingzervicezoneField.click();
			Thread.sleep(3000);
			pendingzervicezone.click();
			Reporter.log(getTimeStamp() +": Site Id for Pending service zone is populated by the user", true);
			Thread.sleep(3000);
			save.click();
			Reporter.log(getTimeStamp() +": Save button clicked by the user", true);
			Thread.sleep(8000);
			driver.switchTo().window(parentWindow);
			Thread.sleep(3000);			
		}				
	}	
	
	public void processdepartmentrename(WebDriver driver)
			throws InterruptedException {
		
		updateremedyandMDMtables(driver);
		if(dept_rename_complete){
			Reporter.log(getTimeStamp() +": Department Rename Process is COMPLETE", true);
		}		
	}
	
	public void validatetherenameresultsonUI(String P_Dept_new, WebDriver driver)
			throws InterruptedException {
		
		validatetheresultsonSMUUI(P_Dept_new, driver);
		Reporter.log(getTimeStamp() +": Validation of Department Rename on UI is COMPLETE", true);
		logout.click();
		driver.quit();
		
	}	
}