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


public class Activity9 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
try {
//		Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/ajax");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);
        
        WebElement ChangeContent = driver.findElement(By.xpath("//button[@class='ui violet button']"));
        ChangeContent.click();
        
        WebElement h1Text = driver.findElement(By.xpath("//div[@id='ajax-content']/h1"));//.getText();
        
        wait.until(ExpectedConditions.textToBePresentInElement(h1Text, "HELLO!"));
        
        String h3Text = driver.findElement(By.xpath("//div[@id='ajax-content']/h3")).getText();

//        String content = driver.findElement(By.xpath("//div[@class='content']/div")).getText();
        System.out.println("Hello Message: "+h3Text);
        
        WebElement h3 = driver.findElement(By.xpath("//div[@id='ajax-content']/h3"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
        		
        System.out.println("New Message: "+h3Text);
        
        System.out.println("Test Complete");
}finally {
        driver.quit();
}
	}

}
