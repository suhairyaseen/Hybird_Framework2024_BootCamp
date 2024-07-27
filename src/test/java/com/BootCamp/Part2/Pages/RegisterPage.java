package com.BootCamp.Part2.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
	public WebDriver driver;
	
	
	@FindBy(id = "input-firstname")
	private WebElement firstnameTextField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameTextField;

	@FindBy(id = "input-email")
	private WebElement emailTextField;
	
	@FindBy(id = "input-telephone")
	private WebElement teleTextField;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath = "//input[@name = 'newsletter'][@value = '1']")
	private WebElement newsletterBox;
	
	@FindBy(xpath = "//input[@name = 'agree']")
	private WebElement privacyPolicyBox;
	
	@FindBy(xpath = "//input[@class = 'btn btn-primary']")
	private WebElement continueButton;
	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
public void insertFirstnameIntextField(String FN) {
	firstnameTextField.sendKeys(FN);
}
public void insertLastNameInTextField(String LN) {
	lastNameTextField.sendKeys(LN);
}
public void insertEmailInTextField(String Email) {
	emailTextField.sendKeys(Email);
}
public void insertTeleInTextField(String Telephone) {
	teleTextField.sendKeys(Telephone);
}
public void insertPasswordInTextField(String pass) {
	 passwordTextField.sendKeys(pass);
}
public void insertConfirmPasswordInTextField(String confirm) {
	confirmPasswordTextField.sendKeys(confirm);
}
public void checkNewsletterBox() {
	newsletterBox.click();
}
public void checkprivacyPolicyBox() {
	privacyPolicyBox.click();
}
public MyAccountPage clickOncontinueButton() {
	continueButton.click();
	return new MyAccountPage(driver);
}
}
