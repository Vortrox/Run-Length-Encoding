package edu.deakin.sit333;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
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
	
	public static void openBrowserAndClose() {
		System.out.println("Fire up Edge browser.");
		WebDriver driver = getEdgeDriver();
		
		System.out.println("Driver info: " + driver);
		
		// Sleep a while
		sleep(5);
		
		/*
		 * We will use a lot of Selenium APIs here in future 
		 * including maximise window and open a URL in chromium browser.
		 */
		
		// close chrome driver. You can comment below line to keep the browser opened.
		driver.close();
		
	}

	public static void openBrowserMaximizeClose() {
		System.out.println("Fire up Edge browser.");
		WebDriver driver = getEdgeDriver();

		System.out.println("Driver info: " + driver);
		
		sleep(5);
		
		// Maximize chrome driver
		driver.manage().window().maximize();
		
		// Sleep a while
		sleep(5);
		
		// close chrome driver. You can comment below line to keep the browser opened.
		driver.close();
	}

	public static void loadWebPageClose() {
		System.out.println("Fire up Edge browser.");
		WebDriver driver = getEdgeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(5);
		
		// Open the URL in chromium browser.
		driver.get("https://selenium.dev");
		
		// Sleep a while
		sleep(5);
		
		// close chrome driver. You can comment below line to keep the browser opened.
		driver.close();	
	}
	
	/*
	 * You have to complete this function.
	 */
	public static void openBrowserLoadPageResizeClose() {
		// Fill your personal information.
		System.out.println("Hello from <Student ID>, <Full name>");

		System.out.println("Fire up Edge browser.");
		WebDriver driver = getEdgeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
		
		/*
		 * Load google page.
		 */
		// Write code here.
		
		/*
		 * Set window size manually to 640x480 and wait 2 second.
		 * Hint: Explore Selenium window functions to select one which allows to pass window size in WxH.
		 */
		// write code
		
		/*
		 * Double window size manually to 1280x960 and wait 2 second.		 
		 */
		// write code
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver. You can comment below line to keep the browser opened.
		driver.close();	
	}
}
