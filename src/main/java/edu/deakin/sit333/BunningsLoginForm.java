package edu.deakin.sit333;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BunningsLoginForm {
    private static final String loginFormURL = "https://www.bunnings.com.au/login";
    private final WebDriver driver;
    private final WebElement usernameTextBox;
    private final WebElement passwordTextBox;
    private final WebElement signInButton;

    private static WebDriver getEdgeDriver() {
        // todo: It may be worthwhile loading this property from something similar to an .env file in the future
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Vortrox\\Documents\\Scripts\\msedgedriver_124.0.2477.0.exe");
        return new EdgeDriver();
    }

    public BunningsLoginForm() {
        // todo: Consider Fast property of FIRST and re-use identified elements across tests
        driver = getEdgeDriver();
        driver.get(loginFormURL);

        usernameTextBox = driver.findElement(By.id("okta-signin-username"));
        passwordTextBox = driver.findElement(By.id("okta-signin-password"));
        signInButton = driver.findElement(By.id("okta-signin-submit"));
    }

    public void login(String username, String password) {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        signInButton.click();
    }

    public boolean loginSuccessful() {
        String signOutButtonXPath = "//*[@id=\"toobar-container\"]/div/div/div/div/div[2]/ul/li[9]/a";
        // Login is successful if Selenium can locate the "Sign Out" button
        return !driver.findElements(By.xpath(signOutButtonXPath)).isEmpty();
    }

    public void close() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
