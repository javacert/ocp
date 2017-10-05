package javaexamples.cert.interfaces;

// Notes:
// A functional interface contains exactly 2 abstract method.
// An interface can extend an interface and override the single abstract method and still be a functional interface
// You can define static/default methods and it will still be considered a functional interface since again, only 1 abstract method
@FunctionalInterface
public interface FunctionalInterfaceAnnotation
{
    void someMethod();
    // void someMethod2(); // Can only have 1 abstract method with FunctionalInterface annotation - would result in a compiler error.

    default void someDefaultMethod(){

    };

    static void someStaticMethod(){

    }
}
