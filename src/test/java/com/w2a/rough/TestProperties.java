package com.w2a.rough;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {
	public static void main(String[] args) {
		try {
			Properties config = new Properties();
			Properties or = new Properties();
			FileInputStream fis = new FileInputStream("./src/test/resources/properties/config.properties");
			config.load(fis);
			System.out.println(config.getProperty("testsiteurl"));
		}
		catch (Exception e){
			
		}
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// implicit wait only waits for presence of element located
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Explicit
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))).click();
		
		//Fluent
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(5L))
			       .ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))).click();
		
		driver.quit();
		
	}
}
