package javaexamples.cert.internationalizationlocalization.formatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

// Notes:
// 1. DateTimeFormatter is in a different package (java.time.format) to the other date and time objects (java.time)
// 2. ISO is a standard for dates.
// 3. There are 3 formatter types - ofLocalizedDate, OfLocalizedDateTime, ofLocalizedTime
//    --> Remember that if the calling object (LocalDate, LocalDateTime, ZonedDateTime, LocalTime) does not support
//        the DateTime type, a runtime exception will run.
// 4. There are two predefined formats that can show up on the exam: SHORT and MEDIUM.
// 5. You can have custom formatters. Valid symbols are:
//      - MMMM M represents the month. The more Ms you have, the more verbose the Java output. For
//        example, M outputs 1, MM outputs 01, MMM outputs Jan, and MMMM outputs January.
//      - dd d represents the day in the month. As with month, the more ds you have, the more verbose
//        the Java output. dd means to include the leading zero for a single-digit day.
//      - , Use , if you want to output a comma (this also appears after the year).
//      - yyyy y represents the year. yy outputs a two-digit year and yyyy outputs a four-digit year.
//      - hh h represents the hour. Use hh to include the leading zero if you’re outputting a single-digit hour.
//      - : Use : if you want to output a colon.
//      - mm m represents the minute omitting the leading zero if present. mm is more common and represents the
//        minutes using two digits.
// 6. Formatting is rougly equivalent to how it worked the old way using SimpleDateFormat.
public class FormattingDatesAndTimes {

    public static void main(String[] args) {
        formatterExample();
        predefinedFormatExamples();
        shortAndMediumExamples();
        customFormatExample();
        convertStringToDateOrTime();
    }

    private static void formatterExample() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));          // 2020-01-20
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));          // 11:12:34
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2020-01-20T11:12:34
    }

    private static void predefinedFormatExamples() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime.format(dateTime)); // 20/01/20
        System.out.println(shortDateTime.format(date));     // 20/01/20

        // Remember, time cannot be formatted as a date.
        // System.out.println(shortDateTime.format(time));  // UnsupportedTemporalTypeException: Unsupported field: DayOfMonth

        // The following produced the same output since both the formatter object and the DateTime objects support format
        System.out.println(dateTime.format(shortDateTime)); // 20/01/20
        System.out.println(date.format(shortDateTime));     // 20/01/20
        //System.out.println(time.format(shortDateTime));   // UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
    }

    private static void shortAndMediumExamples() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(shortF.format(dateTime));    // 20/01/20 11:12
        System.out.println(mediumF.format(dateTime));   // 20-Jan-2020 11:12:34
    }

    private static void customFormatExample() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f));         // January 20, 2020, 11:12
    }

    private static void convertStringToDateOrTime() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("01 02 2015", f);
        LocalTime time = LocalTime.parse("11:22");
        System.out.println(date);                       // 2015–01–02
        System.out.println(time);                       // 11:22
    }
}
