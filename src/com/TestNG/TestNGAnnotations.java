package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	//TestNG Pre-Condition Methods
	@BeforeSuite
	public void beforeSuiteMethod(){
		System.out.println("Before Suite Method");
	}
	
	@BeforeTest
	public void beforeTestMethod(){
		System.out.println("Before Test Method");
	}
	
	@BeforeClass
	public void beforeClassMethod(){
		System.out.println("Before Class Method");
	}
	
	@BeforeMethod
	public void beforeMethodMethod(){
		System.out.println("Before Method Method");
	}
	
	@Test
	public void testMethod(){
		System.out.println("Test Method");
	}
	
	@AfterMethod
	public void afterMethodMethod(){
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClassMethod(){
		System.out.println("After Class Method");
	}
	
	@AfterTest
	public void afterTestMethod(){
		System.out.println("After Test Method");
	}
	
	@AfterSuite
	public void afterSuiteMethod(){
		System.out.println("After Suite Method");
	}

}
