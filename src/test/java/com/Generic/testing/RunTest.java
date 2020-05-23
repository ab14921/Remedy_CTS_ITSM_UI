package com.Generic.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Generic.stepdefinition.StepDefinition;


import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = { ".\\src\\test\\java\\com\\AIMS\\feature", ".\\src\\test\\java\\com\\Generic\\feature",
		".\\src\\test\\java\\com\\ServiceModellingUtility\\feature" }, 
		glue = { "com/AIMS/stepdefinition",
				"com/Generic/stepdefinition", "com/ServiceModellingUtility/stepdefinition" }, 
		plugin = { "pretty",
						"html:target/cucumber-html-report", "json:target/cucumber-reports/Cucumber.json"}, 
		tags = { "@Sanity" })

public class RunTest extends AbstractTestNGCucumberTests
{
	

//	   JSONObject jo = null;
//	   JSONArray ja = null;
	   public static long featurefromtime,featuretotime;
	   public static String applicationName;
	   public static Properties prop = new Properties();
	   public static InputStream istream = null;
	   public static long scenariofromtime,scenariototime;
	   public static String TestType,Environment;	
	   public static int features;
	
	   
	   @BeforeClass
		public void environmentsetup() throws FileNotFoundException, IOException {
		   features++;
	       TestType=System.getProperty("testtype.key");
	       Environment=System.getProperty("envtype.key");
	       applicationName=System.getProperty("applicationname.key");
	       featurefromtime=System.currentTimeMillis();
	       try {
	               istream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\common-application.properties");
	               prop.load(istream);
	               
	               
	       } catch (IOException ex)
	       {
	               ex.printStackTrace();
	               
	       }
	       if(TestType==null)	
	               TestType=prop.getProperty("testtype.key");
	       
	       if(TestType==null)
	               TestType="None";
	       
	       if(Environment==null)
	               Environment=prop.getProperty("envtype.key");
	       
	       if(applicationName==null)
	    	   applicationName=prop.getProperty("application.name");
	       
	   }
	   

@Test 
public void run() throws InterruptedException
{
	
}	

@AfterClass
public static void logReport() throws Exception{
  	   
  	   
       String jsonString=StepDefinition.arrObj.toString();  
       
        if(!(System.getProperty("applicationname.key")==null)) 
       {
       			FileWriter fw = new FileWriter("result.json");
                fw.write(jsonString);
                fw.close();
       } 

     
	}



}