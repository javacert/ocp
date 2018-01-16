package javaexamples.cert.functionalprogramming.optional;

import java.util.Optional;

// Notes:
// 1. An Optional is created using a factory. You can request an empty Optional or pass an optional for the Optional to wrap.
// 2. Optional constructors are private meaning that you cannot instantiate.
// 3. Optional instance methods:
//      - get() - Throws an exception when Optional is empty, returns a value when Optional contains a value
//      - ifPresent(Consumer c) - Does nothing when Optional is empty, calls Consumer c with value when Optional contains a value
//      - ifPresent() - Returns false when Optional is empty, returns true when Optional contains a value
//      - orElse(T other) - Returns other parameter when Optional is empty, returns value when Optional contains a value
//      - orElseGet(Supplier s) - Returns result of calling Supplier when Optional is empty, returns value when Optional contains a value
//      - orElseThrow(Supplier s) - Returns exception created by calling Supplier when Optional is empty, returns value when Optional contains a value
public class OptionalExamples {

    public static void main(String[] args){
        basicOptionalExamples();
    }

    private static void basicOptionalExamples() {
        // Exception in thread "main" java.lang.NullPointerException
        // Optional<Integer> someOptionalIntegerA = Optional.of(null); // Passing 'null' argument to parameter annotated as @NotNull

        Optional<Integer> someOptionalIntegerB = Optional.of(10);
        System.out.println(someOptionalIntegerB.isPresent()); // true

        Optional<Integer> someOptionalIntegerC = Optional.ofNullable(null);
        System.out.println(someOptionalIntegerC.isPresent()); // false

        // Remember if a value is present it would print out that value, but in these cases the value is null.
        System.out.println(someOptionalIntegerC.orElse(20)); // 20
        System.out.println(someOptionalIntegerC.orElseGet((new Double(Math.random())::intValue))); // 0
        System.out.println(someOptionalIntegerC.orElseThrow(IllegalStateException::new)); // Exception in thread "main" java.lang.IllegalStateException
    }
}
