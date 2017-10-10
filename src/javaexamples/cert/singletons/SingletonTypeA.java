package javaexamples.cert.singletons;

// Notes
// 1. Not considered thread safe since getInstance() may be accessed by multiple threads concurrently resulting in
//    2 objects being created in memory.
// 2. Applying synchronized to the getInstance() method below would make this class thread safe. Can cause performance
//    issues since every call will require synchronization. Double-Checked Locking is a possible solution (not on exam).
public class SingletonTypeA {

    private SingletonTypeA(){
        // Note the private constructor effectively making the class final0
    }

    public static final SingletonTypeA instance = new SingletonTypeA();

    public static SingletonTypeA getInstance(){
        return instance;
    }
}
