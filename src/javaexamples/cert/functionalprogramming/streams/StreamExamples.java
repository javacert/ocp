package javaexamples.cert.functionalprogramming.streams;

import java.util.*;
import java.util.stream.Stream;

// Notes:
// 1. A stream is a sequence of data.
// 2. A stream pipeline is the operations that run on a stream to produce a result
// 3. Streams do not implement Iterable interface and therefore cannot be used with traditional for loops
// 4. Streams can only be used once --> Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
public class StreamExamples {

    public static void main(String[] args){
        creatingFiniteStreams();
        creatingAListFromAStream();
        generatingInfiniteStreams();
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
}
