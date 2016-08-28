package com.gspann;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipcartTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void startup(String browser)
	{

		if(browser.equalsIgnoreCase("firefox"))
		{

			driver=new FirefoxDriver();

		}
		else{
			System.setProperty("webdriver.chrome.driver","D://IMPTASPECTS//Selenium Learning//chromedriver_win32//chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}


	@Test
	public void flipDetails() throws InterruptedException, FileNotFoundException
	{
		FlipcartLogin login=new FlipcartLogin(driver);
		FlipcartExcel read=new FlipcartExcel();
		
		String[][] obj2=(String[][])read.myDP();//we have done downcasting from Object(big) to String(small)
		login.logindetails(obj2[0][0],obj2[0][1]);
		//login.logindetails(obj2[1][0],obj2[1][1]);
		
		Thread.sleep(2000);
		FlipcartScenarios scenario= new FlipcartScenarios(driver);
		scenario.search();
		System.out.println("Search done");
		Thread.sleep(4000);
		scenario.random();
		Thread.sleep(4000);
		String textremoved=scenario.checkout();
		System.out.println("hello");
		Assert.assertEquals(textremoved, "The item Arrow Sport Slim Fit Men's Beige Trousers has been deleted from your cart");
		//Assert.assertEquals(check, "message not matching");
	}
}


