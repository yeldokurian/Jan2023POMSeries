package com.qa.opencart.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Accounts Page Design")
@Story("US 102: design accounts page for open cart with title, is logout link exist, is myaccount link exist, account page headers count")
public class AccountsPageTest extends BaseTest{


@BeforeClass
public void accPageSetup() {
	accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
}
@Severity(SeverityLevel.MINOR)	
@Description("checking accounts page title test..")
@Feature("title test")
@Test
public void accPageTitleTest() {
	String actTitle = accPage.getAccPageTitle();
	Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	
}
@Severity(SeverityLevel.CRITICAL)	
@Description("checking logout link exist test..")
@Feature("logout link exist test")
@Test
public void isLogoutLinkExistTest() {
	Assert.assertTrue(accPage.isLogoutLinkExist());
	
}
@Severity(SeverityLevel.CRITICAL)	
@Description("checking my account link exist test..")
@Feature("account link exist test")
@Test
public void isMyAccountLinkExistTest() {
	Assert.assertTrue(accPage.isMyAccountLinkExist());	
}
@Severity(SeverityLevel.MINOR)	
@Description("getting actual account page headers count test..")
@Feature("account headers count test")
@Test
public void accPageHeadersCountTest() {
	List<String>actAccHeadersList = accPage.getAccountPageHeadersList();
	Assert.assertEquals(actAccHeadersList.size(), 4);
	
}
@Test
@Severity(SeverityLevel.MINOR)	
@Description("getting actual account page headers list test..")
@Feature("account page headers list test")
public void accPageHeadersTest() {
	List<String>actAccHeadersList = accPage.getAccountPageHeadersList();
	
	Assert.assertEquals(actAccHeadersList, AppConstants.EXP_ACCOUNTS_HEADERS_LIST);
	
}


}
