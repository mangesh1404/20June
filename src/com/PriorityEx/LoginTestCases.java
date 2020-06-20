package com.PriorityEx;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
@SuppressWarnings("unused")
public class LoginTestCases {
	
  @Test(groups= {"smoke","regression"})
  public void Tesstcase1() {
	  System.out.println("Tesstcase1");

  }
  @Test(groups= {"smoke","end2end","regression"})
  public void Tesstcase2() {
	  System.out.println("Tesstcase2");
	  Assert.assertEquals(2, 3);
  }

  @Test(groups= {"regression"})
  public void Tesstcase3() {
	  System.out.println("Tesstcase3");
  }

  @Test(groups= {"end2end"})
  public void Tesstcase4() {
	  System.out.println("Tesstcase4");
  }

  @Test(groups= {"end2end","regression"})
  public void Tesstcase5() {
	  System.out.println("Tesstcase5");
  }

  @Test(groups= {"smoke"})
  public void Tesstcase6() {
	  System.out.println("Tesstcase6");
  }

}
