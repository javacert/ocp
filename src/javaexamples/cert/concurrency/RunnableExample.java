package javaexamples.cert.concurrency;

// Notes:
// 1. java.lang.Runnable is a functional interface that takes no arguments and returns no data, with 1 method void run().
// 2. Any lambda expressions which return a value are not compatible with Runnable.
// 3. Runnable has existed for a long time but only with Java 8 was it made into a Functional Interface for use with lambdas.
public class RunnableExample implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing record: " + i);
        }
    }

    public static void main(String[] args) {
        (new Thread(new RunnableExample())).start();
    }
}
