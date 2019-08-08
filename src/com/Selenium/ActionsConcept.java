package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsConcept {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); //Maximize the browser
		driver.manage().deleteAllCookies(); //Delete browser cookies

		/*driver.get("https://www.spicejet.com/");

		//Dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//30 seconds wait for page load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 30 seconds wait for element load


		//Hover an element
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform(); //Hover over Login/Sign Up Web element
		actions.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();//Hover over Spice  Club Members Elements
		driver.findElement(By.linkText("Sign up")).click(); //Click on Sign Up Link
		 */		

		
		/*//Drag and drop element
		driver.get("https://www.elated.com/res/File/articles/development/javascript/jquery/drag-and-drop-with-jquery-your-essential-guide/card-game.html");

		//Dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//30 seconds wait for page load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 30 seconds wait for element load
		String sourceCard ="";
		String tragetCard ="";
		System.out.println("<---: Drag and Drop Card Game:---->");
		switch (10) {
		case 1:
			sourceCard ="card1";
			tragetCard ="one";
			break;
		case 2:
			sourceCard ="card2";
			tragetCard ="two";
			break;
		case 3:
			sourceCard ="card3";
			tragetCard ="three";
			break;
		case 4:
			sourceCard ="card4";
			tragetCard ="four";
			break;
		case 5:
			sourceCard ="card5";
			tragetCard ="five";
			break;
		case 6:
			sourceCard ="card6";
			tragetCard ="six";
			break;
		case 7:
			sourceCard ="card7";
			tragetCard ="seven";
			break;
		case 8:
			sourceCard ="card8";
			tragetCard ="eight";
			break;
		case 9:
			sourceCard ="card9";
			tragetCard ="nine";
			break;
		case 10:
			sourceCard ="card10";
			tragetCard ="ten";
			break;
		default:
			break;
		}
		
		WebElement sourceElement = driver.findElement(By.id(sourceCard));
		WebElement TargetElement = driver.findElement(By.xpath("//*[text()='"+tragetCard+"']"));
		//Drag and drop element
		Actions actions = new Actions(driver);
		
		actions.clickAndHold(sourceElement).moveToElement(TargetElement).release().build().perform();
*/
		
		//Right Click an Element
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		//Dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//30 seconds wait for page load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 30 seconds wait for element load

		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElement(By.xpath("//*[text()='right click me']"))).build().perform();
		
		driver.findElement(By.xpath("//*[text()='Copy']")).click();
		driver.switchTo().alert().accept();
		
		
		//Double Click an element
		Thread.sleep(3000);
		actions.doubleClick(driver.findElement(By.xpath("//*[text()='Double-Click Me To See Alert']"))).build().perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
	}

}
