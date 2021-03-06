package com.DatsProviderEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DaataProvider {
	static WebDriver driver;
	
	@BeforeSuite
	public static void Browser() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
		}

	 @Test(dataProvider = "logindata")
	  public void labelUnameError_page(String tcId, String tcDescr, String uname, String password, String expMessage) {
			System.out.println("testcase Id >> " + tcId);
			System.out.println("testcase Info >> " + tcDescr);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(uname);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			if (!tcDescr.equals("Login_Valid")) {
				String actualError = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
				Assert.assertEquals(actualError, expMessage);
			}else{
				Assert.assertEquals(driver.getTitle(), expMessage);
			}}
	
	 /*@DataProvider
		public Object[][] logindata() throws Exception{
		 
		 data[][]= 
		 
	 }
*/	
}
