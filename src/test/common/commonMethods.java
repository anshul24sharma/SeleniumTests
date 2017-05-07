package test.common;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class commonMethods {
	
	public org.openqa.selenium.WebDriver StartBrowser()
	{	
//		if(readValueFromConfigProperties("os_type")=="mac")
//		{
//			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
//			System.setProperty("webdriver.chrome.driver", "chromedriver");
//		}
//		else if(readValueFromConfigProperties("os_type")=="windows")
//		{
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//		}
		// Setting Driver Path.
		
		final File file = new File(System.getProperty("user.dir") + "/drivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		// Starting driver.
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--kiosk");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Maximizing driver window.
		driver.manage().window().maximize();
		// Returning driver to method call.
		return driver;
	}
	
	public void navigateToSite(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	public String readValueFromConfigProperties(String key)
	{	File file;
		String value = null;
		try 
			{	
				
				file = new File(System.getProperty("user.dir")+ "/src/test/config/config.properties");
					
				FileInputStream fileInput = new FileInputStream(file);
				Properties properties = new Properties();
				properties.load(fileInput);
				fileInput.close();				
				value = properties.getProperty(key);			
				
			} 
		catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		catch (IOException e) 
			{
				e.printStackTrace();
			}
		
		return value;
		
	}
	
	public void waitUntilClickable(WebDriver driver,By elementLocator) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(readValueFromConfigProperties("wait")));
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
	}



	public void waitUntilVisible(WebDriver driver,By elementLocator)
	{		
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(readValueFromConfigProperties("wait")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}

	public void clickElement(WebDriver driver,By locator)
	{				

		driver.findElement(locator).click();
	}

	public void sendKeys(WebDriver driver,By locator, String value)
	{

		driver.findElement(locator).sendKeys(value);
	}

	 


}
