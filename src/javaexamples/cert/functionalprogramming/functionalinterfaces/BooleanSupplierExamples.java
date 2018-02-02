package javaexamples.cert.functionalprogramming.functionalinterfaces;

import java.util.function.BooleanSupplier;

// Notes:
// 1. BooleanSupplier is the only functional interface for boolean.
public class BooleanSupplierExamples {

    public static void main(String[] args){
        basicExamples();
    }

    private static void basicExamples() {
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > 0.5;

        System.out.println(b1.getAsBoolean()); // true
        System.out.println(b2.getAsBoolean()); // true or false
    }
}
