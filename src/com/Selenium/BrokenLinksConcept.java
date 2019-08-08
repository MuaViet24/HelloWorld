package com.Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksConcept {

	public static void main(String[] args) throws MalformedURLException, IOException {


		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("links on page---->>>" + linksList.size());
		
		List<WebElement> activeLinkList = new ArrayList<WebElement>();
		
		//Finding the list of active links from the available links
		for(int i =0;i<linksList.size();i++){
			if(linksList.get(i).getAttribute("href")!= null && linksList.get(i).getAttribute("href").contains("https://")){
				System.out.println(linksList.get(i).getAttribute("href"));
				activeLinkList.add(linksList.get(i));
				
			}
			
		}
		System.out.println("Active link from existing links---->>" + activeLinkList.size());
		
		//Finding if the active links are broken or not
		for(int j=0;j<activeLinkList.size();j++){
			
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinkList.get(j).getAttribute("href")).openConnection();
			connection.connect();//connecting to URL via HttpURLConnection
			String responseMsg = connection.getResponseMessage();
			connection.disconnect();//disconnecting the connection to URL
			System.out.println(activeLinkList.get(j).getAttribute("href") +"  ---->>>---- "+ responseMsg);
			
		}

	}

}
