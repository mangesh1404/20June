package com.ListenersEx;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
// Depends On Method Example
@Listeners(com.ListenersEx.ListenerTest1.class)
class LoginTestCases1 {
	public static WebDriver driver;

  @BeforeSuite
  public static WebDriver setup_Browser() {
	  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// cookies delete
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		return driver;

	}
 @Test(priority= 1)
 public static void  verify_url() {
	 String myurl = driver.getCurrentUrl();
	 System.out.println("current url is "+myurl);
	 String Exp_url= "file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html";
	 Assert.assertEquals(myurl, Exp_url);
	  }
 @Test(priority= 2, dependsOnMethods= {"verify_url"})
 public static void verify_title() {
	 String title= driver.getTitle();
	 System.out.println("title is "+title);
	 String Exptitle= "AdminLTE 2 | Log in";
	 Assert.assertEquals(title,Exptitle);
 }
 
 @Test(priority= 3,dependsOnMethods= {"verify_title"})
 public static void verify_Logo() {
	 String T = driver.findElement(By.xpath("html/body/div[1]/div[1]/a")).getText();
	 String w= "AdminLTE";
	 Assert.assertEquals(T, w);
	 
 }
 @Test(priority= 4)
 @RetryCountIfFailed(3)
 public void BlankLogin() {
	 driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();
	 String Actmsg = driver.findElement(By.xpath(".//*[@id='email_error']")).getText();
	 String Exmsg = "Please enter email.";
	 Assert.assertEquals(Actmsg, "ghjgkj");
 }
 
 
 @Test(priority= 5,dependsOnMethods= {"verify_title"})
 public void InvalidLogin() {
	 driver.findElement(By.id("email")).clear();
	 driver.findElement(By.id("email")).sendKeys("kiran@.com");
	 driver.findElement(By.id("password")).clear();
	 driver.findElement(By.id("password")).sendKeys("123");
	 driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();
     String Actmsg= driver.findElement(By.xpath(".//*[@id='email_error']")).getText();
     String msg = "Please enter email as kiran@gmail.com";
     Assert.assertEquals(Actmsg, msg);
 } 
 @Test(priority=6,dependsOnMethods= {"verify_title"})
 public void ValidLogin() {
	 driver.findElement(By.id("email")).clear();
	 driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	 driver.findElement(By.id("password")).clear();
	 driver.findElement(By.id("password")).sendKeys("123456");
	 driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();
     String Actmsg= driver.findElement(By.xpath("html/body/div[1]/div[1]/section[1]/h1/small")).getText();
     String msg = "Control panel";  
     Assert.assertEquals(Actmsg, msg);
 }
 
 
 
 
 
}
