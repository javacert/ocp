package javaexamples.cert.functionalprogramming.functionalinterfaces;

import java.util.function.*;

// Notes:
// 1. Generics are gone from some of the interfaces, since the type name tells us the primitive type involved.
//    In other cases, such as IntFunction, only the return type generic is needed.
// 2. The single abstract method is often, but not always, renamed to reflect the primitive type involved.
// 3. BiConsumer, BiPredicate, and BiFunction are not shown below since for primitives, functions with 2 different
//    type parameters just aren't often used.
// 4. You need to know which functional interface to use - so if it accepts a double and returns an int, you would
//    be looking for a DoubleToIntFunction.
public class PrimitivesExamples {

    public static void main(String[] args){
        supplierExamples();
        consumerExamples();
        predicateExamples();
        functionExamples();
        unaryExamples();
        binaryExamples();

        intPrimitiveSpecificExamples();
        doublePrimitiveSpecificExamples();
        longPrimitiveSpecificExamples();
    }

    private static void supplierExamples() {
        DoubleSupplier ds;
        IntSupplier is;
        LongSupplier ls;
    }

    private static void consumerExamples() {
        DoubleConsumer dc;
        IntConsumer ic;
        LongConsumer lc;
    }

    private static void predicateExamples() {
        DoublePredicate dp;
        IntPredicate ip;
        LongPredicate lp;
    }

    private static void functionExamples() {
        DoubleFunction<String> df; // Takes a double and returns the generic type
        IntFunction<Double> ifu;
        LongFunction<Integer> lf;
    }

    private static void unaryExamples() {
        DoubleUnaryOperator duo; // Takes a double and returns a double
        IntUnaryOperator iuo;
        LongUnaryOperator luo;
    }

    private static void binaryExamples() {
        DoubleBinaryOperator dbo; // Takes 2 doubles and returns a double
        IntBinaryOperator ibo;
        LongBinaryOperator lbo;
    }

    private static void intPrimitiveSpecificExamples() {
        ToIntFunction<String> tif;
        ToIntBiFunction<String, Long> tibf;
        IntToDoubleFunction itif;
        IntToLongFunction itlf;
        ObjIntConsumer oic;
    }

    private static void doublePrimitiveSpecificExamples() {
        ToDoubleFunction<String> tdf; // Takes 1 generic type and returns a double
        ToDoubleBiFunction<String, Long> tdbf; // Takes 2 generic types and returns a double
        DoubleToIntFunction dtif; // Takes a double and returns an int
        DoubleToLongFunction dtlf; // Takes a double and returns a long
        ObjDoubleConsumer<String> odc; // Takes a generic type and a double, returns void
    }

    private static void longPrimitiveSpecificExamples() {
        ToLongFunction<String> tlf;
        ToLongBiFunction<String, Long> tlbf;
        LongToIntFunction ltif;
        LongToDoubleFunction ltlf;
        ObjLongConsumer olc;
    }
}
