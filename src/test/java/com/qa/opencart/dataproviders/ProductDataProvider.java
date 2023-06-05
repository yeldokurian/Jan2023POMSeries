package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.Product;

public class ProductDataProvider {
	
	@DataProvider(name = "productData")
	public Object[][] getProductTestData() {
		return new Object[][] {
			{new Product("MacBook", "MacBook Pro", 4)},
			{new Product("iMac", "iMac", 3)},
			{new Product("Samsung", "Samsung SyncMaster 941BW", 1)},
			{new Product("Samsung", "Samsung Galaxy Tab 10.1", 7)},
		};
	}
	@DataProvider(name = "productDataWithImage")
	public Object[][] getProductImagesTestData() {
		return new Object[][] {
			{"MacBook", "MacBook Pro", 4},
			{"iMac", "iMac", 3},
			{"Samsung", "Samsung SyncMaster 941BW", 1},
			{"Samsung", "Samsung Galaxy Tab 10.1", 7},
		};
	}
	
	@DataProvider(name = "productDataWithName")
	public Object[][] getProductData() {
		return new Object[][] {
			{"MacBook", "MacBook Pro"},
			{"iMac", "iMac"},
			{"Samsung", "Samsung SyncMaster 941BW"},
			{"Samsung", "Samsung Galaxy Tab 10.1"},
		};
	}
	
	@DataProvider(name = "productDataWithSearchKey")
	public Object[][] getProductSearchKeyData() {
		return new Object [][] {
			
			{"MacBook"},
			{"iMac"},
			{"Samsung"}
			
		};
		
		
	}

}
