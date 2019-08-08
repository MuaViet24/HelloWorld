package com.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practise3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Davi");//Enter First NAme
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("S");//Enter Last NAme
		driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys("Lane 12, ABC Street");//Enter Address
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("devi.s@gmail.com");//Enter Email
		driver.findElement(By.xpath("//*[@type='tel']")).sendKeys("8123456789");//Enter Phone
		driver.findElement(By.xpath("//*[@value='FeMale']")).click();//Select Gender
		for(int i=1;i<=3;i++){
			driver.findElement(By.id("checkbox"+i)).click();//Select hobbies
		}
		
		driver.findElement(By.id("msdd")).click();//Click bootstrap drop drown LAnguage
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'ui-menu')]//li//a"));
		for(int j =0;j<list.size();j++){
			if(list.get(j).getText().contains("English") || list.get(j).getText().contains("Hindi")){
				list.get(j).click();
			}
		}
		
		Select selectSkill = new Select(driver.findElement(By.id("Skills")));//Select Skill
		selectSkill.selectByVisibleText("Java");
		
		
		Select selectCountry = new Select(driver.findElement(By.id("countries")));//Select Country
		selectCountry.selectByVisibleText("India");
		
		driver.findElement(By.xpath("//*[@role='combobox']")).click();//Click  boot strap drop drown Country
		List<WebElement> listCountry = driver.findElements(By.xpath("//ul[@id='select2-country-results']//li"));
		
		for(int k =0;k<listCountry.size();k++){
			if(listCountry.get(k).getText().contains("Australia")){
				listCountry.get(k).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		//Selecting DOB
		Select selectYear = new Select(driver.findElement(By.id("yearbox")));
		selectYear.selectByVisibleText("1990");
		Select selectMonth = new Select(driver.findElement(By.xpath("//*[@placeholder='Month']")));
		selectMonth.selectByVisibleText("October");
		Select selectDay = new Select(driver.findElement(By.id("daybox")));
		selectDay.selectByVisibleText("27");
		
		driver.findElement(By.id("firstpassword")).sendKeys("Qa1234");//Enter password
		driver.findElement(By.id("secondpassword")).sendKeys("Qa1234");//Enter Confirm password
		
		driver.findElement(By.id("submitbtn")).click();//Click Submit button
		
		Thread.sleep(5000);
		String title= driver.getTitle();
		if(title.contains("Web Table")){
			System.out.println("Regitsration completed");
		}
		
	}

}
