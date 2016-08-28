package com.gspann;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipcartLogin {
	
	WebDriver driver;
	
	FlipcartLogin(WebDriver d)
	{
		driver=d;
	}
	
	private By loginLoc=By.xpath("//a[contains(text(),'Log In')]");
	private By emailLoc=By.xpath("//input[@class='_2zrpKA']");
	private By passwordLoc=By.xpath("//input[@class='_2zrpKA _3v41xv']");
	private By submitLoc=By.xpath("//div[@class='Km0IJL col col-3-5']/div/form/div[3]/button");
	
	public void logindetails(String uname, String pwd)
	{
		WebElement login=driver.findElement(loginLoc);
		login.click();
		WebElement email=driver.findElement(emailLoc);
		email.sendKeys(uname);
		WebElement password=driver.findElement(passwordLoc);
		password.sendKeys(pwd);
		WebElement submit=driver.findElement(submitLoc);
		submit.click();

	}
	

}
