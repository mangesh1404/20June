package com.DatsProviderEx;

import org.testng.annotations.DataProvider;

public class DataproviderEx {

	@DataProvider(name ="login")
	  public Object[][] getdata() {
	    return new Object[][] {
				new Object[] { "mangesh@gmail.com", "123458", "invalid" },//invalid
				new Object[] { "a!@#$%", ")(*&^:", "invalid" },//spc chars
				new Object[] { "           ", "   ", "invalid" },//blank
				new Object[] { "ram@gmail.com", "1234", "invalid" },
				new Object[] { "nilam@gmail.com", "1458", "invalid" },
				new Object[] { "mangesh@gmail.com", "12358", "invalid" },
				new Object[] { "xyz@gmail.com", "1234534", "invalid" },
				new Object[] { "kiran@gmail.com", "123456", "valid" },
	    };
	  }
	
	
	
}
