package javaexamples.cert.functionalprogramming.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Notes:
// 1. There are many collectors beyond the collect() method.
// 2. Grouping/Partitioning Collectors examples - averagingDouble(), counting(), groupingBy(..), joining() - see table 4.11
//    on page 217 for full details of all of these examples and what they return.
// 3. Partitioning --> splitting a List into 2 parts - evaluates to true or false
public class CollectingResults {

    public static void main(String[] args) {
        joiningExample();
        averagingIntExample();
        legacyConvertingToACollection();
        groupingByExample();
        groupingByExampleAsSet();
        groupingByExampleAsSetUpdatingReturnType();
        partitioningExample();
    }

    private static void joiningExample() {
        Stream<String> stream = Stream.of("a", "b", "c");
        String result = stream.collect(Collectors.joining(", "));
        System.out.println(result); // a, b, c
    }

    private static void averagingIntExample() {
        Stream<String> stream = Stream.of("a", "bc", "d", "e");
        Double result = stream.collect(Collectors.averagingInt(String::length)); // returns a Double, not a primitive
        System.out.println(result); // 1.25 (5 letters / 4 in stream)
    }

    private static void legacyConvertingToACollection() {
        // Some older code (prior to Java 8) will expect a collection type rather than a stream
        Stream<String> stream = Stream.of("a", "b", "c");
        TreeSet<String> result = stream.filter(s -> s.startsWith("b")).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result); // [b]
    }

    private static void groupingByExample() {
        Stream<String> stream = Stream.of("a", "bc", "d", "e");
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(String::length));
        System.out.println(map); // {1=[a, d, e], 2=[bc]} --> group all the elements of streams into lists (default)
    }

    private static void groupingByExampleAsSet() {
        Stream<String> stream = Stream.of("a", "bc", "d", "e");
        Map<Integer, Set<String>> map = stream.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map); // {1=[a, d, e], 2=[bc]} --> group all the elements of streams into a Set
    }

    private static void groupingByExampleAsSetUpdatingReturnType() {
        Stream<String> stream = Stream.of("a", "bc", "d", "e");
        TreeMap<Integer, Set<String>> map = stream.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map); // {1=[a, d, e], 2=[bc]} --> group all the elements of streams into a Set, returns a TreeMap
    }

    private static void partitioningExample() {
        Stream<String> stream = Stream.of("a", "b", "cd");
        Map<Boolean, List<String>> result = stream.collect(Collectors.partitioningBy(s -> s.length() < 2));
        System.out.println(result); // {false=[cd], true=[a, b]} --> Note that map has 2 keys, true and false
    }
}
