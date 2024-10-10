package com.cigna.test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class act22 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
try {
	driver.get("https://v1.training-support.net/selenium/tab-opener");
	System.out.println("Page Title: "+driver.getTitle());
	
	String parentHandle = driver.getWindowHandle();
	System.out.println("Parent Handle: "+parentHandle);
	
	driver.findElement(By.id("launcher")).click();
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	
	Set<String> allHandles = driver.getWindowHandles();
//	for(String handle: allHandles) {
//		if(!handle.equals(parentHandle)) {
//		driver.switchTo().window(handle);
//		}
//		System.out.println("Second Handle: "+driver.getWindowHandle());
//	}
	int index = 1;
	for (String handle : allHandles) {
	    if (!handle.equals(parentHandle)) {
	        driver.switchTo().window(handle);
	    }
	    System.out.println("Handle-"+ index+": " + driver.getWindowHandle());
	    index++;
	}
}
		finally {
        driver.quit();
}
	}

}
