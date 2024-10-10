package com.cigna.test;

import java.time.Duration;
import java.util.List;

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


public class Activity15 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
try {
//		Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);
        
        WebElement user = driver.findElement(By.xpath("//input[@type='text'][starts-with(@class,'username')]"));
        
        WebElement password = driver.findElement(By.xpath("//input[@type='password'][starts-with(@class,'password')]"));
        
        WebElement login = driver.findElement(By.xpath("//button[@onclick='signIn()']"));        
        
        user.sendKeys("admin");
        password.sendKeys("password");
        login.click();
        
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        
        String LoginMessage = confirmationMessage.getText();
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        System.out.println(LoginMessage);
       
        System.out.println("Test Complete");
}finally {
        driver.quit();
}
	}

}
