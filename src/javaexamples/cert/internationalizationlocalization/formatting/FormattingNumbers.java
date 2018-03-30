package javaexamples.cert.internationalizationlocalization.formatting;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// Notes:
// 1. The format classes are not thread safe - do not store them in instance variables or static variables.
// 2. If you see parsing logic inside a method, make sure that ParseException or Exception is handled or declared.
// 3. The return value of parse is a Number object. Number is the parent class of all the java.lang wrapper classes, so
//    the return value can be cast to its appropriate data type. The Number is cast to a Double and then automatically unboxed into a double.
public class FormattingNumbers {
    private final static Locale locale = new Locale("en", "GB");

    public static void main(String[] args) {
        generalPurposeFormatter();
        numberFormatter();
        currencyFormatter();
        percentFormatter();
        integerFormatter();

        try {
            parseNumberExample();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            parseCurrencyExample();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void generalPurposeFormatter() {
        NumberFormat.getInstance();
        NumberFormat.getInstance(locale);

        NumberFormat us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(3_200_000));
        NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(g.format(3_200_000));
        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(3_200_000));

        // 3,200,000
        // 3.200.000
        // 3 200 000
    }

    private static void numberFormatter() {
        NumberFormat.getNumberInstance();
        NumberFormat.getNumberInstance(locale);
    }

    private static void currencyFormatter() {
        NumberFormat.getCurrencyInstance();
        NumberFormat.getCurrencyInstance(locale);

        double price = 48; // Should really use BigDecimal here!
        NumberFormat us = NumberFormat.getCurrencyInstance();
        System.out.println(us.format(price)); // £48.00
    }

    private static void percentFormatter() {
        NumberFormat.getPercentInstance();
        NumberFormat.getPercentInstance(locale);
    }

    private static void integerFormatter() {
        NumberFormat.getIntegerInstance();
        NumberFormat.getIntegerInstance(locale);
    }

    private static void parseNumberExample() throws ParseException { // Must throw or catch ParseException or Exception
        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);

        String s = "40.45";
        System.out.println(en.parse(s)); // 40.45
        System.out.println(fr.parse(s)); // 40 - France does not use the decimal point to separate numbers!

        // The parse method parses only the beginning of a string. After it reaches a character that
        // cannot be parsed, the parsing stops and the value is returned.

        NumberFormat nf = NumberFormat.getInstance();
        String one = "456abc";
        String two = "-2.5165x10";
        String three = "x85.3";
        System.out.println(nf.parse(one)); // 456
        System.out.println(nf.parse(two)); // -2.5165
        // System.out.println(nf.parse(three)); // throws ParseException since no numbers at the beginning of the String
    }

    private static void parseCurrencyExample() throws ParseException {
        String amt = "£92,807.99"; // If this started with a dollar, it would throw a ParseException since locale is en_GB
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        double value = (Double) cf.parse(amt);
        System.out.println(value); // 92807.99
    }
}
