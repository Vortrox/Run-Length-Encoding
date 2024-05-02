package edu.deakin.sit333;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BunningsLoginForm {
    private static final String loginFormURL = "https://www.bunnings.com.au/login";

    private static WebDriver getEdgeDriver() {
        // todo: It may be worthwhile loading this property from something similar to an .env file in the future
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Vortrox\\Documents\\Scripts\\msedgedriver_124.0.2477.0.exe");
        return new EdgeDriver();
    }

    public static WebDriver login(String username, String password) {
        // todo: Consider Fast property of FIRST and re-use identified elements across tests
        WebDriver driver = getEdgeDriver();
        driver.get(loginFormURL);

        WebElement usernameTextBox = driver.findElement(By.id("okta-signin-username"));
        usernameTextBox.sendKeys(username);

        WebElement passwordTextBox = driver.findElement(By.id("okta-signin-password"));
        passwordTextBox.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        return driver;
    }
}
