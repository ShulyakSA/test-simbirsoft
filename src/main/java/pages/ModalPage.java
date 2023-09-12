package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.checkTableRow;
import static common.DateConverter.*;

public class ModalPage extends BasePage {
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement modalTitle;
    @FindBy(xpath = "//table/tbody")
    private WebElement modalTableBody;
    @FindBy(xpath = "//table/thead")
    private WebElement modalTablehead;

    public ModalPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Проверить заголовок модального окна. Ожидаемый результат: '{text}'")
    public ModalPage checkModalTitle(String text) {
        waitElementIsVisible(modalTitle);
        String textContent = modalTitle.getAttribute("textContent");
        Assertions.assertEquals(text, textContent);
        LOGGER.info("PASSED\nExpected: " + text + "\nActual  : " + textContent);
        return this;
    }

    @Step("Проверить строку таблицы 'Student Name'")
    public ModalPage checkRowStudentName(String value) {
        checkTableRow(modalTableBody, "Student Name", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Student Email'")
    public ModalPage checkRowStudentEmail(String value) {
        checkTableRow(modalTableBody, "Student Email", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Gender'")
    public ModalPage checkRowGender(String value) {
        checkTableRow(modalTableBody, "Gender", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Mobile'")
    public ModalPage checkRowMobile(String value) {
        checkTableRow(modalTableBody, "Mobile", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Date of Birth'")
    public ModalPage checkRowDateOfBirth(String birthDate) {
        parseDateToCalendar(birthDate, "dd.MM.yyyy");
        String value = getDay() + " " + getMonth() + "," + getYear();
        checkTableRow(modalTableBody, "Date of Birth", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Subjects'")
    public ModalPage checkRowSubjects(String value) {
        checkTableRow(modalTableBody, "Subjects", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Hobbies'")
    public ModalPage checkRowHobbies(String value) {
        checkTableRow(modalTableBody, "Hobbies", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Picture'")
    public ModalPage checkRowPicture(String value) {
        checkTableRow(modalTableBody, "Picture", value);
        return this;
    }

    @Step("Проверить строку таблицы 'Address'")
    public ModalPage checkRowAddress(String value) {
        checkTableRow(modalTableBody, "Address", value);
        return this;
    }

    @Step("Проверить строку таблицы 'State and City'")
    public ModalPage checkRowStateAndCity(String value) {
        checkTableRow(modalTableBody, "State and City", value);
        return this;
    }
}
