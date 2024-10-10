package com.cigna.test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
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


public class Activity21a {

	public static void main(String[] args) throws Exception {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		/*
		try {
			driver.get("https://v1.training-support.net/selenium/tab-opener");
			String title = driver.getTitle();
			System.out.println("Page Title: "+title);
			
			String parentHandle = driver.getWindowHandle();
			System.out.println("Parent Window Handle: "+parentHandle);
			WebElement clickMe = driver.findElement(By.id("launcher"));
			clickMe.click();
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> allHandles = driver.getWindowHandles();
//			System.out.println("All Handles: "+allHandles);
			for(String handleTwo: allHandles) {
				if(!handleTwo.equals(parentHandle)) {
					driver.switchTo().window(handleTwo);
					System.out.println("Second Window Handle: "+handleTwo);
				}
				wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
				System.out.println("Second Window Title: "+driver.getTitle());
			}
			WebElement clickMeTwo = driver.findElement(By.id("actionButton"));
			clickMeTwo.click();
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			Set<String> allHandlesThree = driver.getWindowHandles();
			for(String handleThree: allHandlesThree) {
				if(!handleThree.equals(parentHandle)&&!allHandles.contains(handleThree)) {
					driver.switchTo().window(handleThree);
					System.out.println("Second Window Handle: "+handleThree);
				}
				System.out.println("Third Window Title: "+driver.getTitle());
			}
//			System.out.println("Third Windle Handle: "+allHandlesThree);
			System.out.println("Third Window Title: "+driver.getTitle());
			
		}finally {
			driver.quit();
		}
		*/
		 // Open the page
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Print the handle of the parent window
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Find button to open new tab
        driver.findElement(By.id("launcher")).click();

        // Wait for the second tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Print all window handles
        System.out.println("Currently open windows: " + driver.getWindowHandles());

        // Switch focus
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("Page title: " + driver.getTitle());
        String pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);
        // Find and click the button on page to open another tab
        driver.findElement(By.id("actionButton")).click();

        // Wait for new tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        // Switch focus
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("Page title: " + driver.getTitle());
        pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);

        // Close the browser
        driver.quit();
	}

}
