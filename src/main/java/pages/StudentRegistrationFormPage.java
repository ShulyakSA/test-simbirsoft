package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.*;
import static common.DateConverter.*;

public class StudentRegistrationFormPage extends BasePage {

    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//*[@id='userEmail']")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id='genterWrapper']")
    private WebElement gender;
    @FindBy(xpath = "//*[@id='genterWrapper']//label[@for='gender-radio-1']")
    private WebElement genderMale;
    @FindBy(xpath = "//*[@id='genterWrapper']//label[@for='gender-radio-2']")
    private WebElement genderFemale;
    @FindBy(xpath = "//*[@id='genterWrapper']//label[@for='gender-radio-3']")
    private WebElement genderOther;
    @FindBy(xpath = "//*[@id='userNumber']")
    private WebElement mobileInput;
    @FindBy(xpath = "//*[@id='dateOfBirthInput']")
    private WebElement dateOfBirthInput;
    @FindBy(xpath = ".//select[@class='react-datepicker__month-select']")
    private WebElement dateOfBirthMonthSelect;
    @FindBy(xpath = ".//select[@class='react-datepicker__year-select']")
    private WebElement dateOfBirthYearSelect;
    @FindBy(css = "#subjectsInput")
    private WebElement subjectsInput;
    @FindBy(xpath = "//*[@id='uploadPicture']")
    private WebElement uploadPicture;
    @FindBy(xpath = "//*[@id='currentAddress']")
    private WebElement currentAddressInput;
    @FindBy(xpath = "//*[@id='react-select-3-input']")
    private WebElement stateSelect;
    @FindBy(xpath = "//*[@id='react-select-4-input']")
    private WebElement sitySelect;
    @FindBy(xpath = " //*[@id='submit']")
    private WebElement submitButton;


    public StudentRegistrationFormPage() {
        open(System.getProperty("url"));
        PageFactory.initElements(driver, this);
    }

    @Step("Ввести в поле 'First Name' значение '{userFirstName}'")
    public StudentRegistrationFormPage inputFirstName(String userFirstName) {
        input(firstName, userFirstName);
        return this;

    }

    @Step("Ввести в поле 'Last Name' значение '{userLastName}'")
    public StudentRegistrationFormPage inputLastName(String userLastName) {
        input(lastNameInput, userLastName);
        return this;
    }

    @Step("Ввести в поле 'Email' значение '{eMail}'")
    public StudentRegistrationFormPage inputEmail(String eMail) {
        input(emailInput, eMail);
        return this;

    }

    @Step("Ввести в поле 'Mobile' значение '{phone}'")
    public StudentRegistrationFormPage inputMobile(String phone) {
        input(mobileInput, phone);
        return this;
    }

    @Step("Ввести в поле 'Subjects' значение '{subjects}'")
    public StudentRegistrationFormPage inputSubjects(String... subjects) {
        for (String subject : subjects) inputWithEnter(subjectsInput, subject);
        return this;
    }

    @Step("Ввести в поле 'Current Address' значение '{adress}'")
    public StudentRegistrationFormPage inputCurrentAddress(String adress) {
        input(currentAddressInput, adress);
        return this;
    }

    @Step("Прикрепить файл '{pictureName}'")
    public StudentRegistrationFormPage uploadPicture(String pictureName) {
        inputFile(uploadPicture, pictureName);
        return this;
    }

    @Step("Из выпадающего списка  'Select State' выбрать '{state}'")
    public StudentRegistrationFormPage selectState(String state) {
        inputWithEnter(stateSelect, state);
        return this;
    }

    @Step("Из выпадающего списка  'Select Sity' выбрать '{sity}'")
    public StudentRegistrationFormPage selectSity(String sity) {
        inputWithEnter(sitySelect, sity);
        return this;
    }

    @Step("В поле 'Gender' выбрать радиобаттон '{gender}'")
    public StudentRegistrationFormPage radioGender(String gender) {
        if (gender == "Male") {
            clickWithWaiting(genderMale);
        } else if (gender == "Female") {
            clickWithWaiting(genderFemale);
        } else clickWithWaiting(genderOther);
        return this;
    }

    @Step("В поле 'Hobbies' выбрать чек-бокс '{hobbies}'")
    public StudentRegistrationFormPage checkBoxHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            driver.findElement(By.xpath(String.format("//label[text()='%s']", hobby))).click();
        }
        return this;
    }

    @Step("Нажать на кнопку 'Submit'")
    public StudentRegistrationFormPage buttonSubmit() {
        submitWithWaiting(submitButton);
        return this;
    }

    @Step("В поле 'Date of Birth' ввести дату 'birthDate', используя календарь")
    public StudentRegistrationFormPage inputBirthdate(String birthDate) {
        parseDateToCalendar(birthDate, "dd.MM.yyyy");
        clickWithWaiting(dateOfBirthInput);
        select(dateOfBirthYearSelect, getYear());
        select(dateOfBirthMonthSelect, getMonth());
        clickWithWaiting(driver.findElement(By.xpath(String.format(".//div[contains(@class, 'react-datepicker__day react-datepicker__day--0%s')]", getDay()))));
        return this;
    }
}
