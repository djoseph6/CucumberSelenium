package util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import seleniumtests.PageInitalizer;

public class CommonMethods extends PageInitalizer{
	
	public static WebDriver driver;
	
	public static void openBrowserAndNavigateToURL() {
		ConfigReader.readProperties(Constants.CONFIG_READER_PATH);
		switch(ConfigReader.getPropertyValue("browser")) {
			case "chrome" : driver = new ChromeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
		}
		driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //this method is going to initialize all the objects available inside this method
        initializePageObjects();	
		
	}
	
	 public static void closeBrowser() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    public static void sendText(String text, WebElement element) {
	        element.clear();
	        element.sendKeys(text);
	    }

	    public static WebDriverWait getWait(){
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait;
	    }

	    public static void waitForClickability(WebElement element){
	        getWait().until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public static void click(WebElement element){
	            waitForClickability(element);
	            element.click();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }


	    public static void selectFromDropdown(WebElement dropDown, String visibleText) {
	        Select sel = new Select(dropDown);
	        sel.selectByVisibleText(visibleText);
	    }

	    public static void selectFromDropdown(String value, WebElement dropDown) {
	        Select sel = new Select(dropDown);
	        sel.selectByValue(value);
	    }

	    public static void selectFromDropdown(WebElement dropDown, int index) {
	        Select sel = new Select(dropDown);
	        sel.selectByIndex(index);
	    }
	    
	    public static byte[] takeScreenShot(String fileName) {
	    	TakesScreenshot ts = (TakesScreenshot) driver;
	    	byte[] screenShot = ts.getScreenshotAs(OutputType.BYTES);
	    	File screenShot1 = ts.getScreenshotAs(OutputType.FILE);
	    	try{
	            FileUtils.copyFile(screenShot1,
	                    new File(Constants.SCREENSHOT_FILEPATH + fileName+" "
	                            +getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	    	return screenShot;
	    }
	    
	    public static String getTimeStamp(String pattern){
            //it returns the current date and time in java
            Date date = new Date();
            //this function sdf used to format the date as per the pattern we are passing
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            //this line is going to return the formatted date
            return sdf.format(date);
    }
	    
	 
}
