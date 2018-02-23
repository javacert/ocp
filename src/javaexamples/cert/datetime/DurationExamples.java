package javaexamples.cert.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

// Notes:
// Duration works om a similar way to Period, except it is used with objects which have time (Period has Years, Months, Weeks, Days)
// A Period is output using a P, whereas Duration is output using a PT (Period Time)
// A Duration is stored in hours, minutes, and seconds (includes fractional seconds)
public class DurationExamples {

    public static void main(String[] args){

        basicExamples();
        temporalUnitExamples();
        chronoUnitsForTimeDifference();
        periodAndDurationNotEquivalent();
    }

    private static void basicExamples() {
        Duration daily = Duration.ofDays(1);                // PT24H
        Duration hourly = Duration.ofHours(1);              // PT1H
        Duration everyMinute = Duration.ofMinutes(1);       // PT1M
        Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S
        Duration everyMilli = Duration.ofMillis(1);         // PT0.001S
        Duration everyNano = Duration.ofNanos(1);           // PT0.000000001S
    }

    private static void temporalUnitExamples() {
        Duration daily = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly = Duration.of(1, ChronoUnit.HOURS);
        Duration everyMinute = Duration.of(1, ChronoUnit.MINUTES);
        Duration everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
        Duration everyMilli = Duration.of(1, ChronoUnit.MILLIS);
        Duration everyNano = Duration.of(1, ChronoUnit.NANOS);
    }

    private static void chronoUnitsForTimeDifference() {
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate date = LocalDate.of(2016, 1, 20);

        System.out.println(ChronoUnit.HOURS.between(one, two));     // 1 (truncates rather than rounds)
        System.out.println(ChronoUnit.MINUTES.between(one, two));   // 75
        // System.out.println(ChronoUnit.MINUTES.between(one, date));  // DateTimeException - can't mix time with date
    }

    private static void periodAndDurationNotEquivalent() {
        LocalDate date = LocalDate.of(2015, 5, 25);
        Period period = Period.ofDays(1);
        Duration days = Duration.ofDays(1);

        System.out.println(date.plus(period));  // 2015-05-26
        System.out.println(date.plus(days));    // UnsupportedTemporalTypeException: Unsupported unit: Seconds
    }
}
