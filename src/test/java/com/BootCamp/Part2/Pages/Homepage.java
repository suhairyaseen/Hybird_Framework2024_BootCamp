package com.BootCamp.Part2.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText = "Login")
	private WebElement loginDropDown;
	
	@FindBy(linkText = "Register")
	private WebElement registerDropDown;
	
	@FindBy(xpath ="//input[@name ='search']")
    private WebElement searchTextField;	
	
	@FindBy(xpath = "//button[@class = 'btn btn-default btn-lg']")
	private WebElement searchButton;
	
public Homepage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver,this); 
	}

public void clickOnMyAccountDropDown() {
	myAccountDropDown.click();
}

public LoginPage clickOnLoginDropDown() {
	loginDropDown.click();
	return new LoginPage(driver);
}

public RegisterPage clickOnRegisterDropDown() {
	registerDropDown.click();
	return new RegisterPage(driver);
}
public void insertValidProductInSearchField(String Productname) {
	searchTextField.sendKeys(Productname);
}
public ProductPage clickOnSearchButton() {
	searchButton.click();
	return new ProductPage(driver);
}
}
