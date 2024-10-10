package com.cigna.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity13 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
try {
//		Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);
        
        WebElement dynamicText = driver.findElement(By.xpath("//input[@id='input-text']"));
        WebElement toggleInput = driver.findElement(By.id("toggleInput"));
//        toggleInput.click();
        System.out.println("Is textBox enabled after first clicking the toggle button? "+dynamicText.isEnabled());
        toggleInput.sendKeys("This is Test");
        Thread.sleep(1500);
        toggleInput.click();
        System.out.println("Is textBox enabled after clicking the toggle button second time? "+dynamicText.isEnabled());
        System.out.println("Test Complete");
}finally {
        driver.quit();
}
	}

}
