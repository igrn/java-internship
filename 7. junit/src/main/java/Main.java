import java.time.*;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = getZonedDateTime(2021, Month.AUGUST, 10,
                8, 0, ZoneId.of("UTC"));

        System.out.println("Текущие дата/время: " + zonedDateTime);
        System.out.println("Предыдущие месяцы:");

        List<LocalDate> dates = getPreviousDates(zonedDateTime);
        dates.forEach(date -> System.out.println(
                date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                + " " + date.getYear())
        );
    }

    public static List<LocalDate> getPreviousDates(ZonedDateTime zonedDateTime) {
        boolean is16thDayOfMonth = zonedDateTime.getDayOfMonth() >= 16
                && zonedDateTime.getHour() >= 4;
        int lastMonthAdjustment = is16thDayOfMonth ? 0 : 1;

        List<LocalDate> dates = new ArrayList<>();
        for (int i = 12 + lastMonthAdjustment; i > lastMonthAdjustment; i--) {
            dates.add(zonedDateTime.minusMonths(i).toLocalDate());
        }
        return dates;
    }

    public static ZonedDateTime getZonedDateTime(int year, Month month, int day,
                                                  int hour, int minute, ZoneId timezone) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
        return ZonedDateTime.of(localDateTime, timezone);
    }
}
