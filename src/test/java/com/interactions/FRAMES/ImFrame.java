package com.interactions.FRAMES;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImFrame {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait =new WebDriverWait(driver, 10);
		
		driver.get("https://paytm.com/");
		driver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div[2]/div/span[contains(text(),'Sign In')]")).click();
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		String dum = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div/div/div[1]/div/div/div[3]/div[2]/a[1]"))).getText();
		System.out.println(dum);
		driver.quit();
		
	}
}
