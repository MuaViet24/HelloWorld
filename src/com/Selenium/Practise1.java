package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practise1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();


		// Click on register Link
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();

		System.out.println("Title of the page: ----> :" + driver.getTitle());

		/*//Submit the Registration form
		driver.findElement(By.name("firstName")).sendKeys("Test"); //Enter First name
		driver.findElement(By.name("lastName")).sendKeys("Hoc"); //Enter Last name
		driver.findElement(By.name("phone")).sendKeys("1234567890"); //Enter Phone
		driver.findElement(By.name("userName")).sendKeys("test.hoc@gmail.com"); //Enter Email
		driver.findElement(By.name("address1")).sendKeys("ABC New Street"); //Enter Address
		driver.findElement(By.name("city")).sendKeys("NSW"); //Enter City
		driver.findElement(By.name("state")).sendKeys("Sydney"); //Enter State
		driver.findElement(By.name("postalCode")).sendKeys("2000"); //Enter Postal Code
		Select selCountry = new Select(driver.findElement(By.name("country"))); //Select Country from Drop down
		selCountry.selectByVisibleText("AUSTRALIA ");
		driver.findElement(By.name("email")).sendKeys("Test"); //Enter User Name
		driver.findElement(By.name("password")).sendKeys("Test"); //Enter Password
		driver.findElement(By.name("confirmPassword")).sendKeys("Test"); //Enter confirm Password
		driver.findElement(By.name("register")).click(); //Click Submit


		Thread.sleep(8000);
		//Verify the confirmation message
		 String msg = driver.findElement(By.xpath("//*[contains(text(),' sign-in ')]")).getText();

		 if(msg.contains("")){
			 System.out.println("<--Registration successful--->"+ msg);
		 }
		 else{
			 System.out.println("<--Registration failed->" + msg);
		 }*/

		//Click Cruises link
		driver.findElement(By.xpath("//*[contains(text(),'Cruises')]")).click();

		//Verify the cruises available
		System.out.println("Title of the page:--->" + driver.getTitle() );

		if(driver.getTitle().contains("Cruises")){
			System.out.println("<---Welcome to Cruises Special--->");
		}
		else{
			System.out.println("Server down");
		}

		/*String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[";
		String afterXPath = "]/td[1]/font";


		//Printing the first Column of the Cruise table
		for(int i =4 ;i<=11;i++){

			System.out.println(driver.findElement(By.xpath(beforeXPath+i+afterXPath)).getText());
		}*/


		/*String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[";
		String midXPath = "]/td[";
		//String afterXPath = "]/font";
		String afterXPath = "]";


		//Printing all the values from Cruise table
		for(int i = 4;i<=11;i++){
			for(int j=1;j<=4;j++){
				System.out.println(driver.findElement(By.xpath(beforeXPath+i+midXPath+j+afterXPath)).getText());
			}
		}

		//XPath's of the Column

		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[4]/td[2]/strong/font
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[5]/td[2]/font
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[4]/td[3]
		//html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[4]/td[4]/font
		 */

		//Printing the Cruise table value with proper formatting
		/*String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[";
		String midXPath = "]/td[";
		//String afterXPath = "]/font";
		String afterXPath = "]";
		System.out.println("<----:The Schedule of the Cruise for the week:----->");
		for(int i = 4; i<=11; i++){
			for(int j=1;j<=4;j++){

				String val =  driver.findElement(By.xpath(beforeXPath +i+  midXPath +j + afterXPath)).getText();
				switch (j) {
				case 1:
					System.out.println("Day: "+val);
					break;
				case 2:
					System.out.println("Port: "+val);
					break;
				case 3:
					System.out.println("Arrival: "+val);
					break;
				case 4:
					System.out.println("Departure: "+val);
					break;

				default:
					break;
				}

			}

			System.out.println("-----------------------");
		}*/

		// To print all cruise details active on Saturday
		/*String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[";
		String midXPath = "]/td[";
		//String afterXPath = "]/font";
		String afterXPath = "]";
		System.out.println("<----:The Schedule of the Cruise for Saturday:----->");
		for(int i = 4; i<=11; i++){
			String dayVal = driver.findElement(By.xpath(beforeXPath+i+midXPath+"1"+afterXPath)).getText();
			for(int j=1;j<=4;j++){

				if(dayVal.equals("Sat")){
					String val =  driver.findElement(By.xpath(beforeXPath +i+  midXPath +j + afterXPath)).getText();
					switch (j) {
					case 1:
						System.out.println("Day: "+val);
						break;
					case 2:
						System.out.println("Port: "+val);
						break;
					case 3:
						System.out.println("Arrival: "+val);
						break;
					case 4:
						System.out.println("Departure: "+val);
						System.out.println("-----------------------");
						break;

					default:
						break;
					}
				}

			}

		}*/

		/*//To print the cruise details from Inside Passage Port
		String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[";
		String midXPath = "]/td[";
		//String afterXPath = "]/font";
		String afterXPath = "]";
		System.out.println("<----:The Schedule of the Cruise from Inside Passage Port:----->");
		for(int i = 4; i<=11; i++){
			String portVal = driver.findElement(By.xpath(beforeXPath+i+midXPath+"2"+afterXPath)).getText();
			for(int j=1;j<=4;j++){

				if(portVal.equals("Inside Passage")){
					String val =  driver.findElement(By.xpath(beforeXPath +i+  midXPath +j + afterXPath)).getText();
					switch (j) {
					case 1:
						System.out.println("Day: "+val);
						break;
					case 2:
						System.out.println("Port: "+val);
						break;
					case 3:
						System.out.println("Arrival: "+val);
						break;
					case 4:
						System.out.println("Departure: "+val);
						System.out.println("-----------------------");
						break;

					default:
						break;
					}
				}

			}

		}*/


		//To print the cruise details having departures Post 5 PM
		String beforeXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/th/table/tbody/tr[";
		String midXPath = "]/td[";
		String afterXPath = "]";
		System.out.println("<----:The Schedule of the Cruise having departures Post 5 PM:----->");
		for(int i = 4; i<=11; i++){
			String departTimeVal = driver.findElement(By.xpath(beforeXPath+i+midXPath+"4"+afterXPath)).getText();
			for(int j=1;j<=4;j++){

				if(departTimeVal.contains("pm")){
					String[] arrDepartTime=departTimeVal.split(" ");
					int castDepartTime = Integer.parseInt(arrDepartTime[0]);
					//System.out.println("Integer value of departure time:"+castDepartTime);
					if(castDepartTime>=5){
						String val =  driver.findElement(By.xpath(beforeXPath +i+  midXPath +j + afterXPath)).getText();
						switch (j) {
						case 1:
							System.out.println("Day: "+val);
							break;
						case 2:
							System.out.println("Port: "+val);
							break;
						case 3:
							System.out.println("Arrival: "+val);
							break;
						case 4:
							System.out.println("Departure: "+val);
							System.out.println("-----------------------");
							break;

						default:
							break;
						}
					}
				}

			}

		}
	}

}
