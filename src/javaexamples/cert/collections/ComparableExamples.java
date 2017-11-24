package javaexamples.cert.collections;

// Notes
// 1. Remember that numbers are sorted before letters, and uppercase letters are sorted before lowercase letters.
// 2. Used to compare 2 objects when using Collections.sort, but compareTo can be called directly to compare 2 objects.
// 3. There are 3 rules to know:
//       a. The number zero is returned when the current object is equal to the argument to compareTo()
//       b. A number less than zero is returned when the current objects is smaller than the argument to compareTo()
//       c. A number greater than zero is returned when current object is larger than the argument to compareTo()
// 4. In legacy code, the compareTo() requires a cast since it is passed in Object and not the generic type.
// 5. You should try and keep compareTo() and equals() consistent.
// 5. Lives in java.util
public class ComparableExamples<T> implements Comparable<T>{

    public static void main(String[] args){

    }

    @Override
    public int compareTo(T o) { // Note only 1 parameter
        return 0;
    }
}
