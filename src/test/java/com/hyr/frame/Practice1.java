package com.hyr.frame;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
try {		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		System.out.println("Page Title: "+driver.getTitle());
		
		WebElement txtBoxParent = driver.findElement(By.id("name"));
		txtBoxParent.clear();
		txtBoxParent.sendKeys("This is Sample");
		
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		
		WebElement selectDropdown = driver.findElement(By.id("selectnav1"));
		Select select = new Select(selectDropdown);
		
		select.selectByVisibleText("- Java");
		driver.switchTo().defaultContent();
		txtBoxParent.clear();
		txtBoxParent.sendKeys("Sample Text re-entry");
		Thread.sleep(5000);
}finally {
	driver.quit();
}

	}

}
