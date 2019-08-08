package com.TestNG;

import org.testng.annotations.Test;

public class TestNGDependsOnMethodConcept {
	
	@Test
	public void Login(){
		System.out.println("Login Page");
		//int i =9/0;
	}
	
	@Test(dependsOnMethods="Login")
	public void Home(){
		System.out.println("Home page");
	}
	

}
