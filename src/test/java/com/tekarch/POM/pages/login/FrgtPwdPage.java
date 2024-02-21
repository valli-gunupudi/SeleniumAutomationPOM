package com.tekarch.POM.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tekarch.POM.pages.base.BasePage;

public class FrgtPwdPage extends BasePage {
	@FindBy(id = "un")
	WebElement forgotPwdUN;
	@FindBy(id = "continue")
	WebElement cntBtn;
	@FindBy(tagName = "h1")
	WebElement chkEmailText;

	public FrgtPwdPage(WebDriver driver) {
		super(driver);
	}

	public void enterFrgtPwdUN(String data) {
		enterText(forgotPwdUN, data, "forgotPwdUN");
	}

	public WebDriver cntBtn() {
		clickElement(cntBtn, "cntBtn");
		return driver;
	}

	public String getPageVerification() {
		String data = getTextFromElement(chkEmailText, "chkEmailText");
		return data;
	}

}
