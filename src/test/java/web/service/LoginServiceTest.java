package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class LoginServiceTest {
    @Test
    public void testLoginSuccess() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Vortrox\\Documents\\Scripts\\msedgedriver_124.0.2477.0.exe");

        WebDriver driver = new EdgeDriver();
        System.out.println("Driver info: " + driver);

        // Full path where login.html is located.
        // You can click on html file and copy the path shown in your browser.
        driver.navigate().to(System.getProperty("user.dir") + "/pages/login.html");

        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("testuser");

        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("testpass");

        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("15062000");

        // Find Submit button, and click on button.
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        /*
         * On successful login, the title of page changes to 'success',
         * otherwise, 'fail'.
         */
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "success");

        driver.close();
    }
}
