package edu.deakin.sit333;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileOutputStream;
import java.io.IOException;

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
		System.out.println("First name element: " + element);
		// Send first name
		element.sendKeys("Vortrox");

		/*
		 * Find following input fields and populate with values
		 */
		// todo: Fill with real info before submitting. Do not commit.
		element = driver.findElement(By.id("lastname"));
		System.out.println("Last name element: " + element);
		element.sendKeys("117");

		element = driver.findElement(By.id("phoneNumber"));
		System.out.println("Phone number element: " + element);
		element.sendKeys("04--------");

		element = driver.findElement(By.id("email"));
		System.out.println("Email element: " + element);
		element.sendKeys("vortrox117@gmail.com");

		String password = "12345";
		element = driver.findElement(By.id("password"));
		System.out.println("Password element: " + element);
		element.sendKeys(password);

		element = driver.findElement(By.id("confirmPassword"));
		System.out.println("Confirm password element: " + element);
		element.sendKeys(password);
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		element = driver.findElement(By.xpath("//*[text()='Create account']"));
		System.out.println("Create account element: " + element);
		element.click();

		/*
		 * Take screenshot using selenium API.
		 */
		try {
			FileOutputStream outputStream = new FileOutputStream("screenshot.png");
			byte[] screenshotData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			outputStream.write(screenshotData);
			outputStream.close();
		} catch (IOException ignore) {

		}

		// Sleep a while
		sleep(2);
		
		// close driver
		driver.close();	
	}
}
