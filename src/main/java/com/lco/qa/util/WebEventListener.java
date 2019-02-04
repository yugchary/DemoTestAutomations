package com.lco.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.w3c.dom.events.EventListener;

import com.lco.qa.base.TestBase;

public  class WebEventListener extends TestBase implements WebDriverEventListener {
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		//System.out.println("Before navigating to: '" + url + "'");
		
		
		log.debug("Before navigating to: '" + url + "'");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		//System.out.println("Navigated to:'" + url + "'");
		log.debug("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		//System.out.println("Value of the:" + element.toString() + " before any changes made");
		log.debug("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		//System.out.println("Element value changed to: " + element.toString());
		log.debug("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		//System.out.println("Trying to click on: " + element.toString());
		log.debug("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		//System.out.println("Clicked on: " + element.toString());
		log.debug("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		//System.out.println("Navigating back to previous page");
		log.debug("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		//System.out.println("Navigated back to previous page");
		log.debug("Navigated back to next page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		//System.out.println("Navigating forward to next page");
		log.debug("Navigated forward to previous page");
	}

	public void afterNavigateForward(WebDriver driver) {
		//System.out.println("Navigated forward to next page");
		log.debug("Navigated forward to next page");
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		//System.out.println("Trying to find Element By : " + by.toString());
		log.debug("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		//System.out.println("Found Element By : " + by.toString());
		log.debug("Found Element By : " + by.toString());
	}
	
	
	
	public void onException(Throwable error, WebDriver driver) {
		//System.out.println("Exception occured: " + error);
		log.error("Exception occured: " + error);
		try {
			Testutil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	  non overridden methods of WebListener class
	 */

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	

	

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	

}
