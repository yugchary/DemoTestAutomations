package com.lco.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.lco.qa.base.TestBase;

import com.lco.qa.pages.OnePersonGatherInfoPage;
import com.lco.qa.pages.ProductSelectionPage;
import com.lco.qa.util.Testutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OnePersonQuoteTest extends TestBase {

	OnePersonGatherInfoPage onePerson;
	ProductSelectionPage productSelectionPage;
	ExtentTest extentTest;

	//ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/LIC_TestExecutoinReport_Extent.html", true);

	public OnePersonQuoteTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		onePerson = new OnePersonGatherInfoPage();
	}

	@Test
	public void homePageTitleTest() {
		log.info("****************************** Starting homePageTitleTest test cases execution *****************************************");
		//extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extentTest = extent.startTest("homePageTitleTest");
		String title = onePerson.validateLoginPageTitle();
		Assert.assertEquals(title, "LifeCo Insurance Company");
		log.info("****************************** Ending homePageTitleTest test cases execution *****************************************");

	}

	@Test
	public void onePersonQuoteTest() {
		log.info("****************************** Starting onePersonQuoteTest test cases execution *****************************************");
		extentTest = extent.startTest("onePersonQuoteTest");
		productSelectionPage = onePerson.Quote1();
		log.info("****************************** Ending onePersonQuoteTest test cases execution *****************************************");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report

			String screenshotPath = Testutil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
																							// report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report
		driver.quit();
	}

}
