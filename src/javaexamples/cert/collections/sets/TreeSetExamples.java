package javaexamples.cert.collections.sets;

// Notes
// 1. TreeSet cannot contain null elements

import java.util.Set;
import java.util.TreeSet;

// Scenarios - when to use?
// 1. When you need to store unique values but you also need them in alphabetical order.
public class TreeSetExamples {

    public static void main(String[] args){
        treeSetsObjectsMustImplementComparable();
    }

    private static void treeSetsObjectsMustImplementComparable(){

        Set<SomeClassWhichDoesImplementComparable> someSet = new TreeSet<>();
        someSet.add(new SomeClassWhichDoesImplementComparable());

        // Throws the following
        // Exception in thread "main" java.lang.ClassCastException: javaexamples.cert.collections.sets.SomeClassWhichDoesNotImplementComparable cannot be cast to java.lang.Comparable
        Set<SomeClassWhichDoesNotImplementComparable> someOtherSet = new TreeSet<>();
        someOtherSet.add(new SomeClassWhichDoesNotImplementComparable());
    }
}

class SomeClassWhichDoesNotImplementComparable {

}

class SomeClassWhichDoesImplementComparable<T> implements Comparable<T>{

    @Override
    public int compareTo(T o) {
        return 0;
    }
}