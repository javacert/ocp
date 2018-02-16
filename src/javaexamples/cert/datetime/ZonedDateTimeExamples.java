package javaexamples.cert.datetime;

import java.time.*;

public class ZonedDateTimeExamples {

    public static void main(String[] args) {
        basicExample();
        findCurrentZone();
        printAllZones();
    }

    private static void basicExample() {

        LocalDate date1 = LocalDate.of(2016, 1, 1);
        LocalTime time1 = LocalTime.of(3, 3, 3);
        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);

        ZoneId zone = ZoneId.of("US/Eastern");

        // These are the only 3 method signatures you need to know for the exam:
        ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20, 6, 15, 30, 200, zone);
        ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);

        System.out.println(zoned1); // 2015-01-20T06:15:30.000000200-05:00[US/Eastern]
        System.out.println(zoned2); // 2016-01-01T03:03:03-05:00[US/Eastern]
        System.out.println(zoned3); // 2016-01-01T03:03:03-05:00[US/Eastern]
    }

    private static void findCurrentZone() {
        System.out.println(ZoneId.systemDefault()); // Europe/London
    }

    private static void printAllZones() {

        ZoneId.getAvailableZoneIds().stream()
                .sorted().forEach(System.out::println);

        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("US") || z.contains("America"))
                .sorted().forEach(System.out::println);
    }
}
