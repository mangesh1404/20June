package com.DatsProviderEx;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class LoginData1 {
	
public static WebDriver driver;
	@BeforeSuite
	public static void Browser() {
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		}
	// code for login
  @Test(dataProvider = "logindata")
  public void labelUnameError_page(String tcId, String tcDescr, String uname, String password, String expMessage) {
		System.out.println("testcase Id >> " + tcId);
		System.out.println("testcase Info >> " + tcDescr);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		if (!tcDescr.equals("Valid")) {
			String actualError = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
			Assert.assertEquals(actualError, expMessage);
		}else{
			Assert.assertEquals(driver.getTitle(), expMessage);
		}}
  // code for excel sheet read
	@DataProvider
	public Object[][] logindata() throws Exception{
		  {
			  FileInputStream fis = new FileInputStream("D:\\login.xlsx");
				Workbook wb = Workbook.getWorkbook(fis);
				Sheet sh = wb.getSheet("m");
				int rows = sh.getRows();
				int col = sh.getColumns();
				System.out.println(rows+" "+col);
				Object data[][] = new Object[rows-1][col];
				for (int i= 1 ; i < rows; i++) {

					for (int j=0; j < col; j++) {
						data[i-1][j] = sh.getCell(j, i).getContents();
					}}
				return data;
}}}
