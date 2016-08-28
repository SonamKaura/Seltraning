package com.gspann;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipcartScenarios {

	WebDriver driver;

	FlipcartScenarios(WebDriver d)
	{
		this .driver=d;
	}

	private By searchLoc=By.xpath("//input[@class='LM6RPg']");
	private By submitLOc=By.xpath("//button[@type='submit']");
	private By productsLoc=By.xpath("//div[@class='_2xw3j-']/div[3]/div[1]/div");
	private By sizeLoc=By.xpath("//ul[@class='eaKBCI']/li[1]/a");
	private By buyLoc=By.xpath("//button[@type='button']");
	private By deliverLoc=By.xpath("//div[@class='carousel-inner']/div/div[1]/a/p[4]");
	private By cartLoc=By.xpath("//button[@class='_3zLR9i _3Plo8Q _19RW-r']");
	private By gotocartLoc=By.xpath("//div[@class='_2BPjzq']/button");
	private By removeitemLoc=By.xpath("//a[@title='Remove Item']");
	private By messageLoc=By.xpath("//div[@class='cart-activity info fk-alert-user fk-text-center bmargin10 to-fade']");

			public void search () throws InterruptedException
	{
		WebElement search=driver.findElement(searchLoc);
		search.sendKeys("levis");
		WebElement submit=driver.findElement(submitLOc);
		submit.click();
		System.out.println("Submit done");
		Thread.sleep(10000);	
	}

	public void random()
	{
		//Clicking on random product
		List <WebElement> products = driver.findElements(productsLoc);
		int size=products.size();
		System.out.println("Size is "+size);
		Random r = new Random();
		int randomValue=r.nextInt(size);
		System.out.println("Random Value"+randomValue);
		products.get(randomValue).click(); 
		System.out.println("product is clicked");

	}
	
	public String checkout() throws InterruptedException
	{
		System.out.println("Inside checkout");
		WebElement size=driver.findElement(sizeLoc);
		System.out.println("size checkout");
		if(!size.isDisplayed())
		{
			System.out.println("size displayed ");
			WebElement cart=driver.findElement(cartLoc);
			cart.click();
			WebElement removeitem=driver.findElement(removeitemLoc);
			removeitem.click();
			WebElement message=driver.findElement(messageLoc);
			String text=message.getText();
			System.out.println("Message after removing is:"+text);
			return text;
		}
		size.click();
		System.out.println("size is clicked");
		WebElement cart=driver.findElement(cartLoc);
		cart.click();
		System.out.println("cart is clicked");
		WebElement gotocart=driver.findElement(gotocartLoc);
		gotocart.click();
		System.out.println("Goto cart clicked");
		WebElement removeitem=driver.findElement(removeitemLoc);
		removeitem.click();
		System.out.println("remove is clicked");
		Thread.sleep(3000);
		WebElement message=driver.findElement(messageLoc);
		String removedtext=message.getText();
		System.out.println("Message after removing"+removedtext);
		return removedtext;
		//Assert.assertTrue(text.equals(arg0), message);
	}

}
