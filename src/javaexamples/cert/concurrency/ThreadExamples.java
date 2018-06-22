package javaexamples.cert.concurrency;

// Notes:
// 1. Java thread priority constants:
//      - Thread.MIN_PRIORITY  --> 1
//      - Thread.NORM_PRIORITY --> 5
//      - Thread.MAX_PRIORITY  --> 10
// 2. The simplest way to execute a thread is by using the java.lang.Thread class.
// 3. Executing a task with Thread is a two-step process:
//      - First you define the Thread with the corresponding task to be done. 2 ways to do this:
//          * Provide a Runnable object or lambda expression to the Thread constructor.
//          * Create a class that extends Thread and overrides the run() method.
//      - Then you start the task by using the Thread.start() method.
// 4. Java does not provide any guarantees about the order in which a thread will be processed once it is started.
public class ThreadExamples extends Thread { // This is a less common way than implementing Runnable

    public void run() {
        System.out.println("Printing zoo inventory");
    }

    public static void main(String[] args) {
        (new ThreadExamples()).start(); // If we used (new ThreadExamples()).run() a new thread would not be used, it would run on the existing thread.
    }
}
