package javaexamples.cert.annotations;

// Notes:
// Always check the following 3 things when you see @Override
// 1. The method is implementing a method from an interface
// 2. Overriding a superclass method of a class shown in the example
// 3. Overriding a method declared in Object, such as hashcode, equals or toString
public class OverrideAnnotation implements InterfaceWithOverrideAnnotation {

    public static void main(String[] args){
        OverrideAnnotation overrideAnnotation = new OverrideAnnotation();
        overrideAnnotation.someMethodToOverride();
    }

    @Override
    public void someMethodToOverride() {

    }

    // @Override // --> Method does not override method from its superclass
    public void someMethod() {

    }
}

interface InterfaceWithOverrideAnnotation {

    void someMethodToOverride();
}
