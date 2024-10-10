package com.hyr.windowHandle;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1a {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		try {
			driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
			System.out.println("Page Title: "+driver.getTitle());
			
			WebElement btnToOpenPageOne = driver.findElement(By.id("newWindowBtn"));
			
			String parentHandle = driver.getWindowHandle();
			System.out.println("Parent Handle: "+parentHandle);
			
			btnToOpenPageOne.click();
			
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			
			Set<String> allHandles = driver.getWindowHandles();
			for(String handle: allHandles) {
				if(!handle.equals(parentHandle)) {
					driver.switchTo().window(handle);
					driver.manage().window().maximize();
					System.out.println("Handle Two: "+driver.getWindowHandle());
					driver.findElement(By.id("firstName")).sendKeys("Krishnakumar");
//					Thread.sleep(5000);
					driver.close();
					break;
				}
			}
			Thread.sleep(5000);

			driver.switchTo().window(parentHandle);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
			driver.findElement(By.id("name")).sendKeys("Krishna's name in Parent Window");
			Thread.sleep(5000);
			
		}finally {
			driver.quit();
		}
		
	}

}
