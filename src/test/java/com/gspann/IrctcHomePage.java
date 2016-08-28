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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class IrctcHomePage {
	
	WebDriver driver;
	
	IrctcHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	private By flightTicketsLoc = By.xpath("//a[text()='Flight Tickets']");
	
	
	public void clickFlightTickets(){
		driver.findElement(flightTicketsLoc).click();
	}

}
