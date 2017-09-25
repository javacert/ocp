package javaexamples.cert.nestedclasses;

// Notes:
// 1. A static inner class is a static class defined at the member level.
// 2. It can be instantiated without an object of the enclosing class, so it cannot access instance variables
//    without an explicit object of the enclosing class.
// 3. It is similar to a regular class with exception to the following:
//    - The nesting creates a namespace because the enclosing class name must be used to refer to it.
//    - It can be made private or use one of the other access modifiers to encapsulate it.
//    - The enclosing class can refer to the fields and methods of the static nested class.
public class StaticInnerClasses {

    static class StaticNestedClass {
        private int someNestedClassVariable = 10;
    }

    public static void main(String[] args){

        StaticNestedClass staticNestedClass = new StaticNestedClass(); // Access in a static method - no instance required!
        System.out.println(staticNestedClass.someNestedClassVariable); // 10 - note you can access private instance variables.
    }
}
