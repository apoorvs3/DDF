package com.interactions.assignments;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assassin1 {
	static WebDriver driver;
	static Actions action;

	
	public static void getLinks() {
		List<WebElement> links = null;
		try {
			driver.findElement(By.xpath("//h3[contains(text(),'Way2Automation')]")).click();
			links = driver.findElements(By.tagName("a"));
			for(WebElement link: links) {
				System.out.println(link.getText());
			}
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"elementor-popup-modal-26600\"]/div/div[4]")).click();
			System.out.println("Total count: "+ links.size());
		}
		
		
	}
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("[name='q']")).sendKeys("way2automation");
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Assassin1.getLinks();
		Assassin1.TearDown();
	}
	
	public static void TearDown() {
		driver.quit();
	}
}
