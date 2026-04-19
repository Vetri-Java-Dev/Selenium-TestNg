package com.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	  WebDriver driver;
	
	  @Test
	  public void validLoginTest() {
		  driver.findElement(By.id("login2")).click();
		  
		  //providing credentials for valid 
		  driver.findElement(By.id("loginusername")).sendKeys("vetri1734");
		  driver.findElement(By.id("loginpassword")).sendKeys("1234");
		  
		  driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
		  
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		  
		  String actual=driver.findElement(By.id("nameofuser")).getText();
		 
		  SoftAssert softAssert=new SoftAssert();
		  softAssert.assertTrue((!actual.contains("Welcome")));
		  
		  softAssert.assertAll();
	  }
	  
	  @Test
	  public void invalidUserName() {
		  driver.findElement(By.id("login2")).click();
		  
		  //providing credentials for invalid 
		  driver.findElement(By.id("loginusername")).sendKeys("vetri173");
		  driver.findElement(By.id("loginpassword")).sendKeys("1234");
		  
		  driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
		  
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		  
		  wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  
		  String expected="User does not exist.";
		  
		  SoftAssert softAssert=new SoftAssert();
		  
		  softAssert.assertNotEquals(alert.getText(), expected);
		  alert.accept();
		  
		  softAssert.assertAll();
		  
	  }
	  
	  @Test
	  public void invalidPassword() {
		  driver.findElement(By.id("login2")).click();
		  
		  //providing credentials for invalid 
		  driver.findElement(By.id("loginusername")).sendKeys("vetri1734");
		  driver.findElement(By.id("loginpassword")).sendKeys("123");
		  
		  driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
		  
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		  
		  wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert=driver.switchTo().alert();
		  
		  String expected="Wrong password.";
		  
		  Assert.assertEquals(alert.getText(), expected);
		  alert.accept();
		  
	  }
	  
	  @BeforeMethod(alwaysRun = true)
	  public void beforeTest() {
		  ChromeOptions options=new ChromeOptions();
		  
		  options.addArguments("--start-maximized");
		  //options.addArguments("--headless");
		  
		  driver=new ChromeDriver(options);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  
		  driver.get("https://www.demoblaze.com/");
	  }
	  
	  @AfterMethod(alwaysRun = true)
	  public void afterTest() {
		  driver.quit();
	  }
	  
}
