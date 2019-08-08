package com.Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPopUpHandle {
		
	static int i =0;
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		//Take screenshot of the page
		//captureScreenshots(driver);
		
		//Click on Submit button
		driver.findElement(By.name("submit")).click();
		
		//Take screenshot of the page
		//captureScreenshots(driver);
		
		Alert alertReview = driver.switchTo().alert();
		
		//print the message on the alert
		System.out.println(alertReview.getText());
		
				
		//Click on OK
		alertReview.accept();
		
		//Take screenshot of the page
		//captureScreenshots(driver);
		
		driver.switchTo().alert().accept();
		
		//Take screenshot of the page
		//captureScreenshots(driver);//----screen shots not captured when alert open
	}
	
	public static void captureScreenshots(WebDriver driver) throws IOException{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Stuff\\Reetu\\WorkSpace\\HelloWorld\\Screenshots\\s"+i++ +".png"));
		
	}

}
