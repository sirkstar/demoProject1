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

public class act6 {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions builder = new Actions(driver);
try {
	driver.get("https://v1.training-support.net/selenium/input-events");
	System.out.println("Page Title: "+driver.getTitle());
	
	builder.keyDown(Keys.SHIFT).sendKeys("K").keyUp(Keys.SHIFT).build().perform();
	System.out.println("Typed text: "+driver.findElement(By.id("keyPressed")).getText());
	builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	
}finally {
	driver.quit();
}
		
	}

}
