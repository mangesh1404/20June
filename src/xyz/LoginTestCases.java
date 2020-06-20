package xyz;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginTestCases {
	@Test(dataProvider = "loginData")
	public void loginTestCases(String tcId, String testDesc, String un, String pw, String expMessage) {
		System.out.println("starting a  >>> " + testDesc + "having Id  >> " + tcId);
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		if (!testDesc.equals("valid")) {
			String actualError = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
			String expMessage1 = expMessage;
			Assert.assertEquals(actualError, expMessage1);
		} else {
			String actTitle = driver.getTitle();
			String expTitle = expMessage;
			Assert.assertEquals(actTitle, expTitle);
		}
		driver.close();
	}

	@DataProvider
	public Object[][] loginData() {
		return new Object[][] { 
				new Object[] { "TC01", "Blank", "", "", "blank not allowed.s" },
				new Object[] { "TC01", "invalid", "dggd", "dhd", "blank not allowed.s" },
				new Object[] { "TC01", "spChars", "^$^$&", "&*(*((", "spchars not allowed.s" },
				new Object[] { "TC01", "valid", "kiran@gmail.com", "123456", "DashBooard" }, };
	}
}
