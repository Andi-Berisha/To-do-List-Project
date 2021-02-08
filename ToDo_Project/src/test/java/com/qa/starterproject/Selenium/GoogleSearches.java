package com.qa.starterproject.Selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleSearches {

	private static RemoteWebDriver driver;
	private static WebElement targ;
	private final String URL = "http://www.google.com";
	
	
	@BeforeAll
	public static void beforeAll() {
		// we need system properties
		// we need a driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver(chromeCfg());
        
	
	}

	@AfterAll
	public static void afterAll() {
		//closes the Chrome driver/
		driver.quit();
	}

	@Test
	public void googleKittens() throws InterruptedException {
		
		//given that I can access Google.com
		driver.get(URL);
		
		//When: I search kittens using the search bar 
	targ = driver.findElement(By.name("q"));
	targ.sendKeys("Kittens");
	targ.submit();
		
		//Then: I should get results of kittens
	
	     String result = driver.getTitle();
		
		//Assertion: 
	     assertEquals("Kittens - Google Search", result);

		Thread.sleep(10000);
	}
	
	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
	public static ChromeOptions chromeCfg() {
	 Map<String, Object> prefs = new HashMap<String, Object>();
	 ChromeOptions cOptions = new ChromeOptions();
	  
	 // Settings
	 prefs.put("profile.default_content_setting_values.cookies", 2);
	 prefs.put("network.cookie.cookieBehavior", 2);
	 prefs.put("profile.block_third_party_cookies", true);

	 // Create ChromeOptions to disable Cookies pop-up
	 cOptions.setExperimentalOption("prefs", prefs);

	 return cOptions;
	 }
}
