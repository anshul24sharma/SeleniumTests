package test.testCases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import test.common.commonMethods;

public class SeleniumTest4 {	
	
	commonMethods cmethods = new commonMethods();
	@Test
	public void javaScriptTest() {

//		System.setProperty("webdriver.chrome.driver",
//				"/Users/optimus103.OPTIMUSDOM/Downloads/chromedriver.exe");
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("window-size=1024,768");
//
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		WebDriver driver = new ChromeDriver(capabilities);
		
		WebDriver driver = cmethods.StartBrowser();
		driver.get("http://www.optimusinfo.com/contact-us/");


		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement message_box = driver.findElement(By.id("avia_message_1"));
		message_box.sendKeys("This is a test message");		
		String enteredTextMessage = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",message_box);	
		System.out.println("Entered Text Message is " + enteredTextMessage);
		
		jse.executeScript("document.getElementById('avia_message_1').value = 'Changed Text Message';");	
		
		
		driver.close();

	}

	

}