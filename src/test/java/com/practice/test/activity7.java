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

public class activity7 {

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
		Actions builder = new Actions(driver);
		driver.get("https://v1.training-support.net/selenium/drag-drop");
		System.out.println("Title: "+driver.getTitle());
		
		WebElement ball = driver.findElement(By.id("draggable"));
		WebElement dz1 = driver.findElement(By.id("droppable"));
		WebElement dz2 = driver.findElement(By.id("dropzone2"));
		
		builder.clickAndHold(ball).moveToElement(dz1).release().build().perform();
		String dropText = "Dropped!";
//		wait.until(ExpectedConditions.textToBePresentInElement(dz11, dropText));

//		WebElement dz11 = dz1.findElement(By.tagName("p"));
		String Dz1Text = dz1.findElement(By.tagName("p")).getText();
System.out.println(Dz1Text);
		Assert.assertEquals(dropText, Dz1Text);
		Thread.sleep(1000);
		builder.dragAndDrop(ball, dz2).build().perform();
//		dropText = "Dropped!";

//		WebElement dz22 = dz2.findElement(By.tagName("p"));
		String Dz2Text = dz2.findElement(By.tagName("p")).getText();
//		wait.until(ExpectedConditions.textToBePresentInElement(dz22, dropText));
		System.out.println(Dz2Text);
		Thread.sleep(1000);

		Assert.assertEquals(Dz2Text, dropText);
		
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
