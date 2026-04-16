package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Tests {
	
  @Test(priority=3)
  public void b() {
	System.out.println("B");  
  }
  
  @Test(priority=2)
  public void a() {
	  System.out.println("A");
  }
  
  @Test(priority=1)
  public void c() {
	  System.out.println("C");
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
