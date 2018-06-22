package javaexamples.cert.concurrency;

// Notes:
// 1. We can use Thread.sleep() method to implement polling.
// 2. The Thread.sleep() method requests the current thread of execution rest for a specified number of milliseconds.
public class ThreadSleepExample {

    private static int counter = 0;

    // Alternatively, we could have wrapped each call to the Thread.sleep() method in a try/catch block over InterruptedException.
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++) ThreadSleepExample.counter++;
        }).start();

        while (ThreadSleepExample.counter < 100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000); // 1 SECOND
        }
        System.out.println("Reached!");
    }
}
