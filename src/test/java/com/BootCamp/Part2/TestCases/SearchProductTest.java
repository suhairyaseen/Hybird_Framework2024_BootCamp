package com.BootCamp.Part2.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BootCamp.Part2.Pages.Homepage;
import com.BootCamp.Part2.Pages.ProductPage;
import com.BootCamp.Part2.TestBase.TestBase;

public class SearchProductTest extends TestBase{

	public SearchProductTest() throws Exception {
		super();
		
	}

	public WebDriver driver;
	public Homepage homepage;
	public ProductPage productpage;
	
	
	@BeforeMethod
	public void setUpPage() {
		driver = intializeBrowers(prop.getProperty("browser"));
	}
	
	@Test
	public void validProductsearch() {
		homepage = new Homepage(driver);
		homepage.insertValidProductInSearchField(propdata.getProperty("validproduct"));
		productpage	= homepage.clickOnSearchButton();
		Assert.assertTrue(productpage.displayedvalidProductSearch());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
