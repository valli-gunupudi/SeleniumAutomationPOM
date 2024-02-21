package com.tekarch.POM.pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import com.tekarch.POM.utilities.ExtentReportsUtility;

@Listeners(com.tekarch.POM.utilities.POMListenerUtility.class)
public class BasePage {
	public WebDriver driver = null;
	protected Wait<WebDriver> wait = null;
	protected Logger baseTestlog = LogManager.getLogger();
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			baseTestlog.info("data is entered in " + objectName + " textbox");
			extentReport.logTestInfo("data is entered in " + objectName + " textbox");

		} else {
			baseTestlog.info(objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			baseTestlog.info(objectName + "button is clicked");
			extentReport.logTestInfo(objectName + "button is clicked");
		} else {
			baseTestlog.info(objectName + " element is not enabled");

		}
	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		baseTestlog.info("text is extracted from " + objectName);
		extentReport.logTestInfo("text is extracted from " + objectName);
		return data;
	}

	public void maximiseBrowser() {
		driver.manage().window().maximize();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		baseTestlog.info("page is refreshed");
	}

	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			baseTestlog.info(ObjectName + " is cleared");
		} else {
			baseTestlog.info(ObjectName + " element is not displayed");
		}
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	public void waitForVisibility(WebElement ele, int time, String objectName) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void selectChkBox(WebElement ele, String ObjectName) {
		if (!ele.isSelected()) {
			ele.click();
			baseTestlog.info(ObjectName + "check button is selected");
		} else {
			baseTestlog.info(ObjectName + "check button is not selected");
		}
	}
}