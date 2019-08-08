package com.TestNG;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test(priority=6,groups="A")
	public void test1(){
		System.out.println("test1");
	}
	
	@Test(priority=5,groups="B")
	public void test2(){
		System.out.println("test2");
	}
	@Test(priority=4,groups="A")
	public void test3(){
		System.out.println("test3");
	}
	@Test(priority=3,groups="B")
	public void test4(){
		System.out.println("test4");
	}
	@Test(priority=2,groups="A")
	public void test5(){
		System.out.println("test5");
	}
	@Test(priority=1,groups="B")
	public void test6(){
		System.out.println("test6");
	}

}
