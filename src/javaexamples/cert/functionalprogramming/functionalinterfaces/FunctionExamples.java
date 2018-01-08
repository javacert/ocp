package javaexamples.cert.functionalprogramming.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

// Notes
// 1. A Function is responsible for turning one parameter into a value of a potentially different type and returning it.
// 2. BiFunction is responsible for turning 2 parameters into a value and returning it.
public class FunctionExamples {
    public static void main(String[] args){
        functionExamples();
    }

    private static void functionExamples() {
        // Takes a String and returns an Integer
        Function<String, Integer> f1 = String::length; // Assigns public int length() {
        System.out.println(f1.apply("SomeStringWithLengthToFind"));

        // Takes 2 Strings and returns a String
        BiFunction<String, String, String> f2 = String::concat; // Assigns public String concat(String str) {
        System.out.println(f2.apply("AStringToConcat", "AnotherStringToConcat"));
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
public interface BiFunction<T, U, R> {

    */
/**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @return the function result
     *//*

    R apply(T t, U u);

    */
/**
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
     *//*

    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }
}*/
