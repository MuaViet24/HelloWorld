package com.TestNG;

import org.testng.annotations.Test;

public class TestNGInvocationCountConcept {
	
	@Test(invocationCount=10)
	public void sum(){
		int a=10;
		int b= 20;
		System.out.println("Sum===> "+ (a+b));
	}

}
