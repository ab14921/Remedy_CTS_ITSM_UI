package com.Generic.stepdefinition;



import java.io.FileNotFoundException;


import cucumber.api.Scenario;	
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Reporter;


import com.ServiceModellingUtility.remedyPage.SMUBasePage;
import com.ServiceModellingUtility.remedyPage.CompanyMargePage;
import com.ServiceModellingUtility.remedyPage.CompanyRename;
import com.DataBase.DBUtil;
import com.ServiceModellingUtility.remedyPage.DepartmentRename;
import com.Generic.remedyPage.Baseclass;
import com.Generic.remedyPage.HomePage;
import com.Generic.remedyPage.LoginPage;
import com.Generic.testing.RunTest;
import com.ServiceModellingUtility.remedyPage.OrganizationSplit;
import com.ServiceModellingUtility.remedyPage.ServiceModellingUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.CucumberException;

import com.AIMS.remedyPage.AIMSHome;

public class StepDefinition extends Baseclass {
	
	String arsys_jdbc_url = q.getProperty("arsys.jdbc.url");
	String arsys_jdbc_username = q.getProperty("arsys.jdbc.username");
	String arsys_jdbc_password = q.getProperty("arsys.jdbc.password");
	
	String syn_mdm_co_table_Merge_query = p
			.getProperty("syn_mdm_co_table_Merge_query");
	String syn_mdm_co_table_Merge_query_to_Find_PAR_CO_GUID = p
			.getProperty("syn_mdm_co_table_Merge_query_to_Find_PAR_CO_GUID");
	String Query_syn_mdm_co_validation1 = p
			.getProperty("Query_syn_mdm_co_validation1");
	String query_to_find_Company_Entry_ID_COM_Company = p
			.getProperty("query_to_find_Company_Entry_ID_COM_Company");
	String Query_CTM_people_validation = p
			.getProperty("Query_CTM_people_validation");
	String Query_CTM_people_validation2 = p
			.getProperty("Query_CTM_people_validation2");
	String Query_CTM_people_validation3 = p
			.getProperty("Query_CTM_people_validation3");

	String Query_AST_Impacted_Areas_validation = p
			.getProperty("Query_AST_Impacted_Areas_validation");
	String Query_AST_Impacted_Areas_validation2 = p
			.getProperty("Query_AST_Impacted_Areas_validation2");
	String Query_SIT_Site_Company_Association_validation = p
			.getProperty("Query_SIT_Site_Company_Association_validation");
	String Query_CTM_People_Organization_validation = p
			.getProperty("Query_CTM_People_Organization_validation");
	String Query_HPD_Help_desk_validation = p
			.getProperty("Query_HPD_Help_desk_validation");
	String Query_SAV_AIMS_EvResInsAss_Appr_validation = p
			.getProperty("Query_SAV_AIMS_EvResInsAss_Appr_validation");
	String Query_smu_companymergeauditrecord_validation = p
			.getProperty("Query_smu_companymergeauditrecord_validation");
	String Query_SMU_CompanyEditRecord_Validation = p
			.getProperty("Query_SMU_CompanyEditRecord_Validation");
	String Query_AST_AssetPeople_validation = p
			.getProperty("Query_AST_AssetPeople_validation");
	String Query_AST_AssetPeople_validation2 = p
			.getProperty("Query_AST_AssetPeople_validation2");
	String Query_HPD_Impacted_Areas_validation = p
			.getProperty("Query_HPD_Impacted_Areas_validation");
	String Query_HPD_Impacted_Areas_validation2 = p
			.getProperty("Query_HPD_Impacted_Areas_validation2");
	String Query_smu_companyrenameauditrecord_validation = p
			.getProperty("Query_smu_companyrenameauditrecord_validation");
//	String Query_SMU_vrfy_serv_zn_validation = p
//			.getProperty("Query_SMU_vrfy_serv_zn_validation");
//	String Query_SMU_vrfy_serv_acct_validation = p
//			.getProperty("Query_SMU_vrfy_serv_acct_validation");
	
	//Department Rename STARTS
	String Query_syn_mdm_co_validation2 = p
			.getProperty("Query_syn_mdm_co_validation2");
	String Query_CTM_people_validation4 = p
			.getProperty("Query_CTM_people_validation4");
	String Query_AST_Impacted_Areas_validation3 = p
			.getProperty("Query_AST_Impacted_Areas_validation3");
	String Query_CTM_People_Organization_validation3 = p
			.getProperty("Query_CTM_People_Organization_validation3");
	String Query_AST_AssetPeople_validation3 = p
			.getProperty("Query_AST_AssetPeople_validation3");
	String Query_HPD_Impacted_Areas_validation3 = p
			.getProperty("Query_HPD_Impacted_Areas_validation3");
	String Query_SYN_MDM_SERV_ZN_validation = p
			.getProperty("Query_SYN_MDM_SERV_ZN_validation");
	String Query_SYN_MDM_SERV_ACCT_validation = p
			.getProperty("Query_SYN_MDM_SERV_ACCT_validation");
	String Query_CO_validation = p
			.getProperty("Query_CO_validation");
	String Query_CO_NM_validation = p
			.getProperty("Query_CO_NM_validation");
	String Query_KEY_CROSS_REF_validation = p
			.getProperty("Query_KEY_CROSS_REF_validation");
	String Query_SERV_ZN_validation = p
			.getProperty("Query_SERV_ZN_validation");
	String Query_SERV_ACCT_validation = p
			.getProperty("Query_SERV_ACCT_validation");
	//Department Rename ENDS
	
	//Company Rename and Merge STARTS
	String Query_CO_validation1 = p
			.getProperty("Query_CO_validation1");	
	String Query_CO_NM_validation1 = p
			.getProperty("Query_CO_NM_validation1");
	String Query_KEY_CROSS_REF_validation1 = p
			.getProperty("Query_KEY_CROSS_REF_validation1");
	String Query_SERV_ZN_validation1 = p
			.getProperty("Query_SERV_ZN_validation1");
	String Query_SERV_ACCT_validation1 = p
			.getProperty("Query_SERV_ACCT_validation1");
	String Query_Remedy_ServiceZone = p
			.getProperty("Query_Remedy_ServiceZone");
	String Query_Remedy_ServiceAccount = p
			.getProperty("Query_Remedy_ServiceAccount");
	
	//Company Rename and Merge ENDS
	
	//Organization Split Starts
	String Query_CO_validation2 = p
			.getProperty("Query_CO_validation2");
	String Query_CO_NM_validation2 = p
			.getProperty("Query_CO_NM_validation2");
	//Organization Split ENDS
	
	//SMU STARTS
	String Query_Validate_Contact_MDM = p
			.getProperty("Query_Validate_Contact_MDM");
	//SMU ENDS
	//Splunk Log Variables
    static long featurefromtime,featuretotime;
	public static JSONArray arrObj = new JSONArray();
	public static int scenarioCount=0;

    //
//***********************************SPLUNK LOG starts*************************************************************
	

	   @Before
	public void beforeEveryScenario(Scenario scenario) throws Exception {
		   scenarioCount++;
		   featurefromtime=System.currentTimeMillis();
	   }
	   
	
	@After
	@SuppressWarnings("unchecked")
	public void afterEveryScenario(Scenario scenario) {
		featuretotime=System.currentTimeMillis();
		arrObj.add(getJsonObject(scenario));
	
	   }
	@SuppressWarnings("unchecked")
	private JSONObject getJsonObject(Scenario scenario) {
		   String status="";String errorDetails="NA";
		   JSONObject jObj = new JSONObject();
		   jObj.put("Duration", calculateDuration(featurefromtime,featuretotime));
		   jObj.put("Env", RunTest.Environment);
		   jObj.put("MAL", RunTest.applicationName);
		   jObj.put("OutputType", "Scenario-Detail");
		   jObj.put("Scenario", scenario.getName());
		   if(scenario.getStatus().equalsIgnoreCase("passed")) {
			   status="Pass";
		   }else if(scenario.getStatus().equalsIgnoreCase("failed")) {
			   status="Fail";
			   errorDetails="Exception while executing the scenario";
		   }
		   jObj.put("Status", status);
		   
		   jObj.put("errordetails", errorDetails);
		   return jObj ;
	   }
	   public String calculateDuration(long Ftime,long Ttime){
		    long milliseconds =Ttime -  Ftime;
			long diffSeconds = milliseconds / 1000 % 60;
			long diffMinutes = milliseconds / (60 * 1000) % 60;
			long diffHours = milliseconds / (60 * 60 * 1000) % 24;
			return diffHours+"."+diffMinutes+"."+diffSeconds;
	   }
	
	
	

	
	
//************************************** SPLUNK LOG ends ***************************************************//	
	
//************************************** Common Steps Starts ***********************************************//	
	@Given("^open browser and start application$")
	public void open_browser_and_start_application() throws Throwable {

		environment();
		browser("Chrome");
		driver.manage().window().maximize();

	}

	@Then("^login with (.+) and (.+) to Remedy$")
	public void login_to_Remedy(String un, String pw) throws Throwable {

		LoginPage l = new LoginPage(driver);
		l.Login_to(driver, un, pw);

	}

	@When("^Enter the valid '(.+)' and '(.+)'$")
	public void enter_the_valid_UserName_and_Password(String un, String pw) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.Login_to(driver, un, pw);

	}
	
	@Then("^Click on Logout$")
	public void click_On_Logout() throws Throwable {
		SMUBasePage bp = new SMUBasePage(driver);
		bp.clickOnLogout(driver);
	}	
	
	@Then("^logout from AIMS$")
	public void logout_From_AIMS() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.logoutFromAIMS(driver);
	}

	@Then("^close the browser$")
	public void close_the_browser() {
		HomePage h = new HomePage(driver);
		h.closingBrowser(driver);
	}
	
	@Then("^copy results on console into a text file$")
	public void Write_Console_Data_Into_Txt_File() throws FileNotFoundException, InterruptedException {
		Baseclass bc = new Baseclass();
		bc.WriteConsoleOutputIntoTxtFile();
	}
	
//************************************** Common Steps Ends ***********************************************//
	
//*************************************** AIMS STARTS ***********************************************//
	
	@When("^click on Alert Instruction Management System$")
	public void click_On_AIMS() throws Throwable {
		HomePage h = new HomePage(driver);
		h.AIMS(driver);
		Thread.sleep(5000);

	}
	
	@Then("^add instructions for the customer (.+)$")
	public void add_Instructions_For_The_Customer(String P_customer) throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addInstructionsForTheCustomer(P_customer, driver);
		Thread.sleep(5000);

	}
	
	@Then("^add matching criteria for servicezone$")
	public void add_Matching_Criteria_For_Servicezone() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addMatchingCriteriaForServiceZone(driver);
		Thread.sleep(5000);

	}
	
	@Then("^add matching criteria for ci$")
	public void add_Matching_Criteria_For_CI() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addMatchingCriteriaForCI(driver);
		Thread.sleep(5000);

	}
	
	@Then("^add matching criteria for cigroup$")
	public void add_Matching_Criteria_For_CIGroup() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addMatchingCriteriaForCIGroup(driver);
		Thread.sleep(5000);

	}
	
	@Then("^add matching criteria for site/location$")
	public void add_Matching_Criteria_For_Site_Location() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addMatchingCriteriaForSiteLocation(driver);
		Thread.sleep(5000);

	}
	
	@Then("^add matching criteria for organization$")
	public void add_Matching_Criteria_For_Organization() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addMatchingCriteriaForOrganization(driver);
		Thread.sleep(5000);

	}
	
	@Then("^add matching criteria for department$")
	public void add_Matching_Criteria_For_Department() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addMatchingCriteriaForDepartment(driver);
		Thread.sleep(5000);

	}
	
	@Then("^add matching criteria for serviceaccount$")
	public void add_Matching_Criteria_For_ServiceAccount() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.addMatchingCriteriaForServiceAccount(driver);
		Thread.sleep(5000);

	}
	
	@Then("^save AIMS instruction$")
	public void save_AIMS_Instruction() throws Throwable {
		AIMSHome ah = new AIMSHome(driver);
		ah.saveAIMSInstruction(driver);
		Thread.sleep(5000);

	}
	
//*************************************** AIMS ENDS ***********************************************//

	//************************************** MERGE STARTS ***********************************************//
	@When("^click on Company Marge$")
	public void click_on_Company_Marge() throws Throwable {
		HomePage h = new HomePage(driver);
		h.companyMarge(driver);

	}

	@Then("^check user permission to marge the company$")
	public void check_user_permission_to_marge_the_company() throws Throwable {

		CompanyMargePage c = new CompanyMargePage(driver);
		c.testCompanyMergePage();
	}

	@When("^User have an option on the fly-out menu for Company Merge$")
	public void User_have_an_option_on_the_fly_out_menu_for_Company_Merge()
			throws InterruptedException {

		HomePage h = new HomePage(driver);
		h.companyMarge(driver);

	}

	@Then("^user do not have an option on the fly-out for Company Merge$")
	public void user_do_not_have_an_option_on_the_fly_out_for_Company_Merge()
			throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.companyMarge(driver);

	}

	@Then("^select the (.+) that will merge into the other (.+)$")
	public void select_the_Company_that_will_merge_into_the_other_company(
			String comp1, String comp2) throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.testcompanyMarge(comp1, comp2, driver);
	}

	@Then("^validate syn_mdm_co table of sourcecompany (.+) from database before merge$")
	public void validateSourceCompanyFromDatabaseBeforeMerge(
			String sourcecompany) throws Exception {
		Reporter.log(
				"******validate syn_mdm_co table of source Company From Database Before Merge*****",
				true);
		DBUtil dbutil = new DBUtil();
		
		System.out.println("Source company is : " +sourcecompany);
		System.out.println("Query is : " +syn_mdm_co_table_Merge_query);
		dbutil.validationWithDatabase(sourcecompany, "co",
				syn_mdm_co_table_Merge_query);
		Reporter.log(
				"******validation complete for syn_mdm_co table of source Company From Database Before Merge*****",
				true);
	}

	@Then("^validate syn_mdm_co table of sourcecompany (.+) from database after merge$")
	public void validateSourceCompanyFromDatabaseAfterMerge(String sourcecompany)
			throws Exception {
		Reporter.log("******validate syn_mdm_co table of source Company From Database after Merge*****",true);

		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				syn_mdm_co_table_Merge_query);
		Reporter.log("******validation complete for syn_mdm_co table of source Company From Database after Merge*****",true);
	}

	@Then("^validate syn_mdm_co table of destinationcompany (.+) from database before merge$")
	public void validateDestinationCompanyFromDatabaseBeforeMerge(
			String destinationcompany) throws Exception {
		Reporter.log(
				"******validate syn_mdm_co table of Destination Company From Database Before Merge*****",
				true);

		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				syn_mdm_co_table_Merge_query);

		Reporter.log(
				"******validation complete for  syn_mdm_co table of Destination Company From Database Before Merge*****",
				true);

	}

	@Then("^validate syn_mdm_co table of destinationcompany (.+) from database after merge$")
	public void validateDestinationCompanyFromDatabaseAfterMerge(
			String destinationcompany) throws Exception {
		Reporter.log("******validate syn_mdm_co table of Destination Company From Database after Merge*****",true);

		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				syn_mdm_co_table_Merge_query);
		Reporter.log("******validation complete for  syn_mdm_co table of Destination Company From Database after Merge*****",true);

	}

	@Then("^validate SIT_Site_Company_Association table of source company (.+) before merge$")
	public void validate_SIT_Site_Company_Association_table_of_source_company_before_merge(
			String sourcecompany) throws Exception {
		Reporter.log(
				"******validate SIT_Site_Company_Association table for  source Company From Database Before Merge*****",
				true);

		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_SIT_Site_Company_Association_validation);
		Reporter.log(
				"******validation complete for  SIT_Site_Company_Association table for  source Company From Database Before Merge*****",
				true);
	}

	@Then("^validate SIT_Site_Company_Association table of destination company (.+) before merge$")
	public void validate_SIT_Site_Company_Association_table_of_destination_company_before_merge(
			String destinationcompany) throws Exception {
		Reporter.log(
				"******validate SIT_Site_Company_Association table for  destination Company From Database Before Merge*****",
				true);
		// Class.forName("net.sourceforge.jtds.jdbc.Driver");
		// Connection con = DriverManager.getConnection(arsys_jdbc_url,
		// arsys_jdbc_username, arsys_jdbc_password);
		// Reporter.log("Connected to DB");
		// Statement smt = con.createStatement();
		// ResultSet rs = smt
		// .executeQuery("Select Site_Company_Association_ID, Last_Modified_By, Last_Modified_Date, Company, InstanceId, Site_Id from SIT_Site_Company_Association where Company = '"
		// + destinationcompany + "'");
		//
		// DBTablePrinter.printResultSet(rs);
		// con.close();
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_SIT_Site_Company_Association_validation);
		Reporter.log(
				"******validation complete for  SIT_Site_Company_Association table for  destination Company From Database Before Merge*****",
				true);
	}

	@Then("^validate SIT_Site_Company_Association table of source company (.+) after merge$")
	public void validate_SIT_Site_Company_Association_table_of_source_company_after_merge(
			String sourcecompany) throws Exception {
		Reporter.log("******validate SIT_Site_Company_Association table for  source Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_SIT_Site_Company_Association_validation);
		Reporter.log("******validation complete for  SIT_Site_Company_Association table for  source Company From Database after Merge*****",true);
	}
	
	@Then("^validate SIT_Site_Company_Association table of destination company (.+) after merge$")
	public void validate_SIT_Site_Company_Association_table_of_destination_company_after_merge(
			String destinationcompany) throws Exception {
		Reporter.log("******validate SIT_Site_Company_Association table for  destination Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_SIT_Site_Company_Association_validation);
		Reporter.log("******validation complete for  SIT_Site_Company_Association table for  destination Company From Database after Merge*****",true);
	}

//	@Then("^validate SIT_Site_Company_Association table of destination company (.+) after merge$")
//	public void validate_SIT_Site_Company_Association_table_of_destination_company_after_merge(
//			String destinationcompany) throws Exception {
//		Reporter.log("******validate SIT_Site_Company_Association table for  destination Company From Database after Merge*****");
//		Class.forName("net.sourceforge.jtds.jdbc.Driver");
//		Connection con = DriverManager.getConnection(arsys_jdbc_url,
//				arsys_jdbc_username, arsys_jdbc_password);
//		Reporter.log("Connected to DB");
//		Statement smt = con.createStatement();
//		ResultSet rs = smt
//				.executeQuery("Select Site_Company_Association_ID, Last_Modified_By, Last_Modified_Date, Company, InstanceId, Site_Id from SIT_Site_Company_Association where Company = '"
//						+ destinationcompany + "'");
//
//		Reporter.log(String.format("%25s|%25s|%25s|%25s|%25s|%25s",
//				"Site_Company_Association_ID", "Last_Modified_By",
//				"Last_Modified_Date", "Company", "InstanceId", "Site_Id"));
//
//		DBTablePrinter.printResultSet(rs);
//		con.close();
//		Reporter.log("******validation complete for  SIT_Site_Company_Association table for  destination Company From Database after Merge*****");
//	}

	
	@Then("^Select The (.+) That will merge into the other field$")
	public void select_the_company_that_will_merge_into_the_other_field(
			String comp) throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.testcompanyMarge1(comp);
	}

	@Then("^validate COM_Company and CTM_people table of source company (.+) before merge$")
	public void validate_COM_Company_Table_Of_Source_Company_Before_Merge(
			String sourcecompany) throws Exception {
		Reporter.log(
				"******validate COM_Company table & CTM_people table for  source Company From Database before Merge*****",
				true);

		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameDatabase(sourcecompany, "co",
				query_to_find_Company_Entry_ID_COM_Company, "Company_Entry_ID",
				Query_CTM_people_validation, "companyID");
		Reporter.log(
				"******validation complete for  COM_Company table & CTM_people table for  source Company From Database before Merge*****",
				true);
	}

	@Then("^validate COM_Company and CTM_people table of destination company (.+) before merge$")
	public void validate_COM_Company_Table_Of_Destination_Company_Before_Merge(
			String destinationcompany) throws Exception {
		Reporter.log(
				"******validate COM_Company table & CTM_people table for  destination Company From Database before Merge*****",
				true);
	

		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameDatabase(destinationcompany,
				"co", query_to_find_Company_Entry_ID_COM_Company,
				"Company_Entry_ID", Query_CTM_people_validation, "companyID");
		Reporter.log(
				"******validation complete for COM_Company table & CTM_people table for  destination Company From Database before Merge*****",
				true);

	}

	@Then("^validate COM_Company and CTM_people table of destination company (.+) after merge$")
	public void validate_COM_Company_Table_Of_Destination_Company_After_Merge(
			String destinationcompany) throws Exception {
		Reporter.log("******validate COM_Company table & CTM_people table for  destination Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameDatabase(destinationcompany,
				"co", query_to_find_Company_Entry_ID_COM_Company,
				"Company_Entry_ID", Query_CTM_people_validation, "companyID");
			Reporter.log("******validation complete for  COM_Company table & CTM_people table for  destination Company From Database after Merge*****",true);
		}
	

	@Then("^validate COM_Company and CTM_people table of source company (.+) after merge$")
	public void validate_COM_Company_Table_Of_Source_Company_After_Merge(
			String sourcecompany) throws Exception {
		Reporter.log("******validate COM_Company table & CTM_people table for  source Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameDatabase(sourcecompany, "co",
				query_to_find_Company_Entry_ID_COM_Company, "Company_Entry_ID",
				Query_CTM_people_validation, "companyID");
			Reporter.log("******validation complete for  COM_Company table & CTM_people table for  source Company From Database after Merge*****",true);
		}
	

	@When("^Click on initiate button$")
	public void Click_on_initiate_button() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.testInitiateButton(driver);
	}

	@Then("^Check the merge status$")
	public void Check_the_merge_status() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.mergeStatus(driver);
	}

	@Then("^If merge is success then click on view results in SMU$")
	public void if_merge_is_success_then_click_on_view_results_in_SMU() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.clickOnViewResultInSMU();
	}

	@Then("^Expand the result$")
	public void expandResult() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.expandResult();
	}

	@Then("^check any error occured or not$")
	public void checkanyerroroccuredornot() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.handleError();
	}

	@Then("^Check the merge status message$")
	public void Check_the_merge_status_message() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.mergeStatusMessage();
	}

	@Then("^Click on reset button$")
	public void click_on_Reset_button() throws Exception {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.testResetButton();

	}

	@Then("^company fields should be enabled$")
	public void company_fields_should_be_enabled() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.testCompanyTextFieldFunctionality();
	}

	@When("^click on cancel button$")
	public void click_on_cancel_button() throws InterruptedException {
		CompanyMargePage c = new CompanyMargePage(driver);
		c.clickOnCancelButton();

	}

	@Then("^User shoule be redirected to Home page$")
	public void User_shoule_be_redirected_to_Home_page() throws InterruptedException {
		LoginPage l = new LoginPage(driver);
		l.validateHomePage();
	}

	@Then("^validate AST_Impacted_Areas table of source company (.+) before merge$")
	public void test_AST_Impacted_Areas_table_beforemerge(String sourcecompany)
			throws Exception {

		Reporter.log(
				"******validate AST_Impacted_Areas table for  source Company From Database Before Merge*****",
				true);
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_AST_Impacted_Areas_validation);

		Reporter.log(
				"******validation complete for  AST_Impacted_Areas table for  source Company From Database Before Merge*****",
				true);
	}

	@Then("^validate AST_Impacted_Areas table of destination company (.+) before merge$")
	public void test_AST_Impacted_Areas_table_for_destination_beforemerge(
			String destinationcompany) throws Exception {

		Reporter.log(
				"******validate AST_Impacted_Areas table for  destination Company From Database Before Merge*****",
				true);
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_AST_Impacted_Areas_validation);

		Reporter.log(
				"******validation complete for  AST_Impacted_Areas table for  destination Company From Database Before Merge*****",
				true);
	}

	@Then("^validate AST_Impacted_Areas table of source company (.+) after merge$")
	public void test_AST_Impacted_Areas_table_after_merge(String sourcecompany)
			throws Exception {

		Reporter.log("******validate AST_Impacted_Areas table for  source Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_AST_Impacted_Areas_validation);
		Reporter.log("******validation complete for  AST_Impacted_Areas table for  source Company From Database after Merge*****",true);

	}

	@Then("^validate AST_Impacted_Areas table of destination company (.+) after merge$")
	public void test_AST_Impacted_Areas_table_for_destination_comp_after_merge(
			String destinationcompany) throws Exception {

		Reporter.log("******validate AST_Impacted_Areas table for  destination Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_AST_Impacted_Areas_validation);
		Reporter.log("******validation complete for  AST_Impacted_Areas table for  destination Company From Database after Merge*****",true);

	}	

	@Then("^validate HPD_Help_desk table of source company (.+) before merge$")
	public void test_HPD_Help_desk_table_beforemerge(String sourcecompany)
			throws Exception {

		Reporter.log("******validate HPD_Help_desk table for  source Company From Database Before Merge*****");		
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_HPD_Help_desk_validation);
		Reporter.log("******validation complete for  HPD_Help_desk table for  source Company From Database Before Merge*****");
	}

	@Then("^validate SAV_AIMS_EvResInsAss_Appr table of source company (.+) before merge$")
	public void test_SAV_AIMS_EvResInsAss_Appr_table_beforemerge(
			String sourcecompany) throws Exception {

		Reporter.log(
				"******validate SAV_AIMS_EvResInsAss_Appr table for  source Company From Database Before Merge*****",
				true);		
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_SAV_AIMS_EvResInsAss_Appr_validation);

		Reporter.log(
				"******validation complete for  SAV_AIMS_EvResInsAss_Appr table for  source Company From Database Before Merge*****",
				true);
	}
	

	@Then("^validate SAV_AIMS_EvResInsAss_Appr table of source company (.+) after merge$")
	public void test_SAV_AIMS_EvResInsAss_Appr_table_aftermerge(
			String sourcecompany) throws Exception {

		Reporter.log("******validate SAV_AIMS_EvResInsAss_Appr table for  source Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_SAV_AIMS_EvResInsAss_Appr_validation);


		Reporter.log("******validation complete for  SAV_AIMS_EvResInsAss_Appr table for  source Company From Database after Merge*****",true);
	}

	@Then("^validate SAV_AIMS_EvResInsAss_Appr table of destination company (.+) before merge$")
	public void test_SAV_AIMS_EvResInsAss_Appr_table_beforemerge_descomp(
			String destinationcompany) throws Exception {

		Reporter.log(
				"******validate SAV_AIMS_EvResInsAss_Appr table for  destination Company From Database Before Merge*****",
				true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_SAV_AIMS_EvResInsAss_Appr_validation);
		Reporter.log(
				"******validation complete for  SAV_AIMS_EvResInsAss_Appr table for  destination Company From Database Before Merge*****",
				true);
	}	

	@Then("^validate SAV_AIMS_EvResInsAss_Appr table of destination company (.+) after merge$")
	public void test_SAV_AIMS_EvResInsAss_Appr_table_aftermerge_descomp(
			String destinationcompany) throws Exception {

		Reporter.log("******validate SAV_AIMS_EvResInsAss_Appr table for  destination Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_SAV_AIMS_EvResInsAss_Appr_validation);

		Reporter.log("******validation complete for  SAV_AIMS_EvResInsAss_Appr table for  destination Company From Database after Merge*****",true);
		Thread.sleep(2000);
	}
	
	@Then("^validate SERV_ZN Remedy table for the source company (.+) before merge$")
	public void validate_SERV_ZN_Remedy_Before_Merge(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceZone);
		Reporter.log("******validation of SERV_Zone Remedy table is complete for the Source Company before merge*****",
				true);
	}
	
	@Then("^validate SERV_ZN Remedy table for the destination company (.+) before merge$")
	public void validate_SERV_ZN_Remedy_Before_Merge_Destcomp(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceZone);
		Reporter.log("******validation of SERV_Zone Remedy table is complete for the Destination Company before merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT Remedy table for the source company (.+) before merge$")
	public void validate_SERV_ACCT_Remedy_Before_Merge(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceAccount);
		Reporter.log("******validation of SERV_ACCT Remedy table is complete for the  Source Company before merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT Remedy table for the destination company (.+) before merge$")
	public void validate_SERV_ACCT_Remedy_Before_Merge_Destcomp(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceAccount);
		Reporter.log("******validation of SERV_ACCT Remedy table is complete for the  Destination Company before merge*****",
				true);
	}
	
	@Then("^validate SERV_ZN Remedy table for the source company (.+) after merge$")
	public void validate_SERV_ZN_Remedy_After_Merge(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceZone);
		Reporter.log("******validation of SERV_Zone Remedy table is complete for the Source Company after merge*****",
				true);
	}
	
	@Then("^validate SERV_ZN Remedy table for the destination company (.+) after merge$")
	public void validate_SERV_ZN_Remedy_After_Merge_Destcomp(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceZone);
		Reporter.log("******validation of SERV_Zone Remedy table is complete for the Destination Company after merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT Remedy table for the source company (.+) after merge$")
	public void validate_SERV_ACCT_Remedy_After_Merge(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceAccount);
		Reporter.log("******validation of SERV_ACCT Remedy table is complete for the  Source Company after merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT Remedy table for the destination company (.+) after merge$")
	public void validate_SERV_ACCT_Remedy_After_Merge_Destcomp(String activecompany)
			throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(activecompany, "co",
				Query_Remedy_ServiceAccount);
		Reporter.log("******validation of SERV_ACCT Remedy table is complete for the  Destination Company after merge*****",
				true);
	}

	@Then("^validate HPD_Help_desk table of source company (.+) after merge$")
	public void test_HPD_Help_desk_table_aftermerge(String sourcecompany)
			throws Exception {

		Reporter.log("******validate HPD_Help_desk table for  source Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_HPD_Help_desk_validation);

		Reporter.log("******validation complete for  HPD_Help_desk table for  source Company From Database after Merge*****",true);
	}

	@Then("^validate HPD_Help_desk table of destination company (.+) before merge$")
	public void test_HPD_Help_desk_table_beforemerge_desccomp(
			String destinationcompany) throws Exception {

		Reporter.log(
				"******validate HPD_Help_desk table for  destination Company From Database Before Merge*****",
				true);		
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_HPD_Help_desk_validation);

		Reporter.log(
				"******validation complete for  HPD_Help_desk table for  destination Company From Database Before Merge*****",
				true);
	}

	@Then("^validate HPD_Help_desk table of destination company (.+) after merge$")
	public void test_HPD_Help_desk_table_aftermerge_desccomp(
			String destinationcompany) throws Exception {

		Reporter.log("******validate HPD_Help_desk table for  destination Company From Database after Merge*****");
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_HPD_Help_desk_validation);

		Reporter.log("******validation complete for  HPD_Help_desk table for  destination Company From Database after Merge*****");
	}

//	@Then("^validate CTM_People_Organization table of source company (.+) after merge$")
//	public void test_CTM_People_Organization_table_aftermerge(
//			String sourcecompany) throws Exception {
//
//		Reporter.log("******validate CTM_People_Organization table for  source Company From Database after Merge*****");
//		Class.forName("net.sourceforge.jtds.jdbc.Driver");
//		Connection con = DriverManager.getConnection(arsys_jdbc_url,
//				arsys_jdbc_username, arsys_jdbc_password);
//		Reporter.log("Connected to DB");
//		Statement smt = con.createStatement();
//		ResultSet rs = smt
//				.executeQuery("Select People_Organization_ID, Last_Modified_By, Last_Modified_Date, Company, InstanceId from CTM_People_Organization where Company = '"
//						+ sourcecompany + "'");
//
//		DBTablePrinter.printResultSet(rs);
//
//		Reporter.log("******validation complete for  CTM_People_Organization table for  source Company From Database after Merge*****");
//	}
	
	@Then("^validate CTM_People_Organization table of source company (.+) before merge$")
	public void test_CTM_People_Organization_table_beforemerge(
			String sourcecompany) throws Exception {

		Reporter.log(
				"******validate CTM_People_Organization table for  source Company From Database Before Merge*****",
				true);
	

		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_CTM_People_Organization_validation);

		Reporter.log(
				"******validation complete for  CTM_People_Organization table for  source Company From Database Before Merge*****",
				true);
	}

	@Then("^validate CTM_People_Organization table of destination company (.+) before merge$")
	public void test_CTM_People_Organization_table_beforemerge_descomp(
			String destinationcompany) throws Exception {

		Reporter.log(
				"******validate CTM_People_Organization table for  destination Company From Database Before Merge*****",
				true);	
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_CTM_People_Organization_validation);

		Reporter.log(
				"******validation complete for  CTM_People_Organization table for  destination Company From Database Before Merge*****",
				true);
	}
	
	@Then("^validate CTM_People_Organization table of source company (.+) after merge$")
	public void test_CTM_People_Organization_table_aftermerge(
			String sourcecompany) throws Exception {

		Reporter.log("******validate CTM_People_Organization table for  source Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(sourcecompany, "co",
				Query_CTM_People_Organization_validation);

		Reporter.log("******validation complete for  CTM_People_Organization table for  source Company From Database after Merge*****",true);
	}

	@Then("^validate CTM_People_Organization table of destination company (.+) after merge$")
	public void test_CTM_People_Organization_table_aftermerge_descomp(
			String destinationcompany) throws Exception {

		Reporter.log("******validate CTM_People_Organization table for  destination Company From Database after Merge*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabase(destinationcompany, "co",
				Query_CTM_People_Organization_validation);

		Reporter.log("******validation complete for  CTM_People_Organization table for  destination Company From Database after Merge*****",true);
	}

	@Then("^Close the browser$")
	public void postTest() {

		driver.close();
	}

	@Then("^check (.+) and (.+) both are locked while merging$")
	public void validationOfEditCompany(String sourcecompany,
			String destinationcompany) throws Exception {

		Reporter.log("******validate SMU_CompanyEditRecord table for  source and destination  Company while merging*****");
		DBUtil dbutil=new DBUtil();
		dbutil.validationWithDatabaseWithZeroParameter(Query_SMU_CompanyEditRecord_Validation);

		Reporter.log("******validation complete for  SMU_CompanyEditRecord table for  source and destination  Company while merging******");
	}

	@Then("^check (.+) and (.+) both are unlocked After merging$")
	public void validationOfEditCompanyAfterMerge(String sourcecompany,
			String destinationcompany) throws Exception {

		Reporter.log("******validate SMU_CompanyEditRecord table for  source and destination  Company After merging*****");//		
		DBUtil dbutil=new DBUtil();
		dbutil.validationWithDatabaseWithZeroParameter(Query_SMU_CompanyEditRecord_Validation);

		Reporter.log("******validation complete for  SMU_CompanyEditRecord table for  source and destination  Company After merging******");

	}

	@Then("^validate smu_companymergeauditrecord table of source company (.+) and destination company (.+) before merge$")
	public void testsmu_companymergeauditrecordTable(String sourcecompany,
			String destinationcompany) throws Exception {

		Reporter.log(
				"******validate smu_companymergeauditrecord table for  source and destination  Company before merging*****",
				true);

		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabasewithMultipleparameter(sourcecompany,
				"co_s", "co_d", destinationcompany,
				Query_smu_companymergeauditrecord_validation);

		Reporter.log(
				"******validation complete for  smu_companymergeauditrecord table for  source and destination  Company before merging******",
				true);

	}	

	@Then("^validate smu_companymergeauditrecord table of source company (.+) and destination company (.+) after merge$")
	public void testsmu_companymergeauditrecordTableAftermerge(
			String sourcecompany, String destinationcompany) throws Exception {

		Reporter.log("******validate smu_companymergeauditrecord table for  source and destination  Company after merging*****",true);
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithDatabasewithMultipleparameter(sourcecompany,
				"co_s", "co_d", destinationcompany,
				Query_smu_companymergeauditrecord_validation);


		Reporter.log("******validation complete for  smu_companymergeauditrecord table for  source and destination  Company after merging******",true);

	}
	
	@Then("^validate CO table for the source company (.+) before merge$")
	public void validate_CO_Before_Source_Company_Merge(
			String srccompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(srccompany, "co",
				Query_CO_validation1);
		Reporter.log(
				"******validation of CO table is complete for the source Company before Merge*****",
				true);
	}
	
	@Then("^validate CO table for the destination company (.+) before merge$")
	public void validate_CO_Before_Dest_Company_Merge(
			String destcompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(destcompany, "co",
				Query_CO_validation1);
		Reporter.log(
				"******validation of CO table is complete for the destination Company before Merge*****",
				true);
	}
	
	
	
	@Then("^validate CO_NM table for the source company (.+) before merge$")
	public void validate_CO_NM_Before_Source_Company_Merge(
			String srccompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(srccompany, "co",
				Query_CO_NM_validation1);
		Reporter.log(
				"******validation of CO_NM table is complete for the source Company before merge*****",
				true);
	}
	
	@Then("^validate CO_NM table for the destination company (.+) before merge$")
	public void validate_CO_NM_Before_Dest_Company_Merge(
			String destcompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(destcompany, "co",
				Query_CO_NM_validation1);
		Reporter.log(
				"******validation of CO_NM table is complete for the destination Company before merge*****",
				true);
	}
	
	@Then("^validate KEY_CROSS_REF table for the source company (.+) before merge$")
	public void validate_KEY_CROSS_REF_Before_Source_Company_Merge(
			String srccompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(srccompany, "co",
				Query_CO_validation1, "CO_GUID",
				Query_KEY_CROSS_REF_validation1, "CO_GUID_C");
		Reporter.log(
				"******validation of KEY_CROSS_REF table is complete for the Source Company before merge*****",
				true);
	}
	
	@Then("^validate KEY_CROSS_REF table for the destination company (.+) before merge$")
	public void validate_KEY_CROSS_REF_Before_Dest_Company_Merge(
			String destcompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(destcompany, "co",
				Query_CO_validation1, "CO_GUID",
				Query_KEY_CROSS_REF_validation1, "CO_GUID_C");
		Reporter.log(
				"******validation of KEY_CROSS_REF table is complete for the destination company before merge*****",
				true);
	}
	
	
	@Then("^validate SERV_ZN table for the source company (.+) before merge$")
	public void validate_SERV_ZN_Before_Source_Company_Merge(
			String srccompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(srccompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ZN_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ZN table is complete for the source company before merge*****",
				true);
	}
	
	@Then("^validate SERV_ZN table for the destination company (.+) before merge$")
	public void validate_SERV_ZN_Before_Dest_Company_Merge(
			String destcompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(destcompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ZN_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ZN table is complete for the destination company before merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT table for the source company (.+) before merge$")
	public void validate_SERV_ACCT_Before_Source_Company_Merge(
			String srccompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(srccompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ACCT_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ACCT table is complete for the source Company before merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT table for the destination company (.+) before merge$")
	public void validate_SERV_ACCT_Before_Dest_Company_Merge(
			String destcompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(destcompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ACCT_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ACCT table is complete for the destination Company before merge*****",
				true);
	}
	
	@Then("^validate CO table for the source company (.+) after merge$")
	public void validate_CO_After_Source_Company_Merge(
			String srccompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(srccompany, "co",
				Query_CO_validation1);
		Reporter.log(
				"******validation of CO table is complete for the source Company after Merge*****",
				true);
	}
	
	@Then("^validate CO table for the destination company (.+) after merge$")
	public void validate_CO_After_Dest_Company_Merge(
			String destcompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(destcompany, "co",
				Query_CO_validation1);
		Reporter.log(
				"******validation of CO table is complete for the destination Company after Merge*****",
				true);
	}
	
	
	
	@Then("^validate CO_NM table for the source company (.+) after merge$")
	public void validate_CO_NM_After_Source_Company_Merge(
			String srccompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(srccompany, "co",
				Query_CO_NM_validation1);
		Reporter.log(
				"******validation of CO_NM table is complete for the source Company after merge*****",
				true);
	}
	
	@Then("^validate CO_NM table for the destination company (.+) after merge$")
	public void validate_CO_NM_After_Dest_Company_Merge(
			String destcompany) throws Exception {
		DBUtil dbutil = new DBUtil();
		dbutil.validationWithMDMDatabase(destcompany, "co",
				Query_CO_NM_validation1);
		Reporter.log(
				"******validation of CO_NM table is complete for the destination Company after merge*****",
				true);
	}
	
	@Then("^validate KEY_CROSS_REF table for the source company (.+) after merge$")
	public void validate_KEY_CROSS_REF_After_Source_Company_Merge(
			String srccompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(srccompany, "co",
				Query_CO_validation1, "CO_GUID",
				Query_KEY_CROSS_REF_validation1, "CO_GUID_C");
		Reporter.log(
				"******validation of KEY_CROSS_REF table is complete for the Source Company after merge*****",
				true);
	}
	
	@Then("^validate KEY_CROSS_REF table for the destination company (.+) after merge$")
	public void validate_KEY_CROSS_REF_After_Dest_Company_Merge(
			String destcompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(destcompany, "co",
				Query_CO_validation1, "CO_GUID",
				Query_KEY_CROSS_REF_validation1, "CO_GUID_C");
		Reporter.log(
				"******validation of KEY_CROSS_REF table is complete for the destination company after merge*****",
				true);
	}
	
	@Then("^validate SERV_ZN table for the source company (.+) after merge$")
	public void validate_SERV_ZN_After_Source_Company_Merge(
			String srccompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(srccompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ZN_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ZN table is complete for the source company after merge*****",
				true);
	}
	
	@Then("^validate SERV_ZN table for the destination company (.+) after merge$")
	public void validate_SERV_ZN_After_Dest_Company_Merge(
			String destcompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(destcompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ZN_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ZN table is complete for the destination company after merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT table for the source company (.+) after merge$")
	public void validate_SERV_ACCT_After_Source_Company_Merge(
			String srccompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(srccompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ACCT_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ACCT table is complete for the source Company after merge*****",
				true);
	}
	
	@Then("^validate SERV_ACCT table for the destination company (.+) after merge$")
	public void validate_SERV_ACCT_After_Dest_Company_Merge(
			String destcompany) throws Exception {
		
		DBUtil dbutil = new DBUtil();
		dbutil.validationUsingMultipleTableInSameMDMDatabase(destcompany, "dept",
				Query_CO_validation, "CO_GUID",
				Query_SERV_ACCT_validation1, "CO_GUID_D");
		Reporter.log(
				"******validation of SERV_ACCT table is complete for the destination Company after merge*****",
				true);
	}
	
//*************************************** MERGE ENDS ***********************************************//
	
//*************************************** COMPANY RENAME STARTS ***********************************************//
	@When("^click on Company Rename$")
	public void click_On_Company_Rename() throws Throwable {
		HomePage h = new HomePage(driver);
		h.companyRename(driver);
		Thread.sleep(5000);

	}

	@Then("^Enter the (.+) that will be renamed$")
	public void enter_The_Active_Company(String ActiveCompany) throws Throwable {
		CompanyRename cr = new CompanyRename(driver);
		cr.EnterActivecompany(ActiveCompany, driver);
	}

	@Then("^Enter the (.+) for the company$")
	public void enter_The_New_name_for_The_Company(String newname)
			throws Throwable {
		CompanyRename cr = new CompanyRename(driver);
		cr.EnterNewName(newname);
	}
	
	@Then("^initiate company rename$")
	public void initiate_Company_Rename()
			throws Throwable {
		CompanyRename cr = new CompanyRename(driver);
		cr.InitiateCompanyRename(driver);
	}

	@Then("^Validate company rename status$")
	public void validate_Company_Rename_Status() throws Throwable {
		CompanyRename cr = new CompanyRename(driver);
		cr.validateCompanyRenameStatus(driver);
	}	

	@Then("^click on view Result button$")
	public void clickonviewResultbutton() throws Throwable {
		CompanyRename cr = new CompanyRename(driver);
		cr.clickOnViewResult();
	}

	@Then("^Click on Reset button$")
	public void click_On_Reset_Button() throws Throwable {
		CompanyRename cr = new CompanyRename(driver);
		cr.clickOnResetButton(driver);
	}

	@Then("^Click on Cancel button$")
	public void click_On_Cancel_Button() throws Throwable {
		CompanyRename cr = new CompanyRename(driver);
		cr.clickOnCancelButton(driver);
	}
	
		@Then("^validate syn_mdm_co table for the company (.+) before update$")
		public void validate_Syn_Mdm_Co_Before_Update(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					syn_mdm_co_table_Merge_query);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the company before update*****",
					true);
		}
		
		@Then("^validate COM_Company and CTM_people table for the company (.+) before update$")
		public void validate_COM_Company_And_CTM_people_Before_Update(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();			
			dbutil.validationUsingMultipleTableInSameDatabase(activecompany, "co",
					query_to_find_Company_Entry_ID_COM_Company, "Company_Entry_ID",
					Query_CTM_people_validation, "companyID");
			Reporter.log(
					"******validation of COM_Company and CTM_people tables is complete for the company before update*****",
					true);
		}
		
		@Then("^validate AST_Impacted_Areas table for the company (.+) before update$")
		public void validate_AST_Impacted_Areas_Before_Update(String activecompany)
				throws Exception {
	
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_AST_Impacted_Areas_validation);
	
			Reporter.log(
					"******validation of AST_Impacted_Areas is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the company (.+) before update$")
		public void validate_CTM_People_Organization_Before_Update(
				String activecompany) throws Exception {
	
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_CTM_People_Organization_validation);
	
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate HPD_Help_desk table for the company (.+) before update$")
		public void validate_HPD_Help_desk_Before_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_HPD_Help_desk_validation);
			Reporter.log("******validation of HPD_Help_desk table is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the company (.+) before update$")
		public void validate_AST_AssetPeople_Before_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_AST_AssetPeople_validation);
			Reporter.log("******validation of AST_AssetPeople table is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the company (.+) before update$")
		public void validate_HPD_Impacted_Areas_Before_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_HPD_Impacted_Areas_validation);
			Reporter.log("******validation of HPD_Impacted_Areas table is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate SAV_AIMS_EvResInsAss_Appr table for the company (.+) before update$")
		public void validate_SAV_AIMS_EvResInsAss_Appr_Before_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_SAV_AIMS_EvResInsAss_Appr_validation);
			Reporter.log("******validation of SAV_AIMS_EvResInsAss_Appr table is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate SERV_ZN Remedy table for the company (.+) before update$")
		public void validate_SERV_ZN_Remedy_Before_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceZone);
			Reporter.log("******validation of SERV_Zone Remedy table is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate SERV_ACCT Remedy table for the company (.+) before update$")
		public void validate_SERV_ACCT_Remedy_Before_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceAccount);
			Reporter.log("******validation of SERV_ACCT Remedy table is complete for the Company before update*****",
					true);
		}
		
		@Then("^validate CO table for the company (.+) before update$")
		public void validate_CO_Before_Company_Rename(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(activecompany, "co",
					Query_CO_validation1);
			Reporter.log(
					"******validation of CO table is complete for the Company before Rename*****",
					true);
		}
		
		@Then("^validate CO_NM table for the company (.+) before update$")
		public void validate_CO_NM_Before_Company_Rename(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(activecompany, "co",
					Query_CO_NM_validation1);
			Reporter.log(
					"******validation of CO_NM table is complete for the Company before Rename*****",
					true);
		}
		
		@Then("^validate SERV_ZN table for the company (.+) before update$")
		public void validate_SERV_ZN_Before_Company_Rename(
				String activecompany) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(activecompany, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the company before rename*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the company (.+) before update$")
		public void validate_SERV_ACCT_Before_Company_Rename(
				String activecompany) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(activecompany, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the Company before rename*****",
					true);
		}
		
	//			@Then("^validate smu_companyrenameauditrecord table of the company (.+) before update$")
	//			public void validate_Smu_Companyrenameauditrecord_Before_Update(String activecompany)
	//					throws Exception {
	//				DBUtil dbutil = new DBUtil();
	//				dbutil.validationWithDatabase(activecompany, "co",
	//						Query_smu_companyrenameauditrecord_validation);
	//				Reporter.log("******validation of smu_companyrenameauditrecord table is complete for the Company before update*****",
	//						true);
	//			}
		
		@Then("^validate syn_mdm_co table for the old company (.+) after update$")
		public void validate_Syn_Mdm_Co_After_Update(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					syn_mdm_co_table_Merge_query);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the OLD company After update*****",
					true);
		}
		
		@Then("^validate COM_Company and CTM_people table for the old company (.+) after update$")
		public void validate_COM_Company_And_CTM_people_After_Update(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();			
			dbutil.validationUsingMultipleTableInSameDatabase(activecompany, "co",
					query_to_find_Company_Entry_ID_COM_Company, "Company_Entry_ID",
					Query_CTM_people_validation, "companyID");
			Reporter.log(
					"******validation of COM_Company and CTM_people tables is complete for the OLD company After update*****",
					true);
		}
		
		@Then("^validate AST_Impacted_Areas table for the old company (.+) after update$")
		public void validate_AST_Impacted_Areas_After_Update(String activecompany)
				throws Exception {
	
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_AST_Impacted_Areas_validation);
	
			Reporter.log(
					"******validation of AST_Impacted_Areas is complete for the OLD Company after update*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the old company (.+) after update$")
		public void validate_CTM_People_Organization_After_Update(
				String activecompany) throws Exception {
	
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_CTM_People_Organization_validation);
	
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the OLD Company after update*****",
					true);
		}
		
		@Then("^validate HPD_Help_desk table for the old company (.+) after update$")
		public void validate_HPD_Help_desk_After_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_HPD_Help_desk_validation);
			Reporter.log("******validation of HPD_Help_desk table is complete for the OLD Company after update*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the old company (.+) after update$")
		public void validate_AST_AssetPeople_After_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_AST_AssetPeople_validation);
			Reporter.log("******validation of AST_AssetPeople table is complete for the OLD Company after update*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the old company (.+) after update$")
		public void validate_HPD_Impacted_Areas_After_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_HPD_Impacted_Areas_validation);
			Reporter.log("******validation of HPD_Impacted_Areas table is complete for the OLD Company after update*****",
					true);
		}
		
		@Then("^validate SAV_AIMS_EvResInsAss_Appr table for the old company (.+) after update$")
		public void validate_SAV_AIMS_EvResInsAss_Appr_After_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_SAV_AIMS_EvResInsAss_Appr_validation);
			Reporter.log("******validation of SAV_AIMS_EvResInsAss_Appr table is complete for the OLD Company After update*****",
					true);
		}
		
		@Then("^validate SERV_ZN Remedy table for the old company (.+) after update$")
		public void validate_SERV_ZN_Remedy_After_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceZone);
			Reporter.log("******validation of SERV_Zone Remedy table is complete for the OLD Company before update*****",
					true);
		}
		
		@Then("^validate SERV_ACCT Remedy table for the old company (.+) after update$")
		public void validate_SERV_ACCT_Remedy_After_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceAccount);
			Reporter.log("******validation of SERV_ACCT Remedy table is complete for the OLD Company before update*****",
					true);
		}
		
		@Then("^validate CO table for the old company (.+) after update$")
		public void validate_CO_After_Company_Rename(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(activecompany, "co",
					Query_CO_validation1);
			Reporter.log(
					"******validation of CO table is complete for the old Company after Rename*****",
					true);
		}
		
		@Then("^validate CO_NM table for the old company (.+) after update$")
		public void validate_CO_NM_After_Company_Rename(
				String activecompany) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(activecompany, "co",
					Query_CO_NM_validation1);
			Reporter.log(
					"******validation of CO_NM table is complete for the old Company after Rename*****",
					true);
		}
		
		@Then("^validate SERV_ZN table for the old company (.+) after update$")
		public void validate_SERV_ZN_After_Company_Rename(
				String activecompany) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(activecompany, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the old company after rename*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the old company (.+) after update$")
		public void validate_SERV_ACCT_After_Company_Rename(
				String activecompany) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(activecompany, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the old Company after rename*****",
					true);
		}
		
		@Then("^validate syn_mdm_co table for the new company (.+) after update$")
		public void validate_Syn_Mdm_Co_After_Update_New_Co(
				String newname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(newname, "co",
					syn_mdm_co_table_Merge_query);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the NEW company After update*****",
					true);
		}
		
		@Then("^validate COM_Company and CTM_people table for the new company (.+) after update$")
		public void validate_COM_Company_And_CTM_people_After_Update_New_Co(
				String newname) throws Exception {
			DBUtil dbutil = new DBUtil();			
			dbutil.validationUsingMultipleTableInSameDatabase(newname, "co",
					query_to_find_Company_Entry_ID_COM_Company, "Company_Entry_ID",
					Query_CTM_people_validation, "companyID");
			Reporter.log(
					"******validation of COM_Company and CTM_people tables is complete for the NEW company After update*****",
					true);
		}
		
		@Then("^validate AST_Impacted_Areas table for the new company (.+) after update$")
		public void validate_AST_Impacted_Areas_After_Update_New_Co(String newname)
				throws Exception {
	
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(newname, "co",
					Query_AST_Impacted_Areas_validation);
	
			Reporter.log(
					"******validation of AST_Impacted_Areas is complete for the NEW Company after update*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the new company (.+) after update$")
		public void validate_CTM_People_Organization_After_Update_New_Co(
				String newname) throws Exception {
	
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(newname, "co",
					Query_CTM_People_Organization_validation);
	
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the NEW Company after update*****",
					true);
		}
		
		@Then("^validate HPD_Help_desk table for the new company (.+) after update$")
		public void validate_HPD_Help_desk_After_Update_New_Co(String newname)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(newname, "co",
					Query_HPD_Help_desk_validation);
			Reporter.log("******validation of HPD_Help_desk table is complete for the NEW Company after update*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the new company (.+) after update$")
		public void validate_AST_AssetPeople_After_Update_New_Co(String newname)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(newname, "co",
					Query_AST_AssetPeople_validation);
			Reporter.log("******validation of AST_AssetPeople table is complete for the NEW Company after update*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the new company (.+) after update$")
		public void validate_HPD_Impacted_Areas_After_Update_New_Co(String newname)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(newname, "co",
					Query_HPD_Impacted_Areas_validation);
			Reporter.log("******validation of HPD_Impacted_Areas table is complete for the NEW Company after update*****",
					true);
		}
		
		@Then("^validate SAV_AIMS_EvResInsAss_Appr table for the new company (.+) after update$")
		public void validate_SAV_AIMS_EvResInsAss_Appr_After_Update_New_Co(String newname)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(newname, "co",
					Query_SAV_AIMS_EvResInsAss_Appr_validation);
			Reporter.log("******validation of SAV_AIMS_EvResInsAss_Appr table is complete for the NEW Company After update*****",
					true);
		}
		
		@Then("^validate SERV_ZN Remedy table for the new company (.+) after update$")	
		public void validate_SERV_ZN_Remedy_After_Update_New_Co(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceZone);
			Reporter.log("******validation of SERV_Zone Remedy table is complete for the NEW Company before update*****",
					true);
		}
		
		@Then("^validate SERV_ACCT Remedy table for the new company (.+) after update$")
		public void validate_SERV_ACCT_Remedy_After_Update_New_Co(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceAccount);
			Reporter.log("******validation of SERV_ACCT Remedy table is complete for the NEW Company before update*****",
					true);
		}
		
		@Then("^validate smu_companyrenameauditrecord table for the company (.+) to audit changes$")
		public void validate_Smu_Companyrenameauditrecord_After_Update(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_smu_companyrenameauditrecord_validation);
			Reporter.log("******validation of smu_companyrenameauditrecord table is complete for the Company*****",
					true);
		}
		
		@Then("^validate CO table for the new company (.+) after update$")
		public void validate_CO_After_Company_Rename_New_Co(
				String newname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(newname, "co",
					Query_CO_validation1);
			Reporter.log(
					"******validation of CO table is complete for the new Company after Rename*****",
					true);
		}
		
		@Then("^validate CO_NM table for the new company (.+) after update$")
		public void validate_CO_NM_After_Company_Rename_New_Co(
				String newname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(newname, "co",
					Query_CO_NM_validation1);
			Reporter.log(
					"******validation of CO_NM table is complete for the new Company after Rename*****",
					true);
		}
		
		@Then("^validate SERV_ZN table for the new company (.+) after update$")
		public void validate_SERV_ZN_After_Company_Rename_New_Co(
				String newname) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(newname, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the new company after rename*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the new company (.+) after update$")
		public void validate_SERV_ACCT_After_Company_Rename_New_Co(
				String newname) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(newname, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the new Company after rename*****",
					true);
		}
		
//*************************************** COMPANY RENAME ENDS ***********************************************//
			
			
//*************************************** ORGANIZATION SPLIT STARTS *****************************************//
		
		@When("^click on Organization Split$")
		public void click_On_Organization_Split() throws Throwable {
			HomePage h = new HomePage(driver);
			h.organizationSplit(driver);
			Thread.sleep(5000);
		}
		
		@Then("^Enter the (.+) to select the organization$")
		public void enter_The_Company_Name(String P_CompanyName) throws Throwable {
			OrganizationSplit os = new OrganizationSplit(driver);
			os.EnterTheCompanyName(P_CompanyName, driver);
		}
		
		@Then("^Select the organization (.+) to split$")
		public void select_The_Organization_To_Split(String P_CompanyName) throws Throwable {
			OrganizationSplit os = new OrganizationSplit(driver);
			os.SelectTheOrgToSplit(P_CompanyName, driver);
		}
		
		@Then("^Click on Initiate button$")
		public void select_The_Organization_TO_Split() throws Throwable {
			OrganizationSplit os = new OrganizationSplit(driver);
			os.InitiateTheSplit(driver);
		}
		
		@Then("^Run Presplit validation by entering (.+) to the new company$")
		public void run_Presplit_Validation_By_Entering_Abbreviation_TO_The_New_Company(String P_Abbreviation) throws Throwable {
			OrganizationSplit os = new OrganizationSplit(driver);
			os.PreSplitValidation(P_Abbreviation, driver);
			Thread.sleep(3000);
		}
		
		@Then("^validate organization split status$")
		public void validate_organization_split_status() throws Throwable {
			OrganizationSplit os = new OrganizationSplit(driver);
			os.validateOrgSplitStatus(driver);
		}
		
		@Then("^View the results in SMU$")
		public void view_The_Results_In_SMU() throws Throwable {
			OrganizationSplit os = new OrganizationSplit(driver);
			os.viewTheResultsInSMU(driver);
			
		}
		

		
		@Then("^validate syn_mdm_co table for the company (.+) before split$")
		public void validate_Syn_Mdm_Co_Before_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					syn_mdm_co_table_Merge_query);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the company before split*****",
					true);
		}
		
		
		@Then("^validate COM_Company table for the company (.+) before split$")
		public void validate_COM_Company_Before_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					query_to_find_Company_Entry_ID_COM_Company);
			Reporter.log(
					"******validation of COM_Company table is complete for the company before split*****",
					true);
		}
		
	
		
		@Then("^validate CTM_people table for the company (.+) before split$")
		public void validate_CTM_people_Before_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_CTM_people_validation2);
			Reporter.log(
					"******validation of CTM_people table is complete for the company before split*****",
					true);
		}
		

		
		@Then("^validate AST_Impacted_Areas table for the company (.+) before split$")
		public void validate_AST_Impacted_Areas_Before_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_AST_Impacted_Areas_validation);
			Reporter.log(
					"******validation of AST_Impacted_Areas table is complete for the company before split*****",
					true);
		}
		
	
		
		@Then("^validate CTM_People_Organization table for the company (.+) before split$")
		public void validate_CTM_People_Organization_Before_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_AST_Impacted_Areas_validation);
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the company before split*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the organization (.+) before split$")
		public void validate_CTM_People_Organization_Before_Split_For_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_AST_Impacted_Areas_validation2);
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the organization before split*****",
					true);
		}
		
		@Then("^validate HPD_Help_desk table for the company (.+) before split$")
		public void validate_HPD_Help_desk_Before_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_HPD_Help_desk_validation);
			Reporter.log(
					"******validation of HPD_Help_desk table is complete for the company before split*****",
					true);
		}
	
		
		@Then("^validate AST_AssetPeople table for the organization (.+) before split$")
		public void validate_AST_AssetPeople_Before_Split_For_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_AST_AssetPeople_validation2);
			Reporter.log(
					"******validation of AST_AssetPeople table is complete for the organization before split*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the company (.+) before split$")
		public void validate_HPD_Impacted_Areas_Before_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_HPD_Impacted_Areas_validation);
			Reporter.log(
					"******validation of HPD_Impacted_Areas table is complete for the company before split*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the organization (.+) before split$")
		public void validate_HPD_Impacted_Areas_Before_Split_For_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_HPD_Impacted_Areas_validation2);
			Reporter.log(
					"******validation of HPD_Impacted_Areas table is complete for the organization before split*****",
					true);
		}


		
		@Then("^validate SYN_MDM_SERV_ACCT table for the organization (.+) before split$")
		public void validate_SYN_MDM_SERV_ACCT_Before_Split_For_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();			
			dbutil.validationUsingMultipleTableInSameDatabase(organization, "org",
					Query_syn_mdm_co_validation1, "CO_GUID",
					Query_SYN_MDM_SERV_ACCT_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SYN_MDM_SERV_ACCT table is complete for the organization before split*****",
					true);
		}
		
	
		@Then("^validate CO table for the organization (.+) before split$")
		public void validate_CO_For_Organization_before_Split(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(organization, "org",
					Query_CO_validation2);
			Reporter.log(
					"******validation of CO table is complete for the organization before split*****",
					true);
		}
		
		@Then("^validate SERV_ZN table for the company (.+) before split$")
		public void validate_SERV_ZN_For_Company_before_Split(
				String companyname) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(companyname, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the company before split*****",
					true);
		}

		@Then("^validate syn_mdm_co table for the company (.+) after split$")
		public void validate_Syn_Mdm_Co_After_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					syn_mdm_co_table_Merge_query);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the company after split*****",
					true);
		}

		
		@Then("^validate COM_Company table for the new company (.+) after split$")
		public void validate_COM_Company_After_Split_For_New_Company(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "co", 
					query_to_find_Company_Entry_ID_COM_Company);
			Reporter.log(
					"******validation of COM_Company table is complete for the new company after split*****",
					true);
		}


		
		@Then("^validate AST_Impacted_Areas table for the new company (.+) after split$")
		public void validate_AST_Impacted_Areas_After_Split_For_New_Company(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_AST_Impacted_Areas_validation2);
			Reporter.log(
					"******validation of AST_Impacted_Areas table is complete for the new company after split*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the company (.+) after split$")
		public void validate_CTM_People_Organization_After_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_AST_Impacted_Areas_validation);
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the company after split*****",
					true);
		}
		
		
		@Then("^validate HPD_Help_desk table for the company (.+) after split$")
		public void validate_HPD_Help_desk_After_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_HPD_Help_desk_validation);
			Reporter.log(
					"******validation of HPD_Help_desk table is complete for the company after split*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the company (.+) after split$")
		public void validate_AST_AssetPeople_After_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_AST_AssetPeople_validation);
			Reporter.log(
					"******validation of AST_AssetPeople table is complete for the company after split*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the new company (.+) after split$")
		public void validate_AST_AssetPeople_After_Split_for_New_Company(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_AST_AssetPeople_validation2);
			Reporter.log(
					"******validation of AST_AssetPeople table is complete for the new company after split*****",
					true);
		}
	
		
		@Then("^validate HPD_Impacted_Areas table for the new company (.+) after split$")
		public void validate_HPD_Impacted_Areas_After_Split_for_New_Company(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_HPD_Impacted_Areas_validation2);
			Reporter.log(
					"******validation of HPD_Impacted_Areas table is complete for the new company after split*****",
					true);
		}
		
		@Then("^validate SAV_AIMS_EvResInsAss_Appr table for the company (.+) after split$")
		public void validate_SAV_AIMS_EvResInsAss_Appr_After_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_SAV_AIMS_EvResInsAss_Appr_validation);
			Reporter.log(
					"******validation of SAV_AIMS_EvResInsAss_Appr table is complete for the company after split*****",
					true);
		}
		
		@Then("^validate SYN_MDM_SERV_ZN table for the new company (.+) after split$")
		public void validate_SYN_MDM_SERV_ZN_After_Split_for_New_Company(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();			
			dbutil.validationUsingMultipleTableInSameDatabase(organization, "org",
					Query_syn_mdm_co_validation1, "CO_GUID",
					Query_SYN_MDM_SERV_ZN_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SYN_MDM_SERV_ZN table is complete for the new company after split*****",
					true);
		}

		
		@Then("^validate CO table for the company (.+) after split$")
		public void validate_CO_For_Company_after_Split(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(companyname, "co",
					Query_CO_validation1);
			Reporter.log(
					"******validation of CO table is complete for the Company after split*****",
					true);
		}
		
		@Then("^validate CO table for the organization (.+) after split$")
		public void validate_CO_For_Organization_after_Split(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(organization, "org",
					Query_CO_validation2);
			Reporter.log(
					"******validation of CO table is complete for the organization after split*****",
					true);
		}
		
		@Then("^validate CO_NM table for the company (.+) after split$")
		public void validate_CO_NM_For_Company_after_Split(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(companyname, "co",
					Query_CO_NM_validation1);
			Reporter.log(
					"******validation of CO_NM table is complete for the Company after split*****",
					true);
		}
		
		@Then("^validate CO_NM table for the organization (.+) after split$")
		public void validate_CO_NM_For_Organization_after_Split(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(organization, "org",
					Query_CO_NM_validation2);
			Reporter.log(
					"******validation of CO_NM table is complete for the organization after split*****",
					true);
		}
		
		@Then("^validate KEY_CROSS_REF table for the organization (.+) after split$")
		public void validate_KEY_CROSS_REF_After_org_Split(
				String organization) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(organization, "co",
					Query_CO_validation1, "CO_GUID",
					Query_KEY_CROSS_REF_validation1, "CO_GUID_C");
			Reporter.log(
					"******validation of KEY_CROSS_REF table is complete for the new company after org split*****",
					true);
		}
		
		
		@Then("^validate SERV_ZN table for the organization (.+) after split$")
		public void validate_SERV_ZN_For_Organization_after_Split(
				String organization) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(organization, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the organization after split*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the company (.+) after split$")
		public void validate_SERV_ACCT_For_Company_after_Split(
				String companyname) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(companyname, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the Company after split*****",
					true);
		}
			
		
//*************************************** ORGANIZATION SPLIT ENDS ***********************************************//
//*************************************** ORGANIZATION RENAME STARTS ***********************************************//

		
		@Then("^validate syn_mdm_co table for the organization (.+) before split$")
		public void validate_Syn_Mdm_Co_Before_Split_for_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "co",
					syn_mdm_co_table_Merge_query);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the organization before split*****",
					true);
		}
		

		
		@Then("^validate COM_Company table for the organization (.+) before split$")
		public void validate_COM_Company_Before_Split_for_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "co", 
					query_to_find_Company_Entry_ID_COM_Company);
			Reporter.log(
					"******validation of COM_Company table is complete for the organization before split*****",
					true);
		}

		
		@Then("^validate CTM_people table for the organization (.+) before split$")
		public void validate_CTM_people_Before_Split_for_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_CTM_people_validation3);
			Reporter.log(
					"******validation of CTM_people table is complete for the organization before split*****",
					true);
		}
		
		@Then("^validate SIT_Site_Company_Association table for the company (.+) before split$")
		public void validate_SIT_Site_Company_Association_Before_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_SIT_Site_Company_Association_validation);
			Reporter.log(
					"******validation of SIT_Site_Company_Association table is complete for the company before split*****",
					true);
		}
		
	
		
		@Then("^validate AST_Impacted_Areas table for the organization (.+) before split$")
		public void validate_AST_Impacted_Areas_Before_Split_for_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_AST_Impacted_Areas_validation2);
			Reporter.log(
					"******validation of AST_Impacted_Areas table is complete for the organization before split*****",
					true);
		}
	
		@Then("^validate AST_AssetPeople table for the company (.+) before split$")
		public void validate_AST_AssetPeople_Before_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_AST_AssetPeople_validation);
			Reporter.log(
					"******validation of AST_AssetPeople table is complete for the company before split*****",
					true);
		}
	
		@Then("^validate SAV_AIMS_EvResInsAss_Appr table for the company (.+) before split$")
		public void validate_SAV_AIMS_EvResInsAss_Appr_Before_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_SAV_AIMS_EvResInsAss_Appr_validation);
			Reporter.log(
					"******validation of SAV_AIMS_EvResInsAss_Appr table is complete for the company before split*****",
					true);
		}
		
		@Then("^validate SYN_MDM_SERV_ZN table for the organization (.+) before split$")
		public void validate_SYN_MDM_SERV_ZN_Before_Split_for_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();			
			dbutil.validationUsingMultipleTableInSameDatabase(organization, "org",
					Query_syn_mdm_co_validation1, "CO_GUID",
					Query_SYN_MDM_SERV_ZN_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SYN_MDM_SERV_ZN table is complete for the organization before split*****",
					true);
		}
		

		
		@Then("^validate CO_NM table for the company (.+) before split$")
		public void validate_CO_NM_For_Company_Before_Split(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(companyname, "co",
					Query_CO_NM_validation1);
			Reporter.log(
					"******validation of CO_NM table is complete for the Company before split*****",
					true);
		}
		
		@Then("^validate CO_NM table for the organization (.+) before split$")
		public void validate_CO_NM_For_Organization_Before_Split(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(organization, "org",
					Query_CO_NM_validation2);
			Reporter.log(
					"******validation of CO_NM table is complete for the organization before split*****",
					true);
		}

		
		@Then("^validate SERV_ZN table for the organization (.+) before split$")
		public void validate_SERV_ZN_For_Organization_Before_Split(
				String organization) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(organization, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the organization before split*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the company (.+) before split$")
		public void validate_SERV_ACCT_For_Company_Before_Split(
				String companyname) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(companyname, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the Company before split*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the organization (.+) before split$")
		public void validate_SERV_ACCT_For_Organization_Before_Split(
				String organization) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(organization, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the organization before split*****",
					true);
		}
		

		
		@Then("^validate syn_mdm_co table for the new company (.+) after split$")
		public void validate_Syn_Mdm_Co_After_Split_for_New_Company(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "co",
					syn_mdm_co_table_Merge_query);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the new company after split*****",
					true);
		}
		
		@Then("^validate COM_Company table for the company (.+) after split$")
		public void validate_COM_Company_After_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					query_to_find_Company_Entry_ID_COM_Company);
			Reporter.log(
					"******validation of COM_Company table is complete for the company after split*****",
					true);
		}
		
		@Then("^validate CTM_people table for the company (.+) after split$")
		public void validate_CTM_people_After_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_CTM_people_validation2);
			Reporter.log(
					"******validation of CTM_people table is complete for the company after split*****",
					true);
		}
		
		@Then("^validate CTM_people table for the new company (.+) after split$")
		public void validate_CTM_people_After_Split_for_New_Company(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_CTM_people_validation3);
			Reporter.log(
					"******validation of CTM_people table is complete for the new company after split*****",
					true);
		}
		
		@Then("^validate SIT_Site_Company_Association table for the company (.+) after split$")
		public void validate_SIT_Site_Company_Association_After_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_SIT_Site_Company_Association_validation);
			Reporter.log(
					"******validation of SIT_Site_Company_Association table is complete for the company after split*****",
					true);
		}
		
		@Then("^validate AST_Impacted_Areas table for the company (.+) after split$")
		public void validate_AST_Impacted_Areas_After_Split_for_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_AST_Impacted_Areas_validation);
			Reporter.log(
					"******validation of AST_Impacted_Areas table is complete for the company after split*****",
					true);
		}

		
		@Then("^validate CTM_People_Organization table for the new company (.+) after split$")
		public void validate_CTM_People_Organization_After_Split_for_Organization(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(organization, "org", 
					Query_AST_Impacted_Areas_validation2);
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the new company after split*****",
					true);
		}
	

		
		@Then("^validate HPD_Impacted_Areas table for the company (.+) after split$")
		public void validate_HPD_Impacted_Areas_After_Split_For_Company(
				String companyname) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(companyname, "co",
					Query_HPD_Impacted_Areas_validation);
			Reporter.log(
					"******validation of HPD_Impacted_Areas table is complete for the company after split*****",
					true);
		}


		
		@Then("^validate SYN_MDM_SERV_ACCT table for the new company (.+) after split$")
		public void validate_SYN_MDM_SERV_ACCT_After_Split_For_New_Company1(
				String organization) throws Exception {
			DBUtil dbutil = new DBUtil();			
			dbutil.validationUsingMultipleTableInSameDatabase(organization, "org",
					Query_syn_mdm_co_validation1, "CO_GUID",
					Query_SYN_MDM_SERV_ACCT_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SYN_MDM_SERV_ACCT table is complete for the new company after split*****",
					true);
		}

				
		@Then("^validate SERV_ZN table for the company (.+) after split$")
		public void validate_SERV_ZN_For_Company_After_Split(
				String companyname) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(companyname, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the company after split*****",
					true);
		}

		
		@Then("^validate SERV_ACCT table for the organization (.+) after split$")
		public void validate_SERV_ACCT_For_Organization_After_Split(
				String organization) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(organization, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation1, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the organization after split*****",
					true);
		}
				
		
//*************************************** ORGANIZATION RENAME ENDS ***********************************************//
				
//*************************************** DEPARTMENT RENAME STARTS *********************************************//
		
		@Then("^rename the (.+) with (.+)$")
		public void rename_The_Department(String P_Dept, String P_Dept_new) throws Throwable {
			DepartmentRename dr = new DepartmentRename(driver);
			dr.renamethedepartment(P_Dept, P_Dept_new, driver);
			Thread.sleep(5000);
		}		
		
		@Then("^complete the process of department rename$")
		public void complete_The_Process_Of_Department_Rename() throws Throwable {			
			DepartmentRename dr = new DepartmentRename(driver);
			dr.processdepartmentrename(driver);
			Thread.sleep(5000);
		}		
		
		@Then("^validate the results on UI for new (.+)$")
		public void validate_The_Results_On_UI_For_New_Department(String P_Dept_new) throws Throwable {			
			DepartmentRename dr = new DepartmentRename(driver);
			dr.validatetherenameresultsonUI(P_Dept_new, driver);
			Thread.sleep(5000);
		}
		
		@Then("^validate syn_mdm_co table for the department (.+) before update$")
		public void validate_Syn_Mdm_Co_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_syn_mdm_co_validation2);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the Department before Rename*****",
					true);
		}
		
		@Then("^validate CTM_People table for the department (.+) before update$")
		public void validate_CTM_people_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_CTM_people_validation4);
			Reporter.log(
					"******validation of CTM_people table is complete for the Department before Rename*****",
					true);
		}
		
		@Then("^validate AST_Impacted_Areas table for the department (.+) before update$")
		public void validate_AST_Impacted_Areas_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_AST_Impacted_Areas_validation3);
			Reporter.log(
					"******validation of AST_Impacted_Areas table is complete for the Department before Rename*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the department (.+) before update$")
		public void validate_CTM_People_Organization_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_CTM_People_Organization_validation3);
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the Department before Rename*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the department (.+) before update$")
		public void validate_AST_AssetPeople_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_AST_AssetPeople_validation3);
			Reporter.log(
					"******validation of AST_AssetPeople table is complete for the Department before Rename*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the department (.+) before update$")
		public void validate_HPD_Impacted_Areas_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_HPD_Impacted_Areas_validation3);
			Reporter.log(
					"******validation of HPD_Impacted_Areas table is complete for the Department before Rename*****",
					true);
		}
		
//		@Then("^validate SERV_ZN Remedy table for the department (.+) before update$")
//		public void validate_SYN_MDM_SERV_ZN_Before_Dept_Rename(
//				String P_Dept) throws Exception {
//			
//			DBUtil dbutil = new DBUtil();
//			dbutil.validationUsingMultipleTableInSameDatabase(P_Dept, "dept",
//					Query_syn_mdm_co_validation2, "CO_GUID",
//					Query_SYN_MDM_SERV_ZN_validation, "CO_GUID_D");
//			Reporter.log(
//					"******validation of SYN_MDM_SERV_ZN table is complete for the Department before rename*****",
//					true);
//		}
//		
//		@Then("^validate SERV_ACCT Remedy table for the department (.+) before update$")
//		public void validate_SYN_MDM_SERV_ACCT_Before_Dept_Rename(
//				String P_Dept) throws Exception {
//			
//			DBUtil dbutil = new DBUtil();
//			dbutil.validationUsingMultipleTableInSameDatabase(P_Dept, "dept",
//					Query_syn_mdm_co_validation2, "CO_GUID",
//					Query_SYN_MDM_SERV_ACCT_validation, "CO_GUID_D");
//			Reporter.log(
//					"******validation of SYN_MDM_SERV_ACCT table is complete for the Department before rename*****",
//					true);
//		}
		
		@Then("^validate CO table for the department (.+) before update$")
		public void validate_CO_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(P_Dept, "dept",
					Query_CO_validation);
			Reporter.log(
					"******validation of CO table is complete for the Department before Rename*****",
					true);
		}
		
		@Then("^validate CO_NM table for the department (.+) before update$")
		public void validate_CO_NM_Before_Dept_Rename(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(P_Dept, "dept",
					Query_CO_NM_validation);
			Reporter.log(
					"******validation of CO_NM table is complete for the Department before Rename*****",
					true);
		}
		
		@Then("^validate KEY_CROSS_REF table for the department (.+) before update$")
		public void validate_KEY_CROSS_REF_Before_Dept_Rename(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_KEY_CROSS_REF_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of KEY_CROSS_REF table is complete for the Department before rename*****",
					true);
		}
		
		@Then("^validate SERV_ZN table for the department (.+) before update$")
		public void validate_SERV_ZN_Before_Dept_Rename(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the Department before rename*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the department (.+) before update$")
		public void validate_SERV_ACCT_Before_Dept_Rename(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the Department before rename*****",
					true);
		}
		
		@Then("^validate syn_mdm_co table for the old department (.+) after update$")
		public void validate_Syn_Mdm_Co_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_syn_mdm_co_validation2);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate CTM_People table for the old department (.+) after update$")
		public void validate_CTM_people_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_CTM_people_validation4);
			Reporter.log(
					"******validation of CTM_people table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate AST_Impacted_Areas table for the old department (.+) after update$")
		public void validate_AST_Impacted_Areas_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_AST_Impacted_Areas_validation3);
			Reporter.log(
					"******validation of AST_Impacted_Areas table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the old department (.+) after update$")
		public void validate_CTM_People_Organization_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_CTM_People_Organization_validation3);
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the old department (.+) after update$")
		public void validate_AST_AssetPeople_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_AST_AssetPeople_validation3);
			Reporter.log(
					"******validation of AST_AssetPeople table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the old department (.+) after update$")
		public void validate_HPD_Impacted_Areas_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_HPD_Impacted_Areas_validation3);
			Reporter.log(
					"******validation of HPD_Impacted_Areas table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate SYN_MDM_SERV_ZN table for the old department (.+) after update$")
		public void validate_SYN_MDM_SERV_ZN_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameDatabase(P_Dept, "dept",
					Query_syn_mdm_co_validation2, "CO_GUID",
					Query_SYN_MDM_SERV_ZN_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SYN_MDM_SERV_ZN table is complete for the old Department after rename*****",
					true);
		}
		
		@Then("^validate SYN_MDM_SERV_ACCT table for the old department (.+) after update$")
		public void validate_SYN_MDM_SERV_ACCT_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameDatabase(P_Dept, "dept",
					Query_syn_mdm_co_validation2, "CO_GUID",
					Query_SYN_MDM_SERV_ACCT_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SYN_MDM_SERV_ACCT table is complete for the old Department after rename*****",
					true);
		}
		
		@Then("^validate CO table for the old department (.+) after update$")
		public void validate_CO_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(P_Dept, "dept",
					Query_CO_validation);
			Reporter.log(
					"******validation of CO table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate CO_NM table for the old department (.+) after update$")
		public void validate_CO_NM_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(P_Dept, "dept",
					Query_CO_NM_validation);
			Reporter.log(
					"******validation of CO_NM table is complete for the old Department after Rename*****",
					true);
		}
		
		@Then("^validate KEY_CROSS_REF table for the old department (.+) after update$")
		public void validate_KEY_CROSS_REF_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_KEY_CROSS_REF_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of KEY_CROSS_REF table is complete for the old Department after rename*****",
					true);
		}
		
		@Then("^validate SERV_ZN table for the old department (.+) after update$")
		public void validate_SERV_ZN_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the old Department after rename*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the old department (.+) after update$")
		public void validate_SERV_ACCT_After_Dept_Rename_Old(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the old Department after rename*****",
					true);
		}
		
		@Then("^validate syn_mdm_co table for the new department (.+) after update$")
		public void validate_Syn_Mdm_Co_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_syn_mdm_co_validation2);
			Reporter.log(
					"******validation of syn_mdm_co table is complete for the new Department after Rename*****",
					true);
		}
		
		@Then("^validate CTM_People table for the new department (.+) after update$")
		public void validate_CTM_people_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_CTM_people_validation4);
			Reporter.log(
					"******validation of CTM_people table is complete for the new Department after Rename*****",
					true);
		}
		
		@Then("^validate AST_Impacted_Areas table for the new department (.+) after update$")
		public void validate_AST_Impacted_Areas_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_AST_Impacted_Areas_validation3);
			Reporter.log(
					"******validation of AST_Impacted_Areas table is complete for the new Department after Rename*****",
					true);
		}
		
		@Then("^validate CTM_People_Organization table for the new department (.+) after update$")
		public void validate_CTM_People_Organization_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_CTM_People_Organization_validation3);
			Reporter.log(
					"******validation of CTM_People_Organization table is complete for the new Department after Rename*****",
					true);
		}
		
		@Then("^validate AST_AssetPeople table for the new department (.+) after update$")
		public void validate_AST_AssetPeople_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_AST_AssetPeople_validation3);
			Reporter.log(
					"******validation of AST_AssetPeople table is complete for the new Department after Rename*****",
					true);
		}
		
		@Then("^validate HPD_Impacted_Areas table for the new department (.+) after update$")
		public void validate_HPD_Impacted_Areas_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(P_Dept, "dept",
					Query_HPD_Impacted_Areas_validation3);
			Reporter.log(
					"******validation of HPD_Impacted_Areas table is complete for the new Department after Rename*****",
					true);
		}
		
//		@Then("^validate SYN_MDM_SERV_ZN table for the new department (.+) after update$")
//		public void validate_SYN_MDM_SERV_ZN_After_Dept_Rename_New(
//				String P_Dept) throws Exception {
//			
//			DBUtil dbutil = new DBUtil();
//			dbutil.validationUsingMultipleTableInSameDatabase(P_Dept, "dept",
//					Query_syn_mdm_co_validation2, "CO_GUID",
//					Query_SYN_MDM_SERV_ZN_validation, "CO_GUID_D");
//			Reporter.log(
//					"******validation of SYN_MDM_SERV_ZN table is complete for the new Department after rename*****",
//					true);
//		}
//		
//		@Then("^validate SYN_MDM_SERV_ACCT table for the new department (.+) after update$")
//		public void validate_SYN_MDM_SERV_ACCT_After_Dept_Rename_New(
//				String P_Dept) throws Exception {
//			
//			DBUtil dbutil = new DBUtil();
//			dbutil.validationUsingMultipleTableInSameDatabase(P_Dept, "dept",
//					Query_syn_mdm_co_validation2, "CO_GUID",
//					Query_SYN_MDM_SERV_ACCT_validation, "CO_GUID_D");
//			Reporter.log(
//					"******validation of SYN_MDM_SERV_ACCT table is complete for the new Department after rename*****",
//					true);
//		}
		
		@Then("^validate SERV_ZN Remedy table for the company (.+) after update$")
		public void validate_SERV_ZN_Remedy_After_Update1(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceZone);
			Reporter.log("******validation of SERV_Zone Remedy table is complete for the Company after update*****",
					true);
		}
		
		@Then("^validate SERV_ACCT Remedy table for the company (.+) after update$")
		public void validate_SERV_ACCT_Remedy_After_Update1(String activecompany)
				throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithDatabase(activecompany, "co",
					Query_Remedy_ServiceAccount);
			Reporter.log("******validation of SERV_ACCT Remedy table is complete for the Company after update*****",
					true);
		}
		
		@Then("^validate CO table for the new department (.+) after update$")
		public void validate_CO_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(P_Dept, "dept",
					Query_CO_validation);
			Reporter.log(
					"******validation of CO table is complete for the new Department after Rename*****",
					true);
		}
		
		@Then("^validate CO_NM table for the new department (.+) after update$")
		public void validate_CO_NM_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabase(P_Dept, "dept",
					Query_CO_NM_validation);
			Reporter.log(
					"******validation of CO_NM table is complete for the new Department after Rename*****",
					true);
		}
		
		@Then("^validate KEY_CROSS_REF table for the new department (.+) after update$")
		public void validate_KEY_CROSS_REF_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_KEY_CROSS_REF_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of KEY_CROSS_REF table is complete for the new Department after rename*****",
					true);
		}
		
		@Then("^validate SERV_ZN table for the new department (.+) after update$")
		public void validate_SERV_ZN_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ZN_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ZN table is complete for the new Department after rename*****",
					true);
		}
		
		@Then("^validate SERV_ACCT table for the new department (.+) after update$")
		public void validate_SERV_ACCT_After_Dept_Rename_New(
				String P_Dept) throws Exception {
			
			DBUtil dbutil = new DBUtil();
			dbutil.validationUsingMultipleTableInSameMDMDatabase(P_Dept, "dept",
					Query_CO_validation, "CO_GUID",
					Query_SERV_ACCT_validation, "CO_GUID_D");
			Reporter.log(
					"******validation of SERV_ACCT table is complete for the new Department after rename*****",
					true);
		}
//		
//*************************************** DEPARTMENT RENAME ENDS *********************************************//	
//*************************************** SMU STARTS *********************************************************//
		@When("^click on Service Modelling Utility$")
		public void click_On_Service_Modelling_Utility() throws Throwable {
			HomePage h = new HomePage(driver);
			h.SMU(driver);
			Thread.sleep(5000);
		}
		
		@Then("^open the (.+) in SMU$")
		public void open_The_Company_In_SMU(String P_CompanyName) throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.OpenTheCompanyInSMU(P_CompanyName, driver);
			Thread.sleep(5000);
		}
		
		
		@Then("^open the (.+) in Edit mode$")
		public void open_The_Company_In_Edit_Mode(String P_CompanyName) throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.OpenTheCompanyInEditMode(P_CompanyName, driver);
			Thread.sleep(5000);
		}
		
		@Then("^drag the (.+) from (.+) to drop into (.+)$")
		public void drag_And_Drop_Into_Existing_Dept(String P_Contact, String P_SrcDept, String P_DestDept) throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.DragAndDropIntoExistingDept(P_Contact, P_SrcDept, P_DestDept, driver);
			Thread.sleep(5000);
		}		
		
		@Then("^delete siteIDs from siteID table$")
		public void delete_SiteIDs_From_SiteID_Table() throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.deleteSiteIDsFromSiteIDTable(driver);
			Thread.sleep(5000);
		}
		
		@Then("^validate siteIDs from siteID table$")
		public void validate_SiteIDs_From_SiteID_Table() throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.validateSiteIDsFromSiteIDTable(driver);
			Thread.sleep(5000);
		}
		
		@Then("^click on reset staging button on SMU for the (.+)$")
		public void click_On_Reset_Staging_Button(String P_Comp) throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.clickOnResetStagingButton(P_Comp, driver);
			Thread.sleep(5000);
		}
		
		@Then("^click on commit changes button on SMU for the (.+)$")
		public void click_On_Commit_Changes_Button(String P_Comp) throws Throwable {			
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.clickoncommitchangesbutton(P_Comp, driver);
			Thread.sleep(5000);
		}
		
		@Then("^click on cancel button on SMU for the (.+)$")
		public void click_On_Cancel_Button1(String P_Comp) throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.clickOnCancelButton(P_Comp, driver);
			Thread.sleep(5000);
		}
		
		@Then("^create new (.+) under the (.+)$")
		public void create_New_Dept_Under_The_Org(String P_newDept, String P_org) throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.createNewDeptUnderTheOrg(P_newDept, P_org, driver);
			Thread.sleep(5000);
		}
		
		@Then("^clear the company name field$")
		public void clear_Company_Name_Field() throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.clearTheCompanyNameField(driver);
			Thread.sleep(5000);
		}
		
		@Then("^validate people section on SMU UI for dest (.+)$")
		public void validate_People_Section_On_SMU_UI(String P_Destdept) throws Throwable {
			ServiceModellingUtility smu = new ServiceModellingUtility(driver);
			smu.validatePeopleSection(P_Destdept, driver);
			Thread.sleep(5000);
		}
		
		@Then("^Validate if (.+) is associated to (.+)$")
		public void validate_MDMDB_Before_Association(String P_Contact, String P_SrcDept) throws Exception {			
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabasewithMultipleparameter(P_Contact, "lname",
					P_SrcDept, "co", Query_Validate_Contact_MDM);
			Reporter.log(
					"******validation of MDM DB is complete before moving the contact*****",
					true);
		}
		
		@Then("^validate if (.+) is associated to dest (.+)$")
		public void validate_MDMDB_After_Association(String P_Contact, String P_DestDept) throws Exception {			
			DBUtil dbutil = new DBUtil();
			dbutil.validationWithMDMDatabasewithMultipleparameter(P_Contact, "lname",
					P_DestDept, "co", Query_Validate_Contact_MDM);
			Reporter.log(
					"******validation of MDM DB is complete after moving the contact*****",
					true);
		}


//*************************************** SMU ENDS *********************************************************//
}
