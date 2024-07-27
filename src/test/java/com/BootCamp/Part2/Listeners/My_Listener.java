 package com.BootCamp.Part2.Listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BootCamp.Part2.Utility.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class My_Listener implements ITestListener {

	public ExtentReports extent;
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println(" ----The Project Execution Started");
		try {
		 extent =ExtentReporter.createExtentReborter();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getName();
	    test = extent.createTest(testname);
	    test.log(Status.INFO, testname + "--> Started Execution");
	    System.out.println("Test started: " + testname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname = result.getName();
		 test.log(Status.PASS, testname + "-->  Test case Pass");
		 System.out.println("Test successful: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destanationFile = System.getProperty("user.dir") + "\\test-output\\ScreenShotBootCamp" + testname + "png";
		
		try {
			FileHandler.copy(Source, new File(destanationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromBase64String(destanationFile);
		System.out.println("Test failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	String testname = result.getName();
	test.log(Status.SKIP, testname + "-->  Test case Skipped");
	 System.out.println("Test skipped: " + result.getName());
	 
	
	}

	
	@Override
	public void onFinish(ITestContext context) {
	extent.flush();
	}

}
