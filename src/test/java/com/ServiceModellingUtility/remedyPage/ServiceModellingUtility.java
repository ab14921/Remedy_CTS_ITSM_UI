package com.ServiceModellingUtility.remedyPage;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


//import com.thoughtworks.selenium.webdriven.commands.Click;

public class ServiceModellingUtility extends SMUBasePage {
	public WebDriver driver;
	private static final String BLANK_SPACE=" ";
//	String Dept_name;	
	boolean element_found;
	boolean done = false;
	
	@FindBy(xpath = "//textarea[contains(@id,'1000000001')]")
	private WebElement companyName;	
	@FindBy(xpath = "//div[contains(text(),'Edit Company')]")
	private WebElement editCompany;	
	@FindBy(xpath = "//div[contains(text(),'Cancel Editing')]")
	private WebElement cancelEditing;
	@FindBy(xpath = "//div[contains(text(),'Commit Changes')]/parent::div/parent::a/preceding::a/child::div/child::div[contains(text(),'Reset Staging')]")
	private WebElement resetStaging;
	@FindBy(xpath = "//div[contains(text(),'Commit Changes')]")
	private WebElement commitChanges;	
	@FindBy(xpath = "(//a[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath = "//a[contains(@id,'536871088')]")
	private WebElement refreshButton;
	@FindBy(xpath = "(//a[contains(@id,'titleTN')])[1]")
	private WebElement companyElement;
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[2]")
	private WebElement expandResultsButtonOne;
	@FindBy(xpath = "(//a[contains(text(),'Refresh')])[3]")
	private WebElement ASIRefreshButton;
	@FindBy(xpath = "//img[contains(@id,'536871072')]")
	private WebElement ASIDeleteButton;
	@FindBy(xpath = "(//span[contains(text(),'Savvis')])[2]")
	private WebElement savvisCompany;
	@FindBy(xpath = "//a[contains(Text(),'OK')]")
	private WebElement okButton2;
	@FindBy(xpath = "//div[@class='selection dat']/child::input[contains(@id,'5368709')]")
	private static WebElement EditStatus;
	@FindBy(xpath = "(//table[@id='T536871040']//child::td[@scope='row'])[1]")
	private WebElement ASITableFirstElement;
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[3]")
	private WebElement peopleSection;
	@FindBy(xpath = "//img[contains(@id,'536871019')]")
	private WebElement addDepartment;
	@FindBy(xpath = "//textarea[contains(@id,'1000000010')]")
	private WebElement organization;
	@FindBy(xpath = "//textarea[contains(@id,'200000006')]")
	private WebElement newDepartment;
	@FindBy(xpath = "//textarea[contains(@id,'536872917')]")
	private WebElement defaultSourceCompanyId;
	@FindBy(xpath = "//div[@class='MenuTableContainer']/table/tbody/tr[1]/td[1]")
	private WebElement defaultSourceCompanyIdValue;
	@FindBy(xpath = "//input[contains(@id,'rc0id536870919')]")
	private WebElement defaultSiteIdButton;
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
	
	
	
	public ServiceModellingUtility(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	public void OpenTheCompanyInSMU(String P_CompanyName, WebDriver driver)
			throws InterruptedException {

		if (companyName.isEnabled()) {			
			Reporter.log(getTimeStamp() +": Company is Enabled", true);
		} else {						
			Reporter.log(getTimeStamp() +": Company is Disabled", true);
		}
		companyName.sendKeys(P_CompanyName);		
		Reporter.log(getTimeStamp() +": The company name is entered by the user", true);
		Thread.sleep(2000);
		companyName.sendKeys(Keys.ENTER);
		companyName.click();
		Thread.sleep(4000);
		expandSectionsInSMU(driver);
	}

	public void OpenTheCompanyInEditMode(String P_CompanyName, WebDriver driver)
			throws InterruptedException {

		if (companyName.isEnabled()) {			
			Reporter.log(getTimeStamp() +": Company is Enabled", true);
		} else {						
			Reporter.log(getTimeStamp() +": Company is Disabled", true);
		}
		companyName.sendKeys(P_CompanyName);		
		Reporter.log(getTimeStamp() +": The company name is entered by the user", true);
		Thread.sleep(2000);
		companyName.sendKeys(Keys.ENTER);
		companyName.click();
		Thread.sleep(4000);		
		Reporter.log(getTimeStamp() +": Edit company button clicked by the user", true);
		editCompany.click();
		Thread.sleep(10000);		
		long start = System.currentTimeMillis();
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);		
		WebDriverWait wait = new WebDriverWait(driver, 7200);			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'OK')])[3] | (//img[contains(@id,'handlerTN')])[1]")));
		try{
			driver.findElement(By.xpath("(//div[contains(text(),'OK')])[3]")).click();			
			Reporter.log(getTimeStamp() +": OK button clicked by the user", true);
			driver.switchTo().window(parentWindow);			
			Reporter.log(getTimeStamp() +": Wait is complete", true);
			long finish = System.currentTimeMillis();
			long totalTime = finish - start;		
			DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
			df.setTimeZone(TimeZone.getTimeZone("GMT+5.5"));			
			Reporter.log(getTimeStamp() +": Time consumed to load onto staging table for the Company: " +P_CompanyName.toUpperCase() +" :" +df.format(new Date(totalTime)), true);
			Thread.sleep(3000);
			companyName.sendKeys(Keys.ENTER);
		}
		catch (Exception e)
		{
			Reporter.log(getTimeStamp() +": Company data is already loaded", true);
			driver.switchTo().window(parentWindow);
		}		
		
		Thread.sleep(3000);			
	}
	
	public void DragAndDropIntoExistingDept(String P_Contact, String P_SrcDept, String P_DestDept, WebDriver driver)
			throws InterruptedException {		
		
		List <WebElement> Expander = driver.findElements(By.xpath("//img[contains(@id,'handlerTN')]"));		
		Reporter.log(getTimeStamp() +": Total No of expand buttons are:" +Expander.size(), true);
		Thread.sleep(2000);	
		
		for (int i=1; i<=Expander.size(); i++)
		{
		   driver.findElement(By.xpath("(//img[contains(@id,'handlerTN')])["+i+"]")).click();
		}
		
		List <WebElement> TElements = driver.findElements(By.xpath("//a[contains(@id,'titleTN')]"));
		Reporter.log(getTimeStamp() +": Total No of elements(Company/Organization/Department) are:" +TElements.size(), true);
		Thread.sleep(2000);

	    
		for (int i=1; i<=TElements.size(); i++)
		{
			if(driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).getText().equals(P_SrcDept)) {
		    driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).click();
		    Reporter.log(getTimeStamp() +": Source Department has been selected", true);		    
		   }		    
		}		
		

		Thread.sleep(2000);
		peopleSection.click();
		Reporter.log(getTimeStamp() +": People section has been expanded", true);
		Thread.sleep(2000);
		
		List <WebElement> TElements2 = driver.findElements(By.xpath("//a[contains(@id,'titleTN')]"));
		Reporter.log(getTimeStamp() +": Total No of elements(Company/Organization/Department) are:" +TElements.size(), true);
		Thread.sleep(2000);
		
		List <WebElement> Expander2 = driver.findElements(By.xpath("//table[@id='T536870917']//tbody//tr//td[2]"));		
		Reporter.log(getTimeStamp() +": Total No of People records for the Department  " +P_SrcDept+"  are :" +Expander2.size(), true);
		Thread.sleep(4000);
		
		
		
		for (int i=1; i<=TElements2.size(); i++)
		{
//			Reporter.log("Destination department is: " +driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).getText(),true);
//			Reporter.log("Dest Dept inputted is:" +P_DestDept, true);
			if(driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).getText().equals(P_DestDept)) {
		    WebElement DestDept = driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]"));
		    Reporter.log(getTimeStamp() +": The Destination Department has been stored: " +DestDept, true);	
		    findppl:
		    for (int j=2; j<=Expander2.size()+1; j++)
			{
//		    	Reporter.log("People name:" +driver.findElement(By.xpath("//table[@id='T536870917']//tbody//tr["+j+"]//td[2]")).getText(), true);
//		    	Reporter.log("contact inputted is:" +P_Contact, true);
				if(driver.findElement(By.xpath("//table[@id='T536870917']//tbody//tr["+j+"]//td[2]")).getText().equals(P_Contact)) {
			    WebElement Contact = driver.findElement(By.xpath("//table[@id='T536870917']//tbody//tr["+j+"]//td[2]"));
			    Reporter.log(getTimeStamp() +": The Contact has been stored: " +Contact, true);
			    Actions builder = new Actions(driver);
			    Action dragAndDrop = (Action) builder.clickAndHold(Contact)
			    .moveToElement(DestDept).release(DestDept).build();
			    dragAndDrop.perform();
//				a.dragAndDrop(Contact, DestDept);
				Thread.sleep(3000);
				Reporter.log(getTimeStamp() +": The Contact has been Drag and Dropped", true);
				break findppl;
			   }		    
			}
		   }		    
		}		
	}	
	
	
	public void deleteSiteIDsFromSiteIDTable(WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(3000);	
		companyName.click();
		Thread.sleep(2000);	
		companyElement.click();
		Thread.sleep(5000);
		expandResultsButtonOne.click();
		Thread.sleep(4000);
		ASIRefreshButton.click();
		Thread.sleep(3000);
		
		for (int i=1; i<=1; i++)
		{
			if (driver.findElement(By.xpath("(//table[@id='T536871040']//child::td[@scope='row'])["+i+"]")).isDisplayed()){					
				   driver.findElement(By.xpath("(//table[@id='T536871040']//child::td[@scope='row'])["+i+"]")).click();
				  Thread.sleep(4000);
				  ASIDeleteButton.click();
				  Thread.sleep(2000);
				  element_found = true;
			}			
		}
		
		if (!element_found){
			Reporter.log(getTimeStamp() +": No element found in the table", true);
		}
		
	}
	
	public void validateSiteIDsFromSiteIDTable(WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(3000);	
		companyName.click();
		Thread.sleep(2000);	
		companyElement.click();
		Thread.sleep(5000);
		expandResultsButtonOne.click();
		Thread.sleep(4000);
		ASIRefreshButton.click();
		Thread.sleep(3000);
		
	}
	
	
	public void clickoncommitchangesbutton(String P_Comp, WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(3000);	
		companyName.click();
		Thread.sleep(2000);	
		companyElement.click();
		Thread.sleep(4000);		
		Reporter.log(getTimeStamp() +": Commit changes button clicked by the user", true);
		String parentWindow = driver.getWindowHandle();
		commitChanges.click();	
		long start = System.currentTimeMillis();
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
		driver.switchTo().window(parentWindow);		
		WebDriverWait wait = new WebDriverWait(driver, 7200);
		try{				
			Thread.sleep(5000);	
			String retrieved_text = "Complete";
			wait.until(ExpectedConditions. attributeContains(EditStatus, "value", retrieved_text));						
			companyName.sendKeys(Keys.ENTER);
			long finish = System.currentTimeMillis();
			long totalTime = finish - start;
			DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");	
			df.setTimeZone(TimeZone.getTimeZone("GMT+5.5"));			
			Reporter.log(getTimeStamp() +": Time consumed to Commit changes for the company: " +P_Comp.toUpperCase() +" :" +df.format(new Date(totalTime)), true);
			Thread.sleep(1000);
			companyElement.click();
			Thread.sleep(70000);			
		}catch(Exception e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Timeout')]")));			
			Reporter.log(getTimeStamp() +": Time out when Commit changes button is clicked by the user for the company: " +P_Comp.toUpperCase(), true);			
		}						
	}	
	
	public void clickOnResetStagingButton(String P_Comp, WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(3000);	
		companyName.click();
		Thread.sleep(2000);	
		companyElement.click();
		Thread.sleep(4000);
		Reporter.log(getTimeStamp() +": Reset Staging button has been clicked by the user", true);
		resetStaging.click();
		long start = System.currentTimeMillis();		
		WebDriverWait wait = new WebDriverWait(driver, 7200);
		try{			
			Thread.sleep(5000);	
			String retrieved_text = "Ready for Edit";
			wait.until(ExpectedConditions.attributeContains(EditStatus, "value", retrieved_text));		
			long finish = System.currentTimeMillis();
			long totalTime = finish - start;
			DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");	
			df.setTimeZone(TimeZone.getTimeZone("GMT+5.5"));			
			Reporter.log(getTimeStamp() +": Time consumed to Reset staging table for the company: " +P_Comp.toUpperCase() +" :" +df.format(new Date(totalTime)), true);		
			Thread.sleep(2000);
			refreshButton.click();
			Thread.sleep(5000);
			companyElement.click();
			Thread.sleep(4000);
			ASIRefreshButton.click();			
			Thread.sleep(4000);			
			Reporter.log(getTimeStamp() +": Reset staging table is COMPLETE!! ", true);
			
		}catch(Exception e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Timeout')]")));		
			Reporter.log(getTimeStamp() +": Time out when reset staging button is clicked by the user for the company: " +P_Comp.toUpperCase(), true);		
		}
	}
	
	public void clickOnCancelButton(String P_Comp, WebDriver driver)
			throws InterruptedException {
		
		companyName.click();
		Thread.sleep(3000);	
		Reporter.log(getTimeStamp() +": Cancel Editing button has been clicked by the user", true);
		refreshButton.click();
		cancelEditing.click();
		long start = System.currentTimeMillis();		
		
		WebDriverWait wait = new WebDriverWait(driver, 500);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'Search')])[5]")));
			validateStagingTablesForDataOffload(P_Comp, driver);
			long finish = System.currentTimeMillis();
			long totalTime = finish - start;
			DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");	
			df.setTimeZone(TimeZone.getTimeZone("GMT+5.5"));
			Reporter.log(getTimeStamp() +": Time consumed to offload staging table for the company: " +P_Comp.toUpperCase() +" :" +df.format(new Date(totalTime)), true);		
			Thread.sleep(3000);
			
		}catch(Exception e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Timeout')]")));
			Reporter.log(getTimeStamp() +": Time out when cancel editing button is clicked by the user for the company: " +P_Comp.toUpperCase(), true);			
		}				
	}
	
	public void validatePeopleSection(String P_Destdept, WebDriver driver)
			throws InterruptedException {
		
		companyName.click();
		Thread.sleep(3000);
		
		List <WebElement> Expander = driver.findElements(By.xpath("//img[contains(@id,'handlerTN')]"));		
		Reporter.log(getTimeStamp() +": Total No of expand buttons are:" +Expander.size(), true);
		Thread.sleep(4000);
		
		for (int i=1; i<=Expander.size(); i++)
		{
		   driver.findElement(By.xpath("(//img[contains(@id,'handlerTN')])["+i+"]")).click();
		}
		
		StringBuilder builder = new StringBuilder();	    
	    builder.append(BLANK_SPACE);
	    builder.append(P_Destdept);
	    String DestDept = builder.toString();
		
		List <WebElement> TElements = driver.findElements(By.xpath("//a[contains(@id,'titleTN')]"));
		Reporter.log(getTimeStamp() +": Total No of elements(Company/Organization/Department) are:" +TElements.size(), true);
		Thread.sleep(2000);

	    
		for (int i=1; i<=TElements.size(); i++)
		{
			if(driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).getText().equals(DestDept)) {
		    driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).click();
		    Reporter.log(getTimeStamp() +": Destination Department has been selected", true);		    
		   }		    
		}
		
		Thread.sleep(2000);
		peopleSection.click();
		Thread.sleep(4000);
	}
	
	public void createNewDeptUnderTheOrg(String P_newDept, String P_org, WebDriver driver)
			throws InterruptedException {
		
		companyName.click();
		Thread.sleep(2000);
		companyElement.click();
		Thread.sleep(2000);
		addDepartment.click();
		Thread.sleep(4000);
		String parentWindow = driver.getWindowHandle();
		switchToNewWindow(2);
		organization.clear();
		organization.sendKeys(P_org);
		Reporter.log(getTimeStamp() +": Organization has been selected by the user", true);
		Thread.sleep(2000);
		newDepartment.clear();
		newDepartment.sendKeys(P_newDept);
		Reporter.log(getTimeStamp() +": New department has been entered by the user", true);
		Thread.sleep(2000);
		defaultSourceCompanyId.click();
		Thread.sleep(4000);
		defaultSourceCompanyIdValue.click();
		Reporter.log(getTimeStamp() +": Default source company ID selected by the user", true);
		Thread.sleep(2000);
		if (defaultSiteIdButton.isSelected()) {
			Reporter.log(getTimeStamp() +": Default site ID radio button is already checked", true);
			Thread.sleep(3000);
		} else{
			defaultSiteIdButton.click();		
			Reporter.log(getTimeStamp() +": Default site Id is checked by the user", true);
			Thread.sleep(3000);
		}		
		defaultSiteIdField.click();
		Thread.sleep(4000);
		defaultSiteIdvalue.click();
		Reporter.log(getTimeStamp() +": Site Id for default service zone is populated by the user", true);
		Thread.sleep(3000);
		pendingzervicezoneField.click();
		Thread.sleep(4000);
		pendingzervicezone.click();
		Reporter.log(getTimeStamp() +": Site Id for Pending service zone is populated by the user", true);
		Thread.sleep(3000);
		save.click();
		Reporter.log(getTimeStamp() +": Save button clicked by the user", true);
		Thread.sleep(8000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);		
	}
	
	public void clearTheCompanyNameField(WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(6000);
		companyName.clear();
		Thread.sleep(2000);
	}
}