package com.assaabloy.practice;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;
import com.assaaboly.utility.ExcelDataProvider1;
import com.assaaboly.utility.Write2Excel2;
import com.assaaboly.utility.ConfigDataProvider;
import com.assaaboly.utility.helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ExcelDataProvider1 excel;
	Write2Excel2 excelWrite;
	ConfigDataProvider config;
	SoftAssert softAssert;
//	helper help;
	
	@BeforeClass
	public void setUp() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//	@Test(groups = {"smoke"})
	@Test(groups = {"smoke"})
	public void dropDownTest() throws InterruptedException, IOException {
//		help = new helper();
		config = new ConfigDataProvider();
		String excelWritepath = "./DataProvider/TestData.xlsx";
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		excel = new ExcelDataProvider1();
		excelWrite = new Write2Excel2(excelWritepath);
		softAssert = new SoftAssert();
//		driver.get("https://www.assaabloy.com/group/en/news-media/press-releases");
		helper.deleteExistingScreenshots();
		logger=extent.createTest("Opening ASSA ABLOY Page");
		driver.get(config.getPropertyData("baseURL"));
		helper.getScreenshot(driver);
		System.out.println("Page Title: "+driver.getTitle());
//		Thread.sleep(5000);
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		
//		WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[@class='ot-sdk-container' and @role='alertdialog']")
//        ));
		logger.info("Accepting Cookies");
        // Locate the accept button within the cookie banner
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
        acceptButton.click();

        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//        Thread.sleep(2000);
//		WebElement cookieBanner = driver.findElement(By.xpath("//div[@class='ot-sdk-container' and @role='alertdialog']"));
//		driver.switchTo()
        js.executeScript("window.scrollTo(0,0);");
//		Thread.sleep(2000);
		
		WebElement btnCat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@style='z-index: 99999;']/button")));
		btnCat.click();
//		List<WebElement> catElements = driver.findElements(By.xpath("//div[@style='z-index: 99999;']/div[@role='menu']/button/label/div/div"));
		
//		WebElement catElelements1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style='z-index: 99999;']/div[@role='menu']/button/label/div/div")));
		WebElement catMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='menu' and parent::div[@style='z-index: 99999;']]")));
		
		List<WebElement> catMenuItems = catMenu.findElements(By.xpath("//div[@class='richtext_innerWrapper']"));
		
		int indexToSelect =1;
		
		if(indexToSelect>0 && indexToSelect<catMenuItems.size()) {
			WebElement itemToSelect = catMenuItems.get(indexToSelect);
//			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", itemToSelect);
//			Thread.sleep(3000);
			itemToSelect.click();
//			Thread.sleep(2000);
			System.out.println("Item Selected: "+itemToSelect.getText());
			logger.info("SoftAsserting the selected Category option");
			softAssert.assertEquals(excel.getStringData(0, 0, 0), itemToSelect.getText(), "Success/Failed");
			helper.getScreenshot(driver);
//			Assert.assertEquals(excel.getStringData(0, 0, 0), itemToSelect.getText(), "Success/Failed");
			boolean assertResult = excel.getStringData(0, 0, 0).equals(itemToSelect.getText());
			if(assertResult) {
				String result = "Test passed";
				System.out.println("The Testing Status: "+result);
//				assertTrue(assertResult, "The Test Passed");
//				excelWrite.writeData(0, 0, 2, result);
				excelWrite.writeDate(0, 0, 3, result);
			}
		}else {
			WebElement lastItem = catMenuItems.get(catMenuItems.size()-1);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", lastItem);
//			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(lastItem));
			lastItem.click();
//			Thread.sleep(2000);
			System.out.println("Last Item: "+lastItem.getText());
		}
		
		
//		Select select = new Select(cat);
//		
//		select.selectByValue(null)
//		List<WebElement> allOptions = select.getOptions();
//		for(WebElement ele: allOptions) {
			
//		}
		
		softAssert.assertAll();
		logger=extent.createTest("Execution Completed");
	}
	
	@AfterClass
	public void tearDown() {
		excel.close();
		driver.quit();
	}

}
