package common;

import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (System.getProperty("browser")) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "MOZILLA":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("INCORRECT BROWSER NAME->" + System.getProperty("browser"));

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("implicit_wait")), TimeUnit.SECONDS);
        BasePage.setDriver(driver);
        return driver;
    }
}