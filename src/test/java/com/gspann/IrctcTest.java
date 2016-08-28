package com.gspann;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IrctcTest {

	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws InterruptedException
	{
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else
		{                                                                                                                                                                            
			System.setProperty("webdriver.chrome.driver",
					"D://IMPTASPECTS//Selenium Learning//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.irctc.co.in/");
		Thread.sleep(2000);
		
	}

	@Parameters({"Originname", "Destinationname"})
	@Test
	public void testDomesticTravel(String Oname, String Dname) throws InterruptedException{
		IrctcHomePage homePage=new IrctcHomePage(driver);
		homePage.clickFlightTickets();
		IrctcFlightPage flightPage = new IrctcFlightPage(driver);
		flightPage.switchWindow();
		flightPage.enterFlightDetails(Oname, Dname, "2", "Economy", "All");
		flightPage.search();
		int count = flightPage.flightCount();
		Assert.assertEquals(count, "69","Mismatch");
		//Assert.assertTrue(flightResult.equals(totalcount), "Mismatch" );

	}
}
