package com.ipl.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IPLTeamStats {
    	
    	/*
        // Initialize WebDriver (make sure to set the path for your WebDriver)
    	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.iplt20.com/teams/chennai-super-kings/squad-details/1");

        // Extract Column 1 values (as strings)
        List<WebElement> column1Elements = driver.findElements(By.xpath("//div[@class='sm-pp-table__title'][text()='Batting & Fielding Stats']/following-sibling::div//tbody/tr/td[1]"));
        List<String> column1Values = column1Elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        // Extract Column 5 values (as strings)
        List<WebElement> column5Elements = driver.findElements(By.xpath("//div[@class='sm-pp-table__title'][text()='Batting & Fielding Stats']/following-sibling::div//tbody/tr/td[6]"));
        List<String> column5Values = column5Elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        // Merge two lists into a map (key: String from column 1, value: Double from column 5)
        Map<String, Double> mergedMap = new HashMap<>();
        for (int i = 0; i < column1Values.size(); i++) {
            if (i < column5Values.size()) {
                String key = column1Values.get(i);
                // Convert column 5 value to double
                Double value = Double.parseDouble(column5Values.get(i));
                mergedMap.put(key, value);
            }
        }

        // Example of manipulating the map using streams
        mergedMap.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
        
*/
	
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
    	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
    	WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
	public void singleSelect() {
    	//hyr dropdown practice
    	driver.get("https://v1.training-support.net/selenium/selects");
    	
    	WebElement dropdown = driver.findElement(By.id("single-select"));
    	
    	Select select = new Select(dropdown);
    	
    	
	}
	
	@Test
	public void dragNdropTest() {
    	Actions builder = new Actions(driver);

    	//LMS - Drag-n-drop
    	driver.get("https://v1.training-support.net/selenium/drag-drop");
    	
	}
    	
    @AfterSuite
    public void tearDown() {	
        // Close the driver
        driver.quit();
    }
}