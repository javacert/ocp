package javaexamples.cert.collections;

import java.util.Comparator;

// Notes
// 1. Remember that numbers are sorted before letters, and uppercase letters are sorted before lowercase letters.
// 2. Used to specify that you want to use a different order than the object itself provides.
// 3. Comparator is a functional interface since it has only 1 abstract method, and can be written using lambdas over
//    anonymous inner classes.
// 4. Collections.sort accepts 1 or 2 parameters --> Collections.sort(collectionRef, comparatorRef)
// 5. Lives in java.lang, method name is compare (not compareTo as with Comparable), and takes 2 parameters.
// 6. Comparator now has some helped methods with java 8 to help with readability, such as comparing(lambda)
public class ComparatorExamples<T> implements Comparator<T> {

    public static void main(String[] args){

    }

    @Override
    public int compare(T o1, T o2) { // Note 2 parameters
        return 0;
    }
}
