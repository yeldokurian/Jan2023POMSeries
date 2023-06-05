package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class LoginPageNegativeTest extends BaseTest {
	
//	@DataProvider
//	public Object[][] incorrectLoginTestData() {
//	return new Object[][] {
//		{"prospect@gmail.com", "PostRoad1"},
//		{"prospect12@gmail.com", "PostRoad12"},
//		{"prospect12@", "Post12"},
//		{"", "PostRoad"},
//	};
//	
//	}
	
	@DataProvider(name="incorrectLoginExcelData")
	public Object[][] getincorrectLoginExcelTestData(){
		Object incorrectLoginData[][] = ExcelUtil.getTestData(AppConstants.INCORRECT_LOGIN_SHEET_NAME);
		return incorrectLoginData;
	}

	@Test(dataProvider = "incorrectLoginExcelData")
	public void loginWithWrongCredentialsTest(String userName, String password) {
		Assert.assertTrue(loginPage.doLoginWithWrongCredentials(userName, password));
	}
}
