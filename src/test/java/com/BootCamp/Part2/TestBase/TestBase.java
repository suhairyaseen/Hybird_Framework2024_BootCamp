package com.BootCamp.Part2.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.BootCamp.Part2.Utility.Utility;


public class TestBase {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	public Properties propdata;
	public FileInputStream ip1;
	public ChromeOptions option;
	
	public TestBase() throws Exception  {
	prop = new Properties();
	 ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\BootCamp\\Part2\\Config\\config.properties");
	 prop.load(ip);
	 
	 
	 propdata = new Properties();
	 ip1 = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\java\\com\\BootCamp\\Part2\\TestData\\TestData.properties");
	 propdata.load(ip1);
	}
   public WebDriver intializeBrowers(String namebrowser) {
	if(namebrowser.equals("chrome")) {
	 option = new ChromeOptions();
	 option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	 option.addArguments("--start-maximized");	
	 driver = new ChromeDriver(option);
	}
	else {
		System.out.println("There is no match to the namebrowser");
	}
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.implicitly_TimeOut));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.setPageLoad_TimeOut));
	 driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utility.script_TimeOut));
	 driver.get(prop.getProperty("url"));
	 return driver;
}
    
}
