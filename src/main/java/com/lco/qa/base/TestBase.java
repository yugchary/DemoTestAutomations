package com.lco.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.lco.qa.util.Testutil;
import com.lco.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger("TestAutomationLogger");
	public static ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/LIC_TestExecutoinReport_Extent.html", true);
	

	
	public TestBase(){
		
		prop = new Properties();
		try {
			//FileInputStream ip = new FileInputStream("C:\\Users\\akkyu01\\eclipse-workspace\\JavaTraining\\FreeCRMTests\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream ip = new FileInputStream("C:\\Users\\akkyu01\\eclipse-workspace\\JavaTraining\\Sureify\\src\\main\\java\\com\\lco\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String BrowserType = prop.getProperty("browserType");
		String BinariesLoc = prop.getProperty("binariesLocation");

		if (BrowserType.equalsIgnoreCase("CHROME")) {
			//System.setProperty("webdriver.chrome.driver","C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",BinariesLoc+"chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserType.equalsIgnoreCase("IE")) {

			//System.setProperty("webdriver.ie.driver","C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver",BinariesLoc+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (BrowserType.equalsIgnoreCase("FF")) {

			//System.setProperty("webdriver.gecko.driver","C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver",BinariesLoc+"geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Testutil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.implicitlyWait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		

		
		
	}
	

}
