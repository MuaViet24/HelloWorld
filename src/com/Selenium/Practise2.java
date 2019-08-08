package com.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise2 {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		/*driver.get("https://www.google.com/");

		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//handles page load time outs
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//handles element load timeout

		//google search based on the dynamic suggestion provided
		driver.findElement(By.name("q")).sendKeys("JAVA");
		List<WebElement> listWebElements = driver.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class='sbl1']"));
		System.out.println("<----: Number of suggestions provided:--->" + listWebElements.size());

		//printing the suggestions provided on console
		for(int i =0;i<listWebElements.size();i++){

			//System.out.println(listWebElements.get(i).getText());

			//search the suggestion javatpoint
			if(listWebElements.get(i).getText().contains("javatpoint")){
				listWebElements.get(i).click();	
				break;

			}
		}*/
		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");

		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//handles page load time outs
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//handles element load timeout

		//handling webtables having 2 columns with following-siblings concept
		
		//XPath of the Rows
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td[1]
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[1]/font
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[5]/td[1]/font
		
		
		//XPath of the Columns
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/div/font/b
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/div/font/b
		
		//Sibling td sample xpath
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td[1]/following-sibling::td
		
		/*String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[";
		String afterXPath = "]/td[1]";
		String amtXPath = "/following-sibling::td";
		
		for(int i= 1; i<6;i++){
			String locVal = driver.findElement(By.xpath(beforeXPath+i+afterXPath)).getText();
			String amtVal = driver.findElement(By.xpath(beforeXPath+i+afterXPath+amtXPath)).getText();
			System.out.println(locVal +"<<>>"+amtVal);
		}*/
		
		//handling webtables having 4 columns with following-siblings concept
		
		//XPath for Cruise table
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[4]/td[1]
		
		
		//Sibling td sample xpath
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[4]/td[1]/following-sibling::td/following-sibling::td
		
		driver.findElement(By.linkText("Cruises")).click();
		
		String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[";
		String afterXPath = "]/td[1]";
		String remainingXPath = "/following-sibling::td";
		
		for(int i= 4; i<12;i++){
			String dayVal = driver.findElement(By.xpath(beforeXPath+i+afterXPath)).getText();
			String portVal = driver.findElement(By.xpath(beforeXPath+i+afterXPath+remainingXPath)).getText();
			String arrivalVal = driver.findElement(By.xpath(beforeXPath+i+afterXPath+remainingXPath+remainingXPath)).getText();
			String departureVal = driver.findElement(By.xpath(beforeXPath+i+afterXPath+remainingXPath+remainingXPath+remainingXPath)).getText();
			System.out.println(dayVal +"  <<>>  "+portVal+"  <<>>  "+arrivalVal+"  <<>>  "+departureVal);
		
			//System.out.println(dayVal);
		}
	
	}

}
