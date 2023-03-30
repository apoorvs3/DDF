package com.w2a.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	/*
	 * WebDriver Properties LOgs ExtentReports DB Excel Mail ReportNg ExtentReport Logs
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static App_log logging = new App_log();
	public static Logger log = logging.log();
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	

	@BeforeSuite
	public void setUp() {
		if(driver == null) {
			try {
				fis = new FileInputStream("./src/test/resources/properties/config.properties");
				log.info("config file found");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config file loaded");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream("./src/test/resources/properties/OR.properties");
				log.info("Object repository file found");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.info("Object repository loaded");
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
			log.info("Chrome started successfully");
		}
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(config.getProperty("implicitWait")), TimeUnit.SECONDS);
		
	}
	

	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.quit();
			log.info("Test execution completed");
		}
	}
	
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			log.info(by.toString()+ " was not found");
			return false;
		}
	}
}
