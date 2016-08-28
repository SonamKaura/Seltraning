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


public class IrctcFlightPage {

	WebDriver driver;

	IrctcFlightPage(WebDriver d){
		this.driver=d;
	}

	private By flightTicketsLoc = By.xpath("//a[text()='Flight Tickets']");
	private By originLoc = By.xpath("//input[@id='origin']");
	private By autoSuggLoc = By.xpath("//ul[contains(@style,'display: block;')]/li[@class='ui-menu-item']"); 
	private By destinationLoc = By.xpath("//input[@id='destination']");
	private By noOfAdultsDDLoc = By.xpath("//select[@id='noOfAdult']");
	private By travelClassDDLoc=By.xpath("//select[@id='classType']");
	private By airlinesDDLoc=By.xpath("//select[@name='airlinePreference']");
	private By seaachbtn=By.xpath("//div[@id='showdometic']/div[6]");
	private By flightResultlst=By.xpath("//div[@id='flightListResult']/div");
	
	public void switchWindow(){
		String parentwindow=driver.getWindowHandle();
		Set<String>allwin=driver.getWindowHandles();
		for(String eachwindow:allwin)
		{
			if(!eachwindow.equals(parentwindow)){
				driver.switchTo().window(eachwindow);
				break;
			}

		}
		System.out.println("*********** "+driver.getCurrentUrl());
		System.out.println("*********** "+driver.getTitle());

	}
	
	public void enterFlightDetails(String origin,String destination,String noOfAdults,String travelclass,String airpref) throws InterruptedException{
		driver.findElement(originLoc).sendKeys(origin);
		selectAutoSuggestion();
		driver.findElement(destinationLoc).sendKeys(destination);
		selectAutoSuggestion();
		Select adultsDD=new Select(driver.findElement(noOfAdultsDDLoc));
		adultsDD.selectByVisibleText(noOfAdults);		
		Select travelClassDD=new Select(driver.findElement(travelClassDDLoc));
		travelClassDD.selectByVisibleText(travelclass);
		Select airlinesDD=new Select(driver.findElement(airlinesDDLoc));
		airlinesDD.selectByVisibleText(airpref);

	}
	
	public void selectAutoSuggestion() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(autoSuggLoc).click();	
	}
	
	public void search()
	{
		driver.findElement(seaachbtn).click();
	
	}
	public int flightCount()
	{
		List <WebElement> flightResult=driver.findElements(flightResultlst);
		int totalcount=flightResult.size();
		System.out.println("size of the List is "+totalcount);
		return totalcount;
	}
	

}
