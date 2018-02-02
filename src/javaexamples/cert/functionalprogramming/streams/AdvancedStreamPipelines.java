package javaexamples.cert.functionalprogramming.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Notes:
// 1. Streams are lazily evaluated - this means that the stream isn't created until it is needed.
public class AdvancedStreamPipelines {
    public static void main(String[] args){
        lazyEvaluationExample();
    }

    private static void lazyEvaluationExample() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Stream<String> stream = list.stream(); // Remember lazy evaluation!!
        list.add("c");
        list.add("d");
        System.out.println(stream.count()); // Count is 4 - stream not evaluated until used!
    }
}
