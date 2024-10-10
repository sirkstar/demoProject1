package com.cigna.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity3 {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);
        WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement login = driver.findElement((By.xpath("//button[text()='Log in']")));
        
        user.click();
        user.sendKeys("admin");
        pwd.sendKeys("password");
        login.click();
        
//        WebElement actConfirm = driver.findElement(By.id("action-confirmation"));
        String display2 = driver.findElement(By.id("action-confirmation")).getText();
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: "+pageTitle);

//        String DisplayedText = actConfirm.getText();
        System.out.println("Text Displayed: "+display2);
//        Assert.assertEquals(display2, "Welcome Back, admin");
        
        try {
            Assert.assertEquals(display2, "Welcome Back, admin");
            System.out.println("Test Passed: Display message is correct.");
        } catch (AssertionError e) {
            System.out.println("Test Failed: Expected 'Welcome Back, admin' but found '" + display2 + "'.");
        }        
        driver.quit();
	}

}
