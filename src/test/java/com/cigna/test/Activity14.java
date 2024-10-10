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


public class Activity14 {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
try {
//		Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/tables");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("Number of rows: "+rows.size());
        
        List<WebElement> Col = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println("Number of Columns: "+Col.size());
        /*
        List<WebElement> thirdRowText = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));
        for(WebElement xyz: thirdRowText) {
//        	String test = xyz.getText();
        	System.out.println(xyz.getText());
        }
        */
               
        
        WebElement secondRowData = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        String secondRowSecondColText = secondRowData.getText();
        System.out.println("Second Row Second Col Text is: "+secondRowSecondColText);
        
        WebElement headerOne = driver.findElement(By.xpath("//table[@id='sortableTable']/thead//th[1]"));
        headerOne.click();
        
        WebElement secondRowData1 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        String secondRowSecondColText1 = secondRowData1.getText();
        System.out.println("Second Row Second Col Text is: "+secondRowSecondColText1);
        
        List<WebElement> footText = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for(WebElement test: footText) {
        	System.out.println("Footer Values: "+test.getText());
        }
        System.out.println("Test Complete");
}finally {
        driver.quit();
}
	}

}
