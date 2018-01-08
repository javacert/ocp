package javaexamples.cert.functionalprogramming.functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Notes
// 1. You use a consumer when you want to do something with a parameter but not return anything.
// 2. A BiConsumer does the same thing except it takes 2 parameters.
public class ConsumerExamples {
    public static void main(String[] args){
        printConsumerExamples();
    }

    private static void printConsumerExamples() {
        // Note that in the following examples println and printf are overloaded.
        Consumer<String> c1 = System.out::println;
        // Java uses the context of the lambda to work out which version to call, in this case the version with 2 parameters.
        BiConsumer<String, String> c2 = System.out::printf;
    }
}

/*@FunctionalInterface
public interface Consumer<T> {

    *//**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     *//*
    void accept(T t);

    *//**
     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     *//*
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}*/

/*@FunctionalInterface
public interface BiConsumer<T, U> {

    *//**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     *//*
    void accept(T t, U u);

    *//**
     * Returns a composed {@code BiConsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code BiConsumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     *//*
    default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after);

        return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };
    }
}*/
