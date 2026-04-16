package com.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	  WebDriver driver;
	  
	  @Test
	  public void login() {
		  driver.findElement(By.id("login2")).click();
		  
		  //providing credentials
		  driver.findElement(By.id("loginusername")).sendKeys("vetri1734");
		  driver.findElement(By.id("loginpassword")).sendKeys("1234");
		  
		  driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  ChromeOptions options=new ChromeOptions();
		  
		  options.addArguments("--start-maximized");
		  //options.addArguments("--headless");
		  
		  driver=new ChromeDriver(options);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  
		  driver.get("https://www.demoblaze.com/");
	  }
	
	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
	  
}
