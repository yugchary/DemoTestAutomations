package com.lco.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lco.qa.base.TestBase;

public class TemplatePage extends TestBase{
	
	//Page Factory - OR
		@FindBy(xpath="")
		WebElement xyz;
		
		@FindBy(css=".test")
		WebElement selectItem;
		
	//Initialize the Page objects
	public TemplatePage(){
		PageFactory.initElements(driver, this);
		
	}	
	
	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public TemplatePage SampleTest(String un, String pwd) {
		
		return new TemplatePage();
		
	}

}
