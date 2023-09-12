package base;

import common.DriverProvider;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.ModalPage;
import pages.StudentRegistrationFormPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Objects;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = DriverProvider.createDriver();
    protected StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    protected ModalPage modalPage = new ModalPage();
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("START TIME:" + LocalTime.now());
        LOGGER.info("Start clear reports dir: build/reports...");
        File allureResults = new File("allure-results");
        if (allureResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }
        if (Boolean.valueOf(System.getProperty("clear_reports_dir"))) {
            File allureScreenshots = new File("build/reports/tests/");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }
    }


    @AfterEach
    @Step("Очистка кэша")
    void clearCookiesAndLocalStorage() {
        if (Boolean.valueOf(System.getProperty("clear_cookies"))) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    @Step("Закрытие браузера")
    void close() {
        if (!Boolean.valueOf(System.getProperty("hold_browser_open"))) {
            driver.quit();
        }
    }
}