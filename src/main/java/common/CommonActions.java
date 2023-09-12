package common;

import base.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.openqa.selenium.Keys.ENTER;

public class CommonActions extends BasePage {
    @Step("Открыть страницу {url}")
    public static void open(String url) {
        driver.get(url);
    }

    @Step("Ввод значения '{value}'")
    public static void input(WebElement element, String value) {
        waitElementIsVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    @Step("Ввод значения '{value}'")
    public static void inputWithEnter(WebElement element, String value) {
        waitElementIsVisible(element);
        element.clear();
        element.sendKeys(value);
        waitElementIsVisible(element);
        element.sendKeys(ENTER);

    }

    @Step("Нажатие на элемент '{element}'")
    public static void clickWithWaiting(WebElement element) {
        waitElementIsClickable(element);
        element.click();
    }

    @Step("Нажатие на элемент '{element}'")
    public static void submitWithWaiting(WebElement element) {
        waitElementIsVisible(element);
        element.submit();
    }

    @Step("Загрузка файла '{value}'")
    public static void inputFile(WebElement element, String value) {
        String absPath = new File("src/test/resources/" + value).getAbsolutePath();
        waitElementIsVisible(element);
        element.sendKeys(absPath);
    }

    @Step("Из выпадающего списка выбрать '{value}'")
    public static void select(WebElement element, String value) {
        waitElementIsVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    @Step("Строка таблицы: '{label}', Ожидаемый результат: '{value}'")
    public static void checkTableRow(WebElement element, String label, String value) {
        waitElementIsVisible(element);
        WebElement rowKey = (element.findElement(By.xpath(String.format("./tr/td[contains(text(),'%s')]", label))));
        String rowValue = rowKey.findElement(By.xpath("./following::td")).getText();
        Assertions.assertEquals(value, rowValue);
        LOGGER.info("PASSED\nExpected: " + value + "\nActual  : " + rowValue);
    }

}
