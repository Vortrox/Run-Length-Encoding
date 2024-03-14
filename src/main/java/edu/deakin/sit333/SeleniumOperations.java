package edu.deakin.sit333;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {
	private static WebDriver getEdgeDriver() {
		// todo: It may be worthwhile loading this property from something similar to an .env file in the future
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Vortrox\\Documents\\Scripts\\msedgedriver_122.0.2365.66.exe");
		return new EdgeDriver();
	}

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void officeworksRegistrationPage(String url) {
		System.out.println("Fire up Edge browser.");
		WebDriver driver = getEdgeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in Edge browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Ahsan");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		
		
		// Sleep a while
		sleep(2);
		
		// close driver
		driver.close();	
	}
}
