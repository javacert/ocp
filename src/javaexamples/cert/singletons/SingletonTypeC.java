package javaexamples.cert.singletons;

// Notes - this type of singleton is knows as lazy instantiation
// 1. Does not create the singleton object the first time it is loaded, but rather waits until the first time
//    getInstance() is called.
// 2. Reduces memory usage and improves performance when an application starts up.
// 3. The downside is that users may see a noticeable delay the first time an object is accessed.
// 4. Not considered thread safe.
public class SingletonTypeC {

    private static SingletonTypeC instance;
    private SingletonTypeC(){

    }

    public static SingletonTypeC getInstance(){
        if(instance == null){
            instance = new SingletonTypeC();
        }
        return instance;
    }
}
