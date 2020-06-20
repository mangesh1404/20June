package xyz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {

	@Test
	public void checkMessage() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualError = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
		String expMessage = "Email is required ";
		Assert.assertEquals(actualError, expMessage);
		driver.close();
	}

	@Test
	public void checkMessageInvalid() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("sadsda");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("adasdasd");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualError = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
		String expMessage = "blnk not is required ";
		Assert.assertEquals(actualError, expMessage);
		driver.close();
	}

	@Test
	public void checkMessageSpChars() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("&^*#^*%^*");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("#%&%*^#*");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualError = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
		String expMessage = "sp charss is required ";
		Assert.assertEquals(actualError, expMessage);
		driver.close();
	}

	@Test
	public void checkMessageValid() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actTitle = driver.getTitle();
		String expTitle = "DashBooard";
		 Assert.assertEquals(actTitle, expTitle);
		/*
		 * String actualError =
		 * driver.findElement(By.xpath("//div[@id='email_error']")).getText(); String
		 * expMessage = "Email is required "; Assert.assertEquals(actualError,
		 * expMessage);
		 */
		driver.close();
	}
}
