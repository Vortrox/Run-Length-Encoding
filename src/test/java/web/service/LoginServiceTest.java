package web.service;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class LoginServiceTest {
    private static WebDriver driver;
    @BeforeClass
    public static void createDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Vortrox\\Documents\\Scripts\\msedgedriver_124.0.2477.0.exe");

        driver = new EdgeDriver();
        System.out.println("Driver info: " + driver);
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Before
    public void resetLoginForm() {
        driver.navigate().to(System.getProperty("user.dir") + "/pages/login.html");
    }

    @Test
    public void testLoginSuccess() {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("testuser");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("testpass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("15062000");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "success");
    }

    @Test
    public void testFailIncorrectUsername() {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("aaa");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("testpass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("15062000");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");
    }

    @Test
    public void testFailIncorrectPassword() {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("testuser");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("aaa");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("15062000");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");
    }

    @Test
    public void testFailIncorrectDOB() {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("testuser");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("testpass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("00000000");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");
    }

    @Test
    public void testFailBlankUsername() {
        WebElement ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("testpass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("15062000");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");
    }

    @Test
    public void testFailBlankPassword() {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("testuser");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("15062000");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");
    }

    @Test
    public void testFailBlankDOB() {
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("testuser");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("testpass");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "fail");
    }
}
