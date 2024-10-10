package com.cigna.test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class act17 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions builder = new Actions(driver);
try {
	driver.get("https://v1.training-support.net/selenium/selects");
	System.out.println("Page Title: "+driver.getTitle());
	
	WebElement dropdown = driver.findElement(By.id("single-select"));
	
	Select select = new Select(dropdown);
	
	select.selectByVisibleText("Option 2");
	System.out.println("the second option using the visible text: "+select.getFirstSelectedOption().getText());
	Thread.sleep(1000);
	select.selectByIndex(3);
	System.out.println("The third option using the index: "+select.getFirstSelectedOption().getText());
	Thread.sleep(1000);
	select.selectByValue("4");
	System.out.println("the fourth option using the value: "+select.getFirstSelectedOption().getText());
	Thread.sleep(1000);
	
	List<WebElement> allOptions = select.getOptions();
	for(WebElement options: allOptions) {
		System.out.println("All options: "+options.getText());
	}
	
}finally {
	driver.quit();
}
		
	}

}
