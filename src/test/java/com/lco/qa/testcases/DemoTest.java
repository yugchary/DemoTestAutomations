package com.lco.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



//import com.crm.qa.pages.HomePage;

import com.lco.qa.base.TestBase;
import com.lco.qa.pages.DemoPage;
import com.lco.qa.util.Testutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoTest extends TestBase {

	DemoPage demoPage;
	ExtentTest extentTest;

	

	public DemoTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		demoPage = new DemoPage();
	}

	@Test
	public void loginPageTitleTest() {
		
		
		log.info("****************************** Starting loginPageTitleTest test cases execution *****************************************");
		extentTest = extent.startTest("loginPageTitleTest");
		String title = demoPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
		log.info("****************************** Ending loginPageTitleTest test cases execution *****************************************");
	}

	@Test
	public void loginTest() {
		demoPage = demoPage.SampleTest(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = Testutil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}

}
