package com.assaaboly.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class helper {
//
//	public static void main(String[] args) {
//
//	}
	
	public static String getScreenshot(WebDriver driver) {
//		driver = new FirefoxDriver();
		if(driver==null) {
			throw new IllegalArgumentException("Driver cannot be null");
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String screenshotPath = Paths.get("Screenshots", "TestScreenshot"+getCurrentDateAndTime()+".png").toString();
		
		try {
			FileUtils.copyFile(src, new File(screenshotPath));
		}catch(IOException e) {
			System.out.println("Exception: "+e);
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateAndTime() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mm_ss");
		LocalDateTime CurrentDateTime = LocalDateTime.now();
		
		return CurrentDateTime.format(formatter);
		
	}
	
	// Method to delete existing screenshots
    public static void deleteExistingScreenshots() {
        File screenshotsDir = new File("Screenshots");
        if (screenshotsDir.exists() && screenshotsDir.isDirectory()) {
            File[] files = screenshotsDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.delete()) {
                            System.out.println("Deleted: " + file.getName());
                        } else {
                            System.out.println("Failed to delete: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Screenshots directory does not exist.");
        }
    }

}
