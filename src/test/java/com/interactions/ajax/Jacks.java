package com.interactions.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jacks {
	static WebDriver driver =null;
	static Actions action = null;
	static WebDriverWait wait = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		Jacks.BangMum();
	}
	
	
	public static void getBangalore() {
		driver.get("https://ksrtc.in/oprs-web/");
		WebElement origin = driver.findElement(By.xpath("//*[@id=\"fromPlaceName\"]"));
		origin.sendKeys("Beng");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		origin.sendKeys(Keys.DOWN);
		System.out.println(origin.getAttribute("value"));
		driver.quit();
		
	}
	
	public static void BangMum() throws InterruptedException {
		driver.get("https://www.makemytrip.com/");
		try {
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i"))).click();
			driver.switchTo().parentFrame();
			
			
		}catch (Exception e) {
			driver.switchTo().parentFrame();
			System.out.println("Not found banner"+ e);
			Thread.sleep(10000);
		}
		
		WebElement fromCity = driver.findElement(By.xpath("//*[@id=\"fromCity\"]"));
		fromCity.sendKeys("Bengalu");
		fromCity.sendKeys(Keys.DOWN);
		fromCity.sendKeys(Keys.ENTER);
		
		WebElement toCity = driver.findElement(By.xpath("//*[@id=\"toCity\"]"));
		toCity.sendKeys("Kanpu");
		toCity.sendKeys(Keys.DOWN);
		toCity.sendKeys(Keys.ENTER);
		
		
		driver.quit();
		
	}
}
