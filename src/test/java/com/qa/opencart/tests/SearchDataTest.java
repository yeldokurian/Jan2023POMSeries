package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import com.qa.opencart.pojo.Product;

public class SearchDataTest extends BaseTest {
	@BeforeClass
	public void searchSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	
		
		
	
	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void searchProductResultCountTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		Assert.assertTrue(resultsPage.getProductResultsCount()>0);
	}
	
	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void searchPageTitleTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		String actSearchTitle = resultsPage.getResultsPageTitle(product.getSearchKey());
		System.out.println("Search Page Title : "+ actSearchTitle);
		Assert.assertEquals(actSearchTitle, "Search - " + product.getSearchKey());
	}
	
	
	@Test(dataProvider = "productData", dataProviderClass = ProductDataProvider.class)
	public void selectProductTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(product.getProductName());
		String actProductHeaderName = productInfoPage.getProductHeaderName();
		System.out.println("Actual Product Header Name:" + actProductHeaderName);
		Assert.assertEquals(actProductHeaderName, product.getProductName());
	}
	
	
	
	@Test(dataProvider = "productData")
	public void productImagesTest(Product product) {
		resultsPage = accPage.doSearch(product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(product.getProductName());
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		System.out.println("Actual Product Images Count:"+actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, product.getProductImages());
	}

}
