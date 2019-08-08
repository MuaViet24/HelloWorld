package com.Selenium;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport1 {

	public static void main(String[] args) throws IOException {
		
		
		String path = System.getProperty("user.dir");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(".\\Report\\extent.html");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test = extent.createTest("Extent Test");
		
		test.log(Status.INFO, "Information");
		test.log(Status.PASS, "Pass");
		
		extent.flush();
		
		ExtentTest test1 = extent.createTest("Screenshot Test");
		
		test1.log(Status.INFO, "Test1 Information");
		test1.log(Status.PASS, "Pass Test1");
		test1.pass("Pass step", MediaEntityBuilder.createScreenCaptureFromPath(".\\T1.JPG").build());//Note the screen shots  placed in same path where extent report present
		test1.pass("Pass step", MediaEntityBuilder.createScreenCaptureFromPath(".\\s.png").build());
		test1.log(Status.PASS, "Pass step1", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Stuff\\Reetu\\WorkSpace\\HelloWorld\\Screenshots\\s.png").build())	;
		test1.addScreenCaptureFromPath("C:\\Stuff\\Reetu\\WorkSpace\\HelloWorld\\Screenshots\\A1.png");
		test1.addScreenCaptureFromPath(path + "\\Screenshots\\A2.png");
		//test1.pass(test1.addScreenCaptureFromPath(".\\Report\\s.png"));
		test1.log(Status.PASS, "...").addScreenCaptureFromPath(".\\s.png");
		
		
		extent.flush();
	}

}
