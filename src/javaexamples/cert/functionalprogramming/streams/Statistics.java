package javaexamples.cert.functionalprogramming.streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

// Notes
// 1. Both min() and max() are terminal operations, meaning they use up the stream when run.
//    This means if we wanted to find the range for example, we couldn't first calculate the
//    max() and then the min() and find the difference on the same stream --> Statistics is the solution!
public class Statistics {

    public static void main(String[] args){
        optionalEmptyExample();
        calculatingRangeExample();
    }

    private static void optionalEmptyExample() {
        IntStream ints = IntStream.of(1, 2, 3);
        OptionalInt optional = ints.max();
        System.out.println(optional.orElseThrow(RuntimeException::new)); // 3

        IntStream moreInts = IntStream.of();
        OptionalInt anotherOptional = moreInts.max(); // We get an OptionalInt because we have an int stream.
        // System.out.println(anotherOptional.orElseThrow(RuntimeException::new)); //Exception in thread "main" java.lang.RuntimeException
    }

    private static void calculatingRangeExample() {
        IntStream ints = IntStream.of(1, 2, 3);
        IntSummaryStatistics stats = ints.summaryStatistics();
        if(stats.getCount() == 0) throw new RuntimeException();
        System.out.println(stats.getMax() - stats.getMin()); // 2
    }
}
