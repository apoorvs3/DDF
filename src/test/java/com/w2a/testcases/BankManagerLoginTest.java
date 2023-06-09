package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	@Test
	public void loginAsBankManager() throws InterruptedException {
		driver.findElement(By.cssSelector(OR.getProperty("bml-btn"))).click();;
		log.info("Login successfully executed");
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Login not successful");
	}
}