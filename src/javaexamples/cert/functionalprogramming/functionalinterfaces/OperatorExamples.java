package javaexamples.cert.functionalprogramming.functionalinterfaces;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

// Notes
// 1. Both Unary and Binary Operator interfaces require all type parameters to be the same type.
// 2. A UnaryOperator transforms its value into one of the same type (and extends Function)
// 3. A BinaryOperator merges 2 values into one of the same type. E.g. Adding 2 numbers is a binary operation.
//    BinaryOperator extends BiFunction.
// 4. There is no need to specify the return type as it is the same as the parameter.
public class OperatorExamples {
    public static void main(String[] args){
        unaryOperatorExamples();
        binaryOperatorExamples();
        invalidUnaryOperatorExamples();
    }

    private static void unaryOperatorExamples() {
        UnaryOperator<String> u1 = String::toUpperCase; // public interface UnaryOperator<T> extends Function<T, T> {
        System.out.println(u1.apply("First String")); // FIRST STRING
    }

    private static void binaryOperatorExamples() { // public interface BinaryOperator<T> extends BiFunction<T,T,T> {
        BinaryOperator<String> b1 = String::concat;
        System.out.println(b1.apply("First String ", "Second String")); // First String Second String
    }

    private static void invalidUnaryOperatorExamples() {
        // UnaryOperator<Long> u1 = (Long l) -> 3.13; // --> Should return the same type, but returns a double
    }
}

/*@FunctionalInterface
public interface Function<T, R> {

    *//**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     *//*
    R apply(T t);

    *//**
     * Returns a composed function that first applies the {@code before}
     * function to its input, and then applies this function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of input to the {@code before} function, and to the
     *           composed function
     * @param before the function to apply before this function is applied
     * @return a composed function that first applies the {@code before}
     * function and then applies this function
     * @throws NullPointerException if before is null
     *
     * @see #andThen(Function)
     *//*
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    *//**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     *
     * @see #compose(Function)
     *//*
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    *//**
     * Returns a function that always returns its input argument.
     *
     * @param <T> the type of the input and output objects to the function
     * @return a function that always returns its input argument
     *//*
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}*/

/*
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {
    */
/**
     * Returns a {@link BinaryOperator} which returns the lesser of two elements
     * according to the specified {@code Comparator}.
     *
     * @param <T> the type of the input arguments of the comparator
     * @param comparator a {@code Comparator} for comparing the two values
     * @return a {@code BinaryOperator} which returns the lesser of its operands,
     *         according to the supplied {@code Comparator}
     * @throws NullPointerException if the argument is null
     *//*

    public static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
    }

    */
/**
     * Returns a {@link BinaryOperator} which returns the greater of two elements
     * according to the specified {@code Comparator}.
     *
     * @param <T> the type of the input arguments of the comparator
     * @param comparator a {@code Comparator} for comparing the two values
     * @return a {@code BinaryOperator} which returns the greater of its operands,
     *         according to the supplied {@code Comparator}
     * @throws NullPointerException if the argument is null
     *//*

    public static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
    }
}*/
