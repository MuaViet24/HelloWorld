package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGSeleniumTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void getPageTitle(){
		String title = driver.getTitle();
		System.out.println("Title: --->" + title);
		
	}
	
	@Test
	public void logoValidation(){
		
		boolean b = driver.findElement(By.id("hplogo")).isDisplayed();
		System.out.println("Logo validation:---->" + b);
		
	}
	
	@Test
	public void linkValidation(){
		
		boolean b = driver.findElement(By.xpath("//*[@class='gb_d' and text()='Gmail']")).isDisplayed();
		System.out.println("Link Validation:--->" + b);
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
		
	}

}
