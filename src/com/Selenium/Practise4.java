package com.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise4 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/WebTable.html");
		
		//xpath of the elements in the Webtable
		//*[@id="1562659590018-0-uiGrid-0005-cell"]/div
		//*[@id="1562659590018-0-uiGrid-0006-cell"]/div
		//*[@id="1562659590018-0-uiGrid-0009-cell"]/div
		
		//===========================================
		
		//*[@id="1562659590018-1-uiGrid-0005-cell"]/div
		//*[@id="1562659590018-1-uiGrid-0009-cell"]/div
		
		
		String beforeXPath = "//*[@id='1562659590018-";
		String midXPath = "-uiGrid-000";
		String afterXPath = "-cell']/div";
		
		
		//*[@id="1562662529704-0-uiGrid-0005-cell"]/div
		//*[@id="1562662166354-0-uiGrid-0005-cell"]/div
		
		//List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'ui-grid-cell-contents')]"));
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'1562')]//div"));
		
		System.out.println(list.size());
		
		for(int i =0;i<list.size();i++){
			
			System.out.println(list.get(i).getText());
		}
		
		
	}

}
