package javaexamples.cert.methodreferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Notes:
// 1. The :: operator tells Java to pass the parameters automatically into the method.
// 2. The :: returns a functional interface and not an object - in the following examples it returns Comparator
// 3. There are 4 formats of method references:
//      a. Static Methods
//          --> Consumer<List<Integer>> methodRef = Collections::sort;
//      b. Instance methods on a particular instance
//          --> String str = "abc"; Predicate<String> methodRef = str::startsWith;
//      c. Instance methods on an instance to be determined at runtime
//          --> Predicate<String> methodRef = String::isEmpty;
//      d. Constructors
//          --> Supplier<ArrayList> methodRef = ArrayList::new;
public class MethodReferenceExamples {

    public static void main(String[] args) {
        theLongWay();
        theShortWay();
        theShorterWay();
        forEachExample();
    }

    private static void theLongWay() {
        Comparator<SomeClassToCompare> someComparator = (SomeClassToCompare c1, SomeClassToCompare c2) -> { return SomeHelperClass.compareObjects(c1, c2); };
    }

    private static void theShortWay() {
        // Here we are just passing on the same parameters, so some redundancy here
        Comparator<SomeClassToCompare> someComparator = (c1, c2) -> SomeHelperClass.compareObjects(c1, c2);
    }

    private static void theShorterWay() {
        Comparator<SomeClassToCompare> someComparator = SomeHelperClass::compareObjects;
    }


    private static void forEachExample() {
        List<String> cats = Arrays.asList("Annie", "Ripley");
        cats.forEach(c -> System.out.println(c)); // This lambda is a Consumer functional interface - Takes a single param and doesn't return anything.
        cats.forEach(System.out::print);
    }
}

class SomeHelperClass {
    public static int compareObjects(SomeClassToCompare c1, SomeClassToCompare c2) {
        return c1.compareTo(c2);
    }
}

class SomeClassToCompare implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
