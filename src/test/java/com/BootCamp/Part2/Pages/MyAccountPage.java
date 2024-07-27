package com.BootCamp.Part2.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//a[text() = 'View your order history']")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath = "//p[text() = 'Congratulations! Your new account has been successfully created!']")
	private WebElement successfullMessageForRegisteration;
	
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayOrderHistoryLink() {
		boolean orderlink = orderHistoryLink.isDisplayed();
		return orderlink;
	}
	
	public boolean displaysuccessfullMessageForRegisteration() {
		boolean SucessMessage = successfullMessageForRegisteration.isDisplayed();
		return SucessMessage;
	}
	
	
}
