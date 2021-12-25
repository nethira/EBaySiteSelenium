package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.EBaySite;

public class TestBase {
WebDriver driver=null;
EBaySite ebay;
@Parameters({"browser","url"})
@BeforeClass
public void setUp(String browser,String url) throws InterruptedException {

	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	driver.get(url);
	driver.manage().window().maximize();
	ebay=new EBaySite(driver);
	Thread.sleep(5000);
	
}
@AfterClass
public void tearDown() {
	driver.close();
}


}
