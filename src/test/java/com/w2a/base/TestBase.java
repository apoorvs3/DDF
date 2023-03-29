package com.w2a.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	/*
	 * WebDriver Properties LOgs ExtentReports DB Excel Mail
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	
	@BeforeSuite
	public void setUp() {
		if(driver == null) {
			try {
				fis = new FileInputStream("./src/test/resources/properties/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream("./src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(config.getProperty("implicitWait"))));
		
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
