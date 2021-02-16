package com.qa.starterproject.Selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;


@ActiveProfiles(profiles = "test")
@Sql(scripts = { "classpath:schema-test.sql",
"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageTest {

	
	private static RemoteWebDriver driver;
	private final String URL = "http://127.0.0.1:5500/HTML/Andi/Index.html"; 
	private static WebElement targ;

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

	@BeforeAll
	public static void beforeAll() {
		// system.property
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	@Order(1)
    public void createUserTest() throws InterruptedException {
		//given that I can access my todo web app
				driver.get(URL);
				
				//When: I navigate to create user tab 
				targ = driver.findElement(By.xpath("//*[@id=\"Content\"]/ul/li[2]/a")); 
				targ.click();
			
				
				//And: I create a user
				targ = driver.findElement(By.id("name"));
				targ.sendKeys("John");
				
				targ = driver.findElement(By.id("surname"));
				targ.sendKeys("Doe");
				
			
			    //And I click create:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/button"));
				targ.click();
				
				//And then I get output:
				targ = driver.findElement(By.xpath("//*[@id=\"status\"]/a"));
				String output = targ.getText();
				
				//Assertion: 
				assertEquals("Successfully Created, click here to go back", output);

				
			}
	
	@Test
	@Order(2)
    public void createTaskTest() throws InterruptedException {
		//given that I can access my todo web app
				driver.get(URL);
				
				//When: I navigate to create Task tab 
				targ = driver.findElement(By.xpath("/html/body/nav/div/ul/li[3]/a"));
				targ.click();
			
				
				//And: I create a task
				targ = driver.findElement(By.id("name"));
				targ.sendKeys("Groceries");
				
				//And: I append the task to a user
				targ = driver.findElement(By.id("userID"));
				targ.sendKeys("1");
				
			
			    //And I click create:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/button"));
				targ.click();
				
				//And then I get output:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[2]/a"));
				String output = targ.getText();
				
				//Assertion: 
				assertEquals("Task Successfully Created, click here to go back", output);

				
			}
	
	
	@Test
	@Order(3)
    public void ReadUserTest() throws InterruptedException {
		//given that I can access my todo web app
				driver.get(URL);
				
				//When: I navigate to the read user tab 
				targ = driver.findElement(By.xpath("/html/body/nav/div/ul/li[4]/a"));
				targ.click();
			
				
				//And: I enter a User ID
				targ = driver.findElement(By.id("newUserName"));
				targ.sendKeys("2");
				
				
			
			    //And I click read:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/button"));
				targ.click();
				
				//And then I get output:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[2]/p[1]"));
				String output = targ.getText();
				
				//Assertion: 
				assertEquals("Andi", output);

				
			}
	
	
	@Test
	@Order(4)
    public void UpdateUserTest() throws InterruptedException {
		//given that I can access my todo web app
				driver.get(URL);
				
				//When: I navigate to the update user tab 
				targ = driver.findElement(By.xpath("/html/body/nav/div/ul/li[5]/a"));
				targ.click();
			
				
				//And: I enter a User ID
				targ = driver.findElement(By.id("userID"));
				targ.sendKeys("1");
				
				
			
			    //And I enter a new user name:
				targ = driver.findElement(By.id("newUserName"));
				targ.sendKeys("Bob");
				
				//And I enter a new user surname:
				targ = driver.findElement(By.id("newUserSurname"));
				targ.sendKeys("Geldoff");
				
			    //And I click update:
							targ = driver.findElement(By.xpath("/html/body/div[1]/div/form/div/button"));
							targ.click();
				
				//And: I navigate to the home page user list:
							targ = driver.findElement(By.xpath("/html/body/div[2]/a"));
							targ.click();
				
				
				
				//And then I get output:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]"));
				String output = targ.getText();
				
				//Assertion: 
				assertEquals("Name: Bob", output);

				
			}
	
	
	@Test
	@Order(5)
    public void UpdateTaskTest() throws InterruptedException {
		//given that I can access my todo web app
				driver.get(URL);
				
				//When: I navigate to the update task tab 
				targ = driver.findElement(By.xpath("/html/body/nav/div/ul/li[6]/a"));
				targ.click();
			
				
				//And: I enter a User ID
				targ = driver.findElement(By.id("userID"));
				targ.sendKeys("2");
				
				
			
				//And: I enter a Task ID
				targ = driver.findElement(By.id("taskID"));
				targ.sendKeys("2");
				
				//And I enter a new task name:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div/form/div/input[3]"));
				targ.sendKeys("go for a run");
				
			    //And I click update:
							targ = driver.findElement(By.xpath("/html/body/div[1]/div/form/div/button"));
							targ.click();
				
				//And: I navigate to the home page user list:
							targ = driver.findElement(By.xpath("/html/body/div[2]/a"));
							targ.click();
				
				
				
				//And then I get output:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div/ul/ul[2]/li[2]"));
				String output = targ.getText();
				
				//Assertion: 
				assertEquals("Task Name: go for a run", output);

				
			}
	
	

	@Test
	@Order(6)
    public void DeleteTaskTest() throws InterruptedException {
		//given that I can access my todo web app
				driver.get(URL);
				
				//When: I navigate to the delete task tab 
				targ = driver.findElement(By.xpath("/html/body/nav/div/ul/li[8]/a"));
				targ.click();
			
				
				
				
			
				//And: I enter a Task ID
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/input"));
				targ.sendKeys("3");
				
			
				
			  //And I click delete:
							targ = driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/button"));
							targ.click();
				
				
				//And then I get output:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/a"));
				String output = targ.getText();
				
				//Assertion: 
				assertEquals("Successfully deleted, click here to go back", output);

				
			}
	
	
	@Test
	@Order(7)
    public void DeleteUserTest() throws InterruptedException {
		//given that I can access my todo web app
				driver.get(URL);
				
				//When: I navigate to the delete user tab 
				targ = driver.findElement(By.xpath("/html/body/nav/div/ul/li[7]/a"));
				targ.click();
			
				
				//And: I enter a User ID
				targ = driver.findElement(By.id("newUserName"));
				targ.sendKeys("3");
				
					
			  //And I click delete:
							targ = driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/button"));
							targ.click();
				
				
				//And then I get output:
				targ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/a"));
				String output = targ.getText();
				
				//Assertion: 
				assertEquals("Successfully deleted, click here to go back", output);

				
			}
	
	
	
	
	
		
	}
	

		