package com.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		System.out.println("Title of the window : --->:"+driver.getTitle());
		System.out.println("Current URL of the browser : --->:"+driver.getCurrentUrl());
		System.out.println("After printing the URL closing the browser");
		driver.quit();
		

	}

}
