package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class LoginPageTest extends BaseTest{
	
	

@Test
public void loginPageTitleTest() {
	String actTitle = loginPage.getLoginPageTitle();
	Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);

}
@Test
public void loginPageUrlTest() {
	String actUrl = loginPage.getLoginPageUrl();
	Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	
	
}
	

@Test
public void forgotPwdLinkExistTest() {
	Assert.assertTrue(loginPage.isForgotPwdLinkExit());
	
}

@Test
public void loginTest() {
	accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertTrue(accPage.isLogoutLinkExist());
	Assert.assertTrue(accPage.getAccPageTitle().equals("My Account"));
}



}
