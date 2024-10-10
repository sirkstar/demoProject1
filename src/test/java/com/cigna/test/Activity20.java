package com.cigna.test;

import java.time.Duration;
import java.util.List;

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


public class Activity20 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
try {
	driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    String PageTitle1 = driver.getTitle();
    System.out.println("Page Title: "+PageTitle1);
    
    WebElement confirm = driver.findElement(By.id("prompt"));
    
    confirm.click();
    Alert alert = driver.switchTo().alert();
    
    String alertText = alert.getText();
    System.out.println(alertText);
    
    alert.sendKeys("Awesome!");
    Thread.sleep(1500);
    alert.accept();
        
}
		finally {
        driver.quit();
}
	}

}
