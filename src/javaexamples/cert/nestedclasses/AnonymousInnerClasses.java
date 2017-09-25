package javaexamples.cert.nestedclasses;

// Notes:
// 1. An anonymous inner class is a local inner class which does not have a name.
// 2. Anonymous inner classes are required to extend an existing class or implement an existing interface.
// 3. Useful when you have a short implementation that will not be used anywhere else.
// 4. You cannot use extends/implements with anonymous inner classes (the inner classes themselves will extend Object).
public class AnonymousInnerClasses {

    public static void main(String[] args){

        AnonymousInnerClasses anonymousInnerClasses = new AnonymousInnerClasses();
        anonymousInnerClasses.useTheAbstractClass(); // 10
        anonymousInnerClasses.useTheInterface(); // 20
    }

    public void useTheAbstractClass(){
        SomeAbstractClass someAbstractClass = new SomeAbstractClass(){
            @Override
            int someAbstractMethod() {
                return 10;
            }
        }; // Observe the semi-colon
        System.out.println(someAbstractClass.someAbstractMethod());
    }

    public void useTheInterface(){
        SomeInterface someInterface = new SomeInterface(){
            @Override
            public int someInterfaceMethod() { // This must be public - remember all interface methods are public
                return 20;
            }
        }; // Observe the semi-colon
        System.out.println(someInterface.someInterfaceMethod());
    }

    abstract class SomeAbstractClass{
        abstract int someAbstractMethod();
    }

    interface SomeInterface{
        int someInterfaceMethod();
    }
}
