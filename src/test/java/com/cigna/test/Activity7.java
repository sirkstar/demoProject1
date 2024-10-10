package com.cigna.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity7 {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

try {
		Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);
        
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dz1 = driver.findElement(By.id("droppable"));
        WebElement dz2 = driver.findElement(By.id("dropzone2"));

//        String droppedText = driver.findElement(By.tagName("p")).getText();
//        builder.dragAndDrop(ball, dz1).build().perform();
        builder.clickAndHold(ball).moveToElement(dz1).release().build().perform();
        String dz1Text = dz1.findElement(By.tagName("p")).getText();
        if(dz1Text.equals("Dropped!")) {
        	System.out.println("Ball in DropZone1");
        }
        builder.dragAndDrop(ball, dz2).build().perform();
        String dz2Text = dz2.findElement(By.tagName("p")).getText();
        if(dz2Text.equals("Dropped!")) {
        	System.out.println("Ball dropped in DropZone2");
        }
        System.out.println("Test Passed");
}finally {
        driver.quit();
}
	}

}
