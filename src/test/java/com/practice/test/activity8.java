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

public class activity8 {

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
		driver.get("https://v1.training-support.net/selenium/dynamic-controls");
		System.out.println("Title: "+driver.getTitle());
		
		WebElement togglebtn = driver.findElement(By.id("toggleCheckbox"));
		WebElement checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
		togglebtn.click();
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		togglebtn.click();
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		
		checkBox.click();
		
		if(checkBox.isSelected()){
			System.out.println("As expected, the checkbox is selected");
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
