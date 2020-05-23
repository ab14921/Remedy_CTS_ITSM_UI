package com.Generic.remedyPage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;


public class Baseclass {

	public static WebDriver driver;
	public static Properties p = new Properties();
	public static Properties q = new Properties();
	static {
		try {
			p.load(new FileInputStream("src/test/java/properties/sql/sql.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	static{
//		try {
//			System.setOut(new PrintStream(new FileOutputStream("C:\\Automation\\ConsoleOutput.txt")));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	

	public void environment() throws FileNotFoundException, IOException {
		p.load(new FileInputStream("src/test/java/properties/common-application.properties"));
		
		if (p.getProperty("TEST_ENV").contentEquals("ts")) {
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\ts\\application.properties"));
		} else if (p.getProperty("TEST_ENV").contentEquals("qa")) {
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\qa\\application.properties"));
		} else if (p.getProperty("TEST_ENV").contentEquals("pd")) {
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\pd\\application.properties"));
		} else if (p.getProperty("TEST_ENV").contentEquals("dv")) {
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\dv\\application.properties"));
		}
		else {
			System.out.println("No such file");

		}

	}
	public void environment(String environment) throws FileNotFoundException, IOException {
		p.load(new FileInputStream(".\\src\\test\\java\\properties\\common-application.properties"));
		if ("ts".equalsIgnoreCase(environment)) // ts
		{
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\ts\\application.properties"));
		} else if ("qa".equalsIgnoreCase(environment)) // qa
		{
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\qa\\application.properties"));
		} else if ("tn".equalsIgnoreCase(environment)) // tn
		{
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\tn\\application.properties"));
		} else if ("ctl_dv".equalsIgnoreCase(environment)) // ctl_dv
		{
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\ctl_dv\\application.properties"));
		} else if ("ctl_ts".equalsIgnoreCase(environment)) // ctl_ts
		{
			q.load(new FileInputStream(".\\src\\test\\java\\properties\\ctl_ts\\application.properties"));
		} else {
			System.out.println("No such file");
		}
	}


	public void browser(String browser) throws Exception {
		if (browser.equals("FireFox")) {
//			System.setProperty("webdriver.gecko.driver","C:\\project\\Remedy_CTS_IM\\src\\test\\java\\Drivers\\geckodriver.exe");
//			// Create a new instance of the FireFox driver
			driver = new FirefoxDriver();
			
//			File pathBinary = new File("C:\\Mozilla Firefox\\firefox.exe");
//			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//			FirefoxProfile firefoxProfile = new FirefoxProfile();       
//			WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
			
//			File src = new File("./phantomjs-2.1.1-windows/bin/phantomjs.exe");
//   	    	System.out.println("############### USING PHANTOM DRIVER ##############");
//   	    	System.setProperty("phantomjs.binary.path", src.getAbsolutePath());       
//   	    	driver = new PhantomJSDriver(); 
		}

		else if (browser.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Automation\\Remedy_CTS_IM_UI\\Remedy_CTS_Incident_Management\\src\\test\\java\\Drivers\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver",
//					"c:\\jenkins\\tools\\chrome\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					".\\src\\test\\java\\Drivers\\chromedriver.exe");
			
			// Create a new instance of the Chrome driver
			ChromeOptions o = new ChromeOptions();
			o.addArguments("disable-extensions");
			o.addArguments("--start-maximized");
			driver = new ChromeDriver(o);

		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");

			// Create a new instance of the InternetExplorer driver
			driver = new InternetExplorerDriver();

		}

		String url = q.getProperty("url");
		driver.get(url);
		System.out.println("Application Launched Succesffully");



	}
	
	public void switchToNewWindow(int windowNumber) throws InterruptedException {		
	    Set < String > s = driver.getWindowHandles();   
	    Iterator < String > ite = s.iterator();
	    int i = 1;
	    while (ite.hasNext() && i < 10) {
	        String popupHandle = ite.next().toString();
	        driver.switchTo().window(popupHandle);
	        Reporter.log(getTimeStamp() +": Window title is : "+driver.getTitle());
	        if (i == windowNumber) break;
	        i++;
	    }
	}
	
	public Timestamp getTimeStamp() throws InterruptedException {		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());						
		return timestamp;
	}
	
	public void WriteConsoleOutputIntoTxtFile() throws InterruptedException, FileNotFoundException {		
//		PrintStream out = new PrintStream(new FileOutputStream("C:\\Automation\\ConsoleOutput.txt"));
		System.out.flush(); 
//		System.setOut(out);
	}
}
