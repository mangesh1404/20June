package com.DatsProviderEx;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class DPExample {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();		
	}
	
  @Test(dataProvider = "login", dataProviderClass=DataproviderEx.class)
  public void f(String uname, String pass, String status) {
	  	WebElement email=driver.findElement(By.id("email"));
	  	email.clear();
	  	email.sendKeys(uname);
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(status);
  }

  
  @AfterTest
	public void teardown() {
		driver.close();
		
	}
  
  
}
