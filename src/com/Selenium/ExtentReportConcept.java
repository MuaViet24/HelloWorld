package com.Selenium;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportConcept {

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		//String projectPath = System.getProperty("user.dir");
		ExtentHtmlReporter extentHTMLReporter = new ExtentHtmlReporter("extentReport.html");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentHTMLReporter);
		ExtentTest extentTest = extentReports.createTest("Google Search", "Search JAVA");
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		extentTest.log(Status.INFO, "URL has been launched");
		driver.findElement(By.name("q")).sendKeys("JAVA");
		extentTest.pass("Search has been performed");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);//Press Enter
		extentTest.pass("results are available");
		driver.quit();
		extentTest.log(Status.INFO, "Browser Closed");
		//to put all the logs and info on the HTML report
		extentReports.flush();

	}

}
