package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightElement {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		WebElement ele = driver.findElement(By.name("submit"));
		String col = ele.getCssValue("backgroundColor");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0;i<10;i++){
			
			js.executeScript("arguments[0].style.backgroundColor='rgb(0,200,0)'", ele);
			js.executeScript("arguments[0].style.backgroundColor='"+col+"'", ele);
		
		}	
		
		
	}

}
