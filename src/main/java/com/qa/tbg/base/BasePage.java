package com.qa.tbg.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import TBG.Collaterate.Utils.Log;
import TBG.Collaterate.Utils.ReadYamlConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	

		public WebDriver driver;
		public static String browserName;
		
		 
		public WebDriver init_driver() {
			browserName= ReadYamlConfig.getbrowser();
			Log.info(browserName);
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
			    driver= new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				
			} else {
				Log.info(browserName + " is not found, please pass the right browser Name");
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(ReadYamlConfig.geturl());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;

		}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
		
}
