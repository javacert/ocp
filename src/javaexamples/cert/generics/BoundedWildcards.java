package javaexamples.cert.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Notes:
// 1. The upper-bounded wildcard says that any class that extends a given class, can be used as the formal parameter type.
// 2. The lower-bounded wildcard says that any class that is a superclass for a given class, can be used as the formal parameter type.
public class BoundedWildcards {

    public static void main(String[] args) {

        // upperBoundedWildcard examples
        List<RuntimeException> someListA = new ArrayList<>();
        upperBoundedWildcard(someListA);

        List<ArrayIndexOutOfBoundsException> someListB = new ArrayList<>();
        upperBoundedWildcard(someListB);

        List<Throwable> someListC = new ArrayList<>();
        // upperBoundedWildcard(someListC); // --> Will not compile since Throwable is not a subclass of exception.

        // lowerBoundedWildcard examples
        List<RuntimeException> someListD = new ArrayList<>();
        // lowerBoundedWildcard(someListD); // --> Will not compile since RuntimeException is not a superclass of exception.

        List<Throwable> someListE = new ArrayList<>();
        lowerBoundedWildcard(someListE);
    }

    public static void upperBoundedWildcard(List<? extends Exception> incoming){

        List<? extends Exception> l = new ArrayList<RuntimeException>();
    }

    public static void lowerBoundedWildcard(List<? super Exception> incoming){

        // Be careful with the following...
        List<? super IOException> l = new ArrayList<Exception>();
        // l.add(new Exception()); // --> Does not compile because List could be List<IOException>, and Exception would not fit there
        l.add(new IOException()); // --> Compiles fine, could be a list of List<IOException>, and IOException would fit fine in that list
        l.add(new FileNotFoundException()); // --> Compiles fine, could be a list of List<IOException>, and FileNotFoundException would fit fine in that list since it extends IOException
    }
}
