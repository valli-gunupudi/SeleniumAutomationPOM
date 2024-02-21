package com.tekarch.POM.automationTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.tekarch.POM.base.BaseTest;
import com.tekarch.POM.pages.home.HomePage;
import com.tekarch.POM.pages.login.FrgtPwdPage;
import com.tekarch.POM.pages.login.LoginPage;
import com.tekarch.POM.utilities.Constants;
import com.tekarch.POM.utilities.PropertiesUtility;

public class AutomationScriptsLogInTest extends BaseTest {

	protected Logger AutomationScriptslog = LogManager.getLogger();

	@Test
	public void loginErrorMessage1(@Optional("chrome") String name) throws InterruptedException, IOException {
		AutomationScriptslog.info("******AutomationScriptsLogInTest started***********");
		String expected = "Please enter your password.";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.enterUserName(userName);
		Thread.sleep(2000);
		loginPage.clearElement();
		Thread.sleep(2000);
		driver = loginPage.clickLoginButton();
		Thread.sleep(2000);

		String actual = loginPage.getErrorFromElement();
		Thread.sleep(2000);
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

	@Test
	public void loginSalesforce2(@Optional("chrome") String name) throws InterruptedException {
		AutomationScriptslog.info("******login to salesforce automation script started***********");
		String expected = "chandu rajana";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.enterUserName(userName);
		Thread.sleep(2000);
		loginPage.enterPassword(passWord);
		Thread.sleep(2000);
		driver = loginPage.clickLoginButton();

		HomePage homePage = new HomePage(driver);
		String actual = homePage.getUseridFromElement();
		Thread.sleep(2000);
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

	@Test
	public void rememberMe3(@Optional("chrome") String name) throws InterruptedException {
		AutomationScriptslog.info("******rememberMe automation script started***********");
		String expected = "valli@boxfree.com";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passWord = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.enterUserName(userName);
		Thread.sleep(2000);
		loginPage.enterPassword(passWord);
		Thread.sleep(2000);
		loginPage.selectChk();
		Thread.sleep(2000);
		driver = loginPage.clickLoginButton();
		Thread.sleep(2000);
		HomePage homePage = new HomePage(driver);
		homePage.clickNavigation();
		Thread.sleep(2000);
		driver = homePage.clickLogout();

		Thread.sleep(2000);
		String actual = loginPage.getUserEmailFromElement();
		Thread.sleep(2000);
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

	@Test
	public void forgotPassword4a(@Optional("chrome") String name) throws InterruptedException {
		AutomationScriptslog.info("******forgotPassword4a automation script started***********");
		String expected = "Check Your Email";
		String userName = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		driver = loginPage.clickFrgtPwdLink();
		Thread.sleep(2000);
		FrgtPwdPage frgtPage = new FrgtPwdPage(driver);
		frgtPage.enterFrgtPwdUN(userName);
		Thread.sleep(2000);
		frgtPage.cntBtn();
		Thread.sleep(2000);
		String actual = frgtPage.getPageVerification();
		Thread.sleep(2000);
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

	@Test
	public void forgotPassword4b(@Optional("chrome") String name) throws InterruptedException {
		AutomationScriptslog.info("******forgotPassword4b automation script started***********");
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		extentReport.logTestInfo("username and password extracted from properties file");

		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.enterUserName("123");
		Thread.sleep(2000);
		loginPage.enterPassword("22131");
		Thread.sleep(2000);
		loginPage.clickLoginButton();
		Thread.sleep(2000);
		String actual = loginPage.getwrngEmailErr();
		Thread.sleep(2000);
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}

}
