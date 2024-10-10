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


public class Activity21 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
try {
	driver.get("https://v1.training-support.net/selenium/tab-opener");
    String PageTitle1 = driver.getTitle();
    System.out.println("Page Title: "+PageTitle1);
    
    String parentWindow = driver.getWindowHandle();
    System.out.println("ParentWindow: "+parentWindow);
    WebElement pageLauncher = driver.findElement(By.id("launcher"));
    pageLauncher.click();
    
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    
    Set<String> secondWindow = driver.getWindowHandles();
//    Set<String> secondWindow = 
    for(String switchSecond: secondWindow) {
    	System.out.println(switchSecond);
    	if(switchSecond!=parentWindow) {
    		driver.switchTo().window(switchSecond);
//    		String title = driver.getTitle();
//    		System.out.println("Title: "+title);
    	}
    }
    
    driver.findElement(By.id("actionButton")).click();
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    
    Set<String> thirdHandle = driver.getWindowHandles();
    for(String third: thirdHandle) {
    	if(!third.equals(parentWindow) && !third.equals(secondWindow)) {
    		driver.switchTo().window(third);
    		System.out.println(driver.getTitle());
//    		String title2 = driver.getTitle();
//    		System.out.println("Title Third window: "+title2);
    		driver.close();
    	}
    }
    driver.switchTo().window(parentWindow);
    
}
		finally {
        driver.quit();
}
	}

}
