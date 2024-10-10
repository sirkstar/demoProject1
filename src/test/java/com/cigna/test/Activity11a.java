package com.cigna.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity11a {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.out.println("Setting up WebDriver...");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test (groups = {"smoke", "regression"})
    @Parameters({"a","b"})
    public void MathTest(int inputA, int inputB) {
    	int a=inputA;
    	int b=inputB;
    	int sum = a+b;
    	System.out.println("Add results: "+sum);
    }
    
    @Test (groups = {"regression"})
    public void MathSubTest() {
    	int a = 10;
    	int b = 20;
    	int multiply = a*b;
    	System.out.println("Multiply results: "+multiply);
    }
    
    @Test(groups = "regression", enabled = true)
//    @Test(dependsOnMethods= {"MathTest"}, groups = "smoke")
    public void testCheckboxFunctionality() {
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        WebElement chkBox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));

        // Check the default state of the checkbox
        System.out.println("Check Box Selected by default? " + chkBox.isSelected());
        Assert.assertFalse(chkBox.isSelected(), "Checkbox should not be selected by default.");

        // Click the checkbox to change its state
        chkBox.click();
        System.out.println("Check Box selected after clicking check button? " + chkBox.isSelected());
        Assert.assertTrue(chkBox.isSelected(), "Checkbox should be selected after clicking.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}