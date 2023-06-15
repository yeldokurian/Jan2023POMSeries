package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
private WebDriver driver;
private ElementUtil eleUtil;

// 1. constructor of the page class
public LoginPage(WebDriver driver) {
	this.driver = driver;
	eleUtil = new ElementUtil(this.driver);
}

// 2. private By locators ( Private locators are being used by public methods - an example of encapsulation)
	
private By emailId = By.id("input-email");
private By passWord = By.id("input-password");
private By loginBtn = By.xpath("//input[@value='Login']");
private By forgotPwdLink = By.linkText("Forgotten Password");
private By footerlinks = By.xpath("//footer//a");
private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
private By registerLink = By.linkText("Register");


// 3. public page actions/methods
@Step("getting login page title....")
public String getLoginPageTitle() {
	return eleUtil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE_VALUE, AppConstants.SHORT_DEFAULT_WAIT);	
}
@Step("getting login page url")
public String getLoginPageUrl() {
	return eleUtil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstants.SHORT_DEFAULT_WAIT);
	
}
@Step("checking forgot pwd link exist on the login page")
public boolean isForgotPwdLinkExit() {
	 return eleUtil.checkElementIsDisplayed(forgotPwdLink);
	
}
@Step("getting footer links")
public List<String> getFooterLinksList() {
	List<WebElement> footerLinksList =  eleUtil.waitForElementsVisible(footerlinks, AppConstants.MEDIUM_DEFAULT_WAIT);
	List<String> footerTextList = new ArrayList<String>();
	for(WebElement e : footerLinksList) {
		String text = e.getText();
		footerTextList.add(text);
	}
	return footerTextList;
	
}
@Step("login with usernmae{0} and pwd{1}")
public AccountsPage doLogin(String username, String pwd) {
	System.out.println("Correct credentials are:" + username + ":" + pwd);
	eleUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(username);
	eleUtil.doSendKeys(passWord, pwd);
	eleUtil.doClick(loginBtn);
	// This method should return the next landing page - which is the "AccountsPage" and is called "Page Chaining Model"
	return new AccountsPage(driver);
	
}
@Step("login with wrong usernmae{0} and pwd{1}")
public boolean doLoginWithWrongCredentials(String username, String pwd) {
	System.out.println("Wrong credentials are:" + username + ":" + pwd);
	eleUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT);
	eleUtil.doSendKeys(emailId, username);
	eleUtil.doSendKeys(passWord, pwd);
	eleUtil.doClick(loginBtn);
	String errorMessg = eleUtil.doGetElementText(loginErrorMessg);
	System.out.println(errorMessg);
	if(errorMessg.contains(AppConstants.LOGIN_ERROR_MESSAGE)) {
		return true;
	}
	return false;
}

public RegisterPage navigateToRegisterPage() {
	eleUtil.doClick(registerLink);
	return new RegisterPage(driver);
}

}
