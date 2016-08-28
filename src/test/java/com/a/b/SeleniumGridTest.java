package com.a.b;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridTest {
 WebDriver driver;


 @Test
 public void t1() throws Exception{
	 
  DesiredCapabilities cap = new DesiredCapabilities();
  

  cap.setBrowserName(BrowserType.CHROME);
 

  cap.setVersion("52.0");
  cap.setPlatform(Platform.WINDOWS);
  //WebDriver driver = new ChromeDriver();
  WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap); // Here we pass Url of the hub and capabilities in the constructor
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("https://www.flipkart.com/#");

 }
}