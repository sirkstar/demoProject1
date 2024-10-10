package com.practice.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.pages.SelectPageLMS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activity9 {

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
	public void activity5Test() throws InterruptedException {
//		Actions builder = new Actions(driver);
		driver.get("https://v1.training-support.net/selenium/ajax");
		System.out.println("Title: "+driver.getTitle());

		WebElement changeContent = driver.findElement(By.xpath("//button[@class='ui violet button']"));
		changeContent.click();
		WebElement Hello = driver.findElement(By.xpath("//div[@id='ajax-content']/h1"));
		wait.until(ExpectedConditions.visibilityOf(Hello));
//		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='ajax-content']/h1")), "Hello!"));
		String HelloText1 = driver.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText();
		System.out.println("Hello Text1: "+HelloText1);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
		System.out.println(driver.findElement(By.xpath("//div[@class='sub header']")).getText());
		
//		String HelloText1a = "This text is loaded using AJAX";
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
