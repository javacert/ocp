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
        chainingOptional();
        usingFlatMapWithOptional();
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
        // System.out.println(someOptionalIntegerC.orElseThrow(IllegalStateException::new)); // Exception in thread "main" java.lang.IllegalStateException
    }

    private static void chainingOptional() {
        // We can chain Optional to make it much more expressive and avoid nested if statements
        Optional<Integer> optional = Optional.of(123);
        optional.map(n -> "" + n)                   // Convert it to a String Collection
                .filter(s -> s.length() == 3)       // filter out any entries which do not have a length of 3
                .ifPresent(System.out::println);    // 123 - print the vale if it is present

        // A note on optional filter:
        // * If a value is present, and the value matches the given predicate,
        // * return an {@code Optional} describing the value, otherwise return an
        // * empty {@code Optional}.
    }

    private static void usingFlatMapWithOptional() {
        // What if we wanted to get an Optional<Integer> representing the length of a String contained in another Optional?
        // We could do:
        Optional<String> optional = Optional.of("123");
        Optional<Integer> result = optional.map(String::length);

        // but what if we had a helper method that worked this out for us?
        // Optional<Integer> result2 = optional.map(OptionalExamples::getTheLength); --> Does not compile
        // Why - because it would give us Optional<Optional<Integer>>

        Optional<Integer> result3 = optional.flatMap(OptionalExamples::getTheLength); // Removes the unnecessary layer

    }

    private static Optional<Integer> getTheLength(String s){
        return Optional.of(s.length());
    }
}
