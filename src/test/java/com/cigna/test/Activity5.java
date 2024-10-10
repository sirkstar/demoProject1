package com.cigna.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity5 {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

try {
		Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/input-events");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);
        builder.click().pause(1000).build().perform();
        String leftClickText = driver.findElement(By.className("active")).getText();
        System.out.println("Value when left Clicked: "+leftClickText);
        
        builder.doubleClick().pause(2000).build().perform();
        String dblClickText = driver.findElement(By.xpath("//div[@class='active']")).getText();
        System.out.println("Double Click Text: "+dblClickText);
        
        builder.contextClick().pause(1000).build().perform();
        String rightClick = driver.findElement(By.className("active")).getText();
        System.out.println("Right Click Text: "+rightClick);
        
}finally {
        driver.quit();
}
	}

}
