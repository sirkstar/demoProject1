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


public class Activity18 {

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
    
    WebElement sel = driver.findElement(By.id("multi-select"));
    Select select = new Select(sel);
    
    select.selectByVisibleText("Javascript");
    System.out.println(select.getFirstSelectedOption());
    
    select.deselectByVisibleText("Javascript");
    
    select.selectByIndex(5);
    select.selectByIndex(6);
    select.selectByIndex(7);
    
    List<WebElement> req2 = select.getAllSelectedOptions();
    for(WebElement test:req2) {
    System.out.println(test.getText());
    }
    
    for(WebElement test2:req2) {
    	List<WebElement> allOptions = select.getOptions();
    	int selectedIndex = allOptions.indexOf(test2);
    	
    	System.out.println("selected Index: "+selectedIndex);
    	select.deselectByIndex(selectedIndex);
//    	select.deselectByIndex(0)
    }
    
    select.selectByValue("node");
    System.out.println(select.getFirstSelectedOption().getText());
    
    select.deselectByValue("node");
    
}
		finally {
        driver.quit();
}
	}

}
