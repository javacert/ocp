package javaexamples.cert.datetime;

import java.time.*;

public class DayLightSavingsExamples {

    public static void main(String[] args) {
        springForwardExample();
        fallBackExample();
        nonExistentDaylightSavingsTime();
    }

    private static void springForwardExample() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);

        System.out.println(dateTime);       // 2016-03-13T01:30-05:00[US/Eastern]

        dateTime = dateTime.plusHours(1);   // Observe that for this edge case, 2 hours is added to the time to account for Daylight Savings

        System.out.println(dateTime);       // 2016-03-13T03:30-04:00[US/Eastern] *** The offset also changes from -05:00 to -04:00
    }

    private static void fallBackExample() {
        LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);

        System.out.println(dateTime);       // 2016-11-06T01:30-04:00[US/Eastern]

        dateTime = dateTime.plusHours(1);   // Observe that for this edge case, the time stays the same to account for Daylight Savings

        System.out.println(dateTime);       // 2016-11-06T01:30-05:00[US/Eastern] *** Time stays the same, but the offset changes from -04:00 to -05:00

        dateTime = dateTime.plusHours(1);

        System.out.println(dateTime);       // 2016-11-06T02:30-05:00[US/Eastern] *** Since the offset has been changed, time is moved forward by 1 hour.
    }

    private static void nonExistentDaylightSavingsTime() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(2, 30); // Set it to a non-existent time in the Day Light Savings world.
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);

        // Here, since there is no 2.30 at this time, Java automatically bumps the hour forward.
        System.out.println(dateTime);       // 2016-03-13T03:30-04:00[US/Eastern]
    }
}
