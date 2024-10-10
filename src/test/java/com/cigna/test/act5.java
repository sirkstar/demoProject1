package com.cigna.test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class act5 {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions builder = new Actions(driver);
try {
	driver.get("https://v1.training-support.net/selenium/input-events");
	System.out.println("Page Title: "+driver.getTitle());
	
//	WebElement clk = driver.findElement(By.className("active"));
	String frontText = driver.findElement(By.className("active")).getText();
	builder.click().pause(1000).build().perform();
//	WebElement child = clk.findElement(By.tagName("h1"));
	System.out.println("Left Click Text: "+frontText);
	
	builder.doubleClick().pause(2000).build().perform();
	frontText = driver.findElement(By.className("active")).getText();
	System.out.println("Double Click Text: "+frontText);
	
	builder.contextClick().pause(1000).build().perform();
	frontText = driver.findElement(By.className("active")).getText();
	System.out.println("Right Click Text: "+frontText);
	
}finally {
	driver.quit();
}
		
	}

}
