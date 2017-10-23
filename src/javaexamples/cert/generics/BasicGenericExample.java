package javaexamples.cert.generics;

// Notes on generics
// Naming conventions for generics:
// 1. E --> Element
// 2. K --> Map Key
// 3. V --> Map Value
// 4. N --> Number
// 5. T --> Generic Data Type
// 6. S, U, V and so forth --> Multiple Generic Types
// Note that you can use any placeholder you want (e.g. O, _), these are only guidelines.

// Type Erasure --> Generics are only for compile time - behind the scenes, the compiler replaces
// all of placeholders with Object. The process of the removal of generic types is knows as type erasure.

// You cannot do the following with Generics:
// 1. Call the constructor new T() as it would compile to new Object()
// 2. Create an array of that static type - you would be creating an array of Objects
// 3. Call instanceof - with type erasure objects look the same
// 4. Use a primitive as a generic type parameter - you can use the wrapper class instead
// 5. Create a static variable as a generic type parameter

public class BasicGenericExample<T> implements GenericInterface<T>{
    private T someGenericVariable;
    public T someMethod(){
        return someGenericVariable;
    }

    public void methodReceivingGeneric(T incoming){
        this.someGenericVariable = incoming;
    }

    @Override
    public void someInterfaceMethod(T t) {}

    // The method parameter is the generic type T. The return type is GenericInterface<T>
    // Before the return type we declare the formal type parameter of <T>
    // Unless a method is obtaining the generic form type parameter from the class/interface,
    // it is specified immediately before the return type of the method (and is mandatory).
    public static <T> GenericInterface<T> someGenericMethod(T t){

        return new BasicGenericExample<>();
    }

    // Note that in this instance method <T> was method and it did not result in a compilation
    // error as it would in the preceeding example of a static method.
    public GenericInterface<T> someGenericMethodB(T t){

        return new BasicGenericExample<>();
    }
}

interface GenericInterface<T> {
    void someInterfaceMethod(T t);
}
