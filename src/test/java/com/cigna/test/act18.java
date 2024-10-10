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

public class act18 {

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

			WebElement multiSelect = driver.findElement(By.id("multi-select"));
			Select select = new Select(multiSelect);

			select.selectByVisibleText("Javascript");
			System.out.println("First Selected: "+select.getFirstSelectedOption().getText());
			System.out.println("-------------------");

			select.selectByIndex(4);
			select.selectByIndex(5);
			select.selectByIndex(6);

			List<WebElement> selectedOptions = select.getAllSelectedOptions();

			for(WebElement ele: selectedOptions) {
				String eleText = ele.getText();
				System.out.println("selected Options: "+eleText);
			}
			System.out.println("-------------------");

			select.selectByValue("node");
			selectedOptions = select.getAllSelectedOptions();

			for(WebElement ele: selectedOptions) {
				String eleText = ele.getText();
				System.out.println("selected Options: "+eleText);
			}
			System.out.println("-------------------");

			select.deselectByIndex(6);
			selectedOptions = select.getAllSelectedOptions();

			for(WebElement ele: selectedOptions) {
				String eleText = ele.getText();
				System.out.println("selected Options: "+eleText);
			}

		}finally {
			driver.quit();
		}

	}

}
