package javaexamples.cert.functionalprogramming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// Notes:
// 1. A stream is a sequence of data.
// 2. A stream pipeline is the operations that run on a stream to produce a result
public class StreamExamples {

    public static void main(String[] args){
        creatingFiniteStreams();
        creatingAListFromAStream();
        generatingInfiniteStreams();
        countExample();
        minMaxExamples();
        findAnyfindFirstExamples();
    }

    private static void creatingFiniteStreams() {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // vararg
    }

    private static void creatingAListFromAStream() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();
    }

    private static void generatingInfiniteStreams() {
        Stream<Double> randoms = Stream.generate(Math::random);
        // randoms.forEach(System.out::println); // --> Runs infinitely
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        // oddNumbers.forEach(System.out::println); // --> Runs infinitely
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
}
