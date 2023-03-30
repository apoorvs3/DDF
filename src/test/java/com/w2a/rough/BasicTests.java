package com.w2a.rough;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTests  extends BaseTest{
	
	
	@BeforeTest
	public void createDBConnection() {
		System.out.println("Create a DB Connection");
	}
	@AfterTest
	public void closeDBConnection() {
		System.out.println("close a DB Connection");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("Launching browser");
	}
	
	@Test(priority = 2, groups = {"functional"})
	public void doLogin() {
		System.out.println("Login successful");
	}
	
	@Test(priority = 1, groups= {"functional"})
	public void doUdserRegiostration() {
		System.out.println("user registered");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing browser");
	}
}
