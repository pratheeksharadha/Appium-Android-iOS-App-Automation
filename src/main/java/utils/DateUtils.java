package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final String TIMESTAMP_PATTERN =
            "yyyyMMdd_HHmmss";

    private DateUtils() {
    }

    /**
     * Get current date.
     */
    public static String getCurrentDate() {

        return LocalDate.now().toString();

    }

    /**
     * Get current time.
     */
    public static String getCurrentTime() {

        return LocalTime.now()
                .withNano(0)
                .toString();

    }

    /**
     * Get timestamp.
     */
    public static String getTimeStamp() {

        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN));

    }

    /**
     * Get date in custom format.
     *
     * @param pattern date format pattern
     * @return formatted date
     */
    public static String getFormattedDate(String pattern) {

        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(pattern));

    }
}
