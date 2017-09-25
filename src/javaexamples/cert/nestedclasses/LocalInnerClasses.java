package javaexamples.cert.nestedclasses;

// Notes:
// 1. A local inner class is a nested class that is defined within a method.
// 2. They have the following properties:
//    - They do not have an access specifier
//    - They cannot be declared static and cannot declare static fields or methods
//    - They have access to all fields and methods of the enclosing class
//    - They do not have access to local variables of a method unless those variables are final or are effectively final
// 3. Since the compiler will compile a separate class from your inner class, it has not way to refer to local variables.
//    However, if the local variable is final, Java can handle it by passing it to the constructor of the inner class, or
//    by storing it in the class file.
public class LocalInnerClasses {

    int someOuterClassInstanceVariable = 2;

    public static void main(String[] args){
        LocalInnerClasses localInnerClasses = new LocalInnerClasses();
        localInnerClasses.someMethod();
    }

    public void someMethod(){
        final int someFinalVariable = 10;
        class InnerClass{
            public void someMethod(){
                System.out.println(someFinalVariable * someOuterClassInstanceVariable); // 20
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.someMethod();
    }
}
