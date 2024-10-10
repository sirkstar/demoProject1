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


public class Activity11 {

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
        
        WebElement chkBox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
//        WebElement toggleButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        
        System.out.println("Check Box Selected by default? "+chkBox.isSelected());
//        toggleButton.click();
        chkBox.click();
        System.out.println("Check Box selected after clicking check button? "+chkBox.isSelected());
        

        System.out.println("Test Complete");
}finally {
        driver.quit();
}
	}

}
