package com.ipl.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableDemo {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions action = new Actions(driver);
	}
	@Test
	public void iplTest(){
		driver.get("https://www.iplt20.com/points-table/men/2024");
		System.out.println(driver.getTitle());
		
		List<WebElement> Team = driver.findElements(By.xpath("//div[@class='ih-pcard-wrap']/table/tbody[@id='pointsdata']/tr/td[3]//h2"));
		
		int teamsCount = Team.size();
		for(WebElement team:Team) {
			String teamName = team.getText();
			System.out.println("Team Name: "+teamName);
		}
		System.out.println("Team total count: "+teamsCount);

	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
