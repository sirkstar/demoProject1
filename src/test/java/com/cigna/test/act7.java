package com.cigna.test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class act7 {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions builder = new Actions(driver);
try {
	driver.get("https://v1.training-support.net/selenium/drag-drop");
	System.out.println("Page Title: "+driver.getTitle());
	
	WebElement ball = driver.findElement(By.id("draggable"));
	WebElement dropZone1 = driver.findElement(By.id("droppable"));
	WebElement dropZone2 = driver.findElement(By.id("dropzone2"));
	
	builder.clickAndHold(ball).moveToElement(dropZone1).release().build().perform();
	String dropText = "Dropped!";
	
	if(dropZone1.findElement(By.tagName("p")).getText().equals(dropText)) {
		System.out.println("Verified and ball dropped in Drop Zone1");
	}else {
		System.out.println("Ball not dropped in DropZone1");
	}
	
	builder.dragAndDrop(ball, dropZone2).build().perform();
	if(dropZone2.findElement(By.tagName("p")).getText().equals(dropText)) {
		System.out.println("Verified and ball dropped in Drop Zone2");
	}else {
		System.out.println("Ball not dropped in DropZone2");
	}
	
	
}finally {
	driver.quit();
}
		
	}

}
