package com.lco.qa.pages;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lco.qa.base.TestBase;
import com.lco.qa.util.Testutil;

public class ProductSelectionPage extends TestBase {

	// Page Factory - OR
	@FindBy(xpath = "")
	WebElement xyz;

	@FindBy(xpath = "//button[@class='c-button-default circular hidden-xs active btn btn-default']")
	WebElement nextBtn;

	@FindBy(xpath = "//button[@class='c-button-default circular hidden-xs btn btn-default']")
	WebElement nextFinalBtn;
	// c-button-default circular hidden-xs btn btn-default

	// Initialize the Page objects
	public ProductSelectionPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:
	public String validateProductSelectionPageTitle() {
		return driver.getTitle();
	}

	public ProductSelectionPage GetPersonInfo() {

		List<WebElement> list = driver
				.findElements(By.cssSelector(".visible-xs .person-content.row .person-label-content"));

		System.out.println(list.size());

		Iterator<WebElement> t = list.iterator();

		int i = 0;
		while (t.hasNext()) {
			i++;

			String returnText = t.next().getAttribute("innerHTML").toString();
			// t.next().click();
			System.out.println("i value: " + i + returnText);

		}
		return new ProductSelectionPage();

	}

	public ProductSelectionPage ProductSelection() {

		List<WebElement> list = driver.findElements(By.cssSelector(".c-center.mt50.row .quote-this-product-container"));

		System.out.println(list.size());

		Iterator<WebElement> t = list.iterator();

		int i = 0;
		while (t.hasNext()) {
			i++;
			t.next().click();

		}
		nextBtn.click();
		return new ProductSelectionPage();

	}

	public void WaitForAzaxComponentToLoad(By by) {

		List<WebElement> listItem = driver.findElements(by);

		System.out.println("size of the webelements:" + listItem.size());

		Iterator<WebElement> itr = listItem.iterator();

		int i = 0;

		while (itr.hasNext()) {

			String returnText = itr.next().getText();
			System.out.println(i + "value" + returnText);
			while (returnText.isEmpty() && (i <= listItem.size())) {
				i++;
				System.out.println(i + "value" + returnText);

				try {
					Thread.sleep(Testutil.waitTime);
					System.out.println(i + "sleeping");
					listItem = driver.findElements(by);
					itr = listItem.iterator();
					returnText = itr.next().getText();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	public void FinalizeProductSelection() {

		/*
		 * List<WebElement> listAmount = driver
		 * .findElements(By.cssSelector(".plan-sider-info-text.row .plan-cost-amount"));
		 * 
		 * System.out.println("total plan:"+ listAmount.size());
		 * 
		 * Iterator<WebElement> $label = listAmount.iterator();
		 * 
		 * int i = 0; while ($label.hasNext()) { i++;
		 * 
		 * while($label.next().getText().isEmpty()) {
		 * 
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * listAmount = driver.findElements(By.
		 * cssSelector(".plan-sider-info-text.row .plan-cost-amount")); $label =
		 * listAmount.iterator(); //returnText =
		 * $label.next().getAttribute("innerHTML").toString(); }
		 * 
		 * 
		 * 
		 * if($label.next().isDisplayed()) { System.out.println("i displayed value: " +
		 * i ); }else { $label.next(); System.out.println("Not displayed: "+i); }
		 * 
		 * 
		 * }
		 */

		WaitForAzaxComponentToLoad(By.cssSelector(".plan-sider-info-text.row .plan-cost-amount"));

		List<WebElement> list = driver
				.findElements(By.cssSelector(".c-center.col-sm-12 .select-this-product-container.row"));

		System.out.println(list.size());

		Iterator<WebElement> t = list.iterator();

		int i1 = 0;
		while (t.hasNext()) {
			i1++;
			t.next().click();
			System.out.println("clicked: " + i1);
		}

		WaitForAzaxComponentToLoad(By.cssSelector(".plan-total-text"));

		nextFinalBtn.click();
		// return new ProductSelectionPage();

	}

}
