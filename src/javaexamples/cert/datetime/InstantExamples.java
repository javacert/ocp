package javaexamples.cert.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

// Notes:
// 1) You cannot convert a LocalDateTime to an Instant - remember that an Instant represents a point in time and
//    LocalDateTime does not have a zone associated with it, and therefore you could not get an Instant which reflects the
//    same moment of time around the world.
public class InstantExamples {

    public static void main(String[] args) {
        basicExamples();
        convertZonedDateTimeToInstant();
        epochTimeToInstant();
        addingToInstant();
    }

    private static void basicExamples() {
        Instant now = Instant.now();
        for(int x = 0; x < 999999; x++){}
        Instant later = Instant.now();

        Duration duration = Duration.between(now, later);
        System.out.println(duration.toMillis()); // 2
    }

    private static void convertZonedDateTimeToInstant() {
        LocalDate date = LocalDate.of(2015, 5, 25);
        LocalTime time = LocalTime.of(11, 55, 00);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);

        Instant instant = zonedDateTime.toInstant();
        System.out.println(zonedDateTime);              // 2015-05-25T11:55-04:00[US/Eastern]
        System.out.println(instant);                    // 2015-05-25T15:55:00Z

        // Notes on this:
        // The last 2 lines represent the same moment in time.
        // The ZonedDateTime includes a time-zone, whereas the instant reflects the GMT time zone, so you see a difference in the time.
    }

    private static void epochTimeToInstant() {
        LocalDateTime dateTime = LocalDateTime.of(2015, 5, 25, 10, 10, 10);
        Instant instant = Instant.ofEpochSecond(dateTime.toEpochSecond(ZoneOffset.UTC));
        System.out.println(instant);    // 2015-05-25T10:10:10Z
    }

    private static void addingToInstant() {
        Instant instant = ZonedDateTime.now().toInstant();
        Instant nextHour = instant.plus(1, ChronoUnit.DAYS);
        System.out.println(nextHour); // 2018-02-24T15:44:49.078Z (date was 23rd when run)

        // You can only add DAYS, HOURS and WEEKS - although you can see the Years & Months, you cannot manipulate them (Exception thrown)
        Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS);
        System.out.println(nextHour); // UnsupportedTemporalTypeException: Unsupported unit: Weeks
    }
}
