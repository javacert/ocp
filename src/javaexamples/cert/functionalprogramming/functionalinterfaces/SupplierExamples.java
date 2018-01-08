package javaexamples.cert.functionalprogramming.functionalinterfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

// Notes
// 1. A Supplier is used when you want to generate or supply values without taking any input.
public class SupplierExamples {

    public static void main(String[] args){
        arrayListConstructorExample();
        localDateExample();
    }

    private static void arrayListConstructorExample() {
        Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
        ArrayList<String> a1 = s1.get();

        // .get() in the above is the get method in the Supplier functional interface:

        //@FunctionalInterface
        //public interface Supplier<T> {
        //    /**
        //     * Gets a result.
        //     *
        //     * @return a result
        //     */
        //    T get();
        //}

        // Therefore we are delaying the calling of new.

        System.out.println(a1);
    }

    private static void localDateExample() {
        Supplier<LocalDate> s1 = LocalDate::now; // Static method reference
        Supplier<LocalDate> s2 = LocalDate::now;

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);
    }
}
