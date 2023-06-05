package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void reSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmailID() {
		return "testautomation" + System.currentTimeMillis() + "@gmail.com";
		//return "testautomation" + UUID.randomUUID() + "@gmail.com"  --->>>> Alternate method
		
	}
//	@DataProvider(name = "regData")
//	public Object[][] getUserRegTestData() {
//		return new Object[][] {
//			{"John", "Charlette", "8601236875", "Char@321", "yes"},
//			{"Tom", "Meneghani", "5168945689", "tom#124", "no"},
//			{"Sanu", "Patnaik", "9148967845", "sanup@456", "yes"},
//		};
//	}
	
	@DataProvider(name = "regExcelData")
	public Object[][] getRegExcelTestData(){
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
		
	}
	
	@Test(dataProvider = "regExcelData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		String accRegSuccMessg = registerPage.registerUser(firstName, lastName, getRandomEmailID(), telephone, password, subscribe);
		Assert.assertEquals(accRegSuccMessg, AppConstants.USER_RESG_SUCCESS_MESSG);
		}

}
