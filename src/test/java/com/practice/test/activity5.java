package com.practice.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.pages.SelectPageLMS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activity5 {

	WebDriver driver;
	WebDriverWait wait;
	SelectPageLMS sel;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void activity5Test() {
		Actions builder = new Actions(driver);
		driver.get("https://v1.training-support.net/selenium/input-events");
		System.out.println("Title: "+driver.getTitle());
		
		builder.click().pause(1000).build().perform();
		WebElement active = driver.findElement(By.className("active"));

		System.out.println(active.getText());
		
		builder.doubleClick().pause(1000).build().perform();
		active = driver.findElement(By.className("active"));
		System.out.println(active.getText());

		builder.contextClick().pause(1000).build().perform();
		active = driver.findElement(By.className("active"));
		System.out.println(active.getText());		
		
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
