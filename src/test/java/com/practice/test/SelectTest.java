package com.practice.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.practice.pages.SelectPageLMS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTest {
	WebDriver driver;
	WebDriverWait wait;
	SelectPageLMS sel;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test(groups="smoke", priority =0)
	public void selectTest() {
		sel = new SelectPageLMS(driver);
		driver.get("https://v1.training-support.net/selenium/selects");
		System.out.println("Single Select Page Title: "+driver.getTitle());
		sel.selectSingleByIndex(3);
		
//		sel.deselectByIndexSingleSelect(4);
		System.out.println("Selected: "+sel.getSelectedSinlgeSelect());
		sel.selectByVisibleText("Option 2");
		System.out.println("Selected: "+sel.getSelectedSinlgeSelect());
	}
	
	@Test(groups = {"smoke", "Regression"}, priority=1)
	public void multiSelectTest() {
		sel = new SelectPageLMS(driver);
		driver.get("https://v1.training-support.net/selenium/selects");
		System.out.println("MultiSelect Page Title: "+driver.getTitle());
		
		List<Integer> indices = Arrays.asList(4,5,6);
		sel.multipleSelectByIndex(indices);
		
		List<String> values = Arrays.asList("angular");
		sel.multipleSelectByValue(values);
		
		List<String> texts = Arrays.asList("Meteor","NodeJS");
		sel.multiSelectByVisibleText(texts);
		
		System.out.println(sel.getAllOptions1());
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
