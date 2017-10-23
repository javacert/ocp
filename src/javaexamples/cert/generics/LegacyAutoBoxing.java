package javaexamples.cert.generics;

import java.util.ArrayList;
import java.util.List;

// This example shows the dangers of working with raw data types.
// Line 11 does not compile because the compiler does not know that the List holds Integer objects.
// You cannot unbox Object to int.
public class LegacyAutoBoxing {
    public static void main(String[] args){
        List numbers = new ArrayList();
        numbers.add(5);
        // int result = numbers.get(0);
    }
}
