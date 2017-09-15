package javaexamples.cert.operators;

import java.io.Serializable;

// Rules:
// Expression (a instanceof B) will return true if:
// 1. The reference to which a points is an instance of class B
// 2. Is a subclass of class B (directly or indirectly)
// 3. A class that implements the B interface (directly or indirectly)

// instanceOf will throw a compilation error when:
// 1. instanceOf is called on a class and the class is not in the hierarchy
// When checking whether an object is an instanceOf an interface, Java waits until runtime to do the check.
// Reason being, the subclass could implement an interface and the compiler would not know it
public class InstanceOfOperator {

    public static void main(String... args){
        exampleA();
        nullReferenceExample();
        instanceOfWithInvalidClasses();
    }

    private static void exampleA() {
        InstanceOfOperatorClassA a = new InstanceOfOperatorClassB();

        System.out.println(a instanceof InstanceOfOperatorClassC);      // false
        System.out.println(a instanceof InstanceOfOperatorClassB);      // true
        System.out.println(a instanceof InstanceOfOperatorClassA);      // true
        System.out.println(a instanceof InstanceOfOperatorInterfaceA);  // true
        System.out.println(a instanceof Object);                        // true
    }

    private static void nullReferenceExample() {
        InstanceOfOperatorClassA a = null;

        System.out.println(a instanceof InstanceOfOperatorClassC);      // false
        System.out.println(a instanceof InstanceOfOperatorClassB);      // false
        System.out.println(a instanceof InstanceOfOperatorClassA);      // false
        System.out.println(a instanceof InstanceOfOperatorInterfaceA);  // false
        System.out.println(a instanceof Object);                        // false
    }

    private static void instanceOfWithInvalidClasses() {
        InstanceOfOperatorClassA a = new InstanceOfOperatorClassB();

        // System.out.println(a instanceof String);     // Will not compile - inconvertible types - String not in class hierarchy
        System.out.println(a instanceof Serializable);  // Compiles fine since Serializable is an interface
    }
}

class InstanceOfOperatorClassA {}
class InstanceOfOperatorClassB extends InstanceOfOperatorClassA implements InstanceOfOperatorInterfaceA {}
class InstanceOfOperatorClassC extends InstanceOfOperatorClassB {}
interface InstanceOfOperatorInterfaceA {}