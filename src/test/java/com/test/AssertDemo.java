package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {
	
  @Test
  public void testAssert() {
	  String str1=new String("Vignesh");
	  String str2=new String("Vignesh");
	  
	  String str3="Tanush";
	  String str4="Vetri";
	  
	  int a=5;
	  int b=6;
	  
	  
	  
	  Assert.assertEquals(str1,str2);
	  
	  Assert.assertSame(str1,str2);
	  
	  Assert.assertNotEquals(str1,str2,"Equals");
	  
	  Assert.assertTrue(a>b,"B is greater");
  }
}
