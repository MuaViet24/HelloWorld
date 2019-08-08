package com.TestNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNGExtentReport {
	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest extentTest;
	static String projectPath = System.getProperty("user.dir")	;
	
	@BeforeTest
	public static void extentSetUp(){
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(".\\Report\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extentTest = extent.createTest("TestNG Practise Extent");
				
	}
	
	@BeforeMethod
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		extentTest.log(Status.INFO, "Browser launch successful");
		
	}
	
	@Test
	public static void performGoogleSearch() throws IOException{
		
		if(driver.getTitle().contains("Google")){
			extentTest.log(Status.PASS, "URL launched successfully", MediaEntityBuilder.createScreenCaptureFromPath(TestNGExtentReport.takeScreenshot()).build());
		}
		else{
			extentTest.log(Status.FAIL, "URL Not launched ", MediaEntityBuilder.createScreenCaptureFromPath(TestNGExtentReport.takeScreenshot()).build());
			
		}
		driver.findElement(By.name("q")).sendKeys("JAVA");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		if(driver.getTitle().contains("JAVA")){
			extentTest.log(Status.PASS, "Search successful", MediaEntityBuilder.createScreenCaptureFromPath(TestNGExtentReport.takeScreenshot()).build());
			
		}
		else{
			extentTest.log(Status.FAIL, "Search failed", MediaEntityBuilder.createScreenCaptureFromPath(TestNGExtentReport.takeScreenshot()).build());
		}
	}
	
	@AfterMethod
	public static void tearDown(){
		driver.quit();
	}
	
	@AfterTest
	public static void extentClose(){
		extentTest.log(Status.INFO, "Test Completed");
		extent.flush();
	}
	
	public static String takeScreenshot() throws IOException{
		String destinationFile = projectPath + "\\Screenshots\\ss" +System.currentTimeMillis()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}

}
