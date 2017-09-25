package javaexamples.cert.nestedclasses;

// Notes:
// 1. A member inner class is defined at the member level of a class (same as methods, instance variables, constructors etc).
// 2. They have the following properties:
//    - Can be declared public, private, or protected or use default access
//    - Can extend any class and implement interfaces
//    - Can be abstract or final
//    - Cannot declare static fields or methods
//    - Can access members of the outer class including private members
// 3. Inner classes can have the same variable names as outer classes
public class MemberInnerClasses {

    public String someString = "Outer";

    protected class InnerClass {
        public String someString = "Inner";

        public void someMethod(){
            System.out.println(someString); // Inner
            System.out.println(this.someString); // Inner
            System.out.println(MemberInnerClasses.this.someString); // Outer - syntax to access outer class
        }
    }

    public static void main(String... args){
        MemberInnerClasses memberInnerClasses = new MemberInnerClasses();
        InnerClass innerClass = memberInnerClasses.new InnerClass(); // We can only instantiate an inner class through a class reference.

        innerClass.someMethod();
    }
}
