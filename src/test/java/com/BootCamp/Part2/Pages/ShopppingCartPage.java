package com.BootCamp.Part2.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopppingCartPage {

	public WebDriver driver;
	
	@FindBy(linkText = "Shopping Cart")
	private WebElement shoppingCartbutton;
	
	@FindBy(xpath = "//td[@class = 'text-center']/following::img")
	private WebElement RightProduct;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutButton;
	
	public ShopppingCartPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver , this);
	}
	
	public void clickOnShoppingCartbutton() {
		shoppingCartbutton.click();
	}
	
	public boolean displayedRightProduct() {
		boolean product = RightProduct.isDisplayed();
		return product;
	}
	public void clickOncheckoutButton() {
		checkoutButton.click();
	}
}
