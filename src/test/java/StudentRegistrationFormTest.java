import base.BaseTest;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest extends BaseTest {
    final String FIRST_NAME="Михаил";
    final String LAST_NAME="Тестов";
    final String EMAIL="test@test.ru";
    final String GENDER="Male";
    final String MOBILE="9111111111";
    final String BIRTH_DATE= "02.01.1988";
    final String SUBJECT_MATHS="Maths";
    final String SUBJECT_ENGLISH="English";
    final String HOBBIE_SPORTS="Sports";
    final String HOBBIE_READING="Reading";
    final String HOBBIE_MUSIC="Music";
    final String PICTURE="testPicture.png";
    final String CURRENT_ADDRESS="г.Кострома, проезд Студенческий проезд д.100 кв.708";
    final String STATE="Uttar Pradesh";
    final String SITY= "Lucknow";
    final String MODAL_TITLE ="Thanks for submitting the form";

    @Test
    @Owner("Shulyak S.A.")
    public void StudentRegistrationFormTest() {
        studentRegistrationFormPage
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputEmail(EMAIL)
                .radioGender(GENDER)
                .inputMobile(MOBILE)
                .inputBirthdate(BIRTH_DATE)
                .inputSubjects(SUBJECT_MATHS,SUBJECT_ENGLISH)
                .checkBoxHobbies(HOBBIE_SPORTS,HOBBIE_READING,HOBBIE_MUSIC)
                .uploadPicture(PICTURE)
                .inputCurrentAddress(CURRENT_ADDRESS)
                .selectState(STATE)
                .selectSity(SITY)
                .buttonSubmit();
        modalPage
                .checkModalTitle(MODAL_TITLE)
                .checkRowStudentName(FIRST_NAME+" "+LAST_NAME)
                .checkRowStudentEmail(EMAIL)
                .checkRowGender(GENDER)
                .checkRowMobile(MOBILE)
                .checkRowDateOfBirth(BIRTH_DATE)
                .checkRowSubjects(SUBJECT_MATHS+", "+SUBJECT_ENGLISH)
                .checkRowHobbies(HOBBIE_SPORTS+", "+HOBBIE_READING+", "+HOBBIE_MUSIC)
                .checkRowPicture(PICTURE)
                .checkRowAddress(CURRENT_ADDRESS)
                .checkRowStateAndCity(STATE+" "+SITY);


    }


}
