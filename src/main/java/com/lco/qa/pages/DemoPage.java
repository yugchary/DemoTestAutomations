package com.lco.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lco.qa.base.TestBase;

public class DemoPage extends TestBase{
	
	//Page Factory - OR
	
	@FindBy(css="#txtUsername")
	WebElement userName;
		
	//Initialize the Page objects
	public DemoPage(){
		PageFactory.initElements(driver, this);
		
	}	
	
	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public DemoPage SampleTest(String un, String pwd) {
		
		userName.sendKeys("yug");
		
		return new DemoPage();
		
	}

}
