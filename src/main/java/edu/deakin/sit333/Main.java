package edu.deakin.sit333;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.edge.driver",
                "C:\\Users\\Vortrox\\Documents\\Scripts\\msedgedriver_122.0.2365.66.exe");

        WebDriver driver = new EdgeDriver();
        System.out.println(driver);

        driver.get("https://www.google.com");

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}