package com.practice.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.pages.SelectPageLMS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class activity4 {

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
	public void activity4Test() {
		driver.get("https://v1.training-support.net/selenium/target-practice");
		System.out.println("Title: "+driver.getTitle());
		
//		WebElement third = driver.findElement(By.xpath("//h3[@id='third-header']"));
		String thirdText = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
		System.out.println("Third Text: "+thirdText);
		
		WebElement fifth = driver.findElement(By.cssSelector(".ui.green.header"));
		String fifithColor = fifth.getCssValue("color");
		System.out.println(fifithColor);
		
		String violet = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
		System.out.println("Violet: "+violet);
		
		WebElement grey = driver.findElement(By.cssSelector("button[class='ui grey button']"));
		String greyText = grey.getText();
		System.out.println("Grey Text: "+greyText);
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
