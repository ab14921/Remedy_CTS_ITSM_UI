package com.ServiceModellingUtility.remedyPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.Generic.remedyPage.Baseclass;
import com.DataBase.NamedParameterStatement;
import com.DataBase.DBUtil;

import com.DataBase.DBTablePrinter;

public class SMUBasePage extends Baseclass{
	
	boolean dept_rename_complete;
	boolean dept_found;
	boolean done = false;
	boolean done1 = false;
	boolean done2 = false;
	boolean done3 = false;
	boolean done4 = false;
	boolean done5 = false;
	boolean done6 = false;
	boolean done7 = false;
	boolean done8 = false;
	
	private static final String BLANK_SPACE=" ";
	String Dept_name;
	boolean size = false;
	
	
	
	@FindBy(xpath = "//img[@id='reg_img_880000009']")
	private static WebElement SourceSearchButton;
	@FindBy(xpath = "//img[@id='reg_img_536870922']")
	private static WebElement DestinationCompanySearchButton;
	@FindBy(xpath = "//label[@id='label536870913']//following::input[@id='arid_WIN_3_536870913']")
	private static WebElement EditStatus;
	@FindBy(xpath = "//input[@title='Commiting Changes']")
	private static WebElement EditStatusValue;
	@FindBy(xpath = "//label[contains(text(),'Company_Details')]")
	private WebElement sectionOne;	
	@FindBy(xpath = "//div[contains(@id,'536871040')]")
	private WebElement sectionTwo;	
	@FindBy(xpath = "//div[contains(@id,'536870917')]")
	private WebElement sectionThree;	
	@FindBy(xpath = "//div[contains(@id,'536870989')]")
	private WebElement sectionFour;	
	@FindBy(xpath = "//div[contains(@id,'536870997')]")
	private WebElement sectionFive;
	@FindBy(xpath = "//div[contains(@id,'536871020')]")
	private WebElement sectionSix;
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[1]")
	private WebElement expandSectionOne;	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[2]")
	private WebElement expandSectionTwo;	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[3]")
	private WebElement expandSectionThree;	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[4]")
	private WebElement expandSectionFour;	
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[5]")
	private WebElement expandSectionFive;
	@FindBy(xpath = "(//span[@class='Twisty Tsize'])[6]")
	private WebElement expandSectionSix;	
	@FindBy(xpath="(//div[contains(text(),'Logout')])[2]")
	private WebElement logout;
	
	String arsys_jdbc_url = q.getProperty("arsys.jdbc.url");
	String arsys_jdbc_username = q.getProperty("arsys.jdbc.username");
	String arsys_jdbc_password = q.getProperty("arsys.jdbc.password");
	String mdm_jdbc_url = q.getProperty("mdm.jdbc.url");
	String mdm_jdbc_username = q.getProperty("mdm.jdbc.username");
	String mdm_jdbc_password = q.getProperty("mdm.jdbc.password");
	
	String Query_Staging_Table1 = p
			.getProperty("Query_Staging_Table1");
	String Query_Staging_Table2 = p
			.getProperty("Query_Staging_Table2");
	String Query_Staging_Table3 = p
			.getProperty("Query_Staging_Table3");
	String Query_Staging_Table4 = p
			.getProperty("Query_Staging_Table4");
	String Query_Staging_Table5 = p
			.getProperty("Query_Staging_Table5");
	String Query_Staging_Table6 = p
			.getProperty("Query_Staging_Table6");
	String Query_Staging_Table7 = p
			.getProperty("Query_Staging_Table7");
	String Query_Staging_Table8 = p
			.getProperty("Query_Staging_Table8");
	String Query_Staging_Table9 = p
			.getProperty("Query_Staging_Table9");
	
	public SMUBasePage(WebDriver driver){
		super();
		PageFactory.initElements(driver, this);
	}
	
	public static void clickOnSourceCompanySearchButton(){
		SourceSearchButton.click();
	}
	public static void clickOnDestinationCompanySearchButton(){
		DestinationCompanySearchButton.click();
	}
	
//	public void switchToNewWindow(int windowNumber) throws InterruptedException {		
//	    Set < String > s = driver.getWindowHandles();   
//	    Iterator < String > ite = s.iterator();
//	    int i = 1;
//	    while (ite.hasNext() && i < 10) {
//	        String popupHandle = ite.next().toString();
//	        driver.switchTo().window(popupHandle);
//	        Reporter.log(getTimeStamp() +": Window title is : "+driver.getTitle());
//	        if (i == windowNumber) break;
//	        i++;
//	    }
//	}
	
	public void updateremedyandMDMtables(WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(5000);
		
		Reporter.log(getTimeStamp() +": Edit status:" +EditStatus.getAttribute("value"), true);
		
		
		if (EditStatus.getAttribute("value").contains("Commiting")) {
			Reporter.log(getTimeStamp() +": "+EditStatus.getAttribute("value"), true);
			Reporter.log("                       Waiting for next status...", true);
			String retrieved_text = "Staging";			
			WebDriverWait wait = new WebDriverWait(driver, 5400);
			wait.until(ExpectedConditions.attributeContains(EditStatus, "value", retrieved_text));
		} else {

			Reporter.log(getTimeStamp() +": "+EditStatus.getAttribute("value"), true);
		}
		
		if (EditStatus.getAttribute("value").contains("Staging")) {
			Reporter.log(getTimeStamp() +": "+EditStatus.getAttribute("value"), true);
			Reporter.log("                       Waiting for next status...", true);
			String retrieved_text = "Ready for Edit";
			WebDriverWait wait = new WebDriverWait(driver, 5400);
			wait.until(ExpectedConditions.attributeContains(EditStatus, "value", retrieved_text));
		} else {

			Reporter.log(getTimeStamp() +": "+EditStatus.getAttribute("value"), true);
		}
		
		if (EditStatus.getAttribute("value").contains("Ready")) {
			Reporter.log(getTimeStamp() +": "+EditStatus.getAttribute("value"), true);
			dept_rename_complete = true;
			return;
		}
	}
	
	public void validatetheresultsonSMUUI(String P_sel_Element, WebDriver driver)
			throws InterruptedException {
		
		Thread.sleep(5000);
		
		List <WebElement> Expander1 = driver.findElements(By.xpath("//img[contains(@id,'handlerTN')]"));		
		Reporter.log(getTimeStamp() +": Total No of expand buttons are:1:" +Expander1.size(), true);
		
		for (int i=1; i<=Expander1.size(); i++)
		{
		   driver.findElement(By.xpath("(//img[contains(@id,'handlerTN')])["+i+"]")).click();
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(BLANK_SPACE);
	    builder.append(P_sel_Element);
	    Dept_name = builder.toString();
	    
		
		List <WebElement> TElements = driver.findElements(By.xpath("//a[contains(@id,'titleTN')]"));
		Reporter.log(getTimeStamp() +": Total No of elements(Company/Organization/Department) are:" +TElements.size(), true);
		Thread.sleep(2000);	
	    
		Reporter.log(getTimeStamp() +": new department name :" +P_sel_Element, true);
		
		for (int i=1; i<=TElements.size(); i++)
		{
			if(driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).getText().equals(Dept_name)) {
		    driver.findElement(By.xpath("(//a[contains(@id,'titleTN')])["+i+"]")).click();
		    Reporter.log(getTimeStamp() +": Renamed Department has been selected by the user", true);
		    dept_found = true;
		   }		    
		}
		
		if(!dept_found){
			Reporter.log(getTimeStamp() +": No such department found", true);
		}
		
		Thread.sleep(4000);
		
		List <WebElement> Expander2 = driver.findElements(By.xpath("//span[@class='Twisty Tsize']"));		
		Reporter.log(getTimeStamp() +": Total No of expand buttons are:2:" +Expander2.size(), true);
		
		for (int i=2; i<=Expander2.size(); i++)
		{
		   driver.findElement(By.xpath("(//span[@class='Twisty Tsize'])["+i+"]")).click();
		   Thread.sleep(3000);
		}
	}
	
	public void expandSectionsInSMU(WebDriver driver) throws InterruptedException {
		
		if (sectionOne.isDisplayed()){
			Reporter.log(getTimeStamp() +": Section 1 is already expanded", true);
		}else{
			expandSectionOne.click();
			Reporter.log(getTimeStamp() +": Section 1 is expanded by the User", true);
			Thread.sleep(6000);
		}
		
		if (sectionOne.isDisplayed()){
			Reporter.log(getTimeStamp() +": Section 2 is already expanded", true);
		}else{
			expandSectionTwo.click();
			Reporter.log(getTimeStamp() +": Section 2 is expanded by the User", true);
			Thread.sleep(6000);
		}
		
		if (sectionThree.isDisplayed()){
			Reporter.log(getTimeStamp() +": Section 3 is already expanded", true);
		}else{
			expandSectionThree.click();
			Reporter.log(getTimeStamp() +": Section 3 is expanded by the User", true);
			Thread.sleep(6000);
		}
		
		if (sectionFour.isDisplayed()){
			Reporter.log(getTimeStamp() +": Section 4 is already expanded", true);
		}else{
			expandSectionFour.click();
			Reporter.log(getTimeStamp() +": Section 4 is expanded by the User", true);
			Thread.sleep(6000);
		}
		
		if (sectionFive.isDisplayed()){
			Reporter.log(getTimeStamp() +": Section 5 is already expanded", true);
		}else{
			expandSectionFive.click();
			Reporter.log(getTimeStamp() +": Section 5 is expanded by the User", true);
			Thread.sleep(6000);
		}
		
		if (sectionSix.isDisplayed()){
			Reporter.log(getTimeStamp() +": Section 6 is already expanded", true);
		}else{
			expandSectionSix.click();
			Reporter.log(getTimeStamp() +": Section 6 is expanded by the User", true);
			Thread.sleep(6000);
		}
		
	}
	
	public void validateStagingTablesForDataOffload(String P_Comp, WebDriver driver) throws Exception {				
		DBUtil dbutil = new DBUtil();
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table1);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table1 in progress....", true);
		while (!done){
			if (size){
				done = true;				
				Reporter.log(getTimeStamp() +": Staging Table1 has been offloaded", true);
			}else{
				Thread.sleep(3000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table1);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table2);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table2 in progress....", true);
		while (!done1){
			if (size){
				done1 = true;				
				Reporter.log(getTimeStamp() +": Staging Table2 has been offloaded", true);
			}else{
				Thread.sleep(3000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table2);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table3);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table3 in progress....", true);
		while (!done2){
			if (size){
				done2 = true;				
				Reporter.log(getTimeStamp() +": Staging Table3 has been offloaded", true);
			}else{
				Thread.sleep(3000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table3);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table4);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table4 in progress....", true);
		while (!done3){
			if (size){
				done3 = true;				
				Reporter.log(getTimeStamp() +": Staging Table4 has been offloaded", true);
			}else{
				Thread.sleep(3000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table4);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table5);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table5 in progress....", true);
		while (!done4){
			if (size){
				done4 = true;				
				Reporter.log(getTimeStamp() +": Staging Table5 has been offloaded", true);
			}else{
				Thread.sleep(3000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table5);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table6);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table6 in progress....", true);
		while (!done5){
			if (size){
				done5 = true;				
				Reporter.log(getTimeStamp() +": Staging Table6 has been offloaded", true);
			}else{
				Thread.sleep(3000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table6);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table7);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table7 in progress....", true);
		while (!done6){
			if (size){
				done6 = true;				
				Reporter.log(getTimeStamp() +": Staging Table7 has been offloaded", true);
			}else{
				Thread.sleep(3000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table7);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table8);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table8 in progress....", true);
		while (!done7){
			if (size){
				done7 = true;				
				Reporter.log(getTimeStamp() +": Staging Table8 has been offloaded", true);
			}else{
				Thread.sleep(6000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table8);
			}			
		}
		
		size = dbutil.validateStagingTable(P_Comp, "co",
				Query_Staging_Table9);
		Reporter.log(getTimeStamp() +": Offloading of Staging Table9 in progress....", true);
		while (!done8){
			if (size){
				done8 = true;				
				Reporter.log(getTimeStamp() +": Staging Table9 has been offloaded", true);
			}else{
				Thread.sleep(6000);
				size = dbutil.validateStagingTable(P_Comp, "co",
						Query_Staging_Table9);
			}			
		}
	}
	
//	public Timestamp getTimeStamp() throws InterruptedException {		
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());						
//		return timestamp;
//	}
	
	public void clickOnLogout(WebDriver driver) throws InterruptedException {				
		logout.click();		
		Reporter.log(getTimeStamp() +": User has been logged out of the application", true);				
		driver.quit();
	}
	
}
