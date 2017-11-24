package javaexamples.cert.collections.maps;

// Notes
// 1. Stores the keys in a hash table (uses hashCode() to retrieve the values more efficiently
// 2. HashMap is not ordered and therefore more efficient that TreeMap (constant time access)
// 3. Hashtable is thread-safe but more or less redundant and unused now, but offered similar functionality back in the day.
// 4. HashMap does NOT extend Collection, but implements the Map interface.

// Scenarios - when to use?
// 1. When you need to find something based on a unique identifier. You should have no ordering requirements when choosing HashMap.
public class HashMapExamples {

    public static void main(String[] args){

    }
}
