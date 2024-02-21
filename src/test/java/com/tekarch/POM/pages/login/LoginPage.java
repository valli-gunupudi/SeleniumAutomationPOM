package com.tekarch.POM.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tekarch.POM.pages.base.BasePage;

public class LoginPage extends BasePage {
	@FindBy(id = "username")
	WebElement usernameBox;
	@FindBy(id = "password")
	WebElement passwordBox;
	@FindBy(id = "Login")
	WebElement loginButton;
	@FindBy(xpath = "//div[@id=\"error\"]")
	WebElement textWEerror;
	@FindBy(id = "userNavLabel")
	WebElement userNavLabel;
	@FindBy(xpath = "//*[@id=\"rememberUn\"]")
	WebElement rememberMeChk;

	@FindBy(id = "idcard-identity")
	WebElement userEmailChk;
	@FindBy(id = "forgot_password_link")
	WebElement forgotPwdLink;

	@FindBy(id = "error")
	WebElement wrngEmailErr;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String data) {
		enterText(usernameBox, data, "Username");
	}

	public void enterPassword(String data) {
		enterText(passwordBox, data, "password field");
	}

	public void clearElement() {
		clearElement(passwordBox, "password");
	}

	public WebDriver clickLoginButton() {
		clickElement(loginButton, "login button");
		return driver;
	}

	public WebDriver clickFrgtPwdLink() {
		clickElement(forgotPwdLink, "forgotPwdLink");
		return driver;
	}

	public void selectChk() {
		selectChkBox(rememberMeChk, "rememberMeChk");
	}

	public String getErrorFromElement() {
		String data = getTextFromElement(textWEerror, "error msg");
		return data;
	}

	public String getUserEmailFromElement() {
		String data = getTextFromElement(userEmailChk, "user email");
		return data;
	}

	public String getwrngEmailErr() {
		String data = getTextFromElement(wrngEmailErr, "wrngEmailErr");
		return data;
	}

	public String getTitleOfThePage() {
		// waitUntilPageLoads();
		return getPageTitle();
	}
}
