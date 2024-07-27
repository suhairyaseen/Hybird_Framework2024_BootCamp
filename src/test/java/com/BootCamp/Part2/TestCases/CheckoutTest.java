package com.BootCamp.Part2.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BootCamp.Part2.Pages.Homepage;
import com.BootCamp.Part2.Pages.ProductPage;
import com.BootCamp.Part2.Pages.ShopppingCartPage;
import com.BootCamp.Part2.TestBase.TestBase;

public class CheckoutTest extends TestBase {
public CheckoutTest() throws Exception {
		super();
	}

public WebDriver driver;
public Homepage homepage;
public ProductPage productpage;
public ShopppingCartPage shoppingcartpage;

@BeforeMethod
public void setupPage() {
	driver = intializeBrowers(prop.getProperty("browser"));
}
@Test
public void checkoutValidproduct() {
	homepage = new Homepage(driver);
	homepage.insertValidProductInSearchField(propdata.getProperty("validproduc1"));
	productpage = homepage.clickOnSearchButton();
	productpage = new ProductPage(driver);
	shoppingcartpage	= productpage.clickOnAddToCartButton();
	shoppingcartpage = new ShopppingCartPage(driver);
	shoppingcartpage.clickOnShoppingCartbutton();
	Assert.assertTrue(shoppingcartpage.displayedRightProduct());
	shoppingcartpage.clickOncheckoutButton();
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
