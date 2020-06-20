package com.ListenersEx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnEx {

	
	@Test(dependsOnMethods= {"Tesstcase2"}, alwaysRun=true)
	  public void Tesstcase1() {
		  System.out.println("Tesstcase1");
		  

	  }
	  @Test(groups= {"smoke","end2end","regression"})
	  public void Tesstcase2() {
		  System.out.println("Tesstcase2");
		  Assert.assertEquals(1, 2);
	  }}

	  /*@Test(groups= {"regression"})
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
}*/
