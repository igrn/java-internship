import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

class MainTest {
    int year = 2021, minute = 0;
    Month month = Month.AUGUST;
    ZoneId timezone = ZoneId.of("UTC");

    @Test
    @DisplayName("Проверяет список дат, получаемый до 16-го числа и 4-х утра по UTC")
    void checkBefore16thDayAnd4AM() {
        int day = 10, hour = 3;
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, timezone);

        List<LocalDate> expectedDates = new ArrayList<>();
        for (int i = 13; i > 1; i--) {
            expectedDates.add(LocalDate.of(year, month, day).minusMonths(i));
        }
        List<LocalDate> actualDates = Main.getPreviousDates(zonedDateTime);
        Assertions.assertIterableEquals(expectedDates, actualDates);
    }

    @Test
    @DisplayName("Проверяет список дат, получаемый после 16-го числа и 4-х утра по UTC")
    void checkAfter16thDayAnd4AM() {
        int day = 18, hour = 9;
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, timezone);

        List<LocalDate> expectedDates = new ArrayList<>();
        for (int i = 12; i > 0; i--) {
            expectedDates.add(LocalDate.of(year, month, day).minusMonths(i));
        }
        List<LocalDate> actualDates = Main.getPreviousDates(zonedDateTime);
        Assertions.assertIterableEquals(expectedDates, actualDates);
    }

    @Test
    @DisplayName("Проверяет список дат, получаемый строго в 4 утра 16-го числа по UTC")
    void checkAt16thDayAnd4AM() {
        int day = 16, hour = 4;
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, timezone);

        List<LocalDate> expectedDates = new ArrayList<>();
        for (int i = 12; i > 0; i--) {
            expectedDates.add(LocalDate.of(year, month, day).minusMonths(i));
        }
        List<LocalDate> actualDates = Main.getPreviousDates(zonedDateTime);
        Assertions.assertIterableEquals(expectedDates, actualDates);
    }

    @Test
    @DisplayName("Проверяет, что метод возвращает правильную дату/время с временной зоной")
    void testGetZonedDateTime() {
        int day = 10, hour = 8;
        LocalDateTime expectedLocal = LocalDateTime.of(year, month, day, hour, minute);
        ZonedDateTime expected = ZonedDateTime.of(expectedLocal, timezone);
        ZonedDateTime actual = Main.getZonedDateTime(year, month, day, hour, minute, timezone);
        Assertions.assertEquals(expected, actual);
    }
}
