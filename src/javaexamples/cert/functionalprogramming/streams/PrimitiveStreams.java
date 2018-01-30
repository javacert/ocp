package javaexamples.cert.functionalprogramming.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.LongToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// Notes:
// 1. There are 3 types of primitive streams:
//      a. IntStream - Used for the primitive types - int, short, byte and char
//      b. LongStream - Used for the primitive type long
//      c. DoubleStream - Used for the primitive types - double and float
public class PrimitiveStreams {

    public static void main(String[] args) {
        creatingPrimitiveStreams();
        creatingInfinitePrimitiveStreams();
        creatingNumberRanges();
        creatingPrimitiveStreamFromOtherStreams();
        mappingFunctionExamples();
        primitiveStreamFromAStream();
        usingOptionalWithPrimitiveStreams();
        summarizingStatistics();
    }

    private static void creatingPrimitiveStreams() {
        DoubleStream empty = DoubleStream.empty();
        DoubleStream oneValue = DoubleStream.of(3.14);
        DoubleStream varargs = DoubleStream.of(1.1, 1, 1.2);

        varargs.forEach(System.out::print);
    }

    private static void creatingInfinitePrimitiveStreams() {
        DoubleStream random = DoubleStream.generate(Math::random);
        DoubleStream fractions = DoubleStream.iterate(0.5, d -> d / 2);

        random.limit(3).forEach(System.out::println);
        fractions.limit(3).forEach(System.out::println);
    }

    private static void creatingNumberRanges() {
        IntStream range = IntStream.range(1, 6); // 6 is NOT included
        range.forEach(System.out::println); // 1 2 3 4 5

        IntStream rangeClosed = IntStream.rangeClosed(1, 5); // This is neater!
        rangeClosed.forEach(System.out::println); // 1 2 3 4 5
    }

    private static void creatingPrimitiveStreamFromOtherStreams() {
        // Available methods - map, mapToObj, mapToInt, mapToLong, mapToDouble (types need to be compatible)
        // Mapping to the same type you call map.
        // When returning an object stream, the method is mapToObj()
        Stream<String> objStream = Stream.of("a", "b");
        IntStream intStream = objStream.mapToInt(s -> s.length());
    }

    private static void mappingFunctionExamples() {
        // Function, ToDoubleFunction, ToIntFunction, ToLongFunction
        // DoubleFunction, DoubleUnaryOperator, DoubleToIntFunction, DoubleToLongFunction
        // IntFunction, IntToDoubleFunction, IntUnaryFunction, IntToLongFunction
        // LongFunction, LongToDoubleFunction, LongToIntFunction, LongUnaryOperator

        // Note that these are functional interfaces with 1 method to do the conversion.
        LongToDoubleFunction i = (l) -> Math.sin(l);
        System.out.println(i.applyAsDouble(Long.MAX_VALUE));
    }

    private static void primitiveStreamFromAStream() {
        // flatMapToInt(), flatMapToDouble(), flatMapToLong()
        List<Integer> list = new ArrayList<>();
        list.add(1);
        IntStream ints = list.stream().flatMapToInt(x -> IntStream.of(x));
        ints.forEach(System.out::println); // 1
    }

    private static void usingOptionalWithPrimitiveStreams() {
        // 3 main classes:
        // 1. OptionalDouble
        // 2. OptionalInt
        // 3. OptionalLong
        // See table 4.8 for what types the Optional methods return - example below is for OptionalDouble.

        IntStream stream = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = stream.average();
        if(optional.isPresent()) {
            System.out.println(optional.getAsDouble()); // 5.5
            System.out.println(optional.orElseGet(() -> Double.NaN)); // returns a DoubleSupplier
        }
        // We use Optional<Double> for wrapped doubles, and OptionalDouble for primitive doubles.
        // Only observable difference is that we call getAsDouble rather than get to make clear we are working with a primitive.

        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum(); // Also need to know max() and avg() - see method sigs below
        System.out.println(sum);

        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
        OptionalDouble min = doubles.min(); // runs infinitely

        IntStream ints = IntStream.generate(() -> 1);
        OptionalInt max = ints.max(); // runs infinitely
        if(max.isPresent()) {
            System.out.println(max.getAsInt());
        }
    }

    private static void summarizingStatistics() {

    }
}


/*    *//**
     * Returns the sum of elements in this stream.  This is a special case
     * of a <a href="package-summary.html#Reduction">reduction</a>
     * and is equivalent to:
     * <pre>{@code
     *     return reduce(0, Long::sum);
     * }</pre>
     *
     * <p>This is a <a href="package-summary.html#StreamOps">terminal
     * operation</a>.
     *
     * @return the sum of elements in this stream
     *//*
    long sum();

    *//**
     * Returns an {@code OptionalLong} describing the minimum element of this
     * stream, or an empty optional if this stream is empty.  This is a special
     * case of a <a href="package-summary.html#Reduction">reduction</a>
     * and is equivalent to:
     * <pre>{@code
     *     return reduce(Long::min);
     * }</pre>
     *
     * <p>This is a <a href="package-summary.html#StreamOps">terminal operation</a>.
     *
     * @return an {@code OptionalLong} containing the minimum element of this
     * stream, or an empty {@code OptionalLong} if the stream is empty
     *//*
    OptionalLong min();

    *//**
     * Returns an {@code OptionalLong} describing the maximum element of this
     * stream, or an empty optional if this stream is empty.  This is a special
     * case of a <a href="package-summary.html#Reduction">reduction</a>
     * and is equivalent to:
     * <pre>{@code
     *     return reduce(Long::max);
     * }</pre>
     *
     * <p>This is a <a href="package-summary.html#StreamOps">terminal
     * operation</a>.
     *
     * @return an {@code OptionalLong} containing the maximum element of this
     * stream, or an empty {@code OptionalLong} if the stream is empty
     *//*
    OptionalLong max();*/
