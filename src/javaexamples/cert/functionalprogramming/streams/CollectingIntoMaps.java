package javaexamples.cert.functionalprogramming.streams;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Notes:
// 1. Collector code involving maps can get long.
public class CollectingIntoMaps {

    public static void main(String[] args){
        mapFromAStreamExample();
        notGuaranteedHashMapReturn();
        guaranteedTypeReturn();
    }

    private static void mapFromAStreamExample() {
        Stream<String> stream = Stream.of("a", "b", "c");
        //                                                          KEY         VALUE
        Map<String, Integer> map = stream.collect(Collectors.toMap(s -> s, String::length));
        // Since the key is the value in the stream itself, we just return itself, as in s -> s
        // Alternatively you can use Function.identity() to do the same, but might not necessarily be clearer.
        System.out.println(map); // {a=1, b=1, c=1}
    }

    private static void notGuaranteedHashMapReturn() {
        Stream<String> stream = Stream.of("a", "b", "c");
        Map<Integer, String> map = stream.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));

        // Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
        //                                 Function<? super T, ? extends U> valueMapper,
        //                                 BinaryOperator<U> mergeFunction) {

        System.out.println(map.getClass()); // class java.util.HashMap --> Not always guaranteed!
    }

    private static void guaranteedTypeReturn() {
        Stream<String> stream = Stream.of("a", "b", "c");
        Map<Integer, String> map = stream.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));

        // Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
        //                                 Function<? super T, ? extends U> valueMapper,
        //                                 BinaryOperator<U> mergeFunction,
        //                                 Supplier<M> mapSupplier) {

        System.out.println(map.getClass()); // class java.util.TreeMap --> Guaranteed!
    }
}