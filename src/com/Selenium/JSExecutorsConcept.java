package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorsConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.get("https://m.spicejet.com/");
		//driver.get("https://www.yatra.com/");
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		
		Thread.sleep(3000);
		//WebElement ele = driver.findElement(By.xpath("//*[text()='Search']"));
		
		//put border on object
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		/*js.executeScript("arguments[0].style.border='3px solid cyan'", ele);
		
		//refresh the page
		//js.executeScript("history.go(0)");
		
		//generate custom alerts
		js.executeScript("alert('Please click on serach button to view flight details')");
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);*/
				
				
		//scroll to the bottom of the page
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
		
		//Scroll to view particular object
		//WebElement ele = driver.findElement(By.xpath("//*[text()='Continue']"));
		//js.executeScript("arguments[0].scrollIntoView(true)", ele);
		
		//get the inner text of the page
		//String pageInnerText = js.executeScript("return document.documentElement.innerText").toString();
		//System.out.println(pageInnerText);
		
		
		//return the document title page
		//String titlePage = js.executeScript("return document.title;").toString();
		//System.out.println(titlePage);
		
		//Enter the date of travel using JS
		//WebElement ele = driver.findElement(By.xpath("//*[@id='BE_flight_origin_date']"));
		//js.executeScript("arguments[0].setAttribute('value','28-09-2019');", ele);
		String val = "07/10/2019";
		//js.executeScript("document.getElementById('datepicker1').value='"+val+"';");
		js.executeScript("document.getElementById('datepicker2').value='"+val+"';");
				
	}

}
