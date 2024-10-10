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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity17 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
try {
	driver.get("https://v1.training-support.net/selenium/selects");
    String PageTitle1 = driver.getTitle();
    System.out.println("Page Title: "+PageTitle1);
    
    WebElement sel = driver.findElement(By.id("single-select"));
    Select select = new Select(sel);
    select.selectByVisibleText("Option 2");
    System.out.println(select.getFirstSelectedOption().getText());
//    if(select.getFirstSelectedOption().equals("Option 2")) {
//    	System.out.println("Selected Option 2");
//    }
    select.selectByIndex(3);
    System.out.println(select.getFirstSelectedOption().getText());
    
    select.selectByValue("4");
    System.out.println(select.getFirstSelectedOption().getText());
    
    List<WebElement> allOptions = select.getOptions();
    for(WebElement test: allOptions) {
    	System.out.println(test.getText());
    }
}

		finally {
        driver.quit();
}
	}

}
