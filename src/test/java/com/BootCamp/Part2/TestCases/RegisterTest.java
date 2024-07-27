package com.BootCamp.Part2.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BootCamp.Part2.Pages.Homepage;
import com.BootCamp.Part2.Pages.MyAccountPage;
import com.BootCamp.Part2.Pages.RegisterPage;
import com.BootCamp.Part2.TestBase.TestBase;
import com.BootCamp.Part2.Utility.Utility;

public class RegisterTest extends TestBase {
public RegisterTest() throws Exception {
		super();
		
	}

public WebDriver driver;
public Homepage homepage;
public RegisterPage registerpage;
public MyAccountPage myaccountpage;

@BeforeMethod
public void setUpPage() {
	driver = intializeBrowers(prop.getProperty("browser"));
	homepage = new Homepage(driver);
	homepage.clickOnMyAccountDropDown(); 
	registerpage = homepage.clickOnRegisterDropDown();
}
@Test
public void registerWithValidCredential() {
	registerpage = new RegisterPage(driver);
	registerpage.insertFirstnameIntextField(propdata.getProperty("firstname"));
	registerpage.insertLastNameInTextField("lastname");
	registerpage.insertEmailInTextField(Utility.emailStampTime());
	registerpage.insertTeleInTextField("tele");
	registerpage.insertPasswordInTextField(propdata.getProperty("password"));
	registerpage.insertConfirmPasswordInTextField(propdata.getProperty("conpassword"));
	registerpage.checkNewsletterBox();
	registerpage.checkprivacyPolicyBox();
	myaccountpage = registerpage.clickOncontinueButton();
	myaccountpage = new MyAccountPage(driver);
	Assert.assertTrue(myaccountpage.displaysuccessfullMessageForRegisteration());
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
