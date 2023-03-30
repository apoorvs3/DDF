package com.w2a.rough;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTests extends BaseTest{
	@Test(priority = 2, dependsOnMethods = {"dependencyTest1"}, groups = {"functional"})
	public void dependencyTest2() {
		System.out.println("Login successful");
		
	}
	
	@Test(priority = 1, groups = {"functional"})
	public void dependencyTest1() {
		System.out.println("user registered");
		Assert.fail("user not registered");
	}
	
	@Test(priority = 3, dependsOnMethods = {"dependencyTest1"}, alwaysRun = true, groups = {"functional", "regression"})
	public void dependencyTest3() {
		System.out.println("executing third test");
		
	}

	
	@Test(priority = 4, dependsOnMethods = {"dependencyTest1"}, groups = {"functional" , "regression"})
	public void dependencyTest4() {
		System.out.println("executing fourth test");
	}
}
