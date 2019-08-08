package com.Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropFileHAndleConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fip = new FileInputStream("C:\\Stuff\\Reetu\\WorkSpace\\HelloWorld\\src\\com\\Selenium\\config.properties");
		prop.load(fip);
		
		String browser = prop.getProperty("browser");
		
		if(browser.contains("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		

	}

}
