package com.cigna.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Activity4 {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

try {
        driver.get("https://v1.training-support.net/selenium/target-practice");
        String PageTitle1 = driver.getTitle();
        System.out.println("Page Title: "+PageTitle1);
        
        WebElement ThirdHeader = driver.findElement(By.xpath("//h3[contains(@id,'third-header')]"));
//        WebElement FifthHeader = driver.findElement(By.xpath("//h5[contains(text(),'Fifth header')]"));
        WebElement fifthHeader = driver.findElement((By.xpath("(//h1 | //h2 | //h3 | //h4 | //h5)[5]")));
//        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
//        WebElement login = driver.findElement((By.xpath("//button[text()='Log in']")));
        String thirdHeaderText = ThirdHeader.getText();
        System.out.println("Third Header Text: "+thirdHeaderText);
        
        String fiftHeaderColor = fifthHeader.getCssValue("color");
        System.out.println("FiftHeaderColor is: "+fiftHeaderColor);
        
        String violet = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("Violet Color Class Attr value is: "+violet);
        
        String gray = driver.findElement(By.xpath("//button[@class='ui grey button']")).getText();
        System.out.println("Gray Text present is: "+gray);
}finally {
        driver.quit();
}
	}

}
