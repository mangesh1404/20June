package com.DatsProviderEx;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGDemo {
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}
	
	
	
	@Test(priority=1)
	public void verifyTitle() {
		String title=driver.getTitle();
		Assert.assertEquals("AdminLTE 2 | Log in", title);
			
	}
	@Test(priority=3)
	public void test01() {
		
	WebElement uname=driver.findElement(By.id("email"));
	uname.clear();
	uname.sendKeys("kiran@gmail.com");
	WebElement pass=driver.findElement(By.id("password"));
	pass.clear();
	pass.sendKeys("123456");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
	@Test(priority=2)
	public void test012() {
		
	driver.findElement(By.id("email")).sendKeys("mangesh@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
	
	
}
