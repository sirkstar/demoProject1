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


public class Activity8 {

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
        
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        toggleButton.click();
        
        WebElement dynamicCheckBox = driver.findElement(By.id("dynamicCheckbox"));
        wait.until(ExpectedConditions.invisibilityOf(dynamicCheckBox));
        System.out.println(dynamicCheckBox.isDisplayed());
        toggleButton.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicCheckBox));
        System.out.println(dynamicCheckBox.isDisplayed());
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(1500);
        
        System.out.println("Test Passed");
}finally {
        driver.quit();
}
	}

}
