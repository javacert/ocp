package javaexamples.cert.collections.maps;

// Notes
// 1. Stores the keys in a hash table (uses hashCode() to retrieve the values more efficiently
// 2. HashMap is not ordered and therefore more efficient that TreeMap (constant time access)
// 3. Hashtable is thread-safe but more or less redundant and unused now, but offered similar functionality back in the day.
// 4. HashMap does NOT extend Collection, but implements the Map interface.

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

// Scenarios - when to use?
// 1. When you need to find something based on a unique identifier. You should have no ordering requirements when choosing HashMap.
public class HashMapExamples {

    public static void main(String[] args){
        newMergeMethodExample();
    }

    // Note - refer to tables on page 159.
    private static void newMergeMethodExample() {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() < v2.length() ? v1 : v2;
        Map<String, String> someMap = new HashMap<>();
        someMap.put("key1", "value1");
        someMap.put("key2", "longerValue2");

        String output1 = someMap.merge("key1", "newValue1", mapper);
        String output2 = someMap.merge("key2", "newValue2", mapper); // new value shorter, so replace it.

        System.out.println(someMap); // {key1=value1, key2=newValue2}
        System.out.println(output1); // value1
        System.out.println(output2); // newValue2
    }
}