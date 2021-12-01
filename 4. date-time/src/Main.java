import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2021, Month.AUGUST, 10, 8, 0);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC+4"));
        System.out.println("Текущие дата/время по Ульяновску: " + zonedDateTime);

        boolean is16thDay = zonedDateTime.getDayOfMonth() >= 16 && zonedDateTime.getHour() >= 8;
        int delta = is16thDay ? 0 : 1;

        System.out.println("Предыдущие месяца:");
        for (int i = 12 + delta; i > delta; i--) {
            LocalDate date = zonedDateTime.minusMonths(i).toLocalDate();
            System.out.println(date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                    + " " + date.getYear());
        }
    }
}
