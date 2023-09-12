package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import static base.BaseTest.LOGGER;

public class DateConverter {
    private static String day;
    private static String month;
    private static String year;

    public static void parseDateToCalendar(String stringDate, String inputPattern) throws DateTimeParseException {
        LocalDate date = null;
        try {
            date = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(inputPattern));
        } catch (DateTimeParseException e) {
            LOGGER.error("Некорректный формат даты. Введите дату в формате '" + inputPattern + "'");
            e.printStackTrace();
        }
        day = date.format(DateTimeFormatter.ofPattern("dd", Locale.ENGLISH));
        month = date.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
        year = date.format(DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH));
    }

    public static String getDay() {
        return day;
    }

    public static String getMonth() {
        return month;
    }

    public static String getYear() {
        return year;
    }
}
