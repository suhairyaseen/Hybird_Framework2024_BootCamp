package com.BootCamp.Part2.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text() , 'iPhone')]")
	private WebElement validProductSearch;
	
	@FindBy(xpath = "//div[@class = 'caption']/following-sibling::div/child::button[1]")
	private WebElement addToCartButton;
	
public ProductPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
public boolean displayedvalidProductSearch() {
	boolean product = validProductSearch.isDisplayed();
	return product;
}
public ShopppingCartPage clickOnAddToCartButton() {
	addToCartButton.click();
	return new ShopppingCartPage(driver);
}
}
