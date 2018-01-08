package javaexamples.cert.patterns.builder;

import javaexamples.cert.immutability.ImmutableClassExample;

import java.util.ArrayList;
import java.util.List;

// Notes
// Builder pattern is useful when you need to instantiate an object which requires different values to be set.
// Without using a pattern the following options would be available:
// 1. Update or add constructors with new parameters (required for immutable objects) - can become unwieldy over time.
//    (This is known as the telescoping constructor anti-pattern)
// 2. Add additional setter/getter methods - does not work for immutable objects since they cannot be modified after creation.
//    May also lead to class invariants - i.e. setting one value at a time, while working through the updates the class state
//    will temporarily be incorrect until final setter is called.
// What is the builder pattern?
// The builder pattern is a creational pattern in which parameters are passed to a builder object, often through method chaining,
// with the object being created with a final build call. Often used with immutable objects (since no setter methods), but can
// be used with mutable objects as well.
// Note that using a builder class often introduces tight coupling between the 2 classes, and so both classes are often
// contained within the 1 file with the immutable class being marked as private so that you can only get an instance through the builder.
public class BuilderPatternExample {

    public static void main(String[] args){
        BuilderClass builderClass = new BuilderClass();
        ImmutableClassExample immutableClassExample = builderClass.
                setSomeInt(1).
                setSomeString("Hello").
                setSomeListEntry(new ArrayList<String>()).
                build();

        System.out.println(immutableClassExample.getSomeInt() + " " + immutableClassExample.getSomeString()); // 1 Hello
    }
}


class BuilderClass { // Builder class is NOT final - it is mutable

    private String someString; // Variables are not final
    private int someInt;
    private List<String> someList;

    public BuilderClass setSomeString(String aString){
        this.someString = aString;
        return this; // Facilitates method chaining
    }

    public BuilderClass setSomeInt(int aInt){
        this.someInt = aInt;
        return this;
    }

    public BuilderClass setSomeListEntry(List<String> aList){
        this.someList = aList;
        return this;
    }

    public ImmutableClassExample build(){
        return new ImmutableClassExample(this.someString, this.someInt, this.someList); // Build the object!
    }
}

