package javaexamples.cert.functionalprogramming.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCommonTerminalOperations {

    public static void main(String[] args){
        countExample();
        minMaxExamples();
        findAnyfindFirstExamples();
        allMatchAnyMatchNoneMatchExamples();
        forEachExamples();
        reduceExamples();
        collectExamples();
    }

    private static void countExample() {
        Stream<String> s = Stream.of("a", "b", "c");
        // Note that counting an infinite stream will result in the system hanging
        System.out.println(s.count()); // 3
    }

    private static void minMaxExamples() {
        // Allows you to pass a custom comparator and find the smallest or largest value according to the sort order.
        // Both will hang when used against an infinite stream
        // They are considered reductions as they will return a single value after looking through the entire stream.
        Stream<String> s = Stream.of("a", "b", "c");
        Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println); // a

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> -1); // -1, 0, 1 all return false since stream is empty
        System.out.println(minEmpty.isPresent()); // false
    }

    private static void findAnyfindFirstExamples() {
        // Both methods return an element of the stream unless the stream is empty, in which case an Optional is returned.
        // These methods work with infinite streams - note that only the required amount of stream required is generated.
        // findAny() is useful when working with parallel streams - in this case first it comes by is returned.
        // These methods are terminal operations and not reductions - they sometimes return without processing all elements.
        // They do not reduce the streams down to 1 value.
        Stream<String> s = Stream.of("a", "b", "c");
        Stream<String> infinite = Stream.generate(() -> "d");
        s.findAny().ifPresent(System.out::println); // a
        infinite.findAny().ifPresent(System.out::println); // d
    }

    private static void allMatchAnyMatchNoneMatchExamples() {
        // These methods search a stream and return information about how the stream pertains to the predicate
        // They may or may not terminate for infinite streams
        // They are not reductions because they do not necessarily look at all of the elements

        // This example checks if a String begins with a letter
        List<String> list = Arrays.asList("a", "b", "c", "1");
        Stream<String> infinite = Stream.generate(() -> "b");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true - might not terminate and run infinitely if noneMatch, allMatch called.
    }

    private static void forEachExamples() {
        // forEach on an infinite stream does not terminate
        // If applicable, use something like filter over forEach
        // forEach the only terminal operation to return void
        // You can call forEach directly on both streams and collections

        Stream<String> s = Stream.of("a", "b", "c");
        s.forEach(System.out::println);
    }

    private static void reduceExamples() {
        // Reduce combines streams into a single object, and it is a reduction.
        // When you don't specify an identity (first param to reduce), an Optional is returned as there might not be any data.
        // There are 3 choices for what is in this optional:
        // 1. If the stream is empty, an empty Optional is returned
        // 2. If the stream has one element, it is returned
        // 3. If the stream has multiple elements, the accumulator is applied to combine both.
        // You can call methods from Optional e.g. something.reduce(...).isPresent(...)
        // There are 3 variations of reduce (identity, accumulator), (accumulator), (identity, accumulator, combiner)

        String[] array = new String[] { "a", "b", "c" };
        String result = "";
        for (String s : array) { result += s; }
        System.out.println(result);

        // The above is equivalent to:
        Stream<String> stream = Stream.of("a", "b", "c");
        String word = stream.reduce("", (s, c) -> s + c); // Could use String::concat here!
        System.out.println(word);

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> anotherStream = Stream.of(3, 4, 5);
        System.out.println(anotherStream.reduce(1, op, op)); // 90 - This signature is used when processing collections in parallel.
    }

    private static void collectExamples() {
        // collect is a special type of reduction called a mutable reduction.
        // It is more efficient that a regular reduction because we use the same mutable object while accumulating.
        // Allows us to get data out of a stream and into another form.

        Stream<String> stream = Stream.of("a", "b", "c");
        // First parameter --> Supplier that creates the object to store the results
        // Second parameter --> BiConsumer, takes 2 parameters and doesn't return anything. In this case, appends the next String to the StringBuilder
        // Third parameter --> BiConsumer - takes 2 data collections and merges them (useful when running in parallel - may impact order)
        StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word); // abc

        Stream<String> anotherStream = Stream.of("a", "b", "c");
        TreeSet<String> set = anotherStream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set); // [a, b, c]

        // Again but using common collectors interface
        Stream<String> anotherStreamB = Stream.of("a", "b", "c");
        TreeSet<String> setB = anotherStreamB.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(setB); // [a, b, c]

        // If you don't care about the order
        Stream<String> anotherStreamC = Stream.of("a", "b", "c");
        Set<String> setC = anotherStreamC.collect(Collectors.toSet());
        System.out.println(setC); // [a, b, c]
    }
}

