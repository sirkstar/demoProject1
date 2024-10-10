package com.cigna.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class activity1 {

	public static void main(String[] args) throws InterruptedException {
      System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
      WebDriverManager.firefoxdriver().setup();
//		WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net");
        String pageTitle1= driver.getTitle();
        System.out.println("Page Title is: "+pageTitle1);
        Thread.sleep(2000);
        WebElement abtUs = driver.findElement(By.xpath("//a[@href='/about']"));
        abtUs.click();
        String pageTitle2 = driver.getTitle();
        System.out.println("Page Title of newly opened About Us page is: "+ pageTitle2);
        Thread.sleep(2000);

        driver.quit();
	}

}
