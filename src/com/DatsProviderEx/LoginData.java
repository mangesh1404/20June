package com.DatsProviderEx;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


public class LoginData {
	public static WebDriver driver;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter = new DataFormatter();
	 // code to open browser
	@BeforeSuite
	public static void Browser() {
		System.setProperty("WebDriver.Chrome.driver", "C:/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
		driver.manage().window().maximize();
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
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		if (!tcDescr.equals("Login_Valid")) {
			String actualError = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
			Assert.assertEquals(actualError, expMessage);
		}else{
			Assert.assertEquals(driver.getTitle(), expMessage);
		}}
	@DataProvider
	public Object[][] logindata() throws Exception{
		    {
		    FileInputStream fis= new FileInputStream("D:\\login.xlsx"); //Excel sheet file location get mentioned here
		        workbook = new XSSFWorkbook (fis); //get my workbook 
		        worksheet=workbook.getSheet("m");// get my sheet from workbook
		        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
		        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		        int ColNum= Row.getLastCellNum(); // get last ColNum 
		        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
		            for(int i=0; i<RowNum-1; i++) { //Loop work for Row              
		                XSSFRow row= worksheet.getRow(i+1);
		                for (int j=0; j<ColNum; j++) { //Loop work for colNum 
		                    if(row==null)
		                        Data[i][j]= " ";
		                    else{
		                        XSSFCell cell= row.getCell(j);
		                        if(cell==null)
		                            Data[i][j]= " "; //if it get Null value it pass no data 
		                        else
		                        {
		                            String value=formatter.formatCellValue(cell);
		                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
		                        }}}   }
		        return Data;
		    }
	
	}
	}
	



	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
 
