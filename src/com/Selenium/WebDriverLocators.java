package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverLocators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*driver.get("https://reg.ebay.com/reg/PartialReg?siteid=0&co_partnerId=0&UsingSSL=1&rv4=1&AppName=LithiumT-7567-42e3-a620-0b7cf8ee50ee&ru=https%3A%2F%2Fauth.ebay.com%2Foauth2%2Fconsents%3Fclient_id%3DLithiumT-7567-42e3-a620-0b7cf8ee50ee%26redirect_uri%3DLithium_Technol-LithiumT-7567-4-khvro%26scope%26state%3Dhttps%253A%252F%252Fcommunity.ebay.com%252Ft5%252FGetting-Started%252FLink-for-half-ebay-com%252Fqaq-p%252F23669336%26response_type%3Dcode%26hd%26consentGiven%3Dfalse&signInUrl=https%3A%2F%2Fwww.ebay.com%2Fsignin%3Fsgn%3Dreg%26siteid%3D0%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1%26AppName%3DLithiumT-7567-42e3-a620-0b7cf8ee50ee%26ru%3Dhttps%253A%252F%252Fauth.ebay.com%252Foauth2%252Fconsents%253Fclient_id%253DLithiumT-7567-42e3-a620-0b7cf8ee50ee%2526redirect_uri%253DLithium_Technol-LithiumT-7567-4-khvro%2526scope%2526state%253Dhttps%25253A%25252F%25252Fcommunity.ebay.com%25252Ft5%25252FGetting-Started%25252FLink-for-half-ebay-com%25252Fqaq-p%25252F23669336%2526response_type%253Dcode%2526hd%2526consentGiven%253Dfalse");
		
		
		driver.manage().window().maximize();
		
		//1.xpath
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Reetu");
		
		//2. id
		driver.findElement(By.id("ppaFormSbtBtn")).click();
		
		//3.name
		driver.findElement(By.name("lastname")).sendKeys("Rajan");
		
		//4.linkText
		driver.findElement(By.linkText("Sign in")).click();
		
		//5.partialLinkText
		driver.findElement(By.partialLinkText("create an")).click();
		
		Thread.sleep(6000);
		//CSSSelector
		driver.findElement(By.cssSelector("#reg_sfk_btn_fb")).click();*/
		
		
		driver.get("https://www.jotform.com/build/91757291900865#preview");
		driver.manage().window().maximize();
		
		Select selCountry = new Select(driver.findElement(By.name("q12_address12[country]")));
		selCountry.selectByVisibleText("India");
		
		
		
		

	}

}
