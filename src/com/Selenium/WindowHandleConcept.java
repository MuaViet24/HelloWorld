package com.Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowHandleConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/popup.php");
		String parentWindowTitle = driver.getTitle();
		String parentWindowURL = driver.getCurrentUrl();
		
		//Print the title of the Parent window
		System.out.println("The title of the Parent window: " + parentWindowTitle);
		System.out.println("The URL of the Parent window: " + parentWindowURL);

		
		//Click on link- Click Here
		driver.findElement(By.linkText("Click Here")).click();
		
		//get the window handles
		Set<String> windowHandles = driver.getWindowHandles();
		
		//create the object of the iterator 
		Iterator<String> it = windowHandles.iterator();
		
		//point the iterator object to the 1st string present in the Set
		String parentWindowID=it.next();
		
		//print the parent window handle id
		System.out.println("Parent window ID: " + parentWindowID);
		
		String childWindowId = it.next();
		
		//print the child window handle id
		System.out.println("Child Window ID: " + childWindowId);
		
		//Switch to child window
		driver.switchTo().window(childWindowId);
		
		//Print the title of the child window
		System.out.println("The title of the Child window: " + driver.getTitle());
		System.out.println("The URL of the child window: " + driver.getCurrentUrl()); 
		
		//Enter the email id
		driver.findElement(By.name("emailid")).sendKeys("test@gmail.com");
		
		//Click Submit
		driver.findElement(By.name("btnLogin")).click();
		
		
		//Print the title of the child window
		System.out.println("The title of the Child window: " + driver.getTitle());
		System.out.println("The URL of the child window: " + driver.getCurrentUrl());

		//XPAth of the table:
		//html/body/table/tbody/tr[4]/td[1]
		//html/body/table/tbody/tr[5]/td[1]
		
		String beforeXPath = "/html/body/table/tbody/tr[";
		String afterXPath = "]/td[1]";
		String valueXPath = "/following-sibling::td";
		
		//Print the access details of the demo site
		System.out.println("<----: Access details of Demo Site:----->");
		for(int i=4;i<6;i++){
			
			String keyData = driver.findElement(By.xpath(beforeXPath+i+afterXPath)).getText();
			String valData = driver.findElement(By.xpath(beforeXPath+i +afterXPath+valueXPath)).getText();
			System.out.println(keyData +" : "+valData);
		}
		
		//Click on link- Click Here
		driver.findElement(By.linkText("Click Here")).click();
		
		//Print the title of the child window
		String childWindowURL = driver.getCurrentUrl();
		System.out.println("The title of the child window: " + driver.getTitle());
		System.out.println("The URL of the child window: " + childWindowURL);
				

		//Close the browser
		if(childWindowURL.equals(parentWindowURL)){
			System.out.println("The URL of the Parent and Child Window are same. Child browser can be closed");
			driver.close();
		}
		else{
			System.out.println("THE URL of the parent and Child Window are different.");
		}
		
		
		//switch the handle to parent window
		driver.switchTo().window(parentWindowID);
		
		//Print the title of the Parent window
		System.out.println("Welcome to the Parent Window");

		
	}

}
