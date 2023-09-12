package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("explicit_wait")))).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("explicit_wait")))).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

}
