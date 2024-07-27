package com.BootCamp.Part2.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BootCamp.Part2.Pages.Homepage;
import com.BootCamp.Part2.Pages.LoginPage;
import com.BootCamp.Part2.Pages.MyAccountPage;
import com.BootCamp.Part2.TestBase.TestBase;

public class LoginTest extends TestBase {
	public LoginTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public Homepage homepage;
	public LoginPage loginpage;
	public MyAccountPage myaccountpage;
	
	@BeforeMethod
	public void setUpPage() {
		driver = intializeBrowers(prop.getProperty("browser"));
		homepage = new Homepage(driver);
		homepage.clickOnMyAccountDropDown();
		loginpage = new LoginPage(driver);
		loginpage = homepage.clickOnLoginDropDown();	
	}
	@Test
	public void loginWithvalidCredentials() {
		loginpage = new LoginPage(driver);
		loginpage.insertEmailInTextField(prop.getProperty("validEmail"));
		loginpage.insertpasswordInTextField(prop.getProperty("validPassword"));
	    myaccountpage = loginpage.clickOnLoginButton();
	    myaccountpage = new MyAccountPage(driver);
	    Assert.assertTrue( myaccountpage.displayOrderHistoryLink());
		 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
