package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By resultsProduct = By.cssSelector("div.product-layout.product-grid");
	
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		
	}
	//page actions
	public String getResultsPageTitle(String searchKey) {
		return eleUtil.waitForTitleIsAndCapture(searchKey, 10);
		
	}
	
	public int getProductResultsCount() {
		int resultCount = eleUtil.waitForElementsVisible(resultsProduct, 10).size();
		System.out.println("Product Search Result Count=====>" + resultCount);
		return resultCount;	
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By productNameLocator = By.linkText(productName);
		eleUtil.doClick(productNameLocator);
		return new ProductInfoPage(driver);
	}

}
