package javaexamples.cert.singletons;

// Advantages over Type A:
// 1. Initializes the singleton as part of the static initialization block
// 2. Allows additional steps to be taken to set up the singleton after it has been created.
// 3. Allows for handling of cases when the constructor throws an exception.
// 4. Since the singleton is created when the class is loaded, we are able to mark the reference as final, which
//    guarantees that only one instance will be created within our application.
public class SingletonTypeB {

    private static final SingletonTypeB instance;

    static {
        instance = new SingletonTypeB();
    }

    public static SingletonTypeB getInstance(){
        return instance;
    }
}
