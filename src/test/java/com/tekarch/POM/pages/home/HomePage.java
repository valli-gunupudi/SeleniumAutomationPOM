package com.tekarch.POM.pages.home;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tekarch.POM.pages.base.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath = "/html/body/div[2]/div[2]/h1")
	WebElement studentRegistration;
	@FindBy(id = "userNavLabel")
	WebElement userNavLabel;
	@FindBy(linkText = "Logout")
	WebElement logout;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getUseridFromElement() {
		String data = getTextFromElement(userNavLabel, "user id");
		return data;
	}

	public WebDriver clickNavigation() {
		clickElement(userNavLabel, "userNavLabel");
		return driver;
	}

	public WebDriver clickLogout() {
		clickElement(logout, "logout");
		return driver;
	}
}
