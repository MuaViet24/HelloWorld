package com.Selenium;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Practise5 {
	
	static ExtentReports extent;
	static ExtentTest extentTest;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(projectPath+"\\Report\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extentTest = extent.createTest("Practise5");
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		extentReport(driver, projectPath, "INFO", "URL launched");
		if(driver.getTitle().contains("Google")){
			extentReport(driver, projectPath, "PASS", "URL launched succesfully");
		}
		else{
			extentReport(driver, projectPath, "FAIL", "URL Not launched ");
		}
		
		driver.findElement(By.name("q")).sendKeys("JAVA");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		if(driver.getTitle().contains("JAVA")){
			extentReport(driver, projectPath, "PASS", "Search Success");
		}
		else{
			extentReport(driver, projectPath, "FAIL", "Search Failed");
			
		}
		//flag = true;
		extentReport(driver, projectPath, "INFO", "Test Completed");
		extent.flush();
		driver.quit();
		

	}
	
	public static String takeScreenshot(WebDriver driver, String projectPath) throws IOException{
		
		String destinationFile = projectPath + "\\Screenshots\\ss"+System.currentTimeMillis()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
		
	}
	
	public static void extentReport(WebDriver driver,String projectPath, String status, String message) throws IOException{
		
		
		switch (status) {
		case "INFO":
			extentTest.log(Status.INFO, message);
			break;

		case "PASS":
			extentTest.log(Status.PASS, message, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, projectPath)).build());
			break;
		case "FAIL":
			extentTest.log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver, projectPath)).build());
			break;
		}
		
		
	}

}
