package javaexamples.cert.functionalprogramming.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// Notes:
// 1. Intermediate streams deal with an infinite stream simply by returning an infinite stream.
public class StreamsCommonIntermediateOperations {

    public static void main(String[] args) {
        filterExamples();
        distinctExamples();
        limitSkipExamples();
        mapExamples();
        flatMapExamples();
        sortedExamples();
        peekExamples();
    }

    private static void filterExamples() {
        // Returns a stream with elements that match a given expression

        Stream<String> s = Stream.of("a", "b", "c");
        s.filter(x -> x.startsWith("a")).forEach(System.out::println); // a
    }

    private static void distinctExamples() {
        // Returns a stream with duplicate values removed
        // It uses .equals() to determine which objects are the same.

        Stream<String> s = Stream.of("a", "b", "b");
        s.distinct().forEach(System.out::println); // a b
    }

    private static void limitSkipExamples() {
        // Both limit and skip make a stream smaller

        Stream<Integer> s = Stream.iterate(1, n -> n + 1);
        // Skip the first 5 elements and limit output to 2 elements.
        s.skip(5).limit(2).forEach(System.out::println); // 6 7
    }

    private static void mapExamples() {
        // Creates a one-to-one mapping from elements in the stream to the elements in the next step of the stream.

        Stream<String> s = Stream.of("a", "b", "cd");
        s.map(String::length).forEach(System.out::println); // 1 1 2
    }

    private static void flatMapExamples() {
        // The flatMap() takes each element in the stream and makes any elements it contains top-level elements in a single stream.
        // Useful when you want to remove empty elements from a stream or to combine a stream of lists.

        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("a");
        List<String> two = Arrays.asList("b", "c");
        Stream<List<String>> together = Stream.of(zero, one, two);

        // Remember List::stream the same as l -> l.stream()
        together.flatMap(List::stream).forEach(System.out::println); // a b c
        // Note in the above the empty list is removed completely and the others are combined to one list (elements at top-level of stream)

    }

    private static void sortedExamples() {
        // Returns a stream with the elements sorted.
        // It uses the natural ordering unless we specify a comparator (like arrays)

        Stream<String> s = Stream.of("c", "b", "a");
        s.sorted().forEach(System.out::println); // a b c

        Stream<String> s2 = Stream.of("c", "b", "a");
        // Note in the following we cannot use a method reference for reverseOrder since calling reverse order returns a Comparator instance
        s2.sorted(Comparator.reverseOrder()).forEach(System.out::println); // c b a
        // s2.sorted(Comparator::reverseOrder).forEach(System.out::println); // cannot convert java.util.Comparator to int
    }

    private static void peekExamples() {
        // peek() allows you to perform a stream operation without actually changing the stream - therefore useful for debugging.
        // You can potentially modify streams using peek, but it is considered bad practice.

        Stream<String> stream = Stream.of("x", "y", "z");
        long count = stream.filter(s -> s.startsWith("y")).peek(System.out::println).count(); // y
        System.out.println(count); // 1
    }
}
