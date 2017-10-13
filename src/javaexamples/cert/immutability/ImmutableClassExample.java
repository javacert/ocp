package javaexamples.cert.immutability;

// Notes:
// Applying the immutable strategy involves the following:
// 1. Use a constructor to set all properties of the object
// 2. Mark all of the instance variables private and final
// 3. Do not define any setter methods
// 4. Do not allow reference mutable objects to be modified or accessed directly e.g. Changing the contents of a list
//    through the reference. Solution is to NEVER return the reference to the list - suitable options include:
//    - Create wrapper methods to iterate over the data
//    - Create a one-time copy of the data that is returned to the user and never stored as part of the object
// 5. Prevent methods from being overridden. Options include:
//    - Mark the class or methods with the final modifier (will limit usage of the class)
//    - Make the constructor private and apply the factory pattern.

import java.util.ArrayList;
import java.util.List;

// The following class preserves all 5 of the above rules.
public final class ImmutableClassExample { // Class is final

    private final String someString; // Variables are private final
    private final int someInt;
    private final List<String> someList; // No references are publicly available

    public ImmutableClassExample(String aString, int aInt, List<String> aList){
        this.someString = aString;
        this.someInt = aInt;
        if (aList == null) {
            throw new RuntimeException("List must be defined");
        }
        this.someList = new ArrayList<String>(aList); // You must not use the reference to the list passed in, but rather create a copy through new ArrayList
    }

    public String getSomeString(){
        return someString;
    }

    public int getSomeInt(){
        return someInt;
    }

    public String getSomeListEntry(int index){
        return someList.get(index);
    }

}
