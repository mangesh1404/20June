package com.ListenersEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.testng.Assert;

public class CaptureTest {
	
	static WebDriver d;
  @Test
  public void capturescreenshot() {
	  d= new FirefoxDriver();
	  d.get("file:///D:/Java%20study/Selenium%20Software/Offline%20Website/index.html");
	  String title =d.getTitle();
	  Assert.assertEquals("facebook", title);
  }
}
