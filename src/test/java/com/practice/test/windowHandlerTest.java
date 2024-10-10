package com.practice.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.practice.pages.SelectPageLMS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandlerTest {

	WebDriver driver;
	WebDriverWait wait;
	SelectPageLMS sel;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void activity5Test() throws InterruptedException {

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		System.out.println(driver.getTitle());
		
		String parentHandle = driver.getWindowHandle();
		System.out.println("ParentHandle: "+parentHandle);
		
		WebElement btn = driver.findElement(By.id("newWindowBtn"));
		btn.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> secondHandle = driver.getWindowHandles();
		for(String h: secondHandle) {
		System.out.println("-------------");
			System.out.println(h);
			System.out.println("-------------");
		}
		for(String handle: secondHandle) {
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				String secondHandleText = driver.getWindowHandle();
				System.out.println(secondHandleText);
				
			}
//			driver.close();
		}
		driver.switchTo().window(parentHandle);
		
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
